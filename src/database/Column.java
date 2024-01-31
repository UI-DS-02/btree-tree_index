package database;

public class Column<T> {

    String name;
    String datatype;
    T value;

    public Column(String name, String datatype, T value) {
        this.name = name;
        this.datatype = datatype;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
