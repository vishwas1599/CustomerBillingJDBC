package bookOp;

import model.Book;

import java.util.ArrayList;

public interface BookOperations {
    String AddaBook(Book book);
    ArrayList<Book> getAllBooks();
    Book getaBook(int bookId);
    String setBookPrice(int bookId,int upPrice);

}
