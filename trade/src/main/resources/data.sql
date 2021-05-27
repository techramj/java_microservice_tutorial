create sequence if not exists seq_book_id start with 1 increment by 1;
create sequence if not exists seq_company_id start with 1 increment by 1;
create sequence if not exists seq_trade_id start with 1 increment by 1;
create sequence if not exists seq_counter_party_id start with 1 increment by 1;

insert into book(id, name) values ('B'||seq_book_id.nextval,'booking1');
insert into book(id, name) values ('B'||seq_book_id.nextval,'booking2');
insert into book(id, name) values ('B'||seq_book_id.nextval,'booking3');

insert into company(id, name) values ('C'||seq_company_id.nextval,  'TCS');
insert into company(id, name) values ('C'||seq_company_id.nextval,  'INFY');
insert into company(id, name) values ('C'||seq_company_id.nextval,  'DMART');



insert into counter_party(id, name) values ('CP-'||seq_counter_party_id.nextval,'party-1');
insert into counter_party(id, name) values ('CP-'||seq_counter_party_id.nextval,'party-2');
insert into counter_party(id, name) values ('CP-'||seq_counter_party_id.nextval,'party-3');

insert into trade(id, currency, quantity, unit_price, buyer_id, company_id, seller_id)
values ('T'||seq_trade_id.nextval, 'INR', 10, 50,  'B1'  , 'C1' ,'B2');
insert into trade(id, currency, quantity, unit_price, buyer_id, company_id, seller_id)
values ('T'||seq_trade_id.nextval, 'INR', 10, 50,  'B1'  , 'C1' ,'B3');
insert into trade(id, currency, quantity, unit_price, buyer_id, company_id, seller_id)
values ('T'||seq_trade_id.nextval, 'INR', 10, 50,  'B2'  , 'C2' ,'B2');



insert into TRADE_STORE (TRADE_ID ,SERIAL_NO ,COUNTER_PARTY_ID ,BOOK_ID ,MATURITY_DATE ,CREATED_DATE ,EXPIRED ) values
('T1', 1, 'CP-1', 'B1',  to_date('20-05-2020' , 'dd-mm-yyyy'), sysdate(), 'N' );

insert into TRADE_STORE (TRADE_ID ,SERIAL_NO ,COUNTER_PARTY_ID ,BOOK_ID ,MATURITY_DATE ,CREATED_DATE ,EXPIRED ) values
('T2', 2, 'CP-2', 'B1',  to_date('20-05-2021' , 'dd-mm-yyyy'), sysdate(), 'N' );

insert into TRADE_STORE (TRADE_ID ,SERIAL_NO ,COUNTER_PARTY_ID ,BOOK_ID ,MATURITY_DATE ,CREATED_DATE ,EXPIRED ) values
('T2', 1, 'CP-1', 'B1',  to_date('20-05-2021' , 'dd-mm-yyyy'), sysdate(), 'N' );

insert into TRADE_STORE (TRADE_ID ,SERIAL_NO ,COUNTER_PARTY_ID ,BOOK_ID ,MATURITY_DATE ,CREATED_DATE ,EXPIRED ) values
('T2', 3, 'CP-3', 'B1',  to_date('20-05-2014' , 'dd-mm-yyyy'), sysdate(), 'N' );




