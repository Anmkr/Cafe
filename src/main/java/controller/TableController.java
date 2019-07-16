package controller;


import excaption.TableNotFoundException;
import model.Order;
import model.Table;


import java.util.HashMap;

import java.util.Map;

public class TableController {
    private Map<String, Table> tables = new HashMap<String, Table>();

    public void add(Table table) {
        tables.put(table.getName(), table);


    }

    public void printTables() {
        for (Table table : tables.values()) {
            System.out.println(tables);
        }
    }

    public void printBillByOrder(Order order) {
        for (Table table : tables.values()) {
            if (table.getOrder().contains(order)) {
                System.out.println(order);
                break;
            }
        }
    }

    public Table getTableByName(String name) throws TableNotFoundException {
        Table table = tables.get(name);
        if (table == null) {
            throw new TableNotFoundException();
        }
        return table;
    }

    public void printTableByOrder(Order order) {
        for (Table table : tables.values()) {
            if (table.getOrder().contains(order)) {
                System.out.println(table);
                break;
            }
        }
    }
}