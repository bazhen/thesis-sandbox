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
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@NamePattern("%s|name")
@Table(name = "SBOX_BUDGET_ITEM")
@Entity(name = "sbox$BudgetItem")
@EnableRestore
@TrackEditScreenHistory
public class BudgetItem extends StandardEntity {
    private static final long serialVersionUID = -1922458602109657059L;

    @Column(name = "NAME", length = 50)
    protected String name;

    @Column(name = "CODE", nullable = false, length = 3)
    protected String code;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}