set search_path to cpu;

ALTER TABLE cpu_history
    ADD COLUMN estimated_price DOUBLE PRECISION,
    ADD COLUMN actual_price    DOUBLE PRECISION;
