package infraestructure.mapper;

import org.springframework.stereotype.Component;

import core.domain.Transaction;
import core.domain.enums.TransactionStatusEnum;
import infraestructure.entity.TransactionEntity;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionMapper {
    private WalletMapper walletMapper;
    public TransactionEntity toEntity(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toEntity(transaction.getFromWallet()),
                walletMapper.toEntity(transaction.getToWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }

    public TransactionEntity createTransaction(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toEntityUpdate(transaction.getFromWallet()),
                walletMapper.toEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CREATED,
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) throws Exception {
        return new Transaction(
                transactionEntity.getId(),
                walletMapper.toWallet(transactionEntity.getFromWallet()),
                walletMapper.toWallet(transactionEntity.getToWallet()),
                transactionEntity.getTransactionValue(),
                transactionEntity.getStatus(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getUpdateAt()
        );
    }

    public TransactionEntity concludeTransaction(Transaction transaction){
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toEntityUpdate(transaction.getFromWallet()),
                walletMapper.toEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.SUCCESS,
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }

    public TransactionEntity cancelTransaction(Transaction transaction){
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toEntityUpdate(transaction.getFromWallet()),
                walletMapper.toEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CANCELED,
                transaction.getCreatedAt(),
                transaction.getUpdateAt()
        );
    }
}
