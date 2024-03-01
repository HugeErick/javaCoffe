import java.util.Scanner;

public class InputHandler {
    Scanner scanner = new Scanner(System.in);

    void writeInstruction() {
        String userInstruction = scanner.nextLine();
        System.out.println(userInstruction);
    }
}
