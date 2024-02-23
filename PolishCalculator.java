
package polishcalculator;

import stack.Stack;
import stack.ArrayStack;
import stack.LinkedStack;
import stack.ListNode;
import stack.StackUnderflowException;
import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class PolishCalculator {

    public static void main(String[] args) {
        Stack<Double> stack = null;
        Scanner scanner = new Scanner(System.in);
        boolean debugMode = false;
        
        // Let's the user choose which type of stack to be used
        System.out.println("Choose an option: 1 = to use an array or 2 = to use a linked list");
        int choice = scanner.nextInt();
        scanner.nextLine();
            
        if(choice == 1) {
            stack = new ArrayStack<Double>();
        }else if(choice == 2) {
            stack = new LinkedStack<Double>();
        }else {
            System.out.println("Invalid choice. Defaulting to arraystack");
            stack = new ArrayStack<Double>();
        }
        // entry to the calculator loop
        while(true) {
            System.out.println("Please choose of the following:");
            System.out.println("1 = Enter a number, 2 = Choose an operation (+ , - , * , / ), 3 = Swap top two items, 4 = Toggle Debug mode,  0 = exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if(choice == 0) {
                System.out.println("Goodbye!");
                break;
            } else {
                switch(choice) {
                    // Adding a number to the stack
                    case 1:
                        System.out.println("Please enter a number:");
                        Double numberAdded = scanner.nextDouble();
                        stack.push(numberAdded);
                        System.out.println(stack.top());
                        if(debugMode) {
                            System.out.println(stack.toString());
                        }
                        break;
                    
                    // Switch statement for the operators to be used
                    case 2:
                        // checks if stack is empty
                        if(stack.isEmpty()){
                            System.out.println("You must add at least 2 numbers");
                            break;
                        }
                        // try / catch statement to prevent programm from crashing
                        try{
                            System.out.println("Please enter an operation ( + , - , * , / ) ");
                            String operator = scanner.next();
                            switch(operator) {
                                // Summation
                                case "+":
                                    Double numberA = stack.top();
                                    stack.pop();
                                    Double numberB = stack.top();
                                    stack.pop();
                                    Double resultC = numberA + numberB;
                                    stack.push(resultC);
                                    System.out.println(stack.top());
                                    if(debugMode) {
                                        System.out.println(stack.toString());
                                    }
                                    break;

                                // Subtraction
                                case "-":
                                    numberA = stack.top();
                                    stack.pop();
                                    numberB = stack.top();
                                    stack.pop();
                                    resultC = numberA - numberB;
                                    stack.push(resultC);
                                    System.out.println(stack.top());
                                    if(debugMode) {
                                        System.out.println(stack.toString());
                                    }
                                    break;

                                // Multiplication
                                case "*":
                                    numberA = stack.top();
                                    stack.pop();
                                    numberB = stack.top();
                                    stack.pop();
                                    resultC = numberA * numberB;
                                    stack.push(resultC);
                                    System.out.println(stack.top());
                                    if(debugMode) {
                                        System.out.println(stack.toString());
                                    }
                                    break;

                                // Division
                                case "/":
                                    numberA = stack.top();
                                    stack.pop();
                                    numberB = stack.top();
                                    stack.pop();
                                    resultC = numberA / numberB;
                                    stack.push(resultC);
                                    System.out.println(stack.top());
                                    if(debugMode) {
                                        System.out.println(stack.toString());
                                    }
                                    break;
                            }
                        }catch(stack.StackUnderflowException e){
                            System.out.println("There were not enough numbers to operate on, goodbye!");
                            break;
                        }
                    
                    // swaps the top two Items/ Numbers of the stack
                    case 3:
                        System.out.println("The value on top of the Stack is: " +stack.top());
                        Double numberA = stack.top();
                        stack.pop();
                        Double numberB = stack.top();
                        stack.pop();
                        stack.push(numberA);
                        stack.push(numberB);
                        System.out.println("The value on top of the Stack is: " +stack.top());
                        if(debugMode) {
                                    System.out.println(stack.toString());
                                }
                        break;
                        
                    // toggles Debug Mode on or off
                    case 4:
                        debugMode = !debugMode;
                        System.out.println("Debug Mode is now " +(debugMode ? "ON" : "OFF"));
                        break;
                        
                    default:
                        System.out.println("Please choose one of the available options.");
                }
            }
        }
    }
}
