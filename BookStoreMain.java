package mainUIpack;

import bookOp.BookOperationImpl;
import custop.CustoperationsImpl;
import model.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStoreMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BookOperationImpl b = new BookOperationImpl();
        while (true) {
            System.out.println("1.Add a Book");
            System.out.println("2.List all the books");
            System.out.println("3.Get a Book");
            System.out.println("4.Update a Book price");
            System.out.println("5.Add to cart and bill");
           // System.out.println("6.Billing");
            System.out.println("7.Exit");

            System.out.println("Enter your Choice");
            int choice = s.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the details of the book");
                    int bookId = s.nextInt();
                    String bookName = s.next();
                    int book_Price = s.nextInt();
                    Book book = new Book(bookId, bookName, book_Price);
                    System.out.println(b.AddaBook(book));

                    break;
                }
                case 2: {
                    ArrayList<Book> blist = b.getAllBooks();
                    for (Book book : blist) {
                        System.out.println(book);
                    }
                    break;

                }
                case 3: {
                    System.out.println("Enter the book to be searched");
                    int bookId = s.nextInt();
                    Book book = b.getaBook(bookId);
                    if (book != null)
                        System.out.println(book);
                    else
                        System.out.println("Book not found in the store");
                    break;

                }
                case 4: {
                    System.out.println("Enter bookId");
                    int bookId = s.nextInt();
                    System.out.println("Enter the updated price of the book");
                    int upPrice = s.nextInt();
                    System.out.println(b.setBookPrice(bookId, upPrice));
                    break;
                }
                case 5:
                {
                    CustoperationsImpl cust=new CustoperationsImpl();
                    System.out.println();
                    while(true)
                    {
                        String ch="Y";
                        System.out.println("Enter the bookId to add to cart");
                        int bookId=s.nextInt();
                        System.out.println("Enter the number of copies");
                        int qty=s.nextInt();
                        Book book =b.getaBook(bookId);
                        cust.addToCart(book,qty);
                        System.out.println("Do you wish to continue to add more books");
                        ch=s.next();
                        if(ch.charAt(0)=='N')
                            break;
                    }
                    System.out.println("Bill amount  "+cust.getBill()+"    TransactionID "+cust.getTid());
                    break;
                }

                default:
                    s.close();
                    ;
                    System.out.println("Bye Bye...!");
                    System.exit(0);
            }
        }

    }
}
