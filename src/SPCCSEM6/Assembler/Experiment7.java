package SPCCSEM6.Assembler;

import java.util.*;

public class Experiment7 {

    public static List<InstructionLine> initializeInstructionList() {
        InstructionLine instructionLine1 = new InstructionLine("", "START", "501", "");
        InstructionLine instructionLine2 = new InstructionLine("", "READ", "A", "");
        InstructionLine instructionLine3 = new InstructionLine("", "READ", "B", "");
        InstructionLine instructionLine4 = new InstructionLine("", "MOVER", "AREG", "A");
        InstructionLine instructionLine5 = new InstructionLine("", "ADD", "AREG", "B");
        InstructionLine instructionLine6 = new InstructionLine("", "MOVEM", "AREG", "C");
        InstructionLine instructionLine7 = new InstructionLine("", "PRINT", "C", "");
        InstructionLine instructionLine8 = new InstructionLine("A", "DS", "1", "");
        InstructionLine instructionLine9 = new InstructionLine("B", "DS", "1", "");
        InstructionLine instructionLine10 = new InstructionLine("C", "DS", "1", "");
        InstructionLine instructionLine11 = new InstructionLine("", "END", "", "");

        List<InstructionLine> instructionList = new ArrayList<>();
        instructionList.add(instructionLine1);
        instructionList.add(instructionLine2);
        instructionList.add(instructionLine3);
        instructionList.add(instructionLine4);
        instructionList.add(instructionLine5);
        instructionList.add(instructionLine6);
        instructionList.add(instructionLine7);
        instructionList.add(instructionLine8);
        instructionList.add(instructionLine9);
        instructionList.add(instructionLine10);
        instructionList.add(instructionLine11);
        return instructionList;
    }
    public static List<MnemonicTableLine> initializeMnemonicTable() {
        List<MnemonicTableLine> mnemonicTable = new ArrayList<>();
        MnemonicTableLine mnemonicTableLine1 = new MnemonicTableLine("READ", "IS", "(09,1)");
        MnemonicTableLine mnemonicTableLine2 = new MnemonicTableLine("MOVER", "IS", "(04,1)");
        MnemonicTableLine mnemonicTableLine3 = new MnemonicTableLine("ADD", "IS", "(01,1)");
        MnemonicTableLine mnemonicTableLine4 = new MnemonicTableLine("MOVEM", "IS", "(05,1)");
        MnemonicTableLine mnemonicTableLine5 = new MnemonicTableLine("PRINT", "IS", "(10,1)");
        MnemonicTableLine mnemonicTableLine6 = new MnemonicTableLine("DS", "DL", "R#7");
        MnemonicTableLine mnemonicTableLine7 = new MnemonicTableLine("START", "AD", "R#11");
        MnemonicTableLine mnemonicTableLine8 = new MnemonicTableLine("END", "AD", "R#9");
        mnemonicTable.add(mnemonicTableLine1);
        mnemonicTable.add(mnemonicTableLine2);
        mnemonicTable.add(mnemonicTableLine3);
        mnemonicTable.add(mnemonicTableLine4);
        mnemonicTable.add(mnemonicTableLine5);
        mnemonicTable.add(mnemonicTableLine6);
        mnemonicTable.add(mnemonicTableLine7);
        mnemonicTable.add(mnemonicTableLine8);
        return mnemonicTable;
    }

    public static void main(String[] args) {
        int labelCount = 1;
        Map<Character,Integer> labelMap = new HashMap<>();
        List<IntermediateCodeLine> listOfIntermediateCodeLine = new ArrayList<>();
        List<InstructionLine> listOfInstructionLine = initializeInstructionList();
        List<MnemonicTableLine> listOfMnemonicTableLine = initializeMnemonicTable();
        for(int i=0;i<listOfInstructionLine.size();i++){
            InstructionLine instructionLine = listOfInstructionLine.get(i);
            for(int j=0;j<listOfMnemonicTableLine.size();j++){
                IntermediateCodeLine intermediateCodeLine = new IntermediateCodeLine();
                MnemonicTableLine mnemonicTableLine = listOfMnemonicTableLine.get(j);

                //If the Instruction is Imperative Statement
                if (instructionLine.getInstruction().equals(mnemonicTableLine.getOpCode())){

                    if(mnemonicTableLine.getClassName().charAt(0) != 'I') {
                        intermediateCodeLine.setOpCode("(" + mnemonicTableLine.getClassName() + "," + "01)");
                        listOfIntermediateCodeLine.add(intermediateCodeLine);
                    }else{
                        intermediateCodeLine.setOpCode(mnemonicTableLine.getClassName()+mnemonicTableLine.getInfo().substring(0,mnemonicTableLine.getInfo().indexOf(","))+")");
                        listOfIntermediateCodeLine.add(intermediateCodeLine);
                    }

                    //Checking if the Argument 1 is constant
                    try{
                        int constVal = Integer.parseInt(instructionLine.getArgument1());
                        intermediateCodeLine.setArgument1("C,"+constVal);
                    }

                    //Argument 1 is Not a Constant
                    catch (Exception e){

                        //If Argument 1 is Label

                        if(!instructionLine.getArgument2().isEmpty() && labelMap.containsKey(instructionLine.getArgument2().charAt(0))){
                            intermediateCodeLine.setArgument2("S,0"+labelMap.get(instructionLine.getArgument2().charAt(0)));
                            intermediateCodeLine.setArgument1("(1)");
                        }
                        else if(!instructionLine.getArgument2().isEmpty()){
                            labelMap.put(instructionLine.getArgument2().charAt(0),labelCount);
                            intermediateCodeLine.setArgument2("S,0"+labelCount++);
                            intermediateCodeLine.setArgument1("(1)");
                        }
                        else if(instructionLine.getArgument1().length() == 1 && !labelMap.containsKey(instructionLine.getArgument1().charAt(0))){
                            labelMap.put(instructionLine.getArgument1().charAt(0),labelCount);
                            intermediateCodeLine.setArgument1("S,0"+(labelCount++));
                        }else if (instructionLine.getArgument1().length() == 1){
                            intermediateCodeLine.setArgument1("S,0"+labelMap.get(instructionLine.getArgument1().charAt(0)));
                        }

                        //Argument 1 is a Variable
                        else{
                            intermediateCodeLine.setArgument1("(1)");
                        }
                    }
                }
            }
        }
        listOfIntermediateCodeLine.forEach((element)->{
            System.out.println(element.toString());
        });
    }

}
