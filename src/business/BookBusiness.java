package business;

import entity.Book;
import entity.BookType;
import util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookBusiness {
    // hien thi danh sach loai sach
    public static List<Book> getAllBook() {
        Connection connection = null;
        List<Book> bookTypes = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            String sql = "select * from book where isdeleted = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book= new Book();
                book.setBookId(resultSet.getInt("bookid"));
                book.setBookName(resultSet.getString("bookname"));
                book.setTitle(resultSet.getString("tilte"));
                book.setAuthor(resultSet.getString("author"));
                book.setTotalPages(resultSet.getInt("totalpages"));
                book.setContent(resultSet.getString("content"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setPrice(resultSet.getFloat("price"));
                book.setTypeId(resultSet.getInt("typeid"));
                book.setDeleted(resultSet.getBoolean("isdeleted"));
                bookTypes.add(book);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return bookTypes;
    }
    // them
    public static boolean addBook(Book book) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "insert into Book(BookName, Tilte, Author, TotalPages, Content, Publisher, Price, TypeId, IsDeleted) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getTotalPages());
            preparedStatement.setString(5, book.getContent());
            preparedStatement.setString(6, book.getPublisher());
            preparedStatement.setFloat(7, book.getPrice());
            preparedStatement.setInt(8, book.getTypeId());
            preparedStatement.setBoolean(9, book.isDeleted());
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }
    // tim ban ghi theo id
    public static Book getBookById(int id) {
        Connection connection = null;
        Book book = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "select * from book where bookid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book = new Book();
                book.setBookId(resultSet.getInt("bookid"));
                book.setBookName(resultSet.getString("bookname"));
                book.setTitle(resultSet.getString("tilte"));
                book.setAuthor(resultSet.getString("author"));
                book.setTotalPages(resultSet.getInt("totalpages"));
                book.setContent(resultSet.getString("content"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setPrice(resultSet.getFloat("price"));
                book.setTypeId(resultSet.getInt("typeid"));
                book.setDeleted(resultSet.getBoolean("isdeleted"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return book;
    }
    // sua
    public static boolean updateBook(Book book) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "update book set BookName = ?, Tilte = ?, Author = ?, TotalPages = ?, Content = ?, Publisher = ?, Price = ?, TypeId = ?, IsDeleted = ? where bookid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getTotalPages());
            preparedStatement.setString(5, book.getContent());
            preparedStatement.setString(6, book.getPublisher());
            preparedStatement.setFloat(7, book.getPrice());
            preparedStatement.setInt(8, book.getTypeId());
            preparedStatement.setBoolean(9, book.isDeleted());
            preparedStatement.setInt(10, book.getBookId());
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }
    // xoa
    public static boolean deleteBookById(int id) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "delete from book where bookid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }
    // hien thi danh sach cac sach sap xep theo gia sach giam dan
    public static List<Book> listPriceBook(){
        Connection connection = null;
        List<Book> books = new ArrayList<>();
        try{
            connection = ConnectionDB.openConnection();
            String sql = "select * from book order by price desc";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt("bookid"));
                book.setBookName(resultSet.getString("bookname"));
                book.setTitle(resultSet.getString("tilte"));
                book.setAuthor(resultSet.getString("author"));
                book.setTotalPages(resultSet.getInt("totalpages"));
                book.setContent(resultSet.getString("content"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setPrice(resultSet.getFloat("price"));
                book.setTypeId(resultSet.getInt("typeid"));
                book.setDeleted(resultSet.getBoolean("isdeleted"));
                books.add(book);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return books;
    }
    // tim kiem theo ten hoac noi dung
    public static List<Book> searchBookNameOrContent(String keyword){
        Connection connection = null;
        List<Book> books = new ArrayList<>();
        try{
            connection = ConnectionDB.openConnection();
            String sql = "select * from book where bookname like ? or content like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt("bookid"));
                book.setBookName(resultSet.getString("bookname"));
                book.setTitle(resultSet.getString("tilte"));
                book.setAuthor(resultSet.getString("author"));
                book.setTotalPages(resultSet.getInt("totalpages"));
                book.setContent(resultSet.getString("content"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setPrice(resultSet.getFloat("price"));
                book.setTypeId(resultSet.getInt("typeid"));
                book.setDeleted(resultSet.getBoolean("isdeleted"));
                books.add(book);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return books;
    }
    // thong ke so luong sach theo nhom
    public static List<Book> ListBookGroup(){
        Connection connection = null;
        List<Book> books = new ArrayList<>();
        try{
            connection = ConnectionDB.openConnection();
            String sql = "select b.BookName, b.totalPages,\n" +
                    "\tcase\n" +
                    "\t\twhen b.totalPages < 50 Then 'Nhom 1: duoi 50 trang'\n" +
                    "        when b.totalPages >= 50 and b.totalPages < 300 Then 'Nhom 2: tu 50 den duoi 300 trang'\n" +
                    "        else 'Nhom 3: tu 300 tro len'\n" +
                    "    end as totalPagesGroup    \n" +
                    "from book b;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookName(resultSet.getString("bookname"));
                book.setTotalPages(resultSet.getInt("totalpages"));
                book.setTotalPagesGroup(resultSet.getString("totalpagesGroup"));
                books.add(book);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return books;
    }
}
