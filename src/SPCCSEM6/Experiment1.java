package SPCCSEM6;
import java.util.*;

public class Experiment1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Replace with Scanner Input
        String[] inputLines = new String[]{"int a = 10 ;","c = a + 3 ;"};
        Map<String,List<String>> output = new HashMap<>();
        for(int i=0;i<inputLines.length;i++){
            String[] tokens = inputLines[i].split(" ");
            for(int j = 0;j<tokens.length;j++){
                if(tokens[j].equalsIgnoreCase("int") || tokens[j].equalsIgnoreCase("string") || tokens[j].equalsIgnoreCase("double") || tokens[j].equalsIgnoreCase("char")){
                    List<String> keywords;
                    if(output.containsKey("keywords")){
                        keywords = output.get("keywords");
                    }else{
                        keywords = new ArrayList<>();
                    }
                    keywords.add(tokens[i]+" ");
                    output.put("keywords",keywords);
                }
                else if(Character.isLetter(tokens[j].charAt(0))){
                    List<String> identifier;
                    if(output.containsKey("identifier")){
                        identifier = output.get("identifier");
                    }else{
                        identifier = new ArrayList<>();

                    }
                    identifier.add(tokens[j]+" ");
                    output.put("identifier",identifier);
                }
                else{
                    try{
                        int a = Integer.parseInt(tokens[j]);
                        List<String> constants;
                        if(output.containsKey("constants")){
                            constants = output.get("constants");
                        }else{
                            constants = new ArrayList<>();
                        }
                        constants.add(tokens[j]+" ");
                        output.put("constants",constants);
                    }
                    catch (Exception e){
                        List<String> operator;
                        if(output.containsKey("operator")){
                            operator = output.get("operator");
                        }else{
                            operator = new ArrayList<>();
                        }
                        operator.add(tokens[j]+" ");
                        output.put("operator",operator);
                    }
                }
            }
        }
        output.entrySet().forEach((item)->{
            List<String> values = item.getValue();
            String tokenType = item.getKey();
            System.out.print("Token : "+tokenType+" -> ");
            for(int i=0;i<values.size();i++){
                System.out.print(values.get(i));
            }
            System.out.println();
        });
    }

}
