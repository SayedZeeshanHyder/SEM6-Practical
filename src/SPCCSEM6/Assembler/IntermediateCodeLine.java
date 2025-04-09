package SPCCSEM6.Assembler;

public class IntermediateCodeLine {

    private String opCode;
    private String argument1;
    private String argument2;

    @Override
    public String toString() {
        return "IntermediateCodeLine{" +
                "opCode='" + opCode + '\'' +
                ", argument1='" + argument1 + '\'' +
                ", argument2='" + argument2 + '\'' +
                '}';
    }

    IntermediateCodeLine(){}

    IntermediateCodeLine(String opCode, String argument1, String argument2){
        this.opCode = opCode;
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
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
