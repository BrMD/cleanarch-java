package infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import application.gateway.CreateUserGateway;
import application.gateway.EmailAvailableGateway;
import application.gateway.TaxNumberAvailableGateway;
import application.usecaseimpl.CreateUserUseCaseImpl;
import application.usecaseimpl.EmailAvailableUseCaseImpl;
import application.usecaseimpl.TaxNumberAvailableUseCaseimpl;
import usecase.CreateUserUseCase;
import usecase.EmailAvailableUseCase;
import usecase.TaxNumberAvailableUseCase;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseimpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway){
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}