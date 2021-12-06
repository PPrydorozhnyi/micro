create schema if not exists disc;
set search_path to disc;

create type integrity as enum ('DAMAGED', 'WHOLE');

create table disc_history
(
    id bigserial primary key,
    time TIMESTAMP,
    temperature DOUBLE PRECISION,
    speed DOUBLE PRECISION,
    integrity integrity
);

create table disc_config
(
    id bigserial primary key,
    name VARCHAR(20),
    temperature BOOLEAN,
    speed BOOLEAN,
    integrity BOOLEAN
);
