create table users
(
    id          varchar(13)     not null primary key,
    created     datetime        not null,
    name        varchar(255)    not null comment 'name of the user',
    surname     varchar(255)    not null comment 'surname of the user',
    email       varchar(255)    not null comment 'email of the user',
    password    varchar(255)    not null comment 'password of the user, encode bcrypt',
    last_login  datetime            null commnet 'last login of the user'
);

create table roles
(
    id          bigint(20) unsigned not null auto_increment,
    name        varchar(255)        not null comment 'name of the rol',
    primary key (id)
);

create table user_with_roles
(
    user_id         varchar(13)             not null references users (id),
    role_id         bigint(20)  unsigned    not null references roles(id)
);

insert into user (id, created, name, surname, email, password)
values ('BAYZF7072Z501', now(), 'user-name', 'user-surname', 'user@bla.com',
        '$2a$12$arCYkTbMiWwOPym2paR6K.1NYcy2Dyysp/ZCVlZL9oxoSALh7pa2'), --pwd:user
       ('BAYZFA06XJNAV', now(), 'admin-name', 'admin-surname', 'admin@bla.com',
       '$2a$12$nl9EO9n9DJs0aWxdPZlvr.rFCVeN.LfiKNBTRnRZqICzuZGd7JQpe'); -- pwd:admin

 insert into roles (name)
 values ('USER',
         'ADMIN' );

 insert into users_with_roles (user_id, role_id)
 values ((select user.id from users where email = 'user@bla.com'), (select roles.id from roles where name = 'USER')),
        ((select user.id from users where email = 'admin@bla.com'), (select roles.id from roles where name = 'USER')),
        ((select user.id from users where email = 'admin@bla.com'), (select roles.id from roles where name = 'ADMIN'));