create schema if not exists cpu;
set search_path to cpu;

create type loadSharing as enum ('BALANCED', 'UNBALANCED', 'SINGLE');

create type loadQuantity as enum ('HIGH', 'MIDDLE', 'LOW');

create table cpu_history
(
    id bigserial primary key,
    time TIMESTAMP,
    overclocking BOOLEAN,
    frequency DOUBLE PRECISION,
    temperature DOUBLE PRECISION,
    load_sharing loadSharing,
    load_quantity loadQuantity
);

create table cpu_config
(
    id bigserial primary key,
    name VARCHAR(20),
    overclocking BOOLEAN,
    frequency BOOLEAN,
    temperature BOOLEAN,
    load_sharing BOOLEAN,
    load_quantity BOOLEAN

);
