-- First

update phone ph set ph.phone = "333-444-5555"
where ph.primary_number = 1
and ph.person = (select id from person where username = "charlie");

-- Second

update widget set order_number = order_number - 1 where order_number = 2;
update widget set order_number = order_number - 1 where order_number = 3;
update widget set order_number = 3 where name = "head345";

-- Third

update page set title = concat("CNET-",title)
where website = (select id from website where name = "CNET");

-- Fourth

set  @temp1 = (select pr.role from page_role pr where pr.page = (select pg.id from page pg where pg.title = "CNET-Home" 
and pg.website = (select w.id from website w where w.name = "CNET")) and (select p.username from person p where p.id
= pr.developer) = "bob");

set @temp2 = (select pr.role from page_role pr where pr.page = (select pg.id from page pg where pg.title = "CNET-Home" 
and pg.website = (select w.id from website w where w.name = "CNET")) and (select p.username from person p where p.id
= pr.developer) = "charlie");

update page_role pr
set pr.role = @temp1
where 
pr.page = (select pg.id from page pg where pg.title = "CNET-Home" and 
pg.website = (select w.id from website w where w.name = "CNET")) and 
(select p.username from person p where p.id = pr.developer) = "charlie";

update page_role pr
set pr.role = @temp2
where 
pr.page = (select pg.id from page pg where pg.title = "CNET-Home" and 
pg.website = (select w.id from website w where w.name = "CNET")) and 
(select p.username from person p where p.id = pr.developer) = "bob";

