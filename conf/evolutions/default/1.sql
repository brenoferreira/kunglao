# Users schema

# --- !Ups

CREATE TABLE User (
  id varchar(30) NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE User;