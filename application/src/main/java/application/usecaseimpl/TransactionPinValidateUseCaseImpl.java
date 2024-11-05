package application.usecaseimpl;

import application.gateway.TransactionPinValidadeGateway;
import core.domain.TransactionPin;
import core.exception.PinException;
import core.exception.enums.ErrorCodeEnum;
import usecase.TransactionPinValidateUseCase;
import usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase{
    private TransactionPinValidadeGateway transactionPinValidadeGateway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(UpdateTransactionPinUseCase updateTransactionPinUseCase,TransactionPinValidadeGateway transactionPinValidadeGateway) {
        this.transactionPinValidadeGateway = transactionPinValidadeGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }



    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) throws PinException{
         if(transactionPin.getBlocked()){
           throw new PinException(ErrorCodeEnum.PIN0001.getMessage(),ErrorCodeEnum.PIN0001.getCode()); 
        } 
        if(!transactionPinValidadeGateway.validate(transactionPin, pin)){
            transactionPin.setAttempt();
            var transactionPinUpdated = updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0002GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        }

        if(transactionPin.getAttempt()<3){
            transactionPin.resetAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }
        return true;
    }
}
