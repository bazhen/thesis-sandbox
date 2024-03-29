-- begin SBOX_INVOICE
alter table SBOX_INVOICE add constraint FK_SBOX_INVOICE_CONTRACTOR_ID foreign key (CONTRACTOR_ID) references DF_COMPANY(CONTRACTOR_ID)^
alter table SBOX_INVOICE add constraint FK_SBOX_INVOICE_BUDGET_ITEM_ID foreign key (BUDGET_ITEM_ID) references SBOX_BUDGET_ITEM(ID)^
alter table SBOX_INVOICE add constraint FK_SBOX_INVOICE_CARD_ID foreign key (CARD_ID) references WF_CARD(ID)^
create index IDX_SBOX_INVOICE_CONTRACTOR on SBOX_INVOICE (CONTRACTOR_ID)^
create index IDX_SBOX_INVOICE_BUDGET_ITEM on SBOX_INVOICE (BUDGET_ITEM_ID)^
-- end SBOX_INVOICE
