create TABLE USERS (
    id serial primary key,
    lastname varchar(255),
    firstname varchar(255),
    middlename varchar(255),
    email varchar(100) unique,
    phone varchar(100)
)