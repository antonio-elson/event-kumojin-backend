create table events(

    id bigint not null auto_increment,
    name VARCHAR(32) not null,
    description VARCHAR(100),
    start_date DATETIME not null,
    end_date DATETIME not null,

    primary key(id)
);