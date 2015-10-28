/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @since February 14, 2013
 */

@Entity
@Table(name="m_account")
@SequenceGenerator(name="account_id_seq_gen", sequenceName="account_id_seq_gen",allocationSize=0)
public class AccountSettings implements Serializable{

    @Id @GeneratedValue(generator="account_id_seq_gen",strategy= GenerationType.SEQUENCE)
    @Column(name="account_id", nullable=false)
    private BigInteger accountId;
    
    @Column(name="password", nullable=false)
    private String password;
    
    @Temporal(TemporalType.DATE)
    @Column(name="expiry_date", nullable=false)
    private Calendar expiryDate;
    
    @Column(name="pin_code", nullable=false)
    private String pinCode;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="first_login", nullable=false)
    private Calendar firstLogin;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_login", nullable=false)
    private Calendar lastLogin;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_pin_change", nullable=false)
    private Calendar lastPinChange;
    
    @Version
    @Column(name="rec_version", nullable=false)
    private int recordVersion;
    
    @OneToOne(fetch=FetchType.EAGER)
    @Cascade (CascadeType.ALL)
    @JoinColumn(name="profile_id",referencedColumnName="profile_id")
    private Profile owner;

    /**
     * Default Constructor
     */
    public AccountSettings() {
    }

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Calendar getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Calendar firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Calendar getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Calendar lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Calendar getLastPinChange() {
        return lastPinChange;
    }

    public void setLastPinChange(Calendar lastPinChange) {
        this.lastPinChange = lastPinChange;
    }

    public int getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(int recordVersion) {
        this.recordVersion = recordVersion;
    }

    public Profile getOwner() {
        return owner;
    }

    public void setOwner(Profile owner) {
        this.owner = owner;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.accountId != null ? this.accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccountSettings other = (AccountSettings) obj;
        if (this.accountId != other.accountId && (this.accountId == null || !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    
    

}
