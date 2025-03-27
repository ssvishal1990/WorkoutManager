-- Enable pgcrypto extension if not already enabled
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Create client table
CREATE TABLE IF NOT EXISTS client (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    date date,
    workout TEXT
);


CREATE TABLE IF NOT EXISTS trainer
(
    id        UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name      VARCHAR(255) NOT NULL,
    client_id UUID,
    CONSTRAINT fk_trainer_client FOREIGN KEY (client_id)
    REFERENCES client(id)
);

