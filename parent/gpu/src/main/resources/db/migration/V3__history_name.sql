set search_path to gpu;

ALTER TABLE gpu_history
    ADD COLUMN config_id DOUBLE PRECISION,
    ADD COLUMN config_name    VARCHAR(20);
