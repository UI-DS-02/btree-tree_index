package view;

import bPlusTree.BPlusTree;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import database.Column;
import database.Database;
import database.Owner;
import database.Table;

public class Main {
    static Scanner sc = new Scanner(System.in);
    // static   ArrayList<Table<Object>>tables=new ArrayList<>();
    static Database database = new Database();

    public static void main(String[] args) {
        System.out.println("Welcome To The TREE INDEX Database\n\n1.INSERT\n2.DELETE\n3.UPDATE\n4.SELECT\n5.EXIT");
        int order = sc.nextInt();
        while (order != 5) {
            switch (order) {
                case 1 -> insert();
                case 2 -> delete();
                case 3 -> update();
                case 4 -> select();
            }
            order = sc.nextInt();
        }
    }

    static void delete() {

    }

    static void update() {
        try {
            System.out.println("Enter table name you want to update:");
            String tableName = sc.nextLine();
            System.out.println("Do you want to find by id?");
            String answer = sc.nextLine().toLowerCase(Locale.ROOT);
            System.out.println("Enter column title:");
            String columnTitle = sc.nextLine();
            System.out.println("Enter the updated value:");
            String updatedValue = sc.nextLine();
            if (answer.equals("yes")) {
                System.out.println("Enter row ID:");
                int rowId = sc.nextInt();
                database.update(tableName, rowId, updatedValue, columnTitle);

            } else {
                System.out.println("Enter row Name:");
                String rowName = sc.nextLine();
                database.update(tableName, rowName, updatedValue, columnTitle);
            }
            System.out.println("Successfully updated");
        }catch (RuntimeException runtimeException)
        {
            System.out.println(runtimeException.getMessage());
        }
    }

    static void select() {
        System.out.println("Enter table name:");
        String tableName = sc.nextLine();
        System.out.println("Enter row name:");
        String rowName = sc.nextLine();
        for (Table table : database.getTables()) {
            if (table.getName().equals(tableName)) {
                if (rowName.equals("*")) {
                    System.out.println(table.selectAll());
                } else {
                    for (Owner owner : table.getOwners()) {
                        if (owner.getName().equals(rowName)) {
                            System.out.println("Enter column name:");
                            String columnName = sc.nextLine();
                            if (columnName.equals("*")) {
                                System.out.println(table.search(owner));
                            } else
                                for (Column column : owner.getColumns()) {
                                    System.out.println(column.toString());
                                }
                        }
                    }
                }
            }
        }
    }

    static void insert() {
        System.out.println("Please enter the number of tables:");
        int number_table = sc.nextInt();
        int number_row = 0;
        int number_columns = 0;
        for (int j = 0; j < number_table; j++) {
            System.out.println("enter the number of columns:");
            number_columns = sc.nextInt();
            System.out.println("Enter the number of rows:");
            number_row = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < number_table; i++) {
                System.out.println("Enter table name:");
                String name = sc.nextLine();
                Table table = database.creatTable(name);
                for (int l = 0; l < number_row; l++) {
                    System.out.println("Enter row name:");
                    name = sc.nextLine();
                    Owner owner = table.make_new_row(name);
                    System.out.println("Enter the data of this row:");
                    for (int k = 0; k < number_columns; k++) {
                        System.out.println("Enter the column title for this data:");
                        String name_column = sc.next().toLowerCase(Locale.ROOT);
                        System.out.println("Enter the data type of the column:");
                        String data_type = sc.next();
                        //------------------------------------------------------------
                        Column column = table.make_new_column(null, name_column, data_type);
                        System.out.println("Enter the value:");
                        Object value = check_type(data_type);
                        column.setValue(value);
                        //------------------------------------------------------------
                        owner.addColumn(column);
                    }
                }
                table.creatIndex();
            }
        }
    }

    static Object check_type(String data_type) {
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
}