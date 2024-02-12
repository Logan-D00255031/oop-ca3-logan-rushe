import java.util.Scanner;
import java.util.Stack;

public class Q8 {

    // Example equation: 5 x 4 / ( 2 * 3 - 4 ) + 4.5
    public static void main(String[] args) {
        // Initialize variables
        String operator;
        double num;
        Stack<Double> numStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation (Must include spaces between operators and numbers):");
        String equation = in.nextLine();
        Scanner input = new Scanner(equation);
        // Loop until no more numbers or operators
        while (input.hasNext()) {
            // If it's a number
            if(input.hasNextDouble()) {
                // Get the number and push it to the stack
                num = input.nextDouble();
                numStack.push(num);
            } else {
                // Get the operator
                operator = input.next();
                // If it's an open bracket
                if(operator.equals("(")) {
                    // Push to stack
                    operatorStack.push(operator);
                } // If it isn't a closing bracket
                else if (!operator.equals(")")) {
                    // If it's a valid operator
                    if (bomdas(operator) > 0) {
                        // Loop if stack isn't empty and operator on top of the stack is greater than new operator
                        while (!operatorStack.isEmpty() && (bomdas(operatorStack.peek()) > bomdas(operator))) {
                            // Push the value of the evaluation
                            numStack.push(evaluate(numStack, operatorStack));
                        }
                        // Add the new operator to the stack
                        operatorStack.push(operator);
                    } else {
                        System.out.println("ERROR: Invalid Operator");
                    }
                } else {
                    // Loop until the open bracket is on the top of the stack
                    while (!operatorStack.peek().equals("(")) {
                        // Push the value of the evaluation
                        numStack.push(evaluate(numStack, operatorStack));
                    }
                    // Pop the open bracket off the stack
                    operatorStack.pop();
                }
            }
            //System.out.println(numStack);
            //System.out.println(operatorStack);
            //System.out.println();
        }
        // Loop until the operator stack is empty
        while (!operatorStack.isEmpty()) {
            // Push the value of the evaluation
            numStack.push(evaluate(numStack, operatorStack));
            //System.out.println(numStack);
            //System.out.println(operatorStack);
            //System.out.println();
        }
        System.out.printf("Answer: %.2f", numStack.pop());
    }

    // Method for checking precedence of operators
    static int bomdas(String operator) {
        switch (operator) {
            case "x", "X", "*" -> {
                return 4;
            }
            case "/" -> {
                return 3;
            }
            case "+" -> {
                return 2;
            }
            case "-" -> {
                return 1;
            }
            default -> {
                return 0;
            }
        }
    }

    // Method for evaluating the top two numbers on the stack with the top operator on the stack
    static double evaluate(Stack<Double> numStack, Stack<String> operatorStack) {
        String operator = operatorStack.pop();
        if (operator.equalsIgnoreCase("x") || operator.equals("*")) {
            return numStack.pop() * numStack.pop();
        } else if (operator.equalsIgnoreCase("/")) {
            Double num2 = numStack.pop();
            return numStack.pop() / num2;
        } else if (operator.equalsIgnoreCase("+")) {
            return numStack.pop() + numStack.pop();
        } else {
            Double num2 = numStack.pop();
            return numStack.pop() - num2;
        }
    }
}
