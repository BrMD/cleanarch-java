package core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import core.domain.enums.UserTypeEnum;
import core.exception.TransferException;
import core.exception.enums.ErrorCodeEnum;

public class Wallet {
    private Long id;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private TransactionPin transactionPin;
    public Wallet( Long id,TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    
    public Wallet(BigDecimal balance, User user, TransactionPin transactionPin) {
        this.balance = balance;
        this.transactionPin = transactionPin;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }
    public Wallet(){}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public TransactionPin getTransactionPin() {
        return transactionPin;
    }
    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
    public void receiveValue(BigDecimal value){
        this.balance = this.balance.add(value);
    }
    public void transfer(BigDecimal value) throws TransferException{
        if(this.user.getType() == UserTypeEnum.SHOPKEEPER){
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(),ErrorCodeEnum.TR0001.getCode());
        }

        if(this.balance.compareTo(value)<0){
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(),ErrorCodeEnum.TR0002.getCode()); 
        }

        this.balance = this.balance.subtract(value);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((balance == null) ? 0 : balance.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((updateAt == null) ? 0 : updateAt.hashCode());
        result = prime * result + ((transactionPin == null) ? 0 : transactionPin.hashCode());
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
        Wallet other = (Wallet) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (balance == null) {
            if (other.balance != null)
                return false;
        } else if (!balance.equals(other.balance))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (updateAt == null) {
            if (other.updateAt != null)
                return false;
        } else if (!updateAt.equals(other.updateAt))
            return false;
        if (transactionPin == null) {
            if (other.transactionPin != null)
                return false;
        } else if (!transactionPin.equals(other.transactionPin))
            return false;
        return true;
    }
}
