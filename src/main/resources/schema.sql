create table articles(
  url           varchar(2000) primary key,
  author        varchar(255),
  title         varchar(500),
  description   varchar(1000),
  published_at  date,
  content       varchar(10000),
);