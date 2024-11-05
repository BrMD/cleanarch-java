package application.usecaseimpl;

import application.gateway.UpdateTransactionPinGateway;
import core.domain.TransactionPin;
import usecase.UpdateTransactionPinUseCase;

public class UpdateTransactionPinUseCaseImpl implements UpdateTransactionPinUseCase{
    private UpdateTransactionPinGateway updateTransactionPinGateway;
    


    public UpdateTransactionPinUseCaseImpl(UpdateTransactionPinGateway updateTransactionPinGateway) {
        this.updateTransactionPinGateway = updateTransactionPinGateway;
    }



    @Override
    public TransactionPin update(TransactionPin transactionPin){
        return updateTransactionPinGateway.update(transactionPin);
    }

}
