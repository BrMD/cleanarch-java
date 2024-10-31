package infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import infraestructure.entity.WalletEntity;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long>{

}
