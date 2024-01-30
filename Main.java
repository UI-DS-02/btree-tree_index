import bPlusTree.BPlusTree;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import database.Column;
import database.Table;


public class Main {
    public static void main(String[] args) {
        BPlusTree<Integer, Integer> bTree = new BPlusTree<>();
        bTree.insert(10, 1);
        bTree.insert(20, 2);
        bTree.delete(1);
        bTree.delete(10);
        Scanner sc = new Scanner(System.in);
        System.out.println("number table?");
        int number_table = sc.nextInt();

        for (int j = 0; j < number_table; j++) {
            System.out.println("number of columns?");
            int number_columns = sc.nextInt();
            System.out.println("number_row?");
            int number_row = sc.nextInt();
            for (int i = 0; i < number_columns; i++) {
                System.out.println("name column");
                String name_column = sc.next();
                String data_type = sc.next();
//                Object input = null;
//                input = check_type(data_type, input);
                //---------------------------
                Table<Integer> table = new Table(number_columns, number_row);

                //---------------------------------
                if (data_type.equalsIgnoreCase("String")) {
                    Column<String> column = new Column<>();
                    column.setName(name_column);
                    table.make_new_column(column);
                } else if (data_type.equalsIgnoreCase("double")) {
                    Column<Double> column = new Column<>();
                    column.setName(name_column);
                    table.make_new_column(column);
                } else if (data_type.equalsIgnoreCase("integer")) {
                    Column<Double> column = new Column<>();
                    column.setName(name_column);
                    table.make_new_column(column);
                } else if (data_type.equalsIgnoreCase("time")) {
                    Column<Double> column = new Column<>();
                    column.setName(name_column);
                    table.make_new_column(column);
                }
            }
        }
        //--------------------------------------------------------------------
    }

    static Object check_type(String data_type, Object input) {
        Scanner sc = new Scanner(System.in);
        if (data_type.equalsIgnoreCase("String")) {

            System.out.println("enter string");
            input = sc.nextLine();

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

    //---------------------------------------------------

}
