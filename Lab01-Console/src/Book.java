import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {

    private String id;
    private String title;
    private String author;
    private float price;

    //Getter - Setter
    public float getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id: ");
        this.id = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        this.title = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        this.author = sc.nextLine();
        System.out.print("Nhap gia: ");
        this.price = sc.nextFloat();
    }

    public void output() {
        String msg = """
            BOOK:
            -----------
            Ma sach: %s
            Ten sach: %s
            Tac gia: %s
            Gia: %f
            -----------""".formatted(id, title, author, price);
        System.out.printf(msg);
    }
}
