package SPCCSEM6;

import java.util.Scanner;

public class Experiment5Precedence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input Format a+b-c-d+a+b-d+f
        String expressionLine = sc.nextLine();
        int variables = 0;
        int multiplyIndex = expressionLine.indexOf("*");
        while(multiplyIndex != -1){
            int startIndex = multiplyIndex-1;
            int endIndex = multiplyIndex+1;
            if(Character.isDigit(expressionLine.charAt(startIndex))){
                startIndex--;
            }
            if(expressionLine.charAt(endIndex) == 't'){
                endIndex++;
            }
            System.out.println("t"+variables+" = "+expressionLine.substring(startIndex,endIndex+1));
            expressionLine = expressionLine.replace(expressionLine.substring(startIndex,endIndex+1),"t"+variables);
            multiplyIndex = expressionLine.indexOf("*");
            variables++;
        }
        System.out.println("Expression After solving * is = "+expressionLine);
        int divisionIndex = expressionLine.indexOf("/");
        while(divisionIndex != -1){
            int startIndex = divisionIndex-1;
            int endIndex = divisionIndex+1;
            if(Character.isDigit(expressionLine.charAt(startIndex))){
                startIndex--;
            }
            if(expressionLine.charAt(endIndex) == 't'){
                endIndex++;
            }
            System.out.println("t"+variables+" = "+expressionLine.substring(startIndex,endIndex+1));
            expressionLine = expressionLine.replace(expressionLine.substring(startIndex,endIndex+1),"t"+variables);
            divisionIndex = expressionLine.indexOf("/");
            variables++;
        }
        System.out.println("Expression After solving / is = "+expressionLine);
        int additionIndex = expressionLine.indexOf("+");
        while(additionIndex != -1){
            int startIndex = additionIndex-1;
            int endIndex = additionIndex+1;
            if(Character.isDigit(expressionLine.charAt(startIndex))){
                startIndex--;
            }
            if(expressionLine.charAt(endIndex) == 't'){
                endIndex++;
            }
            System.out.println("t"+variables+" = "+expressionLine.substring(startIndex,endIndex+1));
            expressionLine = expressionLine.replace(expressionLine.substring(startIndex,endIndex+1),"t"+variables);
            additionIndex = expressionLine.indexOf("+");
            variables++;
        }
        System.out.println("Expression After solving + is = "+expressionLine);
        int minusIndex = expressionLine.indexOf("-");
        while(minusIndex != -1){
            int startIndex = minusIndex-1;
            int endIndex = minusIndex+1;
            if(Character.isDigit(expressionLine.charAt(startIndex))){
                startIndex--;
            }
            if(expressionLine.charAt(endIndex) == 't'){
                endIndex++;
            }
            System.out.println("t"+variables+" = "+expressionLine.substring(startIndex,endIndex+1));
            expressionLine = expressionLine.replace(expressionLine.substring(startIndex,endIndex+1),"t"+variables);
            minusIndex = expressionLine.indexOf("-");
            variables++;
        }
        System.out.println("Expression After solving - is = "+expressionLine);
        System.out.println("t"+variables+" = "+expressionLine);
        expressionLine = expressionLine.replace(expressionLine,"t"+variables);
        System.out.println("Final Expression = "+expressionLine);

    }

}
