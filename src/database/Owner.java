package database;

import java.util.ArrayList;

public class Owner<T> {
    private ArrayList<Column> columns;
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Owner(int id, String name) {
        columns = new ArrayList<>();
        this.id = -1;
        buildId(id);
        this.name = name;
    }

    public void buildId(int id) {
        for (Column column : columns) {
            if (column.getName().equals("id") && column.getDatatype().equals("integer"))
                this.id = (Integer) column.getValue();
        }
        if (this.id == -1) this.id = id;

    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public Column[] getColumns() {
        return (Column[]) columns.toArray();
    }

    public void setColumns(ArrayList<Column> columns) {
        this.columns = columns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String selectAll() {
        return toString();
    }

    @Override
    public String toString() {
        return "Owner{" + "columns=" + columns + ", id=" + id + ", name='" + name + '\'' + '}';
    }
}
