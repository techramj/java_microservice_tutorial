-- create table person(
--     id integer primary key,
--     name varchar2(100),
--     location varchar2(100),
--     birth_date timestamp
-- );

insert into person(id, name, birth_date, location)
values (10001, ''Kiran'', sysdate(), ''Raipur'');
insert into person(id, name, birth_date, location)
values (10002, ''Jack'', sysdate(), ''Pune'');
insert into person(id, name, birth_date, location)
values (10003, ''Jill'', sysdate(), ''Mumbai'');
insert into person(id, name, birth_date, location)
values (10004, ''Roy'', sysdate(), ''Bhopal'');

insert into course(id, name)
values (101, ''Java'');
insert into course(id, name)
values (102, ''Hibernate'');

insert into passport(id, passport_no)
values (101, ''ABCD0001'');
insert into passport(id, passport_no)
values (102, ''ABCD0002'');
insert into passport(id, passport_no)
values (103, ''ABCD0003'');

insert into student(id, name, passport_id)
values (20001, ''Jack'', 101);
insert into student(id, name, passport_id)
values (20002, ''Adam'', 102);
insert into student(id, name, passport_id)
values (20003, ''Bob'', 103);



insert into review(id, rating, description)
values (50001, ''5'', ''Great course'');
insert into review(id, rating, description)
values (50002, ''5'', ''Great course'');
insert into review(id, rating, description)
values (50003, ''4'', ''Awsome course'');
insert into review(id, rating, description)
values (50004, ''3'', ''Great course'');

