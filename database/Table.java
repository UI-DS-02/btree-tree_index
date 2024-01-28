package database;

import bPlusTree.*;

public class Table<T> {
    private Column[] columns;
    private BPlusTree<Integer,T> table;

    public Table(int number) {
        this.columns = new Column[number];
        this.table=new BPlusTree<Integer,T>();
    }

    public Column[] getColumns() {
        return columns;
    }

    public void setColumns(Column[] columns) {
        this.columns = columns;
    }
}
