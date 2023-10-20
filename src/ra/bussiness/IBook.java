package ra.bussiness;

import ra.bussinessImp.Book;

public interface IBook {
    void inputData();
    void displayData();

    int compareTo(Book o);
}
