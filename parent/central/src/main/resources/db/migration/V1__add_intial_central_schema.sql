create schema if not exists central;
set search_path to central;

create table central_history
(
    id bigserial primary key,
    time TIMESTAMP,
    cpuId BIGINT,
    discId BIGINT,
    gpuId BIGINT,
    motherboardId BIGINT
);

create table central_config
(
    id bigserial primary key,
    name VARCHAR(20),
    cpuId BIGINT,
    discId BIGINT,
    gpuId BIGINT,
    motherboardId BIGINT
);