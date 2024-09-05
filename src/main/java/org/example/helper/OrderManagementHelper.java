package org.example.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderManagementHelper {

    private static OrderManagementHelper INSTANCE = null;
    private OrderManagementHelper() {

    }

    public static OrderManagementHelper getInstance() {
        if(INSTANCE == null) {
            synchronized (OrderManagementHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OrderManagementHelper();
                }
            }
        }
        return INSTANCE;
    }

    public LocalDate toLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }

}
