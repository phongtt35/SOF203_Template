/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author phongtt
 */
public final class DbConnector {
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "reallyStrongPwd#123";
    private static final String SERVER = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "";
    private static final boolean USING_SSL = false;
    
    private static String CONNECT_STRING;
    
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(SERVER).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";")
                    ;
            if (USING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (ClassNotFoundException ex) {
            System.out.println("Không tìm thấy SQLServer Driver");
            System.out.println("Kiểm tra thư viện đã được import vào project hay chưa?");
        }
    }
    
    public synchronized static Connection getConnection() throws Exception {
        return DriverManager.getConnection(CONNECT_STRING);
    }
    
    public static void main(String[] args) throws Exception {
        String version = DbConnector.getConnection().getMetaData()
                .getDatabaseProductVersion();
        System.out.println(version);
    }
}
