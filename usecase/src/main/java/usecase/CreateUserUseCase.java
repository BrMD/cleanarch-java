package usecase;

import core.domain.User;
import core.exception.EmailException;
import core.exception.InternalServerErrorException;
import core.exception.TaxNumberException;
import core.exception.TransactionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException,InternalServerErrorException;
}
