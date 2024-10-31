package infraestructure.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Wallet")
public class WalletEntity {
    @Column(name="Id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="Balance", nullable=false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name="UserId", nullable=false)
    private UserEntity userId;

    
    @OneToOne
    @JoinColumn(name="TransactionPinId", nullable=false)
    private TransactionsPinEntity transactionPinId;

    @Column(name="CreatedAt", nullable=false)
    private LocalDateTime createdAt;

    @Column(name="UpdateAt")
    private LocalDateTime updateAt;

}
