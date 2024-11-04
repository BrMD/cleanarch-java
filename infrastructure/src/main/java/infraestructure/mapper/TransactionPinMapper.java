package infraestructure.mapper;

import org.springframework.stereotype.Component;

import core.domain.TransactionPin;
import infraestructure.entity.TransactionPinEntity;

@Component
public class TransactionPinMapper {
    public TransactionPinEntity toEntity(TransactionPin transactionPin){
        return new TransactionPinEntity(
            transactionPin.getId(),
            transactionPin.getPin(),
            transactionPin.getAttempt(),
            transactionPin.getBlocked(),
            transactionPin.getCreatedAt(),
            transactionPin.getUpdateAt()
        );
    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionPinEntity){
        if(transactionPinEntity == null) return null;
        return new TransactionPin(
            transactionPinEntity.getId(),
            transactionPinEntity.getPin(),
            transactionPinEntity.getAttempt(),
            transactionPinEntity.getBlocked(),
            transactionPinEntity.getCreatedAt(),
            transactionPinEntity.getUpdatedAt()
        );
    }
}
