package usecase;

import java.math.BigDecimal;

import core.exception.NotFoundException;

public interface ConsultBalanceUseCase {
    BigDecimal consult(String taxNumber) throws NotFoundException, Exception;
}
