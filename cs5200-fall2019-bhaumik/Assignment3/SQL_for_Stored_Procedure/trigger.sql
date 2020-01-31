delimiter $$
create trigger website_priviledge_trigger_insert
after insert on website_role
for each row
begin
if new.role = 'owner' then
	insert into website_priviledge values(null, 'create', new.developer,new.website);
	insert into website_priviledge values(null, 'read', new.developer,new.website);
	insert into website_priviledge values(null, 'update', new.developer,new.website);
	insert into website_priviledge values(null, 'delete', new.developer,new.website);
elseif new.role = 'admin' then
	insert into website_priviledge values(null, 'create', new.developer,new.website);
	insert into website_priviledge values(null, 'read', new.developer,new.website);
	insert into website_priviledge values(null, 'update', new.developer,new.website);
	insert into website_priviledge values(null, 'delete', new.developer,new.website);
elseif new.role = 'writer' then
	insert into website_priviledge values(null, 'create', new.developer,new.website);
	insert into website_priviledge values(null, 'read', new.developer,new.website);
	insert into website_priviledge values(null, 'update', new.developer,new.website);
elseif new.role = 'editor' then
	insert into website_priviledge values(null, 'read', new.developer,new.website);
	insert into website_priviledge values(null, 'update', new.developer,new.website);
elseif new.role = 'reviewer' then
	insert into website_priviledge values(null, 'read', new.developer,new.website);
end if;
end;$$


delimiter $$
create trigger website_priviledge_trigger_update
after update on website_role
for each row
begin
delete from website_priviledge where developer = old.developer and website = old.website;
if new.role = 'owner' then
    insert into website_priviledge values(null, 'create', new.developer,new.website);
	insert into website_priviledge values(null, 'read', new.developer,new.website);
	insert into website_priviledge values(null, 'update', new.developer,new.website);
	insert into website_priviledge values(null, 'delete', new.developer,new.website);
elseif new.role = 'admin' then
	insert into website_priviledge values(null, 'create', new.developer,new.website);
	insert into website_priviledge values(null, 'read', new.developer,new.website);
	insert into website_priviledge values(null, 'update', new.developer,new.website);
	insert into website_priviledge values(null, 'delete', new.developer,new.website);
elseif new.role = 'writer' then
	insert into website_priviledge values(null, 'create', new.developer,new.website);
	insert into website_priviledge values(null, 'read', new.developer,new.website);
	insert into website_priviledge values(null, 'update', new.developer,new.website);
elseif new.role = 'editor' then
    insert into website_priviledge values(null, 'read', new.developer,new.website);
	insert into website_priviledge values(null, 'update', new.developer,new.website);
elseif new.role = 'reviewer' then
	insert into website_priviledge values(null, 'read', new.developer,new.website);
end if;
end; $$


delimiter $$
create trigger website_priviledge_trigger_delete
after delete on website_role
for each row
begin
	delete from website_priviledge where developer = old.developer and website = old.website;
end; $$


delimiter $$
create trigger page_priviledge_trigger_insert
after insert on page_role
for each row
begin
if new.role = 'owner' then
	insert into page_priviledge values(null, 'create', new.developer,new.page);
	insert into page_priviledge values(null, 'read', new.developer,new.page);
	insert into page_priviledge values(null, 'update', new.developer,new.page);
	insert into page_priviledge values(null, 'delete', new.developer,new.page);
elseif new.role = 'admin' then
	insert into page_priviledge values(null, 'create', new.developer,new.page);
	insert into page_priviledge values(null, 'read', new.developer,new.page);
	insert into page_priviledge values(null, 'update', new.developer,new.page);
	insert into page_priviledge values(null, 'delete', new.developer,new.page);
elseif new.role = 'writer' then
	insert into page_priviledge values(null, 'create', new.developer,new.page);
	insert into page_priviledge values(null, 'read', new.developer,new.page);
	insert into page_priviledge values(null, 'update', new.developer,new.page);
elseif new.role = 'editor' then
	insert into page_priviledge values(null, 'read', new.developer,new.page);
	insert into page_priviledge values(null, 'update', new.developer,new.page);
elseif new.role = 'reviewer' then
	insert into page_priviledge values(null, 'read', new.developer,new.page);
end if;
end;$$

delimiter $$
create trigger page_priviledge_trigger_update
after update on page_role
for each row
begin
delete from page_priviledge where developer = old.developer and page = old.page;
if new.role = 'owner' then
	insert into page_priviledge values(null, 'create', new.developer,new.page);
	insert into page_priviledge values(null, 'read', new.developer,new.page);
	insert into page_priviledge values(null, 'update', new.developer,new.page);
	insert into page_priviledge values(null, 'delete', new.developer,new.page);
elseif new.role = 'admin' then
	insert into page_priviledge values(null, 'create', new.developer,new.page);
	insert into page_priviledge values(null, 'read', new.developer,new.page);
	insert into page_priviledge values(null, 'update', new.developer,new.page);
	insert into page_priviledge values(null, 'delete', new.developer,new.page);
elseif new.role = 'writer' then
	insert into page_priviledge values(null, 'create', new.developer,new.page);
	insert into page_priviledge values(null, 'read', new.developer,new.page);
	insert into page_priviledge values(null, 'update', new.developer,new.page);
elseif new.role = 'editor' then
	insert into page_priviledge values(null, 'read', new.developer,new.page);
	insert into page_priviledge values(null, 'update', new.developer,new.page);
elseif new.role = 'reviewer' then
	insert into page_priviledge values(null, 'read', new.developer,new.page);
end if;
end;$$


delimiter $$
create trigger page_priviledge_trigger_delete
after delete on page_role
for each row
begin
	delete from page_priviledge where developer = old.developer and page = old.page;
end;$$