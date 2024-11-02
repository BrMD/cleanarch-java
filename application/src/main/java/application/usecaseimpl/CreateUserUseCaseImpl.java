package application.usecaseimpl;

import java.math.BigDecimal;

import application.gateway.CreateUserGateway;
import core.domain.TransactionPin;
import core.domain.User;
import core.domain.Wallet;
import core.exception.EmailException;
import core.exception.InternalServerErrorException;
import core.exception.TaxNumberException;
import core.exception.TransactionPinException;
import core.exception.enums.ErrorCodeEnum;
import usecase.CreateUserUseCase;
import usecase.EmailAvailableUseCase;
import usecase.TaxNumberAvailableUseCase;


public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private EmailAvailableUseCase emailAvailableUseCase;
    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;

    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {
        System.out.println(user.getFullName());
        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if (!createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user,new TransactionPin(pin)))) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}