package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "wallet")
@XmlAccessorType(XmlAccessType.FIELD)
public class Wallet {

    @XmlElement(name = "walletId")
    private int walletId;

    @XmlElement(name = "walletBalance")
    private double balance;

    public Wallet(int id) {
        this.walletId = id;
        this.balance = 100.0;
    }

    public Wallet() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }
}
