create schema if not exists central;
set search_path to central;

create table central_history
(
    id bigserial primary key,
    time TIMESTAMP,
    cpu_id BIGINT,
    disc_id BIGINT,
    gpu_id BIGINT,
    motherboard_id BIGINT
);

create table central_config
(
    id bigserial primary key,
    name VARCHAR(20),
    cpu_id BIGINT,
    disc_id BIGINT,
    gpu_id BIGINT,
    motherboard_id BIGINT
);