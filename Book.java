package model;

public class Book {
    private int bookId;
    private String bookName;
    private int book_Price;

    public Book(int bookId, String bookName, int book_Price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.book_Price = book_Price;
    }

    public void setBookPrice(int book_Price) {
        this.book_Price = book_Price;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookPrice() {
        return book_Price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + book_Price +
                '}';
    }
    }
