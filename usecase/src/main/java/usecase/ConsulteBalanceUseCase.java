package usecase;

import java.math.BigDecimal;

import core.domain.Wallet;

public interface ConsulteBalanceUseCase {
    BigDecimal consult(Wallet wallet);
}
