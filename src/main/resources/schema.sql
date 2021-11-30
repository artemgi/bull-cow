create table users (
  id                    bigserial,
  username              varchar(30) not null,
  password              varchar(80) not null,
  rating                long not null,
  primary key (id)
);

create table roles (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigint not null,
  roles_id               int not null,
  primary key (user_id, roles_id),
  foreign key (user_id) references users (id),
  foreign key (roles_id) references roles (id)
);
CREATE TABLE games (
  game_id               bigint not null,
  user_id               bigint not null,
  hidden_number         varchar(50) not null,
  score                 int not null,
  date                  date,
  primary key (game_id, user_id),
  foreign key (user_id) references users (id)
);

create table rating (
  id                   serial,
  rating               bigint not null,
  score                varchar(50) not null,
  date                 date,
  primary key (id),
);



insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN'), ('SOMETHING');

insert into users (username, password, rating)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 0);

insert into users_roles (user_id, roles_id)
values
(1, 1),
(1, 2);


insert into games (game_id, user_id, hidden_number, score)
values
(1, 1, 1231, 100);

--drop table games,roles, users, users_roles