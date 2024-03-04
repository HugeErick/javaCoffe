package operandos;

public class Source {

    protected final char letter;
    protected final int index;
    public boolean isReg = false;
    public Source(char letter, int getIndex) {
        this.letter = letter;
        this.index = getIndex;
        peak(this.letter, this.index);
        caseIdentification(this.letter);
    }

    private void peak(char letter, int index) {
        System.out.println(letter + " " + index);
    }

    protected void caseIdentification(char letter) {
       if (!(letter == '\0')) {
           isReg = true;
       }
    }


}
