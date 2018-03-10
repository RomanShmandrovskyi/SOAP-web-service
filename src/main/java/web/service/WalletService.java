package web.service;

import web.hendler.WalletResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WalletService {

    @WebMethod()
    WalletResponse getBalanceOfCurrentWallet(
            @WebParam(partName = "wallet_ID") int id);

    @WebMethod()
    WalletResponse getWalletById(
            @WebParam(partName = "wallet_ID") int id);

    @WebMethod()
    WalletResponse buyGood(
            @WebParam(partName = "wallet_ID") int walletId,
            @WebParam(partName = "good_price") double goodPrice);

    @WebMethod()
    WalletResponse putMoneyOnBalance(
            @WebParam(partName = "wallet_ID") int walletId,
            @WebParam(partName = "money_Qnt") double moneyQnt);

    @WebMethod()
    WalletResponse addNewWallet();

    @WebMethod
    WalletResponse deleteWalletById(
            @WebParam(partName = "wallet_ID") int id);

    @WebMethod
    WalletResponse getAllWallets();
}
