CREATE SEQUENCE public.patients_id_seq;

CREATE TABLE Patients (
  id SMALLINT NOT NULL DEFAULT nextval('public.patients_id_seq'),
  firstname VARCHAR(125) NOT NULL,
  name VARCHAR(125) NOT NULL,
  birthdate VARCHAR(125) NOT NULL,
  genre VARCHAR(125) NOT NULL,
  postal_address VARCHAR(125) NOT NULL,
  phone_number VARCHAR(125) NOT NULL,

  PRIMARY KEY (id)
);

ALTER SEQUENCE public.patients_id_seq OWNED BY public.patients.id;


INSERT INTO patients
(firstname, name, birthdate, genre, postal_address, phone_number) 
VALUES 
('Hugoline', 'Sauthier', '05/28/1963', 'woman','9017 Zachery Ports Suite 811 - Gadsden, NM / 00726', '0535574664'),
('Carl', 'Chaulle', '12/09/1939', 'man','686 Ruthie Motorway Suite 250 - Appleton, SD / 60243', '0537874664');
