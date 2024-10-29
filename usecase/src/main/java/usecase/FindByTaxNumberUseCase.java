package usecase;

import core.domain.User;

public interface FindByTaxNumberUseCase {
    User findByTaxNumber(String taxNumber);
}
