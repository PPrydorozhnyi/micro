create schema if not exists cpu;
set search_path to cpu;

create type loadSharing as enum ('BALANCED', 'UNBALANCED', 'SINGLE');

create type loadQuantity as enum ('HIGH', 'MIDDLE', 'LOW');

create table cpu_history
(
    id bigserial primary key,
    time TIMESTAMP,
    overclocking DECIMAL,
    frequency DOUBLE PRECISION,
    temperature DOUBLE PRECISION,
    loadSharing loadSharing,
    loadQuantity loadQuantity
);

create table cpu_config
(
    id bigserial primary key,
    name VARCHAR(20),
    overclockingConfig DECIMAL,
    frequencyConfig DECIMAL,
    temperatureConfig DECIMAL,
    loadSharingConfig DECIMAL,
    loadQuantityConfig DECIMAL

);
