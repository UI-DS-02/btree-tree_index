package database;

public class Column<T> {

    private String name;
    private String datatype;
    private T value;

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

//    @Override
//    public int compareTo(Column o) {
//        if (Integer.valueOf(name).equals(Integer.valueOf(o.name)))
//            return 0;
//        else if (Integer.parseInt(name)<(Integer.parseInt(o.name)))
//            return -1;
//        else return 1;
//    }

    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                ", datatype='" + datatype + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public int hashCode() {
        int code = 0;
        char[] chars = name.toCharArray();
        for (int codex : chars)
            code += codex;
        return code;
    }
    //return super.hashCode();
}
