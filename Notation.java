/**
 * Primary Utility class used for all the evaluations
 * @author Samuella Helha
 */
import java.util.*;

public class Notation {

    // Method to convert infix to postfix using a Queue
    public static String infixToPostfix(String infix) throws InvalidNotationFormatException {
        Queue<String> outputQueue = new LinkedList<>(); // Queue to store postfix expression
        Stack<Character> operatorStack = new Stack<>();  // Stack to hold operators

        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);

            // If the character is a digit, add it to the output queue
            if (Character.isDigit(currentChar)) {
                outputQueue.add(String.valueOf(currentChar));
            }
            // If the character is an opening parenthesis, push it to the operator stack
            else if (currentChar == '(') {
                operatorStack.push(currentChar);
            }
            // If the character is a closing parenthesis, pop from the stack until an opening parenthesis is encountered
            else if (currentChar == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    outputQueue.add(String.valueOf(operatorStack.pop()));
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop(); // Pop the '('
                }
            }
            // If the character is an operator, process the operator stack
            else if (isOperator(currentChar)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(currentChar)) {
                    outputQueue.add(String.valueOf(operatorStack.pop()));
                }
                operatorStack.push(currentChar);
            } else {
                throw new InvalidNotationFormatException("Invalid character in expression");
            }
        }

        // Pop any remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
                throw new InvalidNotationFormatException("Mismatched parentheses in expression");
            }
            outputQueue.add(String.valueOf(operatorStack.pop()));
        }

        return String.join(" ", outputQueue); // Return the postfix expression as a string
    }

    // Method to convert postfix to infix
    public static String postfixToInfix(String postfix) throws InvalidNotationFormatException {
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char currentChar = postfix.charAt(i);

            // If it's a digit, push it to the stack
            if (Character.isDigit(currentChar)) {
                stack.push(String.valueOf(currentChar));
            }
            // If it's an operator, pop two operands from the stack and combine them
            else if (isOperator(currentChar)) {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException("Invalid postfix expression");
                }
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push("(" + operand1 + currentChar + operand2 + ")");
            } else {
                throw new InvalidNotationFormatException("Invalid character in expression");
            }
        }

        // Return the final infix expression
        if (stack.size() != 1) {
            throw new InvalidNotationFormatException("Invalid postfix expression");
        }
        return stack.pop();
    }

    // Method to evaluate a postfix expression
    public static double evaluatePostfix(String postfix) throws InvalidNotationFormatException {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char currentChar = postfix.charAt(i);

            // If it's a digit, push it to the stack as a double
            if (Character.isDigit(currentChar)) {
                stack.push((double) (currentChar - '0'));
            }
            // If it's an operator, pop operands, perform operation, and push result
            else if (isOperator(currentChar)) {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException("Invalid postfix expression");
                }
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(operand1, operand2, currentChar);
                stack.push(result);
            } else {
                throw new InvalidNotationFormatException("Invalid character in expression");
            }
        }

        if (stack.size() != 1) {
            throw new InvalidNotationFormatException("Invalid postfix expression");
        }

        return stack.pop();
    }

    // Helper method to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Helper method to get the precedence of operators
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Helper method to perform an operation
    private static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
