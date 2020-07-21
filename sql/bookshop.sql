--搞一个测试脚本，今后可以反复用
delete from books;
delete from categories;
insert into categories values(1,'001','历史');
insert into categories values(2,'002','文学');
insert into books values(1,'测试历史书','一本历史书',1);
insert into books values(2,'测试文学书','一本文学书',2);
create view book_category as select b.id as bookId,b.info as bookInfo,b.name as bookName,c.id as categoryId,c.code as categoryCode,c.name as categoryName  from books as b left join categories as c on b.category_id=c.id