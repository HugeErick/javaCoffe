import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public InputHandler() {
        writeInstruction();
    }
    private void writeInstruction() {
        System.out.println("Enter input:");
        String userInstruction = scanner.nextLine();
        System.out.println(userInstruction);
        try {
            String regex = "^[a-zA-Z0-9]{1,21}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(userInstruction);
            if (matcher.matches()) {
                System.out.println("ok");
            } else {
                throw new Exception("input no ok");
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
