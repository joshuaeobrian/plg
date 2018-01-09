create table gender(
  id SERIAL PRIMARY KEY NOT NULL,
  gender_type VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX gender_id_unique ON gender(id);
CREATE UNIQUE INDEX gender_gender_type_unique ON gender(gender_type);

create table addresses(
  id SERIAL PRIMARY KEY NOT NULL,
  address INT NOT NULL,
  city VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  zip_code VARCHAR(10) NOT NULL,
  country VARCHAR(50) NOT NULL,
  apt VARCHAR(10) NULL,
  address_type VARCHAR(50) NOT NULL,
  creation_date TIMESTAMP NOT NULL DEFAULT now()
);
CREATE UNIQUE INDEX addresses_id_unique ON addresses(id);

INSERT INTO gender(gender_type) VALUES ('Male');
INSERT INTO gender(gender_type) VALUES ('Female');
INSERT INTO gender(gender_type) VALUES ('Other');

create table person(
  id SERIAL PRIMARY KEY NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  gender_id INT NOT NULL REFERENCES gender(id),
  telephone VARCHAR(20) NULL,
  creation_date TIMESTAMP NOT NULL DEFAULT now(),
  visible BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE UNIQUE INDEX person_id_unique ON person(id);
CREATE UNIQUE INDEX person_username_unique ON person(username);
CREATE UNIQUE INDEX person_email_unique ON person(email);
CREATE UNIQUE INDEX person_unique on person(id,first_name,last_name,email,username);

CREATE TABLE role(
  id SERIAL PRIMARY KEY NOT NULL,
  role_type VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX role_id_unique on role(id);
CREATE UNIQUE INDEX role_role_unique on role(role_type);


CREATE TABLE team(
  id SERIAL PRIMARY KEY NOT NULL,
  team_name VARCHAR(100) NOT NULL,
  team_about VARCHAR(600) NOT NULL,
  team_site VARCHAR(500) NULL,
  team_logo bytea NULL,
  creation_date TIMESTAMP NOT NULL DEFAULT now()
);
CREATE UNIQUE INDEX team_id_unique ON team(id);
CREATE UNIQUE INDEX team_team_name_unique ON team(team_name);

CREATE TABLE team_player(
  player_id INT NOT NULL REFERENCES person(id),
  team_id INT NOT NULL REFERENCES team(id),
  role_id INT NOT NULL REFERENCES role(id)
);
create UNIQUE INDEX team_player_unique ON team_player(player_id, team_id, role_id) ;