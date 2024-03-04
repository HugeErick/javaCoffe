package core;

import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class InstructionsStack {
    protected Stack<String> theInstructionStack;
    public InstructionsStack(InputHandler @NotNull [] inputHandlers){
        theInstructionStack = new Stack<>();
        for (InputHandler ih : inputHandlers ) {
            theInstructionStack.push(ih.userInstruction);
        }

        peakTheInstructionStack(theInstructionStack);
    }

    private void peakTheInstructionStack(@NotNull Stack<String> stack) {
        while (!stack.isEmpty()) {
            String popped = stack.pop();
            System.out.println("p " + popped);
        }
    }


}
