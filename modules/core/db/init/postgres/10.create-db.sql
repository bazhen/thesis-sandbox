-- begin SBOX_BUDGET_ITEM
create table SBOX_BUDGET_ITEM (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50),
    CODE varchar(3) not null,
    --
    primary key (ID)
)^
-- end SBOX_BUDGET_ITEM
-- begin SBOX_INVOICE
create table SBOX_INVOICE (
    CARD_ID uuid,
    --
    NUMBER_ varchar(50),
    CONTRACTOR_ID uuid not null,
    BUDGET_ITEM_ID uuid not null,
    PAYMENT_DATE date not null,
    AMOUNT decimal(19, 2) not null,
    PAYMENT_CONDITIONS varchar(4000) not null,
    --
    primary key (CARD_ID)
)^-- end SBOX_INVOICE
--Add default numerator for sbox$Invoice
CREATE OR REPLACE FUNCTION baseInsert()
RETURNS integer
AS $$
DECLARE
    cnt integer = 0;
BEGIN
cnt = (select count(id) from DF_NUMERATOR where CODE = 'InvoiceNumerator' and delete_ts is null);
if(cnt = 0) then
    INSERT INTO DF_NUMERATOR (ID, CREATE_TS, CREATED_BY, VERSION, CODE, NUMERATOR_FORMAT, SCRIPT_ENABLED,
    PERIODICITY, NUMBER_INITIAL_VALUE, LOC_NAME)
    VALUES ('cf3249cd-5773-4359-b8db-247790001242', now(), 'system', 1, 'InvoiceNumerator', 'СО-[number]', FALSE, 'Y', 1,
    '{"captionWithLanguageList":[{"language":"ru","caption":"Invoice"},{"language":"en","caption":"Invoice"}]}'
    );
end if;
return 0;
END;
$$
LANGUAGE plpgsql;
^
select baseInsert()^
drop function if exists baseInsert()^

-- begin addSecGroupConstraintsForInvoice
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('482d972c-3bc3-4150-adff-676330478c02', current_timestamp, 'admin', 'sbox$Invoice', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.global = true)', '8e6306e2-9e10-414a-b437-24c91ffef804')^

-- end addSecGroupConstraintsForInvoice
