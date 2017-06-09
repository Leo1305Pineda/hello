alter sequence  people_id_seq restart;
insert into people(id,name,surname,identity) values (nextval('people_id_seq'),'Isandra Yulianny','Martinez Martinez','V-22158784');