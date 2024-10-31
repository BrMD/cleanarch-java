package infraestructure.mapper;

import org.springframework.stereotype.Component;

import core.domain.Transaction;
import infraestructure.entity.TransactionEntity;
import infraestructure.entity.WalletEntity;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionMapper {
    private WalletMapper walletMapper;
    public TransactionEntity toEntity(Transaction transaction, WalletEntity from, WalletEntity to){
        return new TransactionEntity(
            transaction.getId(),
            from,
            to,
            transaction.getValue(),
            transaction.getStatus(),
            transaction.getCreatedAt(),
            transaction.getUpdateAt()
        );
    }
}
