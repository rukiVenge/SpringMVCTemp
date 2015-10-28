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
import javax.persistence.ManyToOne;
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
 * @date created: February 14, 2013
 *
 */

@Entity
@Table(name="m_contact_number")
@SequenceGenerator(name="contact_id_seq_gen", sequenceName="contact_id_seq_gen",allocationSize=0)
public class Contact implements Serializable {

//    contact_id bigint NOT NULL,
//  value character varying(20) NOT NULL,
//  contact_type integer NOT NULL, -- 0 - Mobile...
//  is_active boolean NOT NULL,
//  from_date date NOT NULL,
//  to_date date,
//  rec_version integer NOT NULL,
//  profile_id bigint NOT NULL,
//  CONSTRAINT contact_numbers_pkey PRIMARY KEY (contact_id),
//  CONSTRAINT contact_numbers_profile_id_fkey FOREIGN KEY (profile_id)
//      REFERENCES m_profile (profile_id) MATCH SIMPLE
//      ON UPDATE NO ACTION ON DELETE NO ACTION
    
    @Id @GeneratedValue(generator="contact_id_seq_gen", strategy= GenerationType.SEQUENCE)
    @Column(name="contact_id", nullable=false, unique=true)
    private BigInteger contactId;
    
    @Column(name="value_c", nullable=false, length=20)
    private String value;
    
    @Column(name="contact_type", nullable=false)
    private int contactType;
    
    @Column(name="is_active", nullable=false)
    private boolean IsActive;
    
    @Temporal(TemporalType.DATE)
    @Column(name="from_date", nullable=false)
    private Calendar fromDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name="to_date")
    private Calendar toDate;
    
    @Version
    @Column(name="rec_version", nullable=false)
    private int recordVersion;
   
    
    @ManyToOne(fetch= FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name="profile_id",referencedColumnName="profile_id")
    public Profile owner;
    

     /**
     * Default Constructor
     */
    public Contact() {
    }

    /**
     * 
     * @param contactId 
     */
    public Contact(BigInteger contactId) {
        this.contactId = contactId;
    }

    public BigInteger getContactId() {
        return contactId;
    }

    public void setContactId(BigInteger contactId) {
        this.contactId = contactId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getContactType() {
        return contactType;
    }

    public void setContactType(int contactType) {
        this.contactType = contactType;
    }

    public Profile getOwner() {
        return owner;
    }

    public void setOwner(Profile owner) {
        this.owner = owner;
    }
    
    

    public boolean getcIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean cIsActive) {
        this.IsActive = cIsActive;
    }

    public Calendar getFromDate() {
        return fromDate;
    }

    public void setFromDate(Calendar fromDate) {
        this.fromDate = fromDate;
    }

    public Calendar getToDate() {
        return toDate;
    }

    public void setToDate(Calendar toDate) {
        this.toDate = toDate;
    }

    public int getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(int recordVersion) {
        this.recordVersion = recordVersion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.contactId != null ? this.contactId.hashCode() : 0);
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
        final Contact other = (Contact) obj;
        if (this.contactId != other.contactId && (this.contactId == null || !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }
    
    
    
    


    


}
