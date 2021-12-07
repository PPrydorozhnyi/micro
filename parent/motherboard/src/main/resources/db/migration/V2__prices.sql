set search_path to motherboard;

ALTER TABLE motherboard_history
    ADD COLUMN estimated_price DOUBLE PRECISION,
    ADD COLUMN actual_price    DOUBLE PRECISION;
