package SPCCSEM6.Assembler;

public class MnemonicTableLine {

    private String opCode;
    private String className;
    private String info;

    @Override
    public String toString(){
        return "MnemonicTableLine{" +
                "opCode='" + opCode + '\'' +
                ", className='" + className + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    MnemonicTableLine(String opCode, String className, String info){
        this.opCode = opCode;
        this.className = className;
        this.info = info;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
