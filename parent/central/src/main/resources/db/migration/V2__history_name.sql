set search_path to central;

ALTER TABLE central_history
    ADD COLUMN config_id DOUBLE PRECISION,
    ADD COLUMN config_name    VARCHAR(20);
