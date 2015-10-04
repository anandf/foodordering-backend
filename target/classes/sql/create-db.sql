drop table public.user if exists;
create table public.user (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  userName varchar(50) not null,
  email varchar(50) not null,
  password varchar(255) not null,
  phonenumber varchar(50) not null,
  unique(userName)
);
drop table public.order if exists;
create table public.order (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  userId integer not null FOREIGN KEY REFERENCES public.user(id),
  orderPlacedDate date not null,
  orderStartDate date not null,
  orderEndDate date not null,
  cuisineId integer,
  specialNotes varchar(255)
);

drop table public.category if exists;
create table public.category (
  id integer primary key GENERATED  BY DEFAULT AS IDENTITY (START WITH 1),
  name varchar(50) not null,
  description varchar(255),
  unique(name)
);

drop table public.cuisine if exists;
create table public.cuisine (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  name varchar(50) not null,
  description varchar(255),
  image varchar(50) DEFAULT 'http://placehold.it/700x300',
  unique(name)
);

drop table public.menu if exists;
create table public.menu (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  cuisineId integer FOREIGN KEY REFERENCES public.cuisine(id),
  categoryId integer FOREIGN KEY REFERENCES public.category(id),
  dayOfTheWeek varchar(10) not null,
  description varchar(255) not null,
  image varchar(50) DEFAULT 'http://placehold.it/200x200',
  UNIQUE (dayOfTheWeek,cuisineId)
)