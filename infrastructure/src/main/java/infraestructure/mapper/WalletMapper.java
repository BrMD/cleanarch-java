package infraestructure.mapper;

import org.springframework.stereotype.Component;

import core.domain.Wallet;
import infraestructure.entity.TransactionPinEntity;
import infraestructure.entity.UserEntity;
import infraestructure.entity.WalletEntity;

@Component
public class WalletMapper {
    public WalletEntity toEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity){
        return new WalletEntity(
            wallet.getId(),
            wallet.getBalance(),
            userEntity,
            transactionPinEntity,
            wallet.getCreatedAt(),
            wallet.getUpdateAt()
        );
    }
}
