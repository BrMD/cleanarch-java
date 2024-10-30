package core.domain;

import java.time.LocalDateTime;

import core.exception.TransactionPinException;
import core.exception.enums.ErrorCodeEnum;

public class TransactionPin {
    private Long id;
    private Wallet wallet;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    
    public TransactionPin(Long id,Wallet wallet, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt,
            LocalDateTime updateAt) {
        this.id = id;
        this.wallet = wallet;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    public TransactionPin(String pin) throws TransactionPinException {
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private void pinIsValid(String pin) throws TransactionPinException{
        if(pin.length() !=8 ){
            throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(),ErrorCodeEnum.TRP0001.getCode());
        }
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) throws TransactionPinException {
        pinIsValid(pin);
        this.pin = pin;
    }
    public Integer getAttempt() {
        return attempt;
    }
    public void setAttempt() {
        if(this.attempt == 1){
            this.blocked = true;
            this.attempt = 0;
        }else{
            this.attempt = this.attempt - 1;
        }
        
    }

    public void resetAttempt(){
        this.attempt = 3;
    }

    public Boolean getBlocked() {
        return blocked;
    }
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
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
    public Wallet getWallet() {
        return wallet;
    }
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((wallet == null) ? 0 : wallet.hashCode());
        result = prime * result + ((pin == null) ? 0 : pin.hashCode());
        result = prime * result + ((attempt == null) ? 0 : attempt.hashCode());
        result = prime * result + ((blocked == null) ? 0 : blocked.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((updateAt == null) ? 0 : updateAt.hashCode());
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
        TransactionPin other = (TransactionPin) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (wallet == null) {
            if (other.wallet != null)
                return false;
        } else if (!wallet.equals(other.wallet))
            return false;
        if (pin == null) {
            if (other.pin != null)
                return false;
        } else if (!pin.equals(other.pin))
            return false;
        if (attempt == null) {
            if (other.attempt != null)
                return false;
        } else if (!attempt.equals(other.attempt))
            return false;
        if (blocked == null) {
            if (other.blocked != null)
                return false;
        } else if (!blocked.equals(other.blocked))
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
        return true;
    }
}
