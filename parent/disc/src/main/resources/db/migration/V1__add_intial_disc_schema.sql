create schema if not exists disc;
set search_path to disc;

create type integrity as enum ('DAMAGED', 'WHOLE');

create table disc
(
    id bigserial primary key,
    name VARCHAR(20),
    temperature DOUBLE PRECISION,
    speed DOUBLE PRECISION,
    integrity integrity
);
