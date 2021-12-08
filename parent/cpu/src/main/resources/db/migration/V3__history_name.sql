set search_path to cpu;

ALTER TABLE cpu_history
    ADD COLUMN config_id DOUBLE PRECISION,
    ADD COLUMN config_name    VARCHAR(20);
