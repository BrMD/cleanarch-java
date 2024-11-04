package application.usecaseimpl;

import java.math.BigDecimal;

import application.gateway.TransferGateway;
import core.domain.Transaction;
import core.domain.Wallet;
import core.exception.InternalServerErrorException;
import core.exception.NotFoundException;
import core.exception.NotificationException;
import core.exception.enums.ErrorCodeEnum;
import usecase.CreateTransactionUseCase;
import usecase.FindWalletByTaxNumberUseCase;
import usecase.TransactionPinValidateUseCase;
import usecase.TransactionValidateUseCase;
import usecase.TransferUseCase;
import usecase.UserNotificationUseCase;

public class TransferUseCaseImpl implements TransferUseCase{
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferGateway transferGateway;
    private UserNotificationUseCase userNotificationUseCase;
    private TransactionPinValidateUseCase transactionPinValidateUseCase;
    

    public TransferUseCaseImpl(TransactionPinValidateUseCase transactionPinValidateUseCase,UserNotificationUseCase userNotificationUseCase,TransferGateway transferGateway,FindWalletByTaxNumberUseCase findByTaxNumberUseCase,TransactionValidateUseCase transactionValidateUseCase,CreateTransactionUseCase createTransactionUseCase) {
        this.findWalletByTaxNumberUseCase = findByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }


    @Override
    public Boolean transfer(String fromTaxNumber,String toTaxNumber, BigDecimal value,String pin) throws Exception,NotFoundException{
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

       
        transactionPinValidateUseCase.validate(from.getTransactionPin());

        from.transfer(value);
        to.receiveValue(value);
        
        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));
        transactionValidateUseCase.validate(transaction);
        if(!transferGateway.transfer(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if(!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())){
            throw new NotificationException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
        }

        return true;
    }
}
