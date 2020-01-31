-- First
delete from address
where 
primary_address = 1
and person = (select id from person where username = "alice");

update address set 
primary_address = 1 
where person = (select id from person where username = "alice")
and primary_address = 0;


-- Second

set @temp_id = (select id from widget where order_number = (select max(order_number) from widget)
and "Contact" = (select pg.title from page pg where pg.id = widget.page));
delete from widget  
where id = @temp_id;

-- Third


set @temp_page = (select (min(p.updated)) from page p, website w where w.name = 'Wikipedia' and w.id = p.website);
delete from page
where updated in (@temp_page);

select * from page;
-- Fourth
delete from website where name = 'CNET';


