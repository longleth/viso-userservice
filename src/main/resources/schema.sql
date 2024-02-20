
'CREATE DATABASE viso_db;'
'CREATE USER postgrres WITH PASSWORD postgres;'
'GRANT ALL PRIVILEGES ON DATABASE viso_db TO postgrres;'

'create User table in PostgresDB'

CREATE TABLE Users (
    user_id VARCHAR NOT NULL,
    user_name VARCHAR(30) NOT NULL,
    password VARCHAR(16) NOT NULL,
    email VARCHAR(30)
);
