package infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import infraestructure.entity.TransactionPinEntity;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long>{

}
