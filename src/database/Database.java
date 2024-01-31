package database;

import exception.NotFoundException;

import java.time.LocalTime;
import java.util.ArrayList;

public class Database {
    ArrayList<Table> tables = new ArrayList<>();
    static int index = 0;

    public Table creatTable(String name) {
        Table table = new Table(index, name);
        tables.add(index++, table);
        return tables.get(tables.size() - 1);

    }

    public Table searchTable(String tableName) {
        for (Table table : tables) {
            if (table.getName().equals(tableName)) {
                return table;
            }
        }
        return null;
    }

    public void update(String tableName, String name, String newValue, String columnTile) {
        for (Table table : tables) {
            if (table.getName().equals(tableName)) {
                table.update(name, newValue, columnTile);
                return;
            }
            throw new NotFoundException(tableName + " is not valid");
        }
    }

    public void update(String tableName, int id, String newValue, String columnTile) {
        for (Table table : tables) {
            if (table.getName().equals(tableName)) {
                table.update(id, newValue, columnTile);
                return;
            }
            throw new NotFoundException(tableName + " is not valid");
        }
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

}
