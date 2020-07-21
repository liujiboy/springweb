--搞一个测试脚本，今后可以反复用
delete from books;
delete from categories;
insert into categories values(1,'001','历史');
insert into categories values(2,'002','文学');
insert into books values(1,'测试历史书','一本历史书',1);
insert into books values(2,'测试文学书','一本文学书',2);
