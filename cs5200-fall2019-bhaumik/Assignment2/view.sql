drop view if exists deleveloper_roles_and_privileges1;
create view deleveloper_roles_and_privileges1 as
select distinct p.id as person_id, p.first_name, p.last_name, p.username, p.email, w.id as website_id,
w.name as website_name, w.visits as website_visits, w.updated as website_updated, wr.role as website_role, 
wp.priviledge as website_priviledge
from person p, developer d, website w, website_role wr, website_priviledge wp, page pg, page_role pr, 
page_priviledge pp  
where d.id = p.id
and wp.developer = d.id
and wp.website = w.id 
and wr.developer = d.id
and wr.website = w.id
;

select * from deleveloper_roles_and_privileges1;

drop view if exists v1;
create view v1 as
select distinct person_id,first_name,last_name,username,email,website_id,website_name,website_visits,website_updated,
website_role, group_concat(website_priviledge) as 
w_priviledge
from deleveloper_roles_and_privileges1
group by username, website_name, website_role;

select * from v1;

drop view if exists deleveloper_roles_and_privileges2;
create view deleveloper_roles_and_privileges2 as
select distinct p.id as person_id, p.first_name, p.last_name, p.username, p.email,
pg.title as page_title, pg.views as page_views, pg.website as page_website, pg.updated as page_updated, 
pr.role as page_role, pp.priviledge as page_priviledge
from person p, developer d, website w, website_role wr, website_priviledge wp, page pg, page_role pr, 
page_priviledge pp  
where d.id = p.id
and pp.developer = d.id
and pp.page = pg.id 
and pr.developer = d.id
and pr.page = pg.id
;

select * from deleveloper_roles_and_privileges2;

drop view if exists v2;
create view v2 as
select distinct person_id,first_name,last_name,username,email,page_title,page_views, page_website, page_updated,
page_role, group_concat(page_priviledge) as 
p_priviledge
from deleveloper_roles_and_privileges2
group by username, page_title, page_role;

select * from v2;

drop view if exists deleveloper_roles_and_privileges;
create view deleveloper_roles_and_privileges as
select distinct v1.first_name, v1.last_name, v1.username, v1.email, 
v1.website_name, v1.website_visits, v1.website_updated, v1.website_role, 
v1.w_priviledge, v2.page_title, v2.page_views, v2.page_website,v2.page_updated,v2.page_role,v2.p_priviledge
from v1 left outer join v2
on v1.person_id = v2.person_id
and v1.website_id = v2.page_website;

select * from  deleveloper_roles_and_privileges;