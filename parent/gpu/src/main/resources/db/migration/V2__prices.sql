set search_path to gpu;

ALTER TABLE gpu_history
    ADD COLUMN estimated_price DOUBLE PRECISION,
    ADD COLUMN actual_price    DOUBLE PRECISION;
