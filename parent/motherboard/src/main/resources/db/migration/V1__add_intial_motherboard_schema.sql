create schema if not exists motherboard;
set search_path to motherboard;

create table motherboard_history
(
    id bigserial primary key,
    time TIMESTAMP,
    components jsonb,
    free_ports jsonb
);

create table motherboard_config
(
    id bigserial primary key,
    name VARCHAR(20),
    components DECIMAL,
    free_ports DECIMAL
);
