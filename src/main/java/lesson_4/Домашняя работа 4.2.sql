/*ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени. 
Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;*/
use `Cinema`;

select film.title             			'Фильм 1',
       session_start_time.start_time   'Время начала',
       film.duration           			'Длительность',
       film2.title               		'Фильм 2',
       film2.start_time   				'Время начала',
       film2.duration            		'Длительность'
from session_start_time
         join film on session_start_time.film_id = film.id
         join (select film.title,
                      session_start_time.film_id,
                      session_start_time.start_time,
                      film.duration,
                      session_start_time.start_time + INTERVAL film.duration MINUTE as end_time
               from session_start_time
                        join film on session_start_time.film_id = film.id) as film2
              on (session_start_time.start_time + INTERVAL film.duration MINUTE >
                  film2.start_time)
                  and (session_start_time.start_time + INTERVAL film.duration MINUTE < film2.end_time)
                  and session_start_time.film_id != film2.film_id
order by session_start_time.start_time; 
       
/* перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. 
Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;*/
select film_1.title              		'фильм 1',
       session_start_time_1.start_time 	'время начала',
       film_1.duration           		'длительность',
       session_start_time.start_time   	'время начала второго фильма',
       timestampdiff(minute, session_start_time_1.start_time, session_start_time.start_time) -
       film_1.duration as        		'длительность перерыва'
from session_start_time
         join film on session_start_time.film_id = film.id
         left join session_start_time session_start_time_1 on session_start_time_1.id = session_start_time.id - 1
         left join film film_1 on film_1.id = session_start_time_1.film_id
where timestampdiff(minute, session_start_time_1.start_time, session_start_time.start_time) - film.duration >= 30
order by session_start_time_1.start_time desc;

/*список фильмов, для каждого — с указанием общего числа посетителей за все время, 
среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли). 
Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;*/

(select film.title as 'фильмы',
        count(distinct tickets.id) as 'зрители',
        sum(price_film.price) as 'сборы',
        AVG (distinct tickets.id) / count(distinct tickets.start_time_id) as 'среднее число зрителей'
 from tickets
          join session_start_time on tickets.start_time_id = session_start_time.id and price_film.session_start_time_id = session_start_time.id
          join film on session_start_time.film_id = film.id
		
 group by film.title
 order by 'сборы' desc
)
union
select 'Итого:',
       count(*),
       sum(price_film.pric),
       count(*) / count(distinct tickets.start_time_id)
from tickets
         join session_start_time on tickets.start_time_id = session_start_time.id; 