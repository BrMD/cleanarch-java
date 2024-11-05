package infraestructure.mapper;

import org.springframework.stereotype.Component;

import core.domain.Wallet;
import infraestructure.entity.TransactionPinEntity;
import infraestructure.entity.UserEntity;
import infraestructure.entity.WalletEntity;

@Component
public class WalletMapper {
    private TransactionPinMapper transactionPinMapper;
    private UserMapper userMapper;
    public WalletMapper(TransactionPinMapper transactionPinMapper,UserMapper userMapper) {
        this.transactionPinMapper = transactionPinMapper;
        this.userMapper = userMapper;
    }

   public WalletEntity toEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
                wallet.getBalance(),
                transactionPinEntity,
                userEntity,
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public WalletEntity toEntity(Wallet wallet) {
        return new WalletEntity(
                wallet.getBalance(),
                transactionPinMapper.toEntity(wallet.getTransactionPin()),
                userMapper.toEntity(wallet.getUser()),
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

     public Wallet toWallet(WalletEntity walletEntity) throws Exception {
        if (walletEntity == null){
            return null;
        }
        return new Wallet(
                walletEntity.getId(),
                transactionPinMapper.toTransactionPin(walletEntity.getTransactionPinId()),
                walletEntity.getBalance(),
                userMapper.toUser(walletEntity.getUserId()),
                walletEntity.getCreatedAt(),
                walletEntity.getUpdateAt()
        );  
    }

    public WalletEntity toEntityUpdate(Wallet wallet) {
        return new WalletEntity(
                wallet.getId(),
                wallet.getBalance(),
                transactionPinMapper.toEntityUpdate(wallet.getTransactionPin()),
                userMapper.toEntity(wallet.getUser()),
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }
    
}
