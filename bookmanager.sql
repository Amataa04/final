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
select * from BookType;