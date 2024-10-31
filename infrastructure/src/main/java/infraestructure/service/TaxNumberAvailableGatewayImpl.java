package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.TaxNumberAvailableGateway;
import infraestructure.repository.UserEntityRepository;
import static infraestructure.utils.Utilities.log;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway{
    private UserEntityRepository userEntityRepository;


    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }


    @Override
    public Boolean taxNumberAvailable(String taxNumber){
        log.info("Inicio da verificação de TaxNumber::TaxNumberAvailableGatewayImpl");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
