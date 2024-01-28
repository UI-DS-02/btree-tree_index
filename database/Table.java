package database;

import bPlusTree.*;

public class Table<T> {
    private Column<T>[] columns;
    private BPlusTree<Integer,Table> btreeIndex = new BPlusTree();

    public Table(int number) {
        this.columns = new Column[number];
    }

    public Column<T>[] getColumns() {
        return columns;
    }

    public void setColumns(Column<T>[] columns) {
        this.columns = columns;
    }
}
