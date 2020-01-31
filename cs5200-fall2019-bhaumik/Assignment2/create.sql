create schema CS5200_Assignment2_fall2019_Bhaumik;
	
create table person(
id int primary key not null AUTO_INCREMENT,
first_name varchar(20),
last_name varchar(20),
username varchar(20) not null,
password varchar(20) not null,
email varchar(20),
dob Date);


create table user(
id int primary key not null auto_increment, 
user_agreement boolean,
constraint user_person_generalization foreign key (id) references person(id)  
on delete cascade
on update cascade
);

create table developer(
id int primary key not null auto_increment, 
developer_key varchar(20),
constraint developer_person_generalization foreign key (id) references person(id)  
on delete cascade
on update cascade
);

create table website(
id int primary key auto_increment,
name varchar(20) not null,
description varchar(255),
created timestamp not null default current_timestamp on update current_timestamp ,
updated  timestamp not null default current_timestamp on update current_timestamp,
visits int
);

create table page(
id int primary key auto_increment,
title varchar(50) not null,
description varchar(255),
created Date not null,
updated Date not null,
views int,
website int,
foreign key (website) references website(id)
on delete cascade
on update cascade
);

create table widget(
id int primary key auto_increment,
name varchar(20) not null,
width int,
height int,
ccs_class varchar(20),
css_style varchar(20),
text varchar(255),
order_number int,
dtype varchar(10),
size int default 2,
html varchar(255),
url varchar(255),
shareble boolean,
expandable boolean,
src varchar(255),
page int,
foreign key (page) references page(id)
on delete cascade
on update cascade
);

create table phone (
id int primary key auto_increment,
phone varchar(20),
primary_number boolean,
person int,
foreign key (person) references person(id)
on delete cascade
on update cascade
);

create table address (
id int primary key auto_increment,
street1 varchar(50),
street2 varchar(50),
city varchar(20),
state varchar(10),
zip int,
primary_address boolean,
person int,
foreign key (person) references person(id)
on delete cascade
on update cascade
);


  create table priviledge (
  name varchar(20) not null default '',
  primary key (name));
  
  insert into priviledge(name) values ('create');
  insert into priviledge(name) values ('read');
  insert into priviledge(name) values ('update');
  insert into priviledge(name) values ('delete');
  

  create table role (
  name varchar(20) not null default '',
  primary key (name));
  
  insert into role(name) values ('owner');
  insert into role(name) values ('admin');
  insert into role(name) values ('writer');
  insert into role(name) values ('editor');
  insert into role(name) values ('reviewer');
  
create table page_role (
id int primary key auto_increment,
role varchar(20),
developer int,
page int,
foreign key (developer) references developer(id),
foreign key (page) references page(id)
on delete cascade
on update cascade,
foreign key (role) references role(name)
on delete cascade
on update cascade);

create table website_role (
id int primary key auto_increment,
role varchar(20) default null,
developer int,
website int,
foreign key (developer) references developer(id)
on delete cascade
on update cascade,
foreign key (website) references website(id)
on delete cascade
on update cascade,
foreign key (role) references role(name)
on delete cascade
on update cascade);	

create table website_priviledge (
id int primary key auto_increment,
priviledge varchar(20) default null,
developer int,
website int,
foreign key (developer) references developer(id)
on delete cascade
on update cascade,
foreign key (website) references website(id)
on delete cascade
on update cascade,
foreign key (priviledge) references priviledge(name)
on delete cascade
on update cascade);	

create table page_priviledge (
id int primary key auto_increment,
priviledge varchar(20) default null,
developer int,
page int,
foreign key (developer) references developer(id)
on delete cascade
on update cascade,
foreign key (page) references page(id)
on delete cascade
on update cascade,
foreign key (priviledge) references priviledge(name)
on delete cascade
on update cascade);	
