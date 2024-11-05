package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.TransactionPinValidadeGateway;
import core.domain.TransactionPin;


@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidadeGateway{
    

    @Override
    public Boolean validate(TransactionPin transactionPin, String pin){

        if(transactionPin.getPin() != pin){
            return false;
        }
        return true;
    }
}
