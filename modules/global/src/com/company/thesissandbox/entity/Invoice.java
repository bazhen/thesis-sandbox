/*
 * Copyright (c) 2019 com.company.thesissandbox.entity
 */
package com.company.thesissandbox.entity;


/**
 * @author ebazhenov
 */
import com.haulmont.cuba.core.entity.annotation.EnableRestore;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
import com.haulmont.thesis.core.entity.Company;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.thesis.core.entity.TsCard;
import com.haulmont.cuba.core.entity.annotation.Listeners;

@Listeners("sbox_InvoiceListener")
@PrimaryKeyJoinColumn(name = "CARD_ID", referencedColumnName = "ID")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("1")
@Table(name = "SBOX_INVOICE")
@Entity(name = "sbox$Invoice")
@EnableRestore
@TrackEditScreenHistory
public class Invoice extends TsCard {
    private static final long serialVersionUID = 8331758707349405050L;

    @Column(name = "NUMBER_", length = 50)
    protected String number;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONTRACTOR_ID")
    protected Company contractor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BUDGET_ITEM_ID")
    protected BudgetItem budgetItem;

    @Temporal(TemporalType.DATE)
    @Column(name = "PAYMENT_DATE", nullable = false, length = 50)
    protected Date paymentDate;

    @Column(name = "AMOUNT", nullable = false, length = 50)
    protected BigDecimal amount;

    @Column(name = "PAYMENT_CONDITIONS", nullable = false, length = 4000)
    protected String paymentConditions;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setContractor(Company contractor) {
        this.contractor = contractor;
    }

    public Company getContractor() {
        return contractor;
    }

    public void setBudgetItem(BudgetItem budgetItem) {
        this.budgetItem = budgetItem;
    }

    public BudgetItem getBudgetItem() {
        return budgetItem;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setPaymentConditions(String paymentConditions) {
        this.paymentConditions = paymentConditions;
    }

    public String getPaymentConditions() {
        return paymentConditions;
    }


}