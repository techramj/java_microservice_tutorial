insert into medicine(id,name) values (1001,'Epogen');
insert into medicine(id,name) values (1002,'Iodex');
insert into medicine(id,name) values (1003,'Vicks');
insert into medicine(id,name) values (1004,'Crocin');
insert into medicine(id,name) values (1005,'Disprin');
insert into medicine(id,name) values (1006,'Metacin');

insert into medicine_patient_id(medicine_id,patient_id) values (1001,1);
insert into medicine_patient_id(medicine_id,patient_id) values (1002,1);
insert into medicine_patient_id(medicine_id,patient_id) values (1003,2);
insert into medicine_patient_id(medicine_id,patient_id) values (1002,2);
insert into medicine_patient_id(medicine_id,patient_id) values (1004,3);
insert into medicine_patient_id(medicine_id,patient_id) values (1005,4);
insert into medicine_patient_id(medicine_id,patient_id) values (1004,4);