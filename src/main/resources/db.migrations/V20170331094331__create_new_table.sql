CREATE TABLE company_office(
  id SERIAL PRIMARY KEY,
  company_id INT REFERENCES company(id),
  name VARCHAR(100) NOT NULL
);
