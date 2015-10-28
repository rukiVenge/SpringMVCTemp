/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author Mark Kelvin DG. Pineda
 * @date created: February 14, 2013
 *
 */
@Entity
@Table(name = "m_point_bucket")
public class PointBucket {

//  card_no character varying NOT NULL,
//  running_balance integer NOT NULL,
//  last_update timestamp with time zone NOT NULL,
//  last_tx_type integer NOT NULL,
//  rec_version integer NOT NULL,
//  CONSTRAINT m_point_bucket_pkey PRIMARY KEY (card_no)
    //@Column(name="card_no", nullable=false, unique=true)
    @Id
    @Column(name = "card_no", nullable = false, unique = true)
    private String cardNo;
    
    @Column(name = "running_balance", nullable = false)
    private int runningBalance;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update", nullable = false)
    private Calendar lastUpdate;
    
    @Column(name = "last_tx_type", nullable = false)
    private int lastTxType;
    
    @Version
    @Column(name = "rec_version", nullable = false)
    private int recordVersion;

    public PointBucket() {
    }

    public PointBucket(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(int runningBalance) {
        this.runningBalance = runningBalance;
    }

    public Calendar getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Calendar lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getLastTxType() {
        return lastTxType;
    }

    public void setLastTxType(int lastTxType) {
        this.lastTxType = lastTxType;
    }

    public int getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(int recordVersion) {
        this.recordVersion = recordVersion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.cardNo != null ? this.cardNo.hashCode() : 0);
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
        final PointBucket other = (PointBucket) obj;
        if ((this.cardNo == null) ? (other.cardNo != null) : !this.cardNo.equals(other.cardNo)) {
            return false;
        }
        return true;
    }
}
