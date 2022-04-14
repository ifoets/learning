--see the additional  stuff on indexing

--EXTENSION gives stored data in index or heap file
CREATE EXTENSION pageinspect;

--go to behind the meta data of indexes
--bt_metap --BTree_MetaPage
select *
from bt_metap('users_username_idx');

--result root/Integer-3 is the index block no where meta data of index are present

--to retrive that
select *
from bt_page_items('users_username_idx', 3); -- it gives lot of information of page 3 on index memeory


--check what is inside page1
select *
from bt_page_items('users_username_idx', 1);
