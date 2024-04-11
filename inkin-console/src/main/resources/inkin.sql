CREATE TABLE IF NOT EXISTS PUBLIC.assess
(
    id             int auto_increment
        primary key,
    user_id        int          null,
    score          double       null,
    comment        varchar(512) not null,
    character_name varchar(32)  not null,
    image_id       int          null,
    paraphrase     varchar(512) not null,
    create_time    datetime     null default now()
);

CREATE TABLE IF NOT EXISTS PUBLIC.image
(
    id          int auto_increment
        primary key,
    data        LONGBLOB null,
    create_time datetime null default now()
);

CREATE TABLE IF NOT EXISTS PUBLIC.inkin_user
(
    id          int auto_increment primary key,
    name        varchar(32)  not null,
    password    varchar(128) null,
    create_time timestamp default current_timestamp()
);
