package SPCCSEM6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Experiment8 {

    public static void main(String[] args) {
        HashMap<String,Boolean> map = new HashMap<>();
        List<String> mdTable = new ArrayList<>();
        String[] programArray = new String[]{
                "PRG START 0",
                "MACRO",
                "&LAB INCR &ARG1,&ARG2&ARG3",
                "A 1.&ARG1",
                "A 2.&ARG2",
                "A 3.&ARG3",
                "MEND",
                "LOOP1 INCR DATA1,DATA2,DATA3",
                "DATA1 DC F'5'",
                "DATA2 DC F'10'",
                "DATA3 DC F'15'",
        };
        List<String> program = List.of(programArray);
        System.out.println("Index\tName");
        int hashIndexes = 1;

        int i=0;
        //Iterating Through The Entire Program
        for(i=0;i<program.size();i++){
            String[] lineArray = program.get(i).split(" ");
            if(program.get(i).contains("MACRO")){
                mdTable.add(program.get(i));
                i++;

                //Iterating through the Line
                while(!program.get(i).contains("MEND")){
                    System.out.println((mdTable.size()+1)+"\t"+program.get(i));
                    mdTable.add(program.get(i));
                    i++;
                }
                System.out.println((mdTable.size()+1)+"\t"+program.get(i));
                mdTable.add(program.get(i));
                break;
            }
        }
        i++;
        List<String> belowProgram = new ArrayList<>();

        System.out.println("Program after Pass 1 : ");
        for(int j=i;j<program.size();j++){
            System.out.println(program.get(j));
            belowProgram.add(program.get(j));
        }
    }



}
