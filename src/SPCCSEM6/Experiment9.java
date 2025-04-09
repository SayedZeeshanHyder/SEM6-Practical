package SPCCSEM6;

import java.util.Scanner;

public class Experiment9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String productionRule = scanner.nextLine();
        System.out.println("Entered Production Rule : "+productionRule);
        System.out.println("Production Rule has left Recursion : "+checkIfLeftRecursionExists(productionRule));
        String leftPart = productionRule.substring(0,productionRule.indexOf("-"));
        String rightPartLeft = productionRule.substring(productionRule.indexOf(">")+1,productionRule.indexOf("|"));
        String rightPartRight = productionRule.substring(productionRule.indexOf("|")+1);
        String firstProduction = leftPart+"->"+rightPartRight+"X";
        String secondProductionRule = "X->"+reverseAString(rightPartLeft)+"|e";
        System.out.println(firstProduction);
        System.out.println(secondProductionRule);
    }

    static boolean checkIfLeftRecursionExists(String productionRule){
        char first = productionRule.charAt(0);
        char leftMostVariable = productionRule.charAt(productionRule.indexOf(">")+1);
        if(first == leftMostVariable){
            return true;
        }
        return false;
    }

    static String reverseAString(String productionRule){
        String rev = "";
        for(int i=0;i<productionRule.length();i++){
            rev = productionRule.charAt(i)+rev;
        }
        return rev;
    }

}
