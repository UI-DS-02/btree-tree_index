package database;

import java.util.ArrayList;

public class Owner<T> {
    private ArrayList<Column> columns;
    private int id;
    Owner(int id)
    { this.id=id;
    }
    public void addColumn(Column column){columns.add(column);}
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

}
