CREATE database cookbook;

\c cookbook;

CREATE TABLE recipe (
  id SERIAL,
  name TEXT,
  PRIMARY KEY(id)
);

CREATE TABLE ingredient (
  id SERIAL,
  name TEXT,
  PRIMARY KEY(id)
);

CREATE TABLE measurement_type (
  id SERIAL,
  name TEXT,
  abbreviation TEXT,
  PRIMARY KEY(id)
);

CREATE TABLE recipe_ingredient (
  recipe_id INTEGER references recipe ON DELETE CASCADE,
  ingredient_id INTEGER references ingredient,
  measurement_amount SMALLINT,
  measurement_type_id INTEGER REFERENCES measurement_type
);

CREATE TABLE instruction (
  id SERIAL,
  text TEXT,
  PRIMARY KEY(id)
);

CREATE TABLE recipe_instruction (
  recipe_id INTEGER references recipe ON DELETE CASCADE,
  instruction_id INTEGER references instruction,
  instruction_number SMALLINT
);