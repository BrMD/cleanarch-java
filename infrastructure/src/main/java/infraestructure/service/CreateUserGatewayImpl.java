package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.CreateUserGateway;
import core.domain.User;
import core.domain.Wallet;
import infraestructure.mapper.TransactionPinMapper;
import infraestructure.mapper.UserMapper;
import infraestructure.mapper.WalletMapper;
import infraestructure.repository.TransactionPinEntityRepository;
import infraestructure.repository.UserEntityRepository;
import infraestructure.repository.WalletEntityRepository;
import static infraestructure.utils.Utilities.log;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway{
    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;
    private TransactionPinEntityRepository transactionPinEntityRepository;
    private TransactionPinMapper transactionPinMapper;
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper,
            TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper,
            WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }


    @Override
    public Boolean create(User user, Wallet wallet){
        try {
            log.info("Inicio da criação de usuario::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toEntity(wallet, userSaved, transactionPinSaved));
            log.info("Usuario criado com sucesso::CreateUserGatewayImpl");
            return true;
        } catch (Exception e) {
            log.info("Houve um erro na criação do usuario::CreateUserGatewayImpl");
            return false;
        }
    }

}
