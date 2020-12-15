package com.database.endingCredit.domain.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Accounts {
    
    @EmbeddedId
    private AccountsIdentity accountsIdentity;

    private String CustomerId;
    private String AccountType;

    @GeneratedValue
    private LocalDateTime AcctCreateDate;
    


    /**
     * @return AccountsIdentity return the accountsIdentity
     */
    public AccountsIdentity getAccountsIdentity() {
        return accountsIdentity;
    }

    /**
     * @param accountsIdentity the accountsIdentity to set
     */
    public void setAccountsIdentity(AccountsIdentity accountsIdentity) {
        this.accountsIdentity = accountsIdentity;
    }

    /**
     * @return String return the CustomerId
     */
    public String getCustomerId() {
        return CustomerId;
    }

    /**
     * @param CustomerId the CustomerId to set
     */
    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    /**
     * @return String return the AccountType
     */
    public String getAccountType() {
        return AccountType;
    }

    /**
     * @param AccountType the AccountType to set
     */
    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }

    /**
     * @return LocalDateTime return the AcctCreateDate
     */
    public LocalDateTime getAcctCreateDate() {
        return AcctCreateDate;
    }

    /**
     * @param AcctCreateDate the AcctCreateDate to set
     */
    public void setAcctCreateDate(LocalDateTime AcctCreateDate) {
        this.AcctCreateDate = AcctCreateDate;
    }

}
