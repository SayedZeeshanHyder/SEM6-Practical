package SPCCSEM6;

import java.util.Scanner;

public class Experiment5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expressionLine = sc.nextLine();
        int equalToIndex = expressionLine.indexOf("=")+1;
        int variables = 0;
        System.out.println("Replacing "+expressionLine.substring(equalToIndex,equalToIndex+3)+" with t"+variables);
        expressionLine = expressionLine.replace(expressionLine.substring(equalToIndex,equalToIndex+3), "t"+variables);
        System.out.println("Expression becomes "+expressionLine);
        variables++;
        while(expressionLine.length() != 4){
            String expression = expressionLine.substring(equalToIndex,equalToIndex+4);
            System.out.println("Replacing "+expression+" with t"+variables);
            expressionLine = expressionLine.replace(expression, "t"+variables);
            System.out.println("Expression becomes "+expressionLine);
            variables++;
        }
        System.out.println("Replacing "+expressionLine+" with t"+variables);
        String answer = expressionLine.replace(expressionLine,"t"+variables);
        System.out.println("Final Expression = "+answer);
    }

}
