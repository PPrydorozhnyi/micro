set search_path to disc;

ALTER TABLE disc_history
    ADD COLUMN estimated_price DOUBLE PRECISION,
    ADD COLUMN actual_price    DOUBLE PRECISION;
