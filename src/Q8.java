import java.util.Scanner;
import java.util.Stack;

public class Q8 {

    // Example equation: 5 x 4 / ( 2 * 3 - 4 ) + 4.5
    public static void main(String[] args) {
        String operator;
        double num;
        Stack<Double> numStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation (Must include spaces between operators and numbers):");
        String equation = in.nextLine();
        Scanner input = new Scanner(equation);
        while (input.hasNext()) {
            if(input.hasNextDouble()) {
                num = input.nextDouble();
                numStack.push(num);
            } else {
                operator = input.next();
                if(operator.equals("(")) {
                    operatorStack.push(operator);
                } else if (!operator.equals(")")) {
                    if (bomdas(operator) > 0) {
                        while (!operatorStack.isEmpty() && (bomdas(operatorStack.peek()) > bomdas(operator))) {
                            numStack.push(evaluate(numStack, operatorStack));
                        }
                        operatorStack.push(operator);
                    } else {
                        System.out.println("ERROR: Invalid Operator");
                    }
                } else {
                    while (!operatorStack.peek().equals("(")) {
                        numStack.push(evaluate(numStack, operatorStack));
                    }
                    operatorStack.pop();
                }
            }
            //System.out.println(numStack);
            //System.out.println(operatorStack);
            //System.out.println();
        }
        while (!operatorStack.isEmpty()) {
            numStack.push(evaluate(numStack, operatorStack));
            //System.out.println(numStack);
            //System.out.println(operatorStack);
            //System.out.println();
        }
        System.out.printf("Answer: %.2f", numStack.pop());
    }

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
