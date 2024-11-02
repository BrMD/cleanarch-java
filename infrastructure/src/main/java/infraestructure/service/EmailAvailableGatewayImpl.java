package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.EmailAvailableGateway;
import infraestructure.repository.UserEntityRepository;
import static infraestructure.utils.Utilities.log;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway{
    UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email){
        log.info("Inicio da verificação de Email::EmailAvailableGatewayImpl ");
        return !userEntityRepository.existsByEmail(email);
    }
}
