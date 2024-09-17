package entity;

import java.util.Scanner;

public class Book implements IBookManagement{
    private int BookId;
    private String BookName;
    private String Title;
    private String Author;
    private int TotalPages;
    private String Content;
    private String Publisher;
    private float Price;
    private int TypeId;
    private boolean IsDeleted;
    private String TotalPagesGroup;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, String author, int totalPages, String content, String publisher, float price, int typeId, boolean isDeleted, String totalPagesGroup) {
        BookId = bookId;
        BookName = bookName;
        Title = title;
        Author = author;
        TotalPages = totalPages;
        Content = content;
        Publisher = publisher;
        Price = price;
        TypeId = typeId;
        IsDeleted = isDeleted;
        TotalPagesGroup = totalPagesGroup;
    }

    public String getTotalPagesGroup() {
        return TotalPagesGroup;
    }

    public void setTotalPagesGroup(String totalPagesGroup) {
        TotalPagesGroup = totalPagesGroup;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(int totalPages) {
        TotalPages = totalPages;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }


    @Override
    public void displayData() {
        System.out.println("BookId: " + BookId);
        System.out.println("BookName: " + BookName);
        System.out.println("Title: " + Title);
        System.out.println("Author: " + Author);
        System.out.println("TotalPages: " + TotalPages);
        System.out.println("Content: " + Content);
        System.out.println("Publisher: " + Publisher);
        System.out.println("Price: " + Price);
        System.out.println("TypeId: " + TypeId);
        System.out.println("IsDeleted: " + (IsDeleted ? "yes" : "no"));
        System.out.println("-------------------------------------------");
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhap ten sach: ");
        BookName = sc.nextLine();
        System.out.println("Nhap tieu de: ");
        Title = sc.nextLine();
        System.out.println("Nhap ten tac gia: ");
        Author = sc.nextLine();
        System.out.println("Nhap tong so trang: ");
        TotalPages = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap noi dung sach");
        Content = sc.nextLine();
        System.out.println("Nhap nha xuat ban: ");
        Publisher = sc.nextLine();
        System.out.println("Nhap gia sach: ");
        Price = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap ma loai sach: ");
        TypeId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap trang thai sach(true/false): ");
        IsDeleted = Boolean.parseBoolean(sc.nextLine());
    }

    public void displayTotalPagesGroup() {
        System.out.println("BookName: " + BookName);
        System.out.println("Total Pages: " + TotalPages);
        System.out.println("TotalPagesGroup: \n" + TotalPagesGroup);
        System.out.println("-------------------------------------------");
    }
}