package application.gateway;

import java.math.BigDecimal;

import core.domain.Wallet;

public interface ConsultBalanceGateway {
    BigDecimal consult(Wallet wallet);
}
