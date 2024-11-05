package application.gateway;

import core.domain.TransactionPin;

public interface UpdateTransactionPinGateway {
    TransactionPin update(TransactionPin transactionPin);
}
