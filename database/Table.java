package database;

import bPlusTree.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Table<T> {
    private int id;
    static int index = 0;
    private ArrayList<Owner> owners;
    private ArrayList<Column> columns;
    private BPlusTree<Integer, List<Owner>> table;

    public ArrayList<Owner> getOwners() {
        return owners;
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

    public Table(int id) {
        columns = new ArrayList<>();
        owners = new ArrayList<>();
        this.id = id;
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

    public Owner make_new_row() {
        owners.add(new Owner(index++));
        return owners.get(owners.size() - 1);
    }

    public void creatIndex(int columnNumber) {
        boolean checkUniqId = false;
        for (int i = 0; i < columnNumber; i++) {
            if (columns.get(i).name.equals("id")) {
                checkUniqId = true;
            }
        }
        if (!checkUniqId) creatOriginalId();
        else {
            List<Owner> list = new ArrayList<>();
            for (Owner owner : owners) {
                for (Column column : owner.getColumns()) {
                    if (column.datatype.equals("id")) {
                        list.add(owner);
                        table.insert(Integer.parseInt(column.value.toString()), list);
                    }
                }
            }
        }
    }

    void creatOriginalId() {
        List<Owner> list = new ArrayList<>();
        for (Owner owner : owners) {
            list.add(owner);
            table.insert(owner.getId(), list);
        }
    }
}
