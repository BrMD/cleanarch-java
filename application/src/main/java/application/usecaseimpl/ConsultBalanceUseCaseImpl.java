package application.usecaseimpl;

import java.math.BigDecimal;

import core.exception.NotFoundException;
import usecase.ConsultBalanceUseCase;
import usecase.FindWalletByTaxNumberUseCase;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase{
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    public ConsultBalanceUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }
    @Override
    public BigDecimal consult(String taxNumber) throws NotFoundException, Exception{
        return findWalletByTaxNumberUseCase.findByTaxNumber(taxNumber).getBalance();
    }
}
