package dao;

import model.Wallet;

import java.util.ArrayList;
import java.util.List;

public class WalletDao {
    private static double oldBalance;
    private static List<Wallet> wallets;

    public WalletDao() {
        wallets = new ArrayList<>();
    }

    public double getBalance(int id) {
        for (Wallet wallet : wallets) {
            if (wallet.getWalletId() == id) {
                return wallet.getBalance();
            }
        }
        return Double.MAX_VALUE;
    }

    public Wallet getWalletById(int id) {
        for (Wallet wallet : wallets) {
            if (wallet.getWalletId() == id) {
                return wallet;
            }
        }
        return null;
    }

    public double buyGood(double goodPrice, int id) {
        for (Wallet wallet : wallets) {
            if (wallet.getWalletId() == id) {
                oldBalance = wallet.getBalance();
                wallet.setBalance(oldBalance - goodPrice);
                return wallet.getBalance();
            }
        }
        return Double.MAX_VALUE;
    }

    public double putMoneyOnWallet(double moneyQnt, int id) {
        for (Wallet wallet : wallets) {
            if (wallet.getWalletId() == id) {
                oldBalance = wallet.getBalance();
                wallet.setBalance(oldBalance + moneyQnt);
                return wallet.getBalance();
            }
        }
        return Double.MAX_VALUE;
    }

    public boolean addNewWallet() {
        return wallets.add(new Wallet(idGenerator()));
    }

    public boolean deleteWalletById(int walletId) {
        for (Wallet wallet : wallets) {
            if (wallet.getWalletId() == walletId) {
                return wallets.remove(wallet);
            }
        }
        return false;
    }

    public List<Wallet> getAllWallets() {
        return wallets;
    }

    public double cancelTransaction(int id) {
        for (Wallet wallet : wallets) {
            if (wallet.getWalletId() == id) {
                wallet.setBalance(oldBalance);
                return wallet.getBalance();
            }
        }
        return 0;
    }

    private int idGenerator() {
        if (wallets.size() == 0) {
            return 1;
        } else {
            return wallets.get(wallets.size() - 1).getWalletId() + 1;
        }
    }
}
