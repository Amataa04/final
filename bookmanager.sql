CREATE DATABASE BookManager;
USE BookManager;
CREATE TABLE BookType(
	TypeId Int primary key auto_increment,
    TypeName Varchar(50) not null unique,
    Description text,
    IsDeleted bit(1) default 0
);
CREATE TABLE Book(
	BookId int primary key auto_increment,
    BookName varchar(100) not null unique,
    Tilte varchar(200) not null,
    Author varchar(200) not null,
    TotalPages int not null,
    check (TotalPages > 0),
    Content text not null,
    Publisher varchar(100) not null,
    Price decimal(10,2) not null,
    check (Price > 0),
    TypeId int not null,
    foreign key (TypeId) references BookType(TypeId),
    IsDeleted bit(1) default 0
);

insert into BookType(TypeName, Description, IsDeleted) values ('Truyen kieu', 'sach tho van', 0);
select * from BookType 
where typeid = 2;

insert into Book(BookName, Tilte, Author, TotalPages, Content, Publisher, Price, TypeId, IsDeleted) values('Joker', 'Khong co', 'aaaaa', 200, 'hay', 'kim dong', 120, 1, 1);
select * from book;

select booktype.typeid, booktype.typeName, count(book.typeid) as totalBook from booktype
join book on booktype.typeid = book.typeid
group by booktype.typeid;

update book set BookName = 'Joker', Tilte = 'khong co', Author = 'aaaaa', TotalPages = 200, Content = 'hay', Publisher = 'kim dong', Price = 200, TypeId = 3, IsDeleted = 1 
where bookid = 1;

select * from book order by price desc;

select b.BookName, b.totalPages,
	case
		when b.totalPages < 50 Then 'Nhom 1: duoi 50 trang'
        when b.totalPages >= 50 and b.totalPages < 300 Then 'Nhom 2: tu 50 den duoi 300 trang'
        else 'Nhom 3: tu 300 tro len'
    end as totalPagesGroup    
from book b;

SELECT * 
FROM Book 
WHERE BookName LIKE '%joker%' OR Content LIKE 'hay';