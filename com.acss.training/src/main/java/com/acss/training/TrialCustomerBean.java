/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: 02 15, 13
 *
 */


@Entity
@Table(name="customer_information")
@SequenceGenerator(name="customer_id_seq_gen",sequenceName="customer_id_seq_gen",allocationSize=0)
public class TrialCustomerBean implements Serializable{

    @Id @GeneratedValue(generator="customer_id_seq_gen", strategy= GenerationType.SEQUENCE)
    @Column(name="customer_id", nullable=false, unique=true)
    private BigInteger profileId;
    
    @Column(name="first_name", nullable=false)
    private String firstName;
    
    @Column(name="middle_initial")
    private String middleInitial;
            
    @Column(name="last_name", nullable=false)
    private String lastName;
    
    @Column(name="age")
    private int age;
    
    @Temporal(TemporalType.DATE)
    @Column(name="birth_date" )
    private Calendar bDate;
    
    @Column(name="gender" )
    private char gender;
    
   @Column(name="marital_status" )
    private char status;

   @Column(name="address" )
    private String address;
   
   @Column(name="contact_number" )
    private String contactNumber;
   
   @Column(name="email_address" )
    private String emailAddress;
   
   @Version
   @Column(name="rec_version", nullable=false)
   private int recordVersion;
   

    public TrialCustomerBean() {
    }

    public TrialCustomerBean(BigInteger profileId) {
        this.profileId = profileId;
    }

    
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

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Calendar getbDate() {
        return bDate;
    }

    public void setbDate(Calendar bDate) {
        this.bDate = bDate;
    }
    

    public char getGender() {
        return gender;
    }
    

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.profileId != null ? this.profileId.hashCode() : 0);
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
        final TrialCustomerBean other = (TrialCustomerBean) obj;
        if (this.profileId != other.profileId && (this.profileId == null || !this.profileId.equals(other.profileId))) {
            return false;
        }
        return true;
    }
    
    
    

}
