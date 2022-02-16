package com.mad;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class StorageService {
    private static StorageService instance = null;
    private static String connString;
    private String dbName = "storage";

    private StorageService() {
        try {
        Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            e.printStackTrace();
        }
        StorageService.setConnString("jdbc:sqlite:" + dbName + ".db");
        System.out.println(StorageService.getConnString());
        Connection test = null;
        try {
            test = DriverManager.getConnection(connString);
            if (test != null) {
                System.out.println("Storage service initialized.");
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();;
        }
    }

    public static StorageService getService() {
        if (instance == null) {
            System.out.println("here");
            instance = new StorageService();
            System.out.println(instance);
        }
        return instance;
    }

    public static String getConnString() {
        return connString;
    }

    public static void setConnString(String connString) {
        StorageService.connString = connString;
    }

    public <T extends Serializable> void saveObject(T obj) {
        String objName;
        if (obj instanceof Account) {
            objName = ((Account)obj).getUsername();
        }
    }
}
