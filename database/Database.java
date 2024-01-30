package database;

import java.time.LocalTime;
import java.util.ArrayList;

public class Database {
    ArrayList<Table> tables = new ArrayList<>();
    static int index=0;

    public Table creatTable() {
        Table table=new Table(index);
        tables.add(index++,table);
        return tables.get(tables.size()-1);

    }

}
