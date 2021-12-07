set search_path to motherboard;

ALTER TABLE motherboard_history
    ADD COLUMN config_id DOUBLE PRECISION,
    ADD COLUMN config_name    VARCHAR(20);
