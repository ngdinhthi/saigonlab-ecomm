create database ecomm_mobile character set utf8 collate utf8_bin;
use ecomm_mobile;

create table user_login (
  id bigint(12) not null,
  username varchar(255) not null,
  email varchar(500) not null,
  phone varchar(50) default null,
  password varchar(1000) not null,
  hash_type varchar(50) not null,
  active bit(1) default 1,
  primary key(id)
);

create table user_info (
  user_id bigint(12) not null,
  `key` varchar(255) not null,
  value varchar(1000) not null
);

create table permission (
  id int not null,
  code varchar(50) not null,
  name varchar(255) not null,
  description varchar(1000),
  primary key(id)
);

create table user_permission (
  user_id bigint(12) not null,
  permission_id id not null,
  permission_default bit(1) default 0
);