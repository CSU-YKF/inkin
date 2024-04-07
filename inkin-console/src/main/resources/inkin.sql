CREATE DATABASE IF NOT EXISTS inkin;

CREATE TABLE IF NOT EXISTS inkin.assess
(
    id             int auto_increment
        primary key,
    user_id        int          null,
    score          double       null,
    comment        varchar(512) not null,
    character_name varchar(32)  not null,
    paraphrase     varchar(512) not null,
    create_time    datetime     null default now()
);

CREATE TABLE IF NOT EXISTS inkin.image
(
    id          int auto_increment
        primary key,
    data        LONGBLOB null,
    create_time datetime null default now()
);

CREATE TABLE IF NOT EXISTS inkin.user
(
    id          int auto_increment
        primary key,
    name        varchar(32)  not null,
    password    varchar(128) null comment 'salted',
    create_time datetime     null default now()
);
