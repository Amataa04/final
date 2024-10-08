package presentation;

import business.BookBusiness;
import business.BookTypeBusiness;
import entity.Book;
import entity.BookType;

import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("******************BOOK-MANAGEMENT******************\n" +
                    "1. Quản lý loại sách\n" +
                    "2. Quản lý sách\n" +
                    "3. Thoát \n" +
                    "Lựa chọn của bạn: \n");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    BookManagement.MenuTypeBook(sc);
                    break;
                case 2:
                    BookManagement.MenuBook(sc);
                    break;
                case 3:
                    System.out.println("Ket thuc chuong trinh, chuc moi nguoi vui ve:))");
                    System.exit(0);
                default:
                    System.out.println("Chon sai, moi ban chon lai!");
            }
        }
        while (true);
    }
    //MenuTypeBook
    public static void MenuTypeBook(Scanner sc){
        boolean isExit = true;
        do {
            System.out.println("**********************BOOKTYPE-MENU********************\n" +
                    "1. Danh sách loại sách\n" +
                    "2. Tạo mới loại sách\n" +
                    "3. Cập nhật thông tin loại sách\n" +
                    "4. Xóa loại sách\n" +
                    "5. Thống kê số lượng sách theo mã loại sách\n" +
                    "6. Thoát \n" +
                    "Lựa chọn của bạn: \n");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    BookManagement.displayBookType(sc);
                    break;
                case 2:
                    BookManagement.addBookType(sc);
                    break;
                case 3:
                    BookManagement.updateBookType(sc);
                    break;
                case 4:
                    BookManagement.deleteBookType(sc);
                    break;
                case 5:
                    BookManagement.listBookTypeByTypeId(sc);
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.out.println("Chon sai, moi ban chon lai!");
            }
        }
        while (isExit);
    }
    //MenuBook
    public static void MenuBook(Scanner sc){
        boolean isExit = true;
        do {
            System.out.println("***********************BOOK-MENU***********************\n" +
                    "1. Danh sách sách\n" +
                    "2. Tạo mới sách\n" +
                    "3. Cập nhật thông tin sách\n" +
                    "4. Xóa sách\n" +
                    "5. Hiển thị danh sách các cuốn sách theo giá giảm dần\n" +
                    "6. Tìm kiếm sách theo tên hoặc nội dung\n" +
                    "7. Thống kê số lượng sách theo nhóm \n" +
                    "8. Thoát\n");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    BookManagement.displayBook(sc);
                    break;
                case 2:
                    BookManagement.addBook(sc);
                    break;
                case 3:
                    BookManagement.updateBook(sc);
                    break;
                case 4:
                    BookManagement.deleteBook(sc);
                    break;
                case 5:
                    BookManagement.listPriceBook(sc);
                    break;
                case 6:
                    BookManagement.searchBookNameOrContent(sc);
                    break;
                case 7:
                    BookManagement.listGroupBook(sc);
                    break;
                case 8:
                    isExit = false;
                    break;
                default:
                    System.out.println("Chon sai, moi ban chon lai!");
            }
        }
        while (isExit);
    }
    // xay dung phuong thuc danh sach loai sach
    public static void displayBookType(Scanner sc){
        List<BookType> bookTypesList = BookTypeBusiness.getAllBookTypes();
        for (BookType bookType : bookTypesList) {
            bookType.displayData();
        }
    }
    // xay dung phuong thuc tao moi danh sach loai sach
    public static void addBookType(Scanner sc){
        BookType bookType = new BookType();
        bookType.inputData(sc);
        boolean result = BookTypeBusiness.addBookType(bookType);
        if (result) {
            System.out.println("Them danh sach loai sach thanh cong");
        }
        else {
            System.out.println("Them danh sach loai sach that bai");
        }
    }
    // xay dung phuong thuc cap nhap danh sach loai sach
    public static void updateBookType(Scanner sc){
        System.out.println("Nhap id loai sach can sua: ");
        int idBookType = Integer.parseInt(sc.nextLine());
        BookType bookType = BookTypeBusiness.getBookTypeById(idBookType);
        if (bookType != null) {
            bookType.displayData();
            boolean isExit = true;
            do {
                System.out.println("Chon muc can sua");
                System.out.println("1. Sua ten loai sach");
                System.out.println("2. Sua mo ta");
                System.out.println("3. Sua trang thai loai sach");
                System.out.println("4. Thoat");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhap ten loai sach can sua: ");
                        bookType.setTypeName(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhap mo ta can sua: ");
                        bookType.setDescription(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhap trang thai can sua: ");
                        bookType.setDeleted(Boolean.parseBoolean(sc.nextLine()));
                        break;
                    case 4:
                        isExit = false;
                        break;
                    default:
                        System.out.println("Chon sai, moi ban chon lai!");
                }
                boolean result = BookTypeBusiness.updateBookType(bookType);
                if (result) {
                    System.out.println("Cap nhat danh sach loai sach thanh cong");
                }
                else {
                    System.out.println("Cap nhat danh sach loai sach that bai");
                }
            }
            while (isExit);
        }
        else{
            System.out.println("Khong tim thay id loai sach can sua!");
        }
    }
    // xay dung phuong thuc xoa danh sach loai sach
    public static void deleteBookType(Scanner sc){
        System.out.println("Nhap id loai sach can xoa: ");
        int idBookType = Integer.parseInt(sc.nextLine());
        BookType bookType = BookTypeBusiness.getBookTypeById(idBookType);
        if (bookType != null) {
            boolean result = BookTypeBusiness.deleteBookTypeById(idBookType);
            if (result) {
                System.out.println("xoa danh sach loai sach thanh cong ");
            }
            else {
                System.out.println("xoa danh sach loai sach that bai");
            }
        }
        else {
            System.out.println("Khong tim thay id loai sach can xoa!");
        }
    }
    // xay dung phuong thuc thong ke so luong sach theo loai sach
    public static void listBookTypeByTypeId(Scanner sc){
        List<BookType> bookTypesList = BookTypeBusiness.getAllBookTypesByBookId();
        for (BookType bookType : bookTypesList) {
            bookType.displayTotalBooks();
        }
    }
    // xay dung phuong thuc danh sach cac sach
    public static void displayBook(Scanner sc){
        List<Book> bookList = BookBusiness.getAllBook();
        for (Book book : bookList) {
            book.displayData();
        }
    }
    // xay dung phuong thuc tao moi danh sach cac sach
    public static void addBook(Scanner sc){
        Book book = new Book();
        book.inputData(sc);
        boolean result = BookBusiness.addBook(book);
        if (result) {
            System.out.println("Them danh sach cac sach thanh cong");
        }
        else {
            System.out.println("Them danh sach cac sach that bai");
        }
    }
    // xay dung phuong thuc cap nhap danh sach loai sach
    public static void updateBook(Scanner sc){
        System.out.println("Nhap id sach can sua: ");
        int idBook = Integer.parseInt(sc.nextLine());
        Book book = BookBusiness.getBookById(idBook);
        if (book != null) {
            book.displayData();
            boolean isExit = true;
            do {
                System.out.println("Chon muc can sua");
                System.out.println("1. Sua ten sach");
                System.out.println("2. Sua tieu de sach");
                System.out.println("3. Sua ten tac gia");
                System.out.println("4. Sua tong so trang");
                System.out.println("5. Sua noi dung");
                System.out.println("6. Sua nha san xuat");
                System.out.println("7. Sua gia tien");
                System.out.println("8. Sua ma loai sach");
                System.out.println("9. Sua trang thai");
                System.out.println("10. Thoat");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhap ten sach can sua: ");
                        book.setBookName(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhap tieu de can sua: ");
                        book.setTitle(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhap ten tac gia can sua: ");
                        book.setAuthor(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhap tong so trang can sua: ");
                        book.setTotalPages(Integer.parseInt(sc.nextLine()));
                        break;
                    case 5:
                        System.out.println("Nhap noi dung can sua: ");
                        book.setContent(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Nhap nha san xuat can sua: ");
                        book.setPublisher(sc.nextLine());
                        break;
                    case 7:
                        System.out.println("Nhap gia tien can sua: ");
                        book.setPrice(Integer.parseInt(sc.nextLine()));
                        break;
                    case 8:
                        System.out.println("Nhap ma loai sach can sua: ");
                        book.setTypeId(Integer.parseInt(sc.nextLine()));
                        break;
                    case 9:
                        System.out.println("Nhap trang thai can sua: ");
                        book.setDeleted(Boolean.parseBoolean(sc.nextLine()));
                        break;
                    case 10:
                        isExit = false;
                        break;
                    default:
                        System.out.println("Chon sai, moi ban chon lai!");
                }
                boolean result = BookBusiness.updateBook(book);
                if (result) {
                    System.out.println("Cap nhat danh sach cac sach thanh cong");
                }
                else {
                    System.out.println("Cap nhat danh sach cac sach that bai");
                }
            }
            while (isExit);
        }
        else{
            System.out.println("Khong tim thay id  sach can sua!");
        }
    }
    // xay dung phuong thuc xoa cac sach
    public static void deleteBook(Scanner sc){
        System.out.println("Nhap id sach can xoa: ");
        int idBook = Integer.parseInt(sc.nextLine());
        Book book = BookBusiness.getBookById(idBook);
        if (book != null) {
            boolean result = BookBusiness.deleteBookById(idBook);
            if (result) {
                System.out.println("xoa danh sach cac sach thanh cong ");
            }
            else {
                System.out.println("xoa danh sach cac sach that bai");
            }
        }
        else {
            System.out.println("Khong tim thay id sach can xoa!");
        }
    }
    // xay dung phuong thuc hien thi danh sach gia sach theo sap xep giam dan
    public static void listPriceBook(Scanner sc){
        List<Book> bookListPrice = BookBusiness.listPriceBook();
        for (Book book : bookListPrice) {
            book.displayData();
        }
    }
    // xay dung phuong thuc tim kiem theo ten sach hoac noi dung
    public static void searchBookNameOrContent(Scanner sc){
        System.out.println("Nhap tu khoa tim kiem: ");
        String keyword = sc.nextLine();
        List<Book> bookList = BookBusiness.searchBookNameOrContent(keyword);
        if (bookList != null && bookList.size() > 0) {
            for (Book book : bookList) {
                book.displayData();
            }
        }
        else {
            System.out.println("Khong tim thay sach can tim!");
        }
    }
    // thong ke so luong sach theo nhom
    public static void listGroupBook(Scanner sc){
        List<Book> listGroupBooks = BookBusiness.ListBookGroup();
        for (Book book : listGroupBooks) {
            book.displayTotalPagesGroup();
        }
    }
}
