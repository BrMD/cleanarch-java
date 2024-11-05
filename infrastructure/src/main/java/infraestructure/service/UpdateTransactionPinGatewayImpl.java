package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.UpdateTransactionPinGateway;
import core.domain.TransactionPin;
import infraestructure.mapper.TransactionPinMapper;
import infraestructure.repository.TransactionPinEntityRepository;

@Service
public class UpdateTransactionPinGatewayImpl implements UpdateTransactionPinGateway{
    TransactionPinEntityRepository transactionPinEntityRepository;
    TransactionPinMapper transactionPinMapper;

    public UpdateTransactionPinGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository,TransactionPinMapper transactionPinMapper) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin){
        return transactionPinMapper.toTransactionPin(transactionPinEntityRepository.save(transactionPinMapper.toEntityUpdate(transactionPin)));
    }
}
