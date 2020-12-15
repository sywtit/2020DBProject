package com.database.endingCredit.domain.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {
    
    private String LastName;
    private String FirstName;
    private String Email;
    private String PhoneNum;
    private String CreditNum;
    private String Password;

    private String AccountType;
    

    /**
     * @return String return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return String return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return String return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return String return the PhoneNum
     */
    public String getPhoneNum() {
        return PhoneNum;
    }

    /**
     * @param PhoneNum the PhoneNum to set
     */
    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    /**
     * @return String return the CreditNum
     */
    public String getCreditNum() {
        return CreditNum;
    }

    /**
     * @param CreditNum the CreditNum to set
     */
    public void setCreditNum(String CreditNum) {
        this.CreditNum = CreditNum;
    }

    /**
     * @return String return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
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

}
