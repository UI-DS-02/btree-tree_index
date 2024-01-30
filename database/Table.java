package database;

import bPlusTree.*;

import java.util.ArrayList;

public class Table<T> {
    private ArrayList<Owner> owners;
    private ArrayList<Column>columns;
    private BPlusTree<Integer, T> table;

    public Table(int number_column, int number_row) {
       columns=new ArrayList<>(number_column);
       owners=new ArrayList<>(number_row);
    }
    public void make_new_column(Column column){
        columns.add(column);
    }
    public void make_new_row(int number_row){

    }

}
