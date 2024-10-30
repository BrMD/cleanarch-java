package usecase;

import java.math.BigDecimal;

import core.domain.Wallet;

public interface ConsultBalanceUseCase {
    BigDecimal consult(Wallet wallet);
}
