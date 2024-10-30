package usecase;

import java.math.BigDecimal;

import core.exception.InternalServerErrorException;
import core.exception.NotFoundException;
import core.exception.NotificationException;
import core.exception.PinException;
import core.exception.TransferException;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber,String toTaxNumber, BigDecimal value, String pin) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException;
}
