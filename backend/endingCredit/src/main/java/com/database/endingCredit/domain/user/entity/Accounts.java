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

    private String customerId;
    private String accountType;

    @GeneratedValue
    private LocalDateTime acctCreateDate;


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
     * @return String return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return String return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return LocalDateTime return the acctCreateDate
     */
    public LocalDateTime getAcctCreateDate() {
        return acctCreateDate;
    }

    /**
     * @param acctCreateDate the acctCreateDate to set
     */
    public void setAcctCreateDate(LocalDateTime acctCreateDate) {
        this.acctCreateDate = acctCreateDate;
    }

}
