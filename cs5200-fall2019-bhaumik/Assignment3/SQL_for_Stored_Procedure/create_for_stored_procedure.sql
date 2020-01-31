
create table module (
name varchar(20) not null default '',
primary key (name)
  );
  
insert into module (name) values ('Project1');
insert into module (name) values ('Project2');
insert into module (name) values ('Assignment1');
insert into module (name) values ('Assignment2');
insert into module (name) values ('Quiz1');
insert into module (name) values ('Exam');
insert into module (name) values ('Logistics');

create table question ( 
id int primary key auto_increment,
text varchar(40),
asked_by int,
posted_on Date,
length int,
views int,
endorsed_by_instructor boolean,
module varchar(20),
constraint question_widget_generalization foreign key (id) references widget(id)  
on delete cascade
on update cascade,
foreign key (asked_by) references user(id)
on delete cascade
on update cascade,
foreign key (module) references module(name)
on delete cascade
on update cascade
);

create table answer(
id int primary key auto_increment,
text varchar(40),
posted_by int,
posted_on Date,
correct_answer boolean,
up_votes int,
down_votes int,
question int,
constraint answer_widget_generalization foreign key (id) references widget(id)  
on delete cascade
on update cascade,
foreign key (posted_by) references user (id)
on delete cascade
on update cascade,
foreign key (question) references question (id)
on delete cascade
on update cascade
);



