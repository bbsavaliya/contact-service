DROP TABLE IF EXISTS contacts;

CREATE TABLE contacts (
  id 			INT AUTO_INCREMENT  PRIMARY KEY,
  first_name 	VARCHAR(250) NOT NULL,
  last_name 	VARCHAR(250) NOT NULL,
  email		 	VARCHAR(50)  NOT NULL,
  phonenumber 	VARCHAR(10)	 DEFAULT NULL,
  status 		VARCHAR(1)   DEFAULT NULL
);

INSERT INTO contacts (first_name, last_name, email, phonenumber, status) VALUES
  ('Brijesh', 'Savaliya', 'brijesh@gmail.com', '1111111111', 'A'),
  ('Alex', 'Xyz', 'brijesh@gmail.com', '2222222222', 'A'),
  ('John', 'Pqr', 'brijesh@gmail.com', '3333333333', 'A'),
  ('Sam', 'Abc', 'brijesh@gmail.com', '4444444444', 'A'),
  ('Ram', 'Naik', 'brijesh@gmail.com', '5555555555', 'A');