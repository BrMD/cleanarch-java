package application.usecaseimpl;

import java.math.BigDecimal;

import application.gateway.ConsultBalanceGateway;
import core.domain.Wallet;
import usecase.ConsultBalanceUseCase;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase{
    private ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }
    @Override
    public BigDecimal consult(Wallet wallet){
        return consultBalanceGateway.consult(wallet);
    }
}
