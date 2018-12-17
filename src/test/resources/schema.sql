drop schema if exists gamesys cascade ;

create schema gamesys;

create table gamesys.articles(
  id            bigint auto_increment primary key,
  url           varchar(2000) unique ,
  author        varchar(255),
  title         varchar(500),
  description   varchar(1000),
  published_at  date,
  content       varchar(10000),
);
