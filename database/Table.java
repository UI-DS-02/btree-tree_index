package database;

import bPlusTree.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Table<T> {
    private int id;
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
        this.id=id;
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
        owners.add(new Owner());
        return owners.get(owners.size()-1);
    }

    Object check_type(String data_type) {
        // checking if input type is true or not
        Scanner sc = new Scanner(System.in);
        Object input = null;
        if (data_type.equalsIgnoreCase("String")) {

            input = sc.next();

        } else if (data_type.equalsIgnoreCase("double")) {
            input = (Double) sc.nextDouble();

        } else if (data_type.equalsIgnoreCase("integer")) {
            input = sc.nextInt();
        } else if (data_type.equalsIgnoreCase("history")) {

        } else if (data_type.equalsIgnoreCase("time")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm.ss.nnn");
            String time = sc.next();
            input = LocalTime.parse(time, formatter);
        }
        return input;
    }

//    void adding_owner(int number_row, Table<Object> table) {
//        for (int i = 0; i < number_row; i++) {
//            Owner<Object> owner = new Owner<>();
//            for (int j = 0; j < table.getColumns().size(); j++) {
//                System.out.println("enter " + table.getColumns().get(j).getName());
//                columns.get(j).setValue(check_type((String) table.getColumns().get(j).getDatatype()));
//            }
//            owner.setColumns(table.getColumns());
//            table.getOwners().add(owner);
//        }
//    }
}
