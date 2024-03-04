import core.InputHandler;
import core.InstructionsStack;

public class Main {
    public static void main(String[] args)  {
        InputHandler[] inputHandlers = new InputHandler[1];
        InputHandler inputHandler = new InputHandler();
        inputHandlers[0] = inputHandler;
        new InstructionsStack(inputHandlers);
    }
}
