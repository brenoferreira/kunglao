# Scores schema

# --- !Ups

CREATE TABLE Score (
  id int NOT NULL AUTO_INCREMENT,
  winner varchar(255) NOT NULL,
  loser varchar(255) NOT NULL,
  winnerScore int NOT NULL,
  loserScore int NOT NULL,
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE Score;