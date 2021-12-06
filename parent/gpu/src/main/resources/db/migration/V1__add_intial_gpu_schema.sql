create schema if not exists gpu;
set search_path to gpu;

create type fanOperatingMode as enum ('HIGH', 'NORMAL', 'LOW');

create type loadQuantity as enum ('HIGH', 'MIDDLE', 'LOW');

create table gpu_history
(
    id bigserial primary key,
    time TIMESTAMP,
    temperature DOUBLE PRECISION,
    fan_operating_mode fanOperatingMode,
    load_quantity loadQuantity
);

create table gpu_config
(
    id bigserial primary key,
    name VARCHAR(20),
    temperature BOOLEAN,
    fan_operating_mode BOOLEAN,
    load_quantity BOOLEAN
);