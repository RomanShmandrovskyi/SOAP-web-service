package web.service.implementation;

import dao.WalletDao;
import model.Wallet;
import web.hendler.WalletResponse;
import web.hendler.status.ResponseStatus;
import web.service.WalletService;

import javax.jws.WebService;

@WebService(endpointInterface = "web.service.WalletService")
public class WalletServiceImpl implements WalletService {

    private WalletDao walletDao = new WalletDao();

    public WalletResponse getBalanceOfCurrentWallet(int id) {
        double result = walletDao.getBalance(id);
        if (result == Double.MAX_VALUE) {
            return WalletResponse.fault(ResponseStatus.WALLET_NOT_FOUND);
        } else if (result == 0) {
            return WalletResponse.fault(ResponseStatus.NO_MONEY);
        }
        return WalletResponse.successSingle(
                ResponseStatus.GET_BALANCE,
                result);
    }

    public WalletResponse buyGood(int id, double goodPrice) {
        double result = walletDao.buyGood(goodPrice, id);
        if (result == Double.MAX_VALUE) {
            return WalletResponse.fault(ResponseStatus.WALLET_NOT_FOUND);
        } else {
            if (result < -50.0) {
                walletDao.cancelTransaction(id);
                return WalletResponse.fault(ResponseStatus.CREDIT_LIMIT_EXCEEDED);
            }
            return WalletResponse.successSingle(
                    ResponseStatus.BUY_GOOD,
                    result);
        }
    }

    public WalletResponse putMoneyOnBalance(int id, double moneyQnt) {
        double result = walletDao.putMoneyOnWallet(moneyQnt, id);
        if (result == Double.MAX_VALUE) {
            return WalletResponse.fault(ResponseStatus.WALLET_NOT_FOUND);
        } else {
            if (result > 1000.0) {
                walletDao.cancelTransaction(id);
                return WalletResponse.fault(ResponseStatus.MAX_LIMIT_EXCEEDED);
            }
            return WalletResponse.successSingle(
                    ResponseStatus.REFILL_BALANCE,
                    result);
        }
    }

    public WalletResponse addNewWallet() {
        boolean flag = walletDao.addNewWallet();
        if (flag) {
            return WalletResponse.successSingle(ResponseStatus.ADD_NEW_WALLET, null);
        }
        return WalletResponse.fault(ResponseStatus.NEW_WALLET_ADD_ERROR);
    }

    public WalletResponse getWalletById(int id) {
        Wallet wallet = walletDao.getWalletById(id);
        if (wallet != null) {
            return WalletResponse.successSingle(ResponseStatus.GET_WALLET, wallet);
        }
        return WalletResponse.fault(ResponseStatus.WALLET_NOT_FOUND);
    }

    public WalletResponse deleteWalletById(int id) {
        boolean result = walletDao.deleteWalletById(id);
        if (result) {
            return WalletResponse.successSingle(ResponseStatus.WALLET_DELETE, "true");
        }
        return WalletResponse.fault(ResponseStatus.WALLET_NOT_FOUND);
    }

    public WalletResponse getAllWallets() {
        Object[] results = walletDao.getAllWallets().toArray();
        if (results.length != 0) {
            return WalletResponse.successMany(ResponseStatus.WALLETS_FOUND, results);
        }
        return WalletResponse.fault(ResponseStatus.NO_ONE_WALLET);
    }
}
