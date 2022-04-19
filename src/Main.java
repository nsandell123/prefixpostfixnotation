import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(conversionRPM("64-3+"));
    }

    //Problem Statement: Taking in an expression represented in RPN and output a number. My solution only works with one digit numbers

    public static int conversionRPM(String input) {
        //validation checking (Is there a relationship between number of operators and operands?
        //validation checking (During processing, you can check whether something is out of order)
        //validation checking (Only numeric characters and operators can exist)
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("You have to give a non-empty non-null string");
        }
        Stack<Integer> processingStack = new Stack<Integer>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                int secondOperand = processingStack.pop();
                int firstOperand = processingStack.pop();
                if (input.charAt(i) == '+') {
                    processingStack.push(firstOperand + secondOperand);
                }
                if (input.charAt(i) == '-') {
                    processingStack.push(firstOperand - secondOperand);
                }
                if (input.charAt(i) == '*') {
                    processingStack.push(firstOperand * secondOperand);
                }
                if (input.charAt(i) == '/') {
                    processingStack.push(firstOperand / secondOperand);
                }
            } else {
                processingStack.push(input.charAt(i) - 48);
            }


        }
        return processingStack.pop();

    }


}
