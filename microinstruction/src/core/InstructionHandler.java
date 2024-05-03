package core;

import operandos.Destiny;
import operandos.Source;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionHandler {

    protected static Queue<String> instructionQueue = new LinkedList<>();

    protected Destiny destiny;
    protected Source source;

    public InstructionHandler(Queue<String> getInstruction) {
        instructionQueue = getInstruction;
        while (!instructionQueue.isEmpty()) {
            String poppedInstruction = instructionQueue.poll();
            handleCase(poppedInstruction);
        }
    }

    public void handleCase(String instruction) {
        String[] tokens = tokenization(instruction);
        switch (tokens[0]) {
            case "load", "sub", "bneg", "store", "halt", "add", "or", "branch", "and":
                break;
            default:
                System.out.println("invalid instruction");
                break;
        }

    }

    public String[] tokenization(String s) {
        String[] tokens = s.split("\\s+");
        System.out.println(Arrays.toString(tokens));
        return tokens;
    }
    private Destiny handleDestinyIdentification(String[] tokens) {
        Destiny getDestiny;
        String regex = "([rR]+)([0-3])";
        String secondRegex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Pattern secondPattern = Pattern.compile(secondRegex);
        Matcher matcher = pattern.matcher(tokens[1]);
        Matcher secondMatcher = secondPattern.matcher(tokens[1]);
        if (matcher.find()) {
            String extractedChar = matcher.group(1);
            char theChar = extractedChar.charAt(0);
            String extractedInt = matcher.group(2);
            int theValue = Integer.parseInt(extractedInt);
            getDestiny = new Destiny(theChar, theValue);
            return getDestiny;
        } else if (secondMatcher.find()) {
            String extractedInt = secondMatcher.group(1);
            int theValue = Integer.parseInt(extractedInt);
            getDestiny = new Destiny('\0', theValue);
            return getDestiny;
        } else {
            System.out.println("Destiny format wrong");
            System.exit(1);
        }
        getDestiny = null;
        return getDestiny;
    }

    private Source handleSourceIdentification(String[] tokens) {
        Source getSource;
        String regex = "([rR]+)([0-3])";
        String secondRegex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Pattern secondPattern = Pattern.compile(secondRegex);
        Matcher matcher = pattern.matcher(tokens[2]);
        Matcher secondMatcher = secondPattern.matcher(tokens[2]);
        if (matcher.find()) {
            String extractedChar = matcher.group(1);
            char theChar = extractedChar.charAt(0);
            String extractedInt = matcher.group(2);
            int theValue = Integer.parseInt(extractedInt);
            getSource = new Source(theChar, theValue);
            return getSource;
        } else if (secondMatcher.find()) {
            String extractedInt = secondMatcher.group(1);
            int theValue = Integer.parseInt(extractedInt);
            getSource = new Source('\0', theValue);
            return getSource;
        } else {
            System.out.println("Source format wrong");
            System.exit(1);
        }
        getSource = null;
        return getSource;
    }

    protected void doOperation(Destiny d, Source s){
        if (d.isReg) {
            //to register
        } else {
            //to memory
        }

        if (s.isReg) {
            //from reg
        } else {
            //from reg
        }
    }
}