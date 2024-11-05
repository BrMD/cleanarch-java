package application.gateway;

import core.domain.TransactionPin;

public interface TransactionPinValidadeGateway {
    Boolean validate(TransactionPin transactionPin, String pin);
}
