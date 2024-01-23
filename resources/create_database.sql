SELECT 'hei_wallet' AS database_name
    WHERE NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'hei_wallet');

CREATE DATABASE hei_wallet;

\c hei_wallet;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";