package core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import core.domain.enums.UserTypeEnum;

public class User {
    private UUID id;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullName;
    private UserTypeEnum type;
    private TransactionPin transactionPin;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    public User(UUID id, String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum type,
            TransactionPin transactionPin, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    public User(String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum type,
            TransactionPin transactionPin) {
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createdAt = LocalDateTime.now();
    }
    public User(){}
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public TaxNumber getTaxNumber() {
        return taxNumber;
    }
    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public UserTypeEnum getType() {
        return type;
    }
    public void setType(UserTypeEnum type) {
        this.type = type;
    }
    public TransactionPin getTransactionPin() {
        return transactionPin;
    }
    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((taxNumber == null) ? 0 : taxNumber.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((transactionPin == null) ? 0 : transactionPin.hashCode());
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
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (taxNumber == null) {
            if (other.taxNumber != null)
                return false;
        } else if (!taxNumber.equals(other.taxNumber))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (type != other.type)
            return false;
        if (transactionPin == null) {
            if (other.transactionPin != null)
                return false;
        } else if (!transactionPin.equals(other.transactionPin))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        return true;
    }
}
