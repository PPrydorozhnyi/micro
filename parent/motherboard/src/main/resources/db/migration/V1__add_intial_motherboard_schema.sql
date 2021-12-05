create schema if not exists motherboard;
set search_path to motherboard;

create table motherboard
(
    id bigserial primary key,
    name VARCHAR(20),
    components jsonb,
    freePorts jsonb
);
