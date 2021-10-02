package custop;

import model.Book;

public interface Custoperation {
    void addToCart(Book book, int qty);
    double getBill();

}
