package parser;


public class ValuePair<G, K> {
    private G value1;
    private K value2;

    public ValuePair(G value1, K value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public G getValue1() {
        return value1;
    }

    public void setValue1(G value1) {
        this.value1 = value1;
    }

    public K getValue2() {
        return value2;
    }

    public void setValue2(K value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "ValuePair{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}