package infraestructure.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import core.domain.enums.TransactionStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Transaction")
public class TransactionEntity {
    @Column(name="Id", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToAny
    @JoinColumn(name="FromWallet", nullable=false)
    private WalletEntity fromWallet;

    @ManyToAny
    @JoinColumn(name="ToWallet", nullable=false)
    private WalletEntity toWallet;

    @Column(name="TransactionValue", nullable=false)
    private BigDecimal transactionValue;

    @Column(name="Status", nullable=false)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Column(name="CreatedAt", nullable=false)
    private LocalDateTime createdAt;

    @Column(name="UpdateAt")
    private LocalDateTime updateAt;
}
