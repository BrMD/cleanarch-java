package usecase;

import core.domain.TransactionPin;
import core.exception.PinException;
import core.exception.TransferException;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin) throws TransferException, PinException;
}
