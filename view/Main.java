package view;

import bPlusTree.BPlusTree;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

//        for (int i = 0; i < number_table; i++) {
//            adding_owner(number_row, tables.get(i));
//        }
            }
            order = sc.nextInt();
        }
    }

    static void delete() {

    }

    static void update() {

    }

    static void select() {

    }

    static void insert() {
        System.out.println("Please enter the number of tables:");
        int number_table = sc.nextInt();
        int number_row = 0;
        int number_columns = 0;
        for (int j = 0; j < number_table; j++) {
            System.out.println("Enter the name of the table:");
            String name = sc.next();
            System.out.println("enter the number of columns:");
            number_columns = sc.nextInt();
            System.out.println("Enter the number of rows:");
            number_row = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < number_table; i++) {
                Table table = database.creatTable(name);
                for (int l = 0; l < number_row; l++) {
                    Owner owner = table.make_new_row();
                    System.out.println("Enter the data of this row:");
                    for (int k = 0; k < number_columns; k++) {
                        System.out.println("Enter the column title for this data:");
                        String name_column = sc.next();
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