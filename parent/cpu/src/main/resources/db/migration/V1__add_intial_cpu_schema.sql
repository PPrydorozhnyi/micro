create schema if not exists cpu;
set search_path to cpu;

create type loadSharing as enum ('BALANCED', 'UNBALANCED', 'SINGLE');

create type loadQuantity as enum ('HIGH', 'MIDDLE', 'LOW');

create table cpu
(
    id bigserial primary key,
    name VARCHAR(20),
    overclocking DECIMAL,
    frequency DOUBLE PRECISION,
    temperature DOUBLE PRECISION,
    loadSharing loadSharing,
    loadQuantity loadQuantity
);
