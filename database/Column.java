package database;

public class Column<T> {
    private Value<T>[] values;
    private int index;

    public Column(int number, int index) {
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
