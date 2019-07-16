import model.Order;
import model.Table;
import controller.OrderController;
import controller.TableController;

import java.util.ArrayList;
import java.util.Scanner;

import static command.CafeCommand.*;

public class Cafe {
    static final Scanner SCANNER = new Scanner(System.in);
    static final OrderController ORDER_CONTROLLER = new OrderController();
    static final TableController TABLE_CONTROLLER = new TableController();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            printCafeCommands();
            int command;
            try {
                command = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case -1:
                    System.out.println("Please input a number");
                    break;
                case EXIT:
                    isRun = false;
                    break;
                case Add_TABLE:
                    addTable();
                    break;
                case ADD_ORDER:
                    addOrder();
                    break;
                case PRINT_TABLE_ORDER:
                    TABLE_CONTROLLER.printTables();
                    break;
                case PRINT_ORDER:
                    ORDER_CONTROLLER.printOrders();
                    break;
                default:
                    System.out.println("Please input a valid Command");
            }
        }
    }


    private static void addTable() {
        System.out.println("Please input name");
        String tableStr = SCANNER.nextLine();
        String[] tableData = tableStr.split(",");
        try {
            System.out.println("please input orders name by table ,");
            ORDER_CONTROLLER.printOrders();
            String ordersStr = SCANNER.nextLine();
            String[] ordersName = ordersStr.split(",");
            ArrayList<Order> orders = new ArrayList<Order>();
            for (String s : ordersName) {
                Order orderByTable = ORDER_CONTROLLER.getOrderByTable(s);
                orders.add(orderByTable);

            }
            Table table = new Table();
            table.setName(tableData[0]);
            table.setOrder(orders);
            TABLE_CONTROLLER.add(table);
        } catch (Exception e) {
            System.out.println("Invalid data");
            addTable();
        }
    }

    private static void addOrder() {
        System.out.println("Please input name, price");
        String orderStr = SCANNER.nextLine();
        try {
            String[] orderData = orderStr.split(",");
            double cost = Double.parseDouble(orderData[1]);
            Order order = new Order(orderData[0], cost);
            ORDER_CONTROLLER.add(order);
            System.out.println("Order was successfully added");
        } catch (Exception e) {
            System.out.println("Invalid Data");
            addOrder();
        }
    }


    private static void printTableByOrder() {
        System.out.println("Please input table name");
        ORDER_CONTROLLER.printOrders();
        String tableName = SCANNER.nextLine();
        TABLE_CONTROLLER.printBillByOrder(ORDER_CONTROLLER.getOrderByTable(tableName));
    }



    private static void printCafeCommands() {
        System.out.println("Please input " + EXIT + " Ելք");
        System.out.println("Please input " + Add_TABLE + "  սեղան պատվիրել");
        System.out.println("Please input " + ADD_ORDER + " պատվեր ընդունել");
        System.out.println("Please input " + PRINT_TABLE_ORDER + " for PRINT_TABLE");
        System.out.println("Please input " + PRINT_ORDER + " տպել պատվերը");
    }

}
