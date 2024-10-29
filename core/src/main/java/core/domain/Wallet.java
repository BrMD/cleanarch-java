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
    public Wallet(Long id, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    public Wallet(BigDecimal balance, User user) {
        this.balance = balance;
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
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
    public void receiveValue(BigDecimal value){
        this.balance.add(value);
    }
    public void transfer(BigDecimal value) throws TransferException{
        if(this.user.getType() == UserTypeEnum.SHOPKEEPER){
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(),ErrorCodeEnum.TR0001.getCode());
        }

        if(this.balance.compareTo(value)<0){
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(),ErrorCodeEnum.TR0002.getCode()); 
        }

        this.balance.subtract(value);
    }
}