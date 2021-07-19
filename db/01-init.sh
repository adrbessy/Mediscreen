#!/bin/bash
set -e
export PGPASSWORD=$POSTGRES_PASSWORD;
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
  \connect $APP_DB_NAME $APP_DB_USER
  BEGIN;
    CREATE SEQUENCE public.patients_id_seq;

CREATE TABLE Patients (
  id SMALLINT NOT NULL DEFAULT nextval('public.patients_id_seq'),
  -- given name
  given VARCHAR(125) NOT NULL,
  -- family name
  family VARCHAR(125) NOT NULL,
  -- date of birth
  dob VARCHAR(10) NOT NULL, 
  -- F or M
  sex CHAR(1) NOT NULL,
  -- postal address
  address VARCHAR(125),
  phone VARCHAR(125),

  PRIMARY KEY (id)
);

ALTER SEQUENCE public.patients_id_seq OWNED BY public.patients.id;


INSERT INTO patients
(given, family, dob, sex, address, phone) 
VALUES 
('Test', 'TestNone', '1966-12-31', 'F','1 Brookside St', '100-222-3333'),
('Test', 'TestBorderline', '1945-06-24', 'M','2 High St', '200-333-4444'),
('Test', 'TestInDanger', '2004-06-18', 'M','3 Club Road', '300-444-5555'),
('Test', 'TestEarlyOnset', '2002-06-28', 'F','4 Valley Dr', '400-555-6666');

  COMMIT;
EOSQL

