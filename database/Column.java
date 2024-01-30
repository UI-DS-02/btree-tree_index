package database;

public class Column<T> {

    String name;
    Object datatype;
    T value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDatatype() {
        return datatype;
    }

    public void setDatatype(Object datatype) {
        this.datatype = datatype;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
