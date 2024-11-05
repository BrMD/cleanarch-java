package infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import application.gateway.CreateTransactionGateway;
import application.gateway.FindWalletByTaxNumberGateway;
import application.gateway.TransactionPinValidadeGateway;
import application.gateway.TransactionValidateGateway;
import application.gateway.TransferGateway;
import application.gateway.UpdateTransactionPinGateway;
import application.gateway.UserNotificationGateway;
import application.usecaseimpl.ConsultBalanceUseCaseImpl;
import application.usecaseimpl.CreateTransactionUseCaseImpl;
import application.usecaseimpl.FindWalletByTaxNumberUseCaseImpl;
import application.usecaseimpl.TransactionPinValidateUseCaseImpl;
import application.usecaseimpl.TransactionValidateUseCaseImpl;
import application.usecaseimpl.TransferUseCaseImpl;
import application.usecaseimpl.UpdateTransactionPinUseCaseImpl;
import application.usecaseimpl.UserNotificationUseCaseImpl;
import usecase.ConsultBalanceUseCase;
import usecase.CreateTransactionUseCase;
import usecase.FindWalletByTaxNumberUseCase;
import usecase.TransactionPinValidateUseCase;
import usecase.TransactionValidateUseCase;
import usecase.TransferUseCase;
import usecase.UpdateTransactionPinUseCase;
import usecase.UserNotificationUseCase;

@Configuration
public class WalletConfig {
    
    @Bean
    public FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway){
        return new FindWalletByTaxNumberUseCaseImpl(findWalletByTaxNumberGateway);
    }

    @Bean
    public ConsultBalanceUseCase consultBalanceUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        return new ConsultBalanceUseCaseImpl(findWalletByTaxNumberUseCase);
    }

    @Bean
    public TransferUseCase transferUseCase(TransactionPinValidateUseCase transactionPinValidateUseCase,
        UserNotificationUseCase userNotificationUseCase,
        TransferGateway transferGateway,
        FindWalletByTaxNumberUseCase findByTaxNumberUseCase,
        TransactionValidateUseCase transactionValidateUseCase,
        CreateTransactionUseCase createTransactionUseCase){
        return new TransferUseCaseImpl(transactionPinValidateUseCase, userNotificationUseCase, transferGateway, findByTaxNumberUseCase, transactionValidateUseCase, createTransactionUseCase);
    }

    @Bean
    public TransactionValidateUseCase transactionValidateUseCase(TransactionValidateGateway transactionValidateGateway){
        return new TransactionValidateUseCaseImpl(transactionValidateGateway);
    }

    @Bean
    public UpdateTransactionPinUseCase updateTransactionPinUseCase(UpdateTransactionPinGateway updateTransactionPinGateway){
        return new UpdateTransactionPinUseCaseImpl(updateTransactionPinGateway);
    }

    @Bean
    public CreateTransactionUseCase createTransactionUseCase(CreateTransactionGateway createTransactionGateway){
        return new CreateTransactionUseCaseImpl(createTransactionGateway);
    }

    @Bean
    public UserNotificationUseCase userNotificationUseCase(UserNotificationGateway userNotificationGateway){
        return new UserNotificationUseCaseImpl(userNotificationGateway);
    }

    @Bean
     public TransactionPinValidateUseCase transactionPinValidateUseCase(TransactionPinValidadeGateway transactionPinValidadeGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        return new TransactionPinValidateUseCaseImpl(updateTransactionPinUseCase, transactionPinValidadeGateway);
    }

}
