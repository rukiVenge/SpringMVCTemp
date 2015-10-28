/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "c_card_info")
public class Card implements Serializable {

//  card_no character varying(19) NOT NULL,
//  profile_id bigint,
//  activation_date date,
//  card_expiry date,
//  card_status integer NOT NULL DEFAULT 0, -- 0 - Normal...
//  rec_version integer NOT NULL,
//  CONSTRAINT c_card_info_pkey PRIMARY KEY (card_no),
//  CONSTRAINT c_card_info_profile_id_fkey FOREIGN KEY (profile_id)
//      REFERENCES m_profile (profile_id) MATCH SIMPLE
//      ON UPDATE NO ACTION ON DELETE NO ACTION
    
    @Id
    @Column(name = "card_no", nullable = false, unique = true)
    private String cardNo;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "activation_date")
    private Calendar activationDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "card_expiry")
    private Calendar expiryDate;
    
    @Column(name = "card_status", nullable = false)
    private int cardStatus;
    
    @Version
    @Column(name = "rec_version", nullable = false)
    private int recordVersion;
    
    
    @ManyToOne(fetch= FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name="profile_id",referencedColumnName="profile_id")
    public Profile owner;
    
    
    @OneToMany(fetch= FetchType.LAZY,mappedBy="cOwner")
    @Cascade(CascadeType.ALL)
    private List<Transactions> tOwner;
    
    @OneToOne(fetch= FetchType.EAGER)
    @Cascade (CascadeType.ALL)
    @JoinColumn(name="card_no",referencedColumnName="card_no")
    private PointBucket pointBucket;
    

    /**
     * Default Constructor
     */
    public Card() {
    }

    /**
     *
     * @param cardNo
     */
    public Card(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }


    public Calendar getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Calendar activationDate) {
        this.activationDate = activationDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(int cardStatus) {
        this.cardStatus = cardStatus;
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

    public List<Transactions> gettOwner() {
        return tOwner;
    }

    public void settOwner(List<Transactions> tOwner) {
        this.tOwner = tOwner;
    }

    public PointBucket getPointBucket() {
        return pointBucket;
    }

    public void setPointBucket(PointBucket pointBucket) {
        this.pointBucket = pointBucket;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.cardNo != null ? this.cardNo.hashCode() : 0);
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
        final Card other = (Card) obj;
        if ((this.cardNo == null) ? (other.cardNo != null) : !this.cardNo.equals(other.cardNo)) {
            return false;
        }
        return true;
    }
}
