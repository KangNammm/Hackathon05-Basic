package ra.run;

import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);
    public static List<Book> books = new ArrayList<>();
    static {
        books.add(new Book("Sách kinh thánh", "Sách kinh", 20, 15000, 30000, true));
        books.add(new Book("Truyện ma", "Truyện ma", 25, 20000, 60000, true));
        books.add(new Book("Sách dạy nấu ăn", "Sách nấu ăn", 15, 10000, 20000, false));
    }

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 7) {
            System.out.println("---------------Book Management---------------\n" +
                    "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n" +
                    "2. Hiển thị thông tin tất cả sách trong thư viện\n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần \n" +
                    "4. Xóa sách theo mã sách \n" +
                    "5. Tìm kiếm tương đối sách theo tên sách \n" +
                    "6. Thay đổi thông tin sách theo mã sách \n" +
                    "7. Thoát \n" +
                    "Nhập lựa chọn của bạn :");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    sortListBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    updateBook();
                    break;
                case 7:
                    System.out.println("---------------Đã thoát chương trình---------------");
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }

    }

    private static void addNewBook() {
        System.out.println("Nhập số lượng sách muốn thêm mới : ");
        int quantity = scanner.nextInt();
        if (books.size() + quantity > 100){
            System.out.println("Không thể thêm hơn " + 100 + " cuốn sách.");
            return;
        }
        for (int i = 0; i < quantity; i++) {
            System.out.println(("Nhập thông tin của cuốn sách #" + (i + 1) + " : "));
            Book book = new Book();
            book.inputData();
            books.add(book);
            System.out.println("------------Đã thêm sách thành công !------------");
        }
    }

    private static void displayAllBooks() {
        if (books.isEmpty()){
            System.out.println("-------------Hiện đang chưa có sách-------------");
            return;
        }
        System.out.println("---------------Danh sách---------------");
        for (Book book : books) {
            book.displayData();
        }
        System.out.println("---------------------------------------------");
    }

    private static void sortListBook() {
        if (books.isEmpty()) {
            System.out.println("Không có cuốn sách nào !");
        } else {
            System.out.println("------------Danh sách theo lợi nhuận giảm dần------------");
            Collections.sort(books);
            for (Book b : books) {
                b.displayData();
            }
        }
        System.out.println();
    }

    private static void deleteBook() {
        System.out.println("Nhập Id sách cần xóa :");
        int idDel = scanner.nextInt();
        boolean check = false;
        for (Book book : books) {
            if (book.getBookId() == idDel) {
                books.remove(book);
                System.out.println("----------------Xóa sách thành công----------------");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy sách cần xóa");
        }

    }

    private static void searchBook() {
        System.out.println("Nhập tên sách muốn tìm kiếm : ");
        scanner.nextLine();
        String name = scanner.nextLine().trim().toLowerCase();

        boolean searchCheck = false;
        for (Book book : books) {
            if (book.getBookName().toLowerCase().contains(name)) {
                if (!searchCheck) {
                    System.out.println("Kết quả tìm kiếm : ");
                    searchCheck = true;
                }
                book.displayData();
            }
        }
        if (!searchCheck) {
            System.out.println("Không tìm thấy sách nào phù hợp với từ khóa tìm kiếm.");
        }
    }

    private static void updateBook() {
        System.out.println("Nhập Id sách cần cập nhật : ");
        int idUpdate = scanner.nextInt();
        boolean check = false;
        for (Book book : books) {
            if (book.getBookId() == idUpdate) {
                book.inputData();
                System.out.println("Thông tin sách đã được cập nhật thành công");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy sách với Id vừa nhập.");
        }
    }
}
