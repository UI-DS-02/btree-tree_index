package database;

import bPlusTree.*;
import exception.InvalidInputException;
import exception.NotFoundException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Table<T> {
    private int id;
    static int index = 0;
    private ArrayList<Owner> owners;
    private ArrayList<Column> columns;
    private BPlusTree<Integer, List<Owner>> table;
    private BPlusTree<Integer, List<Owner>> secondIndex;
    private String name;

    public Owner[] getOwners() {
        return (Owner[]) owners.toArray();
    }

    public void setOwners(ArrayList<Owner> owners) {
        this.owners = owners;
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<Column> columns) {
        this.columns = columns;
    }

    public Table(int id, String name) {
        table = new BPlusTree<>();
        columns = new ArrayList<>();
        owners = new ArrayList<>();
        this.id = id;
    }

    public void update(String name, String newValue, String columnTile) {
        //secondIndex.search(name);
    }

    public void update(int id, String newValue, String columnTile) {
        try {
            for (Owner owner : table.search(id)) {
                for (Column column : owner.getColumns()) {
                    if (column.getName().equals(columnTile)){
                        column.setValue(newValue);
                        return;
                    }
                    throw  new NotFoundException(" "+ columnTile +" is not valid");
                }
            }
        } catch (RuntimeException runtimeException) {
            throw new InvalidInputException();
        }
    }

    public String selectAll() {
        return table.toString();
    }

    public String search(Owner owner) {
        return table.search(owner.getId()).toString();
    }

    public Column make_new_column(Object value, String name, String type) {
        if (type.equalsIgnoreCase("String")) {
            assert table != null;
            columns.add(new Column<String>(name, type, (String) value));
        } else if (type.equalsIgnoreCase("double")) {
            assert table != null;
            columns.add(new Column<Double>(name, type, (Double) value));
        } else if (type.equalsIgnoreCase("integer")) {
            assert table != null;
            columns.add(new Column<Integer>(name, type, (Integer) value));
        } else if (type.equalsIgnoreCase("time")) {
            assert table != null;
            columns.add(new Column<LocalTime>(name, type, (LocalTime) value));
        }
        return columns.get(columns.size() - 1);
    }

    public Owner make_new_row(String name) {
        owners.add(new Owner(index++, name));
        return owners.get(owners.size() - 1);
    }

    public void columnIndex() {
        BPlusTree<Integer, List<Owner>> bPlusTree = new BPlusTree();
        for (Owner owner : owners)
            bPlusTree.insert(owner.getColumns()[0].hashCode(), owners);
        secondIndex = bPlusTree;

    }

    public void creatIndex() {
        List<Owner> list = new ArrayList<>();
        for (Owner owner : owners) {
            list.add(owner);
            table.insert(owner.getId(), list);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Table.index = index;
    }

    public BPlusTree<Integer, List<Owner>> getTable() {
        return table;
    }

    public void setTable(BPlusTree<Integer, List<Owner>> table) {
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}