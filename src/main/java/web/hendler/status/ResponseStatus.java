package web.hendler.status;

public class ResponseStatus {
    //success
    public static final String GET_BALANCE = "balance got successfully";
    public static final String BUY_GOOD = "product was purchased successfully";
    public static final String REFILL_BALANCE = "balance was refill successfully";
    public static final String ADD_NEW_WALLET = "new wallet added successfully";
    public static final String GET_WALLET = "wallet is present";
    public static final String WALLET_DELETE = "wallet deleted successfully";
    public static final String WALLETS_FOUND = "there are some wallets!";

    //fault
    public static final String NO_MONEY = "there is no money";
    public static final String CREDIT_LIMIT_EXCEEDED = "you have exceeded your credit limit";
    public static final String MAX_LIMIT_EXCEEDED = "you have exceeded your maximum limit";
    public static final String NEW_WALLET_ADD_ERROR = "something wrong! wallet was not added";
    public static final String WALLET_NOT_FOUND = "there is no one wallet with such id";
    public static final String NO_ONE_WALLET = "there is no one wallet! add one!";
}
