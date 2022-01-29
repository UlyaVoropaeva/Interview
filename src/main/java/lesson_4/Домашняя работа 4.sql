DROP SCHEMA `Cinema` ;
CREATE SCHEMA `Cinema` ;
use `Cinema`;

CREATE TABLE film
(id SERIAL,
title VARCHAR(255) not null unique,
DURATION int not null,
PRIMARY KEY (id))
ENGINE InnoDB CHARACTER SET utf8;


CREATE TABLE session_start_time
(
id SERIAL,
film_id BIGINT UNSIGNED NOT NULL,
start_time time not null,
PRIMARY KEY(id),
constraint film_id FOREIGN KEY (film_id) REFERENCES film (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE price_film
(
id SERIAL,
session_start_time_id BIGINT UNSIGNED NOT NULL,
price DECIMAL(10,2) not null,
PRIMARY KEY(id),
constraint session_start_time_id FOREIGN KEY (session_start_time_id) REFERENCES session_start_time (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE tickets
(
id SERIAL,
start_time_id BIGINT UNSIGNED NOT NULL,
PRIMARY KEY(id),
constraint start_time_id FOREIGN KEY (start_time_id) REFERENCES session_start_time (id) ON DELETE RESTRICT ON UPDATE CASCADE
);
