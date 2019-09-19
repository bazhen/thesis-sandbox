--Remove permissions for entity sbox$Invoce
delete from sec_permission where target like 'sbox$Invoce:%'^
delete from sec_permission where target like 'sbox$Invoce.%'^
