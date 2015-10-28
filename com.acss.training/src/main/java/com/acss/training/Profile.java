/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
 * <p>
 * This class represent a profile table located at <code>m_profile</code>
 * The profile contains customer information
 * </p>
 * 
 * @author Mark Kelvin DG. Pineda
 * @since February 12, 2013
 */

@Entity
@Table(name="m_profile")
@SequenceGenerator(name="profile_id_seq_gen",sequenceName="profile_id_seq_gen",allocationSize=0)
public class Profile implements Serializable {
    @Id @GeneratedValue(generator="profile_id_seq_gen", strategy= GenerationType.SEQUENCE)
    @Column(name="profile_id", nullable=false, unique=true)
    private BigInteger profileId;
    
    @Column(name="first_name", nullable=false, length=50)
    private String firstName;
    
    @Column(name="middle_name", length=50)
    private String middleName;
    
    @Column(name="last_name", nullable=false, length=50)
    private String lastName;
    
    @Column(name="gender", nullable=false, length=50)
    private char gender;
    
    @Temporal(TemporalType.DATE)
    @Column(name="birth_date")
    private Calendar birthDate;
    
    @Column(name="marital_status", length=1)
    private char maritalStatus;
    
    @Column(name="mobile_no", length=11)
    private String mobileNo;
    
    @Column(name="email_address", length=50)
    private String emailAddress;
    
    @OneToOne(fetch= FetchType.EAGER, mappedBy="owner")
    @Cascade (CascadeType.ALL)
    private AccountSettings accountSettings;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy="owner")
    @Cascade(CascadeType.ALL)
    private List<Contact> contacts;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy="owner")
    @Cascade(CascadeType.ALL)
    private List<Card> card;
    
    
    @Embedded
    @AttributeOverrides(
            value = {
        @AttributeOverride(name = "street", column =@Column(name = "street", length = 22)),
        @AttributeOverride(name = "district", column =@Column(name = "district", length = 12)),
        @AttributeOverride(name = "city", column =@Column(name = "city", length = 12)),
        @AttributeOverride(name = "province", column =@Column(name = "province", length = 8)),
        @AttributeOverride(name = "postalCode", column =@Column(name = "postal_code", length = 6))
    })
     
//    @Column(name="street", length=22)
//    private String street;
//    
//    @Column(name="district", length=12)
//    private String district;
//    
//    @Column(name="city", length=12)
//    private String city;
//    
//    @Column(name="province", length=8)
//    private String province;
//    
//    @Column(name="postal_code", length=6)
//    private String postalCode;
 
    private Address address;
    
    @Version
    @Column(name="rec_version", nullable=false)
    private Integer recordVersion;

   
    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }
    
    /**
     * Default Constructor
     */
    public Profile() {}
    
    /**
     * 
     * @param profileId a <code>BigInteger</code> value containing the id
     */
  
    
    /**
     * This method will get a marital status of a customer
     * @return <code>maritalStatus</code>
     */
    public char getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(char maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getRecordVersion() {
        return recordVersion;
    }

    public Address getAddress() {
        return address;
    }

    
    
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getDistrict() {
//        return district;
//    }
//
//    public void setDistrict(String district) {
//        this.district = district;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getProvince() {
//        return province;
//    }
//
//    public void setProvince(String province) {
//        this.province = province;
//    }
//
//    public String getPostalCode() {
//        return postalCode;
//    }

    public AccountSettings getAccountSettings() {
        return accountSettings;
    }

    public void setAccountSettings(AccountSettings accountSettings) {
        this.accountSettings = accountSettings;
    }
    



//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
    

    public BigInteger getProfileId() {
        return profileId;
    }

    public void setProfileId(BigInteger profileId) {
        this.profileId = profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
    
    public Profile(BigInteger profileId) {
        this.profileId = profileId;
    }
    
    
    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.profileId != null ? this.profileId.hashCode() : 0);
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
        final Profile other = (Profile) obj;
        if (this.profileId != other.profileId && (this.profileId == null || !this.profileId.equals(other.profileId))) {
            return false;
        }
        return true;
    }
    
    
    
}
