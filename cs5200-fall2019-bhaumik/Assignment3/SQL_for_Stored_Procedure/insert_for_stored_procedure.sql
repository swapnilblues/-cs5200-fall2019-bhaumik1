insert into person (id,first_name,last_name,username,password,email) 
	values(101,'Arjen','Robben','arjen','arjen','arjen@bayern.com');
insert into person (id,first_name,last_name,username,password,email) 
	values(102,'Callum','Hudson-Odoi','callum','callum','callum@chelsea.com');
insert into person (id,first_name,last_name,username,password,email) 
	values(103,'Luka','Modric','luka','luka','luka@realmadrid.com');
insert into person (id,first_name,last_name,username,password,email) 
	values(104,'Ivan','Rakitic','ivan','ivan','ivan@fcbarcelona.com');
insert into person (id,first_name,last_name,username,password,email) 
	values(105,'Kylian','Mbappe','kylian','kylian','kylian@psg.com');
    
insert into user (id,user_agreement) values (101,true);
insert into user (id,user_agreement) values (102,true);
insert into user (id,user_agreement) values (103,true);
insert into user (id,user_agreement) values (104,true);
insert into user (id,user_agreement) values (105,true);

#--------------------------

insert into widget (id,name,dtype,order_number,page) values (1,'Q1','Question',0,234);
insert into widget (id,name,dtype,order_number,page) values (2,'Q2','Question',0,234);
insert into widget (id,name,dtype,order_number,page) values (3,'Q3','Question',0,234);
insert into widget (id,name,dtype,order_number,page) values (4,'Q4','Question',0,234);
insert into widget (id,name,dtype,order_number,page) values (5,'Q5','Question',0,234);
insert into widget (id,name,dtype,order_number,page) values (6,'Q6','Question',0,234);

insert into question (id,text,asked_by,posted_on,length,views,endorsed_by_instructor,module)
values (1,'Quantum Theory',101,current_timestamp,10,10,true,'Project1');
insert into question (id,text,asked_by,posted_on,length,views,endorsed_by_instructor,module)
values (2,'String Theory',103,current_timestamp,10,10,true,'Project2');
insert into question (id,text,asked_by,posted_on,length,views,endorsed_by_instructor,module)
values (3,'Schrodinger Therory',102,current_timestamp,10,10,true,'Quiz1');
insert into question (id,text,asked_by,posted_on,length,views,endorsed_by_instructor,module)
values (4,'FLuid Mechanics',101,current_timestamp,10,10,true,'Quiz1');
insert into question (id,text,asked_by,posted_on,length,views,endorsed_by_instructor,module)
values (5,'Deep Learning',104,current_timestamp,10,10,true,'Exam');
insert into question (id,text,asked_by,posted_on,length,views,endorsed_by_instructor,module)
values (6,'Reinforcement Learning',105,current_timestamp,10,10,true,'Exam');
#-----------------------------------------------


insert into widget (id,dtype, name, order_number, page) values (1001,'Answer','Q1A1',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (1001,"AAA",1,101,true);
insert into widget (id,dtype, name, order_number, page) values (1002,'Answer','Q1A2',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (1002,"BBB",1,102,false);

insert into widget (id,dtype, name, order_number, page) values (2001,'Answer','Q2A1',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (2001,"CCC",2,103,false);
insert into widget (id,dtype, name, order_number, page) values (2002,'Answer','Q2A2',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (2002,"DDD",2,104,false);

insert into widget (id,dtype, name, order_number, page) values (3001,'Answer','Q3A1',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (3001,"QQQ",3,104,false);
insert into widget (id,dtype, name, order_number, page) values (3002,'Answer','Q3A2',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (3002,"WWW",3,105,false);

insert into widget (id,dtype, name, order_number, page) values (4001,'Answer','Q4A1',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (4001,"WWW",4,105,false);
insert into widget (id,dtype, name, order_number, page) values (4002,'Answer','Q4A2',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (4002,"WWW",4,104,false);
insert into widget (id,dtype, name, order_number, page) values (4003,'Answer','Q4A3',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (4003,"WWW",4,104,false);

insert into widget (id,dtype, name, order_number, page) values (5001,'Answer','Q5A1',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (5001,"WWW",5,101,true);
insert into widget (id,dtype, name, order_number, page) values (5002,'Answer','Q5A2',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (5002,"WWW",5,104,false);
insert into widget (id,dtype, name, order_number, page) values (5003,'Answer','Q5A3',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (5003,"WWW",5,105,true);
insert into widget (id,dtype, name, order_number, page) values (5004,'Answer','Q5A4',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (5004,"WWW",5,102,true);
insert into widget (id,dtype, name, order_number, page) values (5005,'Answer','Q5A5',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (5005,"WWW",5,45,true);
insert into widget (id,dtype, name, order_number, page) values (5006,'Answer','Q5A6',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (5006,"WWW",5,56,true);

insert into widget (id,dtype, name, order_number, page) values (6001,'Answer','Q6A1',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (6001,"WWW",6,45,true);
insert into widget (id,dtype, name, order_number, page) values (6002,'Answer','Q6A2',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (6002,"WWW",6,56,true);
insert into widget (id,dtype, name, order_number, page) values (6003,'Answer','Q6A3',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (6003,"WWW",6,102,true);
insert into widget (id,dtype, name, order_number, page) values (6004,'Answer','Q6A4',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (6004,"WWW",6,105,false);
insert into widget (id,dtype, name, order_number, page) values (6005,'Answer','Q6A5',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (6005,"WWW",6,103,true);
insert into widget (id,dtype, name, order_number, page) values (6006,'Answer','Q6A6',0,234);
insert into answer(id,text,question,posted_by,correct_answer) values (6006,"WWW",6,104,true);
