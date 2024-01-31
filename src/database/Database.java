package database;

import java.time.LocalTime;
import java.util.ArrayList;

public class Database {
    ArrayList<Table> tables = new ArrayList<>();
    static int index=0;

    public Table creatTable(String name) {
        Table table=new Table(index,name);
        tables.add(index++,table);
        return tables.get(tables.size()-1);

    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

}
