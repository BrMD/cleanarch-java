package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.TransactionPinValidadeGateway;
import core.domain.TransactionPin;
import infraestructure.repository.TransactionPinEntityRepository;


@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidadeGateway{
    private TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin){
        var transactionPinSaved = transactionPinEntityRepository.findById(transactionPin.getId());
        if(transactionPinSaved.isEmpty()){
            return false;
        }
        if(transactionPinSaved.get().getPin() != transactionPin.getPin()){
            return false;
        }
        return true;
    }
}
