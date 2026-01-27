import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String msg = """
            Chương trình quản lý sách
            1. Thêm 1 cuốn sách
            2. Xóa 1 cuốn sách
            3. Thay đổi cuốn sách
            4. Xuất thông tin
            5. Tìm sách lập trình
            6. Lấy sách tối đa đánh giá
            7. Tìm kiếm theo tác giả
            0. Thoát
            Chọn chức năng: """;

        int choice;
        do {
            System.out.print(msg);
            choice = sc.nextInt();
            sc.nextLine(); // FIX lỗi Scanner

            switch (choice) {
                case 1 -> {
                    Book book = new Book();
                    book.input();
                    listBook.add(book);
                    System.out.println("--------------");
                }
                case 2 -> {
                    System.out.print("Nhập mã sách cần xóa: ");
                    String bookId = sc.nextLine();

                    Optional<Book> find = listBook
                        .stream()
                        .filter(p -> p.getId().equals(bookId))
                        .findFirst();

                    if (find.isPresent()) {
                        listBook.remove(find.get());
                        System.out.println("Đã xóa sách thành công!");
                    } else {
                        System.out.println("Không tìm thấy sách!");
                    }
                    System.out.println("--------------");
                }
                case 3 -> {
                    System.out.print("Nhập mã sách cần chỉnh sửa: ");
                    String bookId = sc.nextLine();

                    Optional<Book> find = listBook
                        .stream()
                        .filter(p -> p.getId().equals(bookId))
                        .findFirst();

                    if (find.isPresent()) {
                        System.out.println("Nhập thông tin mới:");
                        find.get().input();
                    } else {
                        System.out.println("Không tìm thấy sách!");
                    }
                    System.out.println("--------------");
                }
                case 4 -> {
                    System.out.println("\nDanh sách sách:");
                    listBook.forEach(Book::output);
                    System.out.println("--------------");
                }
                case 5 -> {
                    String search = "lập trình";
                    List<Book> result = listBook
                        .stream()
                        .filter(p ->
                            p.getTitle().toLowerCase().contains(search)
                        )
                        .collect(Collectors.toList());

                    System.out.println("\nKết quả tìm kiếm:");
                    result.forEach(Book::output);
                    System.out.println("--------------");
                }
                case 6 -> {
                    System.out.print("Nhap so luong sach k: ");
                    int k = sc.nextInt();
                    System.out.print("Nhap gia P: ");
                    float P = sc.nextFloat();
                    sc.nextLine();

                    List<Book> result = listBook.stream()
                            .filter(b -> b.getPrice() >= P)
                            .sorted(Comparator.comparing(Book::getPrice).reversed())
                            .limit(k)
                            .collect(Collectors.toList());

                    System.out.println("\nDanh sach sach thoa dieu kien:");
                    result.forEach(Book::output);
                    System.out.println("--------------");
                }
                case 7 -> {
                    System.out.print("Nhập tên tác giả cần tìm: ");
                    String author = sc.nextLine();

                    List<Book> result = listBook
                        .stream()
                        .filter(p ->
                            p
                                .getAuthor()
                                .toLowerCase()
                                .contains(author.toLowerCase())
                        )
                        .collect(Collectors.toList());

                    System.out.println("\nKết quả tìm kiếm:");
                    result.forEach(Book::output);
                    System.out.println("--------------");
                }
            }
        } while (choice != 0);
    }
}
