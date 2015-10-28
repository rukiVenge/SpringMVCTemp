/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_transaction")
public class Transactions implements Serializable {

//      tx_no character varying(15) NOT NULL,
//  card_no character varying(19) NOT NULL,
//  tx_timestamp timestamp with time zone NOT NULL,
//  tx_type integer NOT NULL, -- 0 - rewarding...
//  point_value integer NOT NULL,
//  rec_version integer NOT NULL,
//  CONSTRAINT t_transaction_pkey PRIMARY KEY (tx_no),
//  CONSTRAINT t_transaction_card_no_fkey FOREIGN KEY (card_no)
//      REFERENCES c_card_info (card_no) MATCH SIMPLE
//      ON UPDATE NO ACTION ON DELETE NO ACTION
    @Id
    @Column(name = "tx_no", nullable = false, unique = true)
    private String txNo;
     
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tx_timestamp", nullable = false)
    private Calendar txTimestamp;
    
    @Column(name = "tx_type", nullable = false)
    private int txType;
    
    @Column(name = "point_value", nullable = false)
    private int pointValue;
    
    @Version
    @Column(name = "rec_version", nullable = false)
    private int recordVersion;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name="card_no",referencedColumnName="card_no")
    public Card cOwner;

    /**
     * Default Constructor
     */
    public Transactions() {
    }

    /**
     *
     * @param txNo
     */
    public Transactions(String txNo) {
        this.txNo = txNo;
    }

    public String getTxNo() {
        return txNo;
    }

    public void setTxNo(String txNo) {
        this.txNo = txNo;
    }

    public Calendar getTxTimestamp() {
        return txTimestamp;
    }

    public void setTxTimestamp(Calendar txTimestamp) {
        this.txTimestamp = txTimestamp;
    }

    public int getTxType() {
        return txType;
    }

    public void setTxType(int txType) {
        this.txType = txType;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public int getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(int recordVersion) {
        this.recordVersion = recordVersion;
    }

    public Card getcOwner() {
        return cOwner;
    }

    public void setcOwner(Card cOwner) {
        this.cOwner = cOwner;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.txNo != null ? this.txNo.hashCode() : 0);
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
        final Transactions other = (Transactions) obj;
        if ((this.txNo == null) ? (other.txNo != null) : !this.txNo.equals(other.txNo)) {
            return false;
        }
        return true;
    }
}
