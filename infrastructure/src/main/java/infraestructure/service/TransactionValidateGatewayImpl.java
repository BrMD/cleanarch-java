package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.TransactionValidateGateway;
import core.domain.Transaction;
import infraestructure.client.ApiValidateService;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway{
    private ApiValidateService apiValidateService;
    

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }


    @Override
    public Boolean validate(Transaction transaction){
        var response = apiValidateService.validate();
        if(response == null) return false;
        return response.success();
    }
}
