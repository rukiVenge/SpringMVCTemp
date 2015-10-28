/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acss.training.web.beans;


import java.math.BigInteger;
import java.util.Calendar;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: 02 15, 13
 *
 */



public class TrialCustomerBean {

    
    private BigInteger profileId;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private int age;
    private Calendar bDate;
    private char gender;
    private char status;
    private String address;
    private String contactNumber;
    private String emailAddress;

   
    public TrialCustomerBean() {
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
