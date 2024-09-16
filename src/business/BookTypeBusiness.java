package business;

import entity.BookType;
import util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookTypeBusiness {
    // hien thi danh sach loai sach
    public static List<BookType> getAllBookTypes() {
        Connection connection = null;
        List<BookType> bookTypes = new ArrayList<BookType>();
        try {
            connection = ConnectionDB.openConnection();
            String sql = "select * from booktype where isdeleted = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookType bookType = new BookType();
                bookType.setTypeId(resultSet.getInt("typeid"));
                bookType.setTypeName(resultSet.getString("typename"));
                bookType.setDescription(resultSet.getString("description"));
                bookType.setDeleted(resultSet.getBoolean("isdeleted"));
                bookTypes.add(bookType);
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
    public static boolean addBookType(BookType bookType) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "insert into booktype (typename, description, isdeleted) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookType.getTypeName());
            preparedStatement.setString(2, bookType.getDescription());
            preparedStatement.setBoolean(3, bookType.isDeleted());
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
    public static BookType getBookTypeById(int id) {
        Connection connection = null;
        BookType bookType = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "select * from booktype where typeid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookType = new BookType();
                bookType.setTypeId(resultSet.getInt("typeid"));
                bookType.setTypeName(resultSet.getString("typename"));
                bookType.setDescription(resultSet.getString("description"));
                bookType.setDeleted(resultSet.getBoolean("isdeleted"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return bookType;
    }
    // sua
    public static boolean updateBookType(BookType bookType) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "update booktype set typename = ?, description = ?, isdeleted = ? where typeid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookType.getTypeName());
            preparedStatement.setString(2, bookType.getDescription());
            preparedStatement.setBoolean(3, bookType.isDeleted());
            preparedStatement.setInt(4, bookType.getTypeId());
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
    public static boolean deleteBookTypeById(int id) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "delete from booktype where typeid = ?";
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
    // thong ke so luong sach theo ma loai sach
    public static List<BookType> getAllBookTypesByBookId(int bookId) {
        Connection connection = null;
        List<BookType> bookTypeList = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            String sql = "select booktype.typeid, booktype.typeName, count(book.typeid) as totalBook from booktype\n" +
                    "join book on booktype.typeid = book.typeid\n" +
                    "group by booktype.typeid, booktype.typename;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookType bookType = new BookType();
                bookType.setTypeId(resultSet.getInt("typeid"));
                bookType.setTypeName(resultSet.getString("typename"));
                bookTypeList.add(bookType);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(connection);
        }
        return bookTypeList;
    }
}
