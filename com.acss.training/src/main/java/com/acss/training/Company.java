/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acss.training;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Mark Kelvin DG. Pineda
 */
@Entity
@Table(name = "m_company")
@SequenceGenerator(name = "company_id_seq_gen", sequenceName = "company_id_seq_gen", allocationSize = 0)
public class Company implements Serializable {

    @Id
    @GeneratedValue(generator = "company_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "company_id", nullable = false, unique = true)
    private BigInteger companyId;
    @Column(name = "comp_name", length = 60)
    private String companyName;
//    @Column(name="addr_street",length=22)
//    private String addrStreet;
//    
//    @Column(name="addr_district",length=12)
//    private String addrDistrict;
//    
//    @Column(name="addr_city",length=12)
//    private String addrCity;
//    
//    @Column(name="addr_province",length=8)
//    private String addrProvince;
//    
//    @Column(name="addr_postal_code",length=6)
//    private String addrPostalCode;
    @Embedded
    @AttributeOverrides(
            value = {
        @AttributeOverride(name = "street", column =
        @Column(name = "addr_street", length = 22)),
        @AttributeOverride(name = "district", column =
        @Column(name = "addr_district", length = 12)),
        @AttributeOverride(name = "city", column =
        @Column(name = "addr_city", length = 12)),
        @AttributeOverride(name = "province", column =
        @Column(name = "addr_province", length = 8)),
        @AttributeOverride(name = "postalCode", column =
        @Column(name = "addr_postal_code", length = 6))
    })
    
    private Address address;
    
    @Version
    @Column(name = "rec_version")
    private Integer recordVersion;

    public Company() {
    }

    public Address getAddress() {
        return address;
    }

    public BigInteger getCompanyId() {
        return companyId;
    }

    public void setCompanyId(BigInteger companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

//    public String getAddrStreet() {
//        return addrStreet;
//    }
//
//    public void setAddrStreet(String addrStreet) {
//        this.addrStreet = addrStreet;
//    }
//
//    public String getAddrDistrict() {
//        return addrDistrict;
//    }
//
//    public void setAddrDistrict(String addrDistrict) {
//        this.addrDistrict = addrDistrict;
//    }
//
//    public String getAddrCity() {
//        return addrCity;
//    }
//
//    public void setAddrCity(String addrCity) {
//        this.addrCity = addrCity;
//    }
//
//    public String getAddrProvince() {
//        return addrProvince;
//    }
//
//    public void setAddrProvince(String addrProvince) {
//        this.addrProvince = addrProvince;
//    }
//
//    public String getAddrPostalCode() {
//        return addrPostalCode;
//    }
//
//    public void setAddrPostalCode(String addrPostalCode) {
//        this.addrPostalCode = addrPostalCode;
//    }
    public Integer getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Default constructor
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.companyId != null ? this.companyId.hashCode() : 0);
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
        final Company other = (Company) obj;
        if (this.companyId != other.companyId && (this.companyId == null || !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }
}
