import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        System.out.print("Enter total movie : ");
        int totalMovie = scanner.nextInt();

        for (int i = 1; i <= totalMovie; i++) {
            list.add("Movie # " + i);
            System.out.println("Movie # " + i);
        }


        System.out.print("Enter count movie  in one page : ");
        int pageSize = scanner.nextInt();
        System.out.print("Enter page : ");
        int pageNum = scanner.nextInt();

//              logic
        if (pageNum <= 0) {
            System.out.println("Incorrect page");
            return;
        }
        if (pageSize <= 0) {
            System.out.println("Incorrect number of movies on page");
            return;
        }
        List<String> result = list
                .stream()
                .skip((pageNum - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

        for (String value: result) {
            System.out.println(value);
        }
    }
}