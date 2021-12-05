create schema if not exists gpu;
set search_path to gpu;

create type fanOperatingMode as enum ('HIGH', 'NORMAL', 'LOW');

create type loadQuantity as enum ('HIGH', 'MIDDLE', 'LOW');

create table gpu
(
    id bigserial primary key,
    name VARCHAR(20),
    temperature DOUBLE PRECISION,
    fanOperatingMode fanOperatingMode,
    loadQuantity loadQuantity
);