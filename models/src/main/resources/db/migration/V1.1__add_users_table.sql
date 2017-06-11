create table users(
	id serial primary key,
	identity  character varying(15)  not null,
	name      character varying(35)  not null,
	surname   character varying(35)  not null,
	email     character varying(35)  not null,
	login     character varying(35)  not null unique,
    password  character varying(100) not null,
    enable 	  character varying(10),
    account_non_expired  character varying(10),
    credential_non_expired character varying(10),
    account_non_locked  character varying(10),
    id_ing integer
);