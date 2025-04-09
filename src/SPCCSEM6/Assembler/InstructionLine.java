package SPCCSEM6.Assembler;

public class InstructionLine {

    private String label;
    private String instruction;
    private String argument1;
    private String argument2;

    InstructionLine(String label,String instruction,String argument1,String argument2){
        this.argument1 = argument1;
        this.argument2 = argument2;
        this.label = label;
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "InstructionLine{" +
                "label='" + label + '\'' +
                ", instruction='" + instruction + '\'' +
                ", argument1='" + argument1 + '\'' +
                ", argument2='" + argument2 + '\'' +
                '}';
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getArgument1() {
        return argument1;
    }

    public void setArgument1(String argument1) {
        this.argument1 = argument1;
    }

    public String getArgument2() {
        return argument2;
    }

    public void setArgument2(String argument2) {
        this.argument2 = argument2;
    }
}
