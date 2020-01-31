-- First
select p.id, p.first_name, p.last_name, p.username, d.developer_key from person p join developer 
d on p.id = d.id;

select p.first_name, p.last_name, p.username from person p join developer 
d on p.id = d.id and d.id = 34; 

select p.first_name, p.last_name, p.username from person p where id = (select wr.developer from website_role wr 
where wr.website = (select w.id from website w where w.name = 'Twitter') and wr.role = 'Editor') or id = 
(select wr.developer from website_role wr where wr.website = (select w.id from website w where w.name = 'Twitter') 
and wr.role = 'Admin');

select per.id, per.first_name, per.last_name, per.username
from person per
join developer d on per.id = d.id
join page_role pr on d.id = pr.developer and pr.role = 'Reviewer'
join page p on pr.page = p.id and p.views <300000;

select per.id, per.first_name, per.last_name, per.username
from person per
join developer d on per.id = d.id
join page_role pr on d.id = pr.developer and pr.role = 'Writer'
join page p on pr.page = p.id and p.title = 'Home'
join website w on p.website = w.id 
join widget wg on wg.page = p .id and wg.dtype='heading';

-- Second
select * from website where visits = (select min(visits) from website);

select name from website where id = 678;

select w.name 
from website w
join page pg on pg.website = w.id
join widget wg on wg.page = pg.id and wg.dtype = 'Youtube'
join page_role pr on pr.page = pg.id and pr.role = 'Reviewer'
join developer d on pr.developer = d.id
join person p on d.id = p.id and p.username = 'bob';

select w.name 
from website w
join website_role wr on wr.website = w.id and wr.role = 'Owner'
join developer d on d.id = wr.developer
join person p on p.id = d.id and p.username = 'alice';


select w.name 
from website w
join website_role wr on wr.website = w.id and wr.role = 'Admin' and w.visits > 6000000
join developer d on d.id = wr.developer
join person p on p.id = d.id and p.username = 'charlie';

-- Third

select * from page where views = (select max(views) from page);

select title from page where id = 234;

select p.title
from page p
join page_role pr on pr.page = p.id and pr.role = 'Editor'
join developer d on d.id = pr.developer
join person per on per.id = d.id and per.username = 'alice';

select sum(p.views)
from page p
join website w on p.website = w.id and w.name = 'CNET';

select avg(p.views)
from page p
join website w on p.website = w.id and w.name = 'Wikipedia';

-- Fourth

select wg.name 
from widget wg where page =
(select p.id from page p where  
p.title = 'Home' and p.website =
(select w.id from website w where 
w.name = 'CNET' )
);

select wg.name 
from widget wg where dtype = 'youtube' and
page =(select p.id from page p where  
p.website = (select w.id from website w where 
w.name = 'CNN' )
);

select wg.name from widget wg
join page p on wg.page = p.id and wg.dtype = 'Image'
join page_role pr on pr.page = p.id and pr.role = 'Reviewer'
join developer d on d.id = pr.developer
join person per on per.id = d.id and per.username = 'Alice';

select count(wg.id) from widget wg
join page p on wg.page = p.id
join website w on p.website = w.id and w.name = 'Wikipedia';

-- Fifth

select w.name from website w 
join website_priviledge wp on wp.website = w.id and wp.priviledge = 'Delete'
join developer d on d.id = wp.developer
join person p on p.id = d.id and p.username = 'bob';  

select pg.title from page pg 
join page_priviledge pp on pp.page = pg.id and pp.priviledge = 'Create'
join developer d on d.id = pp.developer
join person p on p.id = d.id and p.username = 'charlie';  
