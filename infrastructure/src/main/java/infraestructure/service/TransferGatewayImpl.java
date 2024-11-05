package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.TransferGateway;
import core.domain.Transaction;
import infraestructure.mapper.TransactionMapper;
import infraestructure.mapper.WalletMapper;
import infraestructure.repository.TransactionEntityRepository;
import infraestructure.repository.WalletEntityRepository;
import jakarta.transaction.Transactional;

@Service
public class TransferGatewayImpl implements TransferGateway{
    WalletEntityRepository walletEntityRepository;
    TransactionEntityRepository transactionEntityRepository;
    WalletMapper walletMapper;
    TransactionMapper transactionMapper;

    public TransferGatewayImpl(TransactionMapper transactionMapper,TransactionEntityRepository transactionEntityRepository, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction){
        
        try{
            walletEntityRepository.save(walletMapper.toEntityUpdate(transaction.getToWallet()));
            walletEntityRepository.save(walletMapper.toEntityUpdate(transaction.getFromWallet()));
            transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));
            return true;
        }catch(Exception e){
            transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
            return false;
        }
        
    } 
}
