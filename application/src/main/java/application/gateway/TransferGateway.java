package application.gateway;

import core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction); 
}
