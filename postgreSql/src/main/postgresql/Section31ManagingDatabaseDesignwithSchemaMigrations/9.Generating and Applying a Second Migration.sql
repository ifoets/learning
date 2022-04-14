--do
alter table comments
rename column contents to body;

--undo 
alter table comments
rename column body to contents;