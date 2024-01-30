package database;

public class Row <T>{
    private Value<T>[] values;
    private int index;

    public Row(int number, int index) {
        this.values = new Value[number];
        this.index = index;
    }

    public Value<T>[] getValues() {
        return values;
    }

    public void setValues(Value<T>[] values) {
        this.values = values;
    }
}
