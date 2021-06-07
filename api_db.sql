drop database postlibrarydb;
drop user postlibrary;
create user postlibrary with password 'password';
create database postlibrarydb with template=template0 owner=postlibrary;
\connect postlibrarydb;
alter default privileges grant all on tables to postlibrary;
alter default privileges grant all on sequences to postlibrary;

-- create table to store user information
create table et_users(
    user_id integer primary key not null,
    user_name varchar(20) not null,
    email varchar(30) not null,
    password text not null
);

--create table to store by posts
create table et_posts(
    id integer primary key not null,
    author varchar(20) not null,
    author_id integer not null,
    likes integer primary key not null,
    popularity numeric(10, 2) not null,
    reads integer primary key not null,
    tags varchar(30) not null
);

alter table et_posts add constraint cat_users_fk
foreign key (user_id) references et_users(user_id);

create table et_transactions(
  transaction_id integer primary key not null,
  post_id integer primary key not null,
  user_id integer not null,
  note varchar(50) not null,
  transaction_date bigint not null
);

alter table et_transactions add constraint trans_cat_fk
foreign key (post_id) references et_posts(post_id);
alter table et_transactions add constraint trans_users_fk
foreign key (user_id) references et_users(user_id);

create sequence et_users_seq increment 1 start 1;
create sequence et_posts_seq increment 1 start 1;
create sequence et_transactions_set increment 1 start 1000;