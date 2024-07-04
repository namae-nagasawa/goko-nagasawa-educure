-- CREATE TABLE smtable01(  
-- id INTEGER PRIMARY KEY,
-- name VARCHAR (64) ,
-- department VARCHAR (64) 
-- );
--
--  INSERT INTO smtable01 VALUES
-- (1104, '吉田','営業部'),
-- (1305, '西川','開発部'),
-- (1408, '佐々木','開発部'),
-- (1502, '木村','営業部'),
-- (1607, '大原','総務部');
--
-- CREATE TABLE smtable02(
-- id INTEGER PRIMARY KEY,
-- name VARCHAR(64),
-- department VARCHAR(64)
-- );
--
-- INSERT INTO smtable02 VALUES
-- (1103,'藤田','営業部'),
-- (1315, '伊藤','開発部'),
-- (1420, '近藤','総務部'),
-- (1513, '佐藤','開発部'),
-- (1618, '小川','総務部');
--確認用
select *from smtable01 ;
select *from smtable02 ;

--<問題１>

INSERT INTO smtable01 values
(1615,'山田','総務部');

--＜問題２＞
select * from smtable01;

--＜問題3＞
update smtable01 
set department = '開発部';

--<問題４>
delete from smtable01 ;

--<問題５>
insert into smtable01 (id,name,department)
values
(1612,'小波','総務部'),
(1610,'井伊田','開発部'),
(1609,'田中','営業部'),
(1622,'園田','開発部');

--<問題６>
insert into smtable01 (id,name,department)
values (1607,'大原','総務部');

update smtable01 
set department = '営業部'
where id =1607 and name='大原' and
department ='総務部';

--＜問題７＞
select  * from smtable01
where name like '%木%'; 

--＜問題８＞
update smtable01 
set department = (
select department
from smtable01
where name = '大原'
);

--<問題９＞
insert into smtable01 (id,name,department)
select id,name,department 
from smtable02 ;

--<問題10>
delete from smtable01 
where id in(
select id from smtable01 
order by name asc limit 4
);

 





