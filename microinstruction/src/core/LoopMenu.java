package core;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LoopMenu {
    private  static final Queue<String> inputQueue = new LinkedList<>();
    public static boolean dontQuitLoop = true;
    public LoopMenu() {
        System.out.println("Welcome to microinstructions pseudoassembly interpreter");
        System.out.println("To stop queueing instructions press !");
        while(dontQuitLoop) {
            //this while loop is not infinite
            //handle queue
            InputHandler inputHandler = new InputHandler();
            if(!Objects.equals(inputHandler.userInstruction, "!")) {
                inputQueue.add(inputHandler.userInstruction);
            }
        }
        System.out.println("displaying queue");
        while (!inputQueue.isEmpty()) {
            String queuedInput = inputQueue.poll();
            System.out.println("Queued input: " + queuedInput);
            // Process the queued input further if needed
        }
    }
}
