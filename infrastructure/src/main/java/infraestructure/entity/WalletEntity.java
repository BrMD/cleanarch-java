package infraestructure.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private TransactionPinEntity transactionPinId;

    @Column(name="CreatedAt", nullable=false)
    private LocalDateTime createdAt;

    @Column(name="UpdateAt")
    private LocalDateTime updateAt;

    public WalletEntity(BigDecimal balance,  TransactionPinEntity transactionPinId, UserEntity userId,LocalDateTime createdAt,LocalDateTime updateAt) {
        this.balance = balance;
        this.createdAt = createdAt;
        this.transactionPinId = transactionPinId;
        this.updateAt = updateAt;
        this.userId = userId;
    }

    public WalletEntity(Long id, BigDecimal balance , TransactionPinEntity transactionPinId, UserEntity userId, LocalDateTime createdAt,LocalDateTime updateAt) {
        this.balance = balance;
        this.createdAt = createdAt;
        this.id = id;
        this.transactionPinId = transactionPinId;
        this.updateAt = updateAt;
        this.userId = userId;
    }



}
