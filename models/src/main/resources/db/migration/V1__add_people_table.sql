create table people(
	id serial primary key,
	name character varying(35) not null,
	surname character varying(35) not null,
	identity character varying(15) unique not null
);