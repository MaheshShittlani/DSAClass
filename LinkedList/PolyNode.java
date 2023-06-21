public class PolyNode {
    private int coff;
    private int pow;

    public PolyNode(int coff, int pow) {
        this.coff = coff;
        this.pow = pow;
    }

    public int getCoff() {
        return coff;
    }

    public int getPow() {
        return pow;
    }

    public void setCoff(int coff) {
        this.coff = coff;
    }
    public void setPow(int pow) {
        this.pow = pow;
    }

    @Override
    public String toString() {
        return "{ "+coff+","+pow+" }";
    }
}
