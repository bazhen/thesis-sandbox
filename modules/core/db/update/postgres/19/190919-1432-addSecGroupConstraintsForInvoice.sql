-- begin addSecGroupConstraintsForInvoice
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('482d972c-3bc3-4150-adff-676330478c02', current_timestamp, 'admin', 'sbox$Invoice', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.global = true)', '8e6306e2-9e10-414a-b437-24c91ffef804')^

-- end addSecGroupConstraintsForInvoice
