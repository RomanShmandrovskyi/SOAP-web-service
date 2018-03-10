package web.hendler;

import model.Wallet;
import web.hendler.status.ResponseStatus;
import web.hendler.status.ResponseStatusFault;
import web.hendler.status.ResponseStatusSuccess;
import web.service.WalletService;
import web.service.implementation.WalletServiceImpl;

import javax.xml.bind.annotation.*;

@XmlSeeAlso(Wallet.class)
public class WalletResponse {

    @XmlElement(name = "value")
    private Object result;

    @XmlElement(name = "values")
    private Object[] results;

    @XmlElementRefs({
            @XmlElementRef(type = ResponseStatusSuccess.class),
            @XmlElementRef(type = ResponseStatusFault.class)
    })
    private ResponseStatus status;

    private WalletResponse(Object result, ResponseStatus status) {
        this.result = result;
        this.status = status;
    }

    private WalletResponse(Object[] results, ResponseStatus status) {
        this.results = results;
        this.status = status;
    }

    public WalletResponse() {
    }

    private WalletResponse(ResponseStatus status) {
        this.status = status;
    }

    public static WalletResponse successSingle(String status, Object result) {
        return new WalletResponse(result, new ResponseStatusSuccess(status));
    }

    public static WalletResponse successMany (String status, Object[] results){
        return new WalletResponse(results, new ResponseStatusSuccess(status));
    }

    public static WalletResponse fault(String status) {
        return new WalletResponse(new ResponseStatusFault(status));
    }
}
