package bookOp;

import model.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookOperationImpl implements BookOperations {
    private static Connection con = null;

    @Override
    public String AddaBook(Book book) {
        PreparedStatement ps = null;
        con = DBManager.getConnection();
        String str = "insert into book values(?,?,?)";

        try {
            ps = con.prepareStatement(str);
            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getBookName());
            ps.setInt(3, book.getBookPrice());
            ps.executeUpdate();

            return "Book added Successfully";
        } catch (SQLException e) {
            return "Adding a book failed";
        }


    }

    @Override
    public ArrayList<Book> getAllBooks() {

        ArrayList<Book> b = new ArrayList<Book>();
        con = DBManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book");
            while (rs.next()) {
                Book book = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3));
                b.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }


    @Override
    public Book getaBook(int bookId) {
        con = DBManager.getConnection();
        Book book = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book where bookId=" + bookId);

            while (rs.next()) {
                book = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return book;
    }

    @Override
    public String setBookPrice(int bookId, int upPrice) {
        PreparedStatement ps = null;
        String str = "update book set book_Price = ? where bookId=?";

        con = DBManager.getConnection();
        try {
            ps = con.prepareStatement(str);
            ps.setInt(1, upPrice);
            ps.setInt(2, bookId);

            ps.executeUpdate();

            return "Book price updated successfully..";

        } catch (SQLException e) {
            //e.printStackTrace();
           // return e.getMessage();
            return ("Cannot update Book price.");

        }
    }
}
