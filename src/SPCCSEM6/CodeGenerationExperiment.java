package SPCCSEM6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerationExperiment {

    static Map<String, String> symbolTable = new HashMap<>();
    static int tempCount = 0;

    static String newTemp() {
        return "t" + (++tempCount);
    }

    public static String generateAddition(String operand1, String operand2) {
        String tempVar = newTemp();
        return tempVar + " = " + operand1 + " + " + operand2;
    }

    public static String generateAssignment(String variable, String value) {
        symbolTable.put(variable, value);
        return variable + " = " + value;
    }

    public static void printSymbolTable() {
        for (Map.Entry<String, String> entry : symbolTable.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void generateCode(List<String> ir) {
        System.out.println("Instructions are :- ");
        for (String instruction : ir) {
            System.out.println(instruction);
        }
    }

    public static void main(String[] args) {
        String t1 = generateAddition("b", "c");
        String assignA = generateAssignment("a", "t1");
        List<String> ir = new ArrayList<>();
        ir.add(t1);
        ir.add(assignA);
        generateCode(ir);
        printSymbolTable();
    }

}
