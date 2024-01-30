package database;

import java.util.ArrayList;

public class Owner<T> {
    private ArrayList<Column> columns;
    private int id;
    //T key;

    public void addColumn(Column column){columns.add(column);}
    public ArrayList<Column> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<Column> columns) {
        this.columns = columns;
    }
}
