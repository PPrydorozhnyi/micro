set search_path to disc;

ALTER TABLE disc_history
    ADD COLUMN config_id DOUBLE PRECISION,
    ADD COLUMN config_name    VARCHAR(20);
