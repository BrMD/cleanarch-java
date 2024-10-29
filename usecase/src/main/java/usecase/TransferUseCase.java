package usecase;

import core.domain.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
