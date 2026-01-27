import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
    }
}