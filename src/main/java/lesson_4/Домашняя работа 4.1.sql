use `Cinema`;

insert into film (title, DURATION) values ('фильм 1',60);
insert into film (title, DURATION) values ('фильм 2',90);
insert into film (title, DURATION) values ('фильм 3',120);
insert into film (title, DURATION) values ('фильм 4',60);
insert into film (title, DURATION) values ('фильм 5',90);

insert into session_start_time (film_id, start_time) values (1,'21:00:00');
insert into session_start_time (film_id, start_time) values (2,'18:00:00');
insert into session_start_time (film_id, start_time) values (3,'15:00:00');
insert into session_start_time (film_id, start_time) values (4,'12:00:00');
insert into session_start_time (film_id, start_time) values (5,'10:00:00');
insert into session_start_time (film_id, start_time) values (1,'10:00:00');

insert into price_film (session_start_time_id, price) values (1,100.00);
insert into price_film (session_start_time_id, price) values (2,200.00);
insert into price_film (session_start_time_id, price) values (3,300.00);
insert into price_film (session_start_time_id, price) values (4,100.00);
insert into price_film (session_start_time_id, price) values (5,200.00);
insert into price_film (session_start_time_id, price) values (1,300.00);

insert into tickets (start_time_id) values (1);
insert into tickets (start_time_id) values (2);
insert into tickets (start_time_id) values (3);
insert into tickets (start_time_id) values (4);
insert into tickets (start_time_id) values (5);
insert into tickets (start_time_id) values (5);
insert into tickets (start_time_id) values (1);
