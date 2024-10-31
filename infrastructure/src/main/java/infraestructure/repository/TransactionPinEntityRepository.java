package infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import infraestructure.entity.TransactionsPinEntity;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionsPinEntity, Long>{

}
