package infraestructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import infraestructure.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {

    Boolean existsByTaxNumber(String taxNumber);

    Boolean existsByEmail(String email);
}


