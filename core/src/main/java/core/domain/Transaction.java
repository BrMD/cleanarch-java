package core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import core.domain.enums.TransactionStatusEnum;

public class Transaction {
    private Long id;
    private Wallet fromWallet;
    private Wallet toWallet;
    private BigDecimal value;
    private TransactionStatusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    public Transaction(Long id, Wallet fromWallet, Wallet toWallet, BigDecimal value, TransactionStatusEnum status,
            LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    public Transaction(Wallet fromWallet, Wallet toWallet, BigDecimal value) {
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = TransactionStatusEnum.CREATED;
        this.createdAt = LocalDateTime.now();
    }
    public Transaction(){}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Wallet getFromWallet() {
        return fromWallet;
    }
    public void setFromWallet(Wallet fromWallet) {
        this.fromWallet = fromWallet;
    }
    public Wallet getToWallet() {
        return toWallet;
    }
    public void setToWallet(Wallet toWallet) {
        this.toWallet = toWallet;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public TransactionStatusEnum getStatus() {
        return status;
    }
    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
   
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fromWallet == null) ? 0 : fromWallet.hashCode());
        result = prime * result + ((toWallet == null) ? 0 : toWallet.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (fromWallet == null) {
            if (other.fromWallet != null)
                return false;
        } else if (!fromWallet.equals(other.fromWallet))
            return false;
        if (toWallet == null) {
            if (other.toWallet != null)
                return false;
        } else if (!toWallet.equals(other.toWallet))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (status != other.status)
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        return true;
    }
}
