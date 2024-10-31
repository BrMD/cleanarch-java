package infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import infraestructure.entity.TransactionEntity;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long>{

}
