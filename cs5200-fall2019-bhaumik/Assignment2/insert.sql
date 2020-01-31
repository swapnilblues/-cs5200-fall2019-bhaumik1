insert into person (id,first_name,last_name,username,password,email) 
	values(12,'Alice','Wonder','alice','alice','alice@wonder.com');

insert into person (id,first_name,last_name,username,password,email) 
	values(23,'Bob','Marley','bob','bob','bob@marley.com');

insert into person (id,first_name,last_name,username,password,email) 
	values(34,'Charles','Gracia','charlie','charlie','chuch@garcia.com');

insert into person (id,first_name,last_name,username,password,email) 
	values(45,'Dan','Martin','dan','dan','dan@martin.com');
    
insert into person (id,first_name,last_name,username,password,email) 
	values(56,'Ed','Karaz','ed','ed','dan@martin.com');
        

insert into developer (id,developer_key) values (12,'4321rewq');
insert into developer (id,developer_key) values (23,'5432trew');
insert into developer (id,developer_key) values (34,'6543ytre');
insert into user (id) values (45);
insert into user (id) values (56);




insert into website (id,name,description,visits,created, updated) values (123,'Facebook','an online social media and social
networking service',1234234, current_timestamp(), current_timestamp());

insert into website_role(role,developer,website) values ('owner', (select p.id from person p where 
p.username = 'alice'), (select w.id from website w where w.name = 'Facebook'));
insert into website_role(role,developer,website) values ('editor', (select p.id from person p where 
p.username = 'bob'), (select w.id from website w where w.name = 'Facebook'));
insert into website_role(role,developer,website) values ('admin', (select p.id from person p where 
p.username = 'charlie'), (select w.id from website w where w.name = 'Facebook'));

insert into website (id,name,description,visits,created, updated) values (234,'Twitter','an online news and social 
networking service',4321543, current_timestamp(), current_timestamp());

insert into website_role(role,developer,website) values ('owner', (select p.id from person p where 
p.username = 'bob'), (select w.id from website w where w.name = 'Twitter'));
insert into website_role(role,developer,website) values ('editor', (select p.id from person p where 
p.username = 'charlie'), (select w.id from website w where w.name = 'Twitter'));
insert into website_role(role,developer,website) values ('admin', (select p.id from person p where 
p.username = 'alice'), (select w.id from website w where w.name = 'Twitter'));


insert into website (id,name,description,visits,created, updated) values (345,'Wikipedia','a free online encyclopedia',
3456654, current_timestamp(), current_timestamp());

insert into website_role(role,developer,website) values ('owner', (select p.id from person p where 
p.username = 'charlie'), (select w.id from website w where w.name = 'Wikipedia'));
insert into website_role(role,developer,website) values ('editor', (select p.id from person p where 
p.username = 'alice'), (select w.id from website w where w.name = 'Wikipedia'));
insert into website_role(role,developer,website) values ('admin', (select p.id from person p where 
p.username = 'bob'), (select w.id from website w where w.name = 'Wikipedia'));

insert into website (id,name,description,visits,created, updated) values (456,'CNN','an American basic cable and
satellite television news channel',6543345, current_timestamp(), current_timestamp());


insert into website_role(role,developer,website) values ('owner', (select p.id from person p where 
p.username = 'alice'), (select w.id from website w where w.name = 'CNN'));
insert into website_role(role,developer,website) values ('editor', (select p.id from person p where 
p.username = 'bob'), (select w.id from website w where w.name = 'CNN'));
insert into website_role(role,developer,website) values ('admin', (select p.id from person p where 
p.username = 'charlie'), (select w.id from website w where w.name = 'CNN'));

insert into website (id,name,description,visits,created, updated) values (567,'CNET','an American media website that
publishes reviews, news, articles,blogs, podcasts and videos on technology and consumer electronics',5433455, 
current_timestamp(), current_timestamp());


insert into website_role(role,developer,website) values ('owner', (select p.id from person p where 
p.username = 'bob'), (select w.id from website w where w.name = 'CNET'));
insert into website_role(role,developer,website) values ('editor', (select p.id from person p where 
p.username = 'charlie'), (select w.id from website w where w.name = 'CNET'));
insert into website_role(role,developer,website) values ('admin', (select p.id from person p where 
p.username = 'alice'), (select w.id from website w where w.name = 'CNET'));

insert into website (id,name,description,visits,created, updated) values (678,'Gizmodo','a design, technology, 
science and science fiction website that also writes articles on politics', 4322345, current_timestamp(), current_timestamp());
 

insert into website_role(role,developer,website) values ('owner', (select p.id from person p where 
p.username = 'charlie'), (select w.id from website w where w.name = 'Gizmodo'));
insert into website_role(role,developer,website) values ('editor', (select p.id from person p where 
p.username = 'alice'), (select w.id from website w where w.name = 'Gizmodo'));
insert into website_role(role,developer,website) values ('admin', (select p.id from person p where 
p.username = 'bob'), (select w.id from website w where w.name = 'Gizmodo'));

 insert into page (id,title,description,website,views,created, updated) values (123,'Home','Landing Page',567,
123434,'2019-08-04','2019-10-10');

insert into page_role(role,developer,page) values ('editor', (select p.id from person p where 
p.username = 'alice'), (select pg.id from page pg where pg.title = 'Home'));
insert into page_role(role,developer,page) values ('reviewer', (select p.id from person p where 
p.username = 'bob'), (select pg.id from page pg where pg.title = 'Home'));
insert into page_role(role,developer,page) values ('writer', (select p.id from person p where 
p.username = 'charlie'), (select pg.id from page pg where pg.title = 'Home'));

insert into page (id,title,description,website,views,created, updated) values (234,'About','Website description',678,
234545,'2019-08-04','2019-10-10');

insert into page_role(role,developer,page) values ('editor', (select p.id from person p where 
p.username = 'bob'), (select pg.id from page pg where pg.title = 'About'));
insert into page_role(role,developer,page) values ('reviewer', (select p.id from person p where 
p.username = 'charlie'), (select pg.id from page pg where pg.title = 'About'));
insert into page_role(role,developer,page) values ('writer', (select p.id from person p where 
p.username = 'alice'), (select pg.id from page pg where pg.title = 'About'));

insert into page (id,title,description,website,views,created, updated) values (345,'Contact','Addresses, phones, and contact
info',345,345656,'2019-08-04','2019-10-10');

insert into page_role(role,developer,page) values ('editor', (select p.id from person p where 
p.username = 'charlie'), (select pg.id from page pg where pg.title = 'Contact'));
insert into page_role(role,developer,page) values ('reviewer', (select p.id from person p where 
p.username = 'alice'), (select pg.id from page pg where pg.title = 'Contact'));
insert into page_role(role,developer,page) values ('writer', (select p.id from person p where 
p.username = 'bob'), (select pg.id from page pg where pg.title = 'Contact'));

insert into page (id,title,description,website,views,created, updated) values (456,'Preferences','Where users can configure their
preferences',456, 456776,'2019-08-04','2019-10-10');

insert into page_role(role,developer,page) values ('editor', (select p.id from person p where 
p.username = 'alice'), (select pg.id from page pg where pg.title = 'Preferences'));
insert into page_role(role,developer,page) values ('reviewer', (select p.id from person p where 
p.username = 'bob'), (select pg.id from page pg where pg.title = 'Preferences'));
insert into page_role(role,developer,page) values ('writer', (select p.id from person p where 
p.username = 'charlie'), (select pg.id from page pg where pg.title = 'Preferences'));

insert into page (id,title,description,website,views,created, updated) values (567,'Profile','Users can configure their
personal information',567,567878,'2019-08-04','2019-10-10');

insert into page_role(role,developer,page) values ('editor', (select p.id from person p where 
p.username = 'bob'), (select pg.id from page pg where pg.title = 'Profile'));
insert into page_role(role,developer,page) values ('reviewer', (select p.id from person p where 
p.username = 'charlie'), (select pg.id from page pg where pg.title = 'Profile'));
insert into page_role(role,developer,page) values ('writer', (select p.id from person p where 
p.username = 'alice'), (select pg.id from page pg where pg.title = 'Profile'));


insert into widget (id,name,dtype,text,order_number,page) values (123,'head123','heading','Welcome',0,123);
insert into widget (id,name,dtype,text,order_number,page) values (234,'post234','html','<p>Lorem</p>',0,234);
insert into widget (id,name,dtype,text,order_number,page) values (345,'head345','heading','Hi',1,345);
insert into widget (id,name,dtype,text,order_number,page) values (456,'intro456','html','<h1>Hi</h1>',2,345);
insert into widget (id,name,dtype,order_number,width,height,url,page) values (567,'image345','image',3,50,100,
'/img/567.png',345);
insert into widget (id,name,dtype,order_number,width,height,url,page) values (678,'video456','youtube',0,400,300,
'https://youtu.be/h67VX51QXiQ',456);

insert into phone (phone,primary_number,person) values ('123-234-3456',true,12);
insert into phone (phone,primary_number,person) values ('234-345-4566',false,12);
insert into phone (phone,primary_number,person) values ('345-456-5677',true,23);
insert into phone (phone,primary_number,person) values ('321-432-5435',true,34);
insert into phone (phone,primary_number,person) values ('432-432-5433',false,34);
insert into phone (phone,primary_number,person) values ('543-543-6544',false,34);
insert into address (street1,street2,city,zip,primary_address,person) values ('123','Adam St.','Alton',01234,
true,12);
insert into address (street1,street2,city,zip,primary_address,person) values ('234','Birch St.','Boston',02345,
false,12);
insert into address (street1,street2,city,zip,primary_address,person) values ('345','Charles St.','Chelms',03455,
true,23);
insert into address (street1,street2,city,zip,primary_address,person) values ('456','Down St.','Dalton',04566,
false,23);
insert into address (street1,street2,city,zip,primary_address,person) values ('543','East St.','Everett',01112,
false,23);
insert into address (street1,street2,city,zip,primary_address,person) values ('654','Frank St.','Foulton',04322,
true,34);
	
