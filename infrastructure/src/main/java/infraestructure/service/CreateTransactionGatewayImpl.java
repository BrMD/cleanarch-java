package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.CreateTransactionGateway;
import core.domain.Transaction;
import infraestructure.mapper.TransactionMapper;
import infraestructure.repository.TransactionEntityRepository;
@Service
public class CreateTransactionGatewayImpl implements CreateTransactionGateway{
    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }


    @Override
    public Transaction create(Transaction transaction){
        try {
            var transactionEntity = transactionMapper.createTransaction(transaction);
        return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
        } catch (Exception e) {
            return null;
        }
    }
    
}
