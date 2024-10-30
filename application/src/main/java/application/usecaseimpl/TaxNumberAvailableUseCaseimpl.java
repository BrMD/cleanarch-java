package application.usecaseimpl;

import application.gateway.TaxNumberAvailableGateway;
import usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseimpl implements TaxNumberAvailableUseCase{
    private TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseimpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }
    @Override
    public Boolean taxNumberAvailable(String taxNumber){
        return taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
}
