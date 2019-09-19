/*
 * Copyright (c) 2019 com.company.thesissandbox.core.listener
 */
package com.company.thesissandbox.core.listener;

import com.company.thesissandbox.entity.Invoice;
import com.haulmont.cuba.core.Persistence;
import org.apache.commons.lang.StringUtils;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Set;
import javax.annotation.ManagedBean;
import javax.inject.Inject;

/**
 * @author ebazhenov
 */
@ManagedBean("sbox_InvoiceListener")
public class InvoiceListener implements BeforeUpdateEntityListener<Invoice>, BeforeInsertEntityListener<Invoice> {

    @Inject
    protected Persistence persistence;

    @Override
    public void onBeforeUpdate(Invoice entity) {

        Set<String> fields = persistence.getTools().getDirtyFields(entity);

        if (CollectionUtils.containsAny(fields, Arrays.asList("number"))){
            StringBuilder description=new StringBuilder();
            description.append(StringUtils.trimToEmpty(entity.<String>getValue("number")));
            entity.setDescription(description.toString());
        }
    }

    @Override
    public void onBeforeInsert(Invoice entity) {
        onBeforeUpdate(entity);
    }
}