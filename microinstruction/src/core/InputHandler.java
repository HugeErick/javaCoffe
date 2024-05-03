package core;

import operandos.Destiny;
import operandos.Source;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);
    public String userInstruction;
    public InputHandler() {
        writeInstruction();
        if (LoopMenu.dontQuitLoop) {
            String[] userTokens = tokenization(userInstruction);
            handleInstructionCase(userTokens);
        }
    }
    private void writeInstruction() {
        System.out.println("Enter input:");
        userInstruction = scanner.nextLine();
        if (Objects.equals(userInstruction, "!")) {
            LoopMenu.dontQuitLoop = false;
        } else {
            try {
                String regex = "^[a-zA-Z0-9\\s]{1,21}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(userInstruction);
                if (matcher.matches()) {
                    System.out.println("ok");
                } else {
                    System.out.println("found:" + userInstruction);
                    throw new Exception("input no ok");
                }
            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    }

    private String @NotNull [] tokenization(@NotNull String input) {
       String[] tokens = input.split("\\s+");
       System.out.println(Arrays.toString(tokens));
       return tokens;
    }

    private void handleInstructionCase(String @NotNull [] tokens) {
        //checking if instruction is valid
        switch (tokens[0]) {
            case "load", "sub", "bneg", "store", "halt", "add", "or", "branch", "and":
                break;
            default:
                System.out.println("invalid instruction");
                break;
        }
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

}
