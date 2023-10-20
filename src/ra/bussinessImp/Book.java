package ra.bussinessImp;

import ra.bussiness.IBook;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;
    static int count = 1;
    public DecimalFormat format = new DecimalFormat("###,###,###");
    public Book(){
        this.bookId = count++;
    }

    public Book(String bookName, String title, int numberOfPages, float importPrice, float exportPrice, boolean bookStatus) {
        this.bookId = count++;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = exportPrice - importPrice;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách :");
        this.bookName = scanner.nextLine();

        System.out.println("Nhập tiêu đề sách :");
        this.title = scanner.nextLine();

        System.out.println("Nhập số trang sách :");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập giá thu vào :");
        this.importPrice = Float.parseFloat(scanner.nextLine());

        System.out.println("Nhập giá bán ra :");
        float exportP = Float.parseFloat(scanner.nextLine());
        while (exportP <= 1.5 * importPrice) {
            System.out.println("Giá bán ra phải lớn hơn hoặc bằng 1.5 lần giá nhập vào, vui lòng nhập lại :");
            exportP = Float.parseFloat(scanner.nextLine());
        }
        this.exportPrice = exportP;

        System.out.println("Nhập trạng thái : (true (Đang bán) / false (Ngừng bán) )");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());

    }
    public boolean getBookStatus(){
        return this.bookStatus;
    }

    @Override
    public void displayData() {
        System.out.println("Book{" +
                "Mã sách : " + bookId +
                ", Tên sách : '" + bookName + '\'' +
                ", Tiêu đề : '" + title + '\'' +
                ", Số trang sách : "  + numberOfPages +
                ", Giá nhập : " + format.format(importPrice) +
                ", Giá xuất : " + format.format(exportPrice) +
                ", Lợi nhuận : " + format.format(exportPrice - importPrice) +
                ", Trạng thái : " + (bookStatus ? "Còn hàng" : "Hết hàng") +
                '}');
    }
    @Override
    public int compareTo(Book o) {
        return (int) -(this.getInterest() - o.getInterest());
    }
}
