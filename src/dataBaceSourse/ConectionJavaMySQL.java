package dataBaceSourse;
import java.sql.*;

public class ConectionJavaMySQL {
    private static Connection CONN;
    private static String ROUTE;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://";

    public ConectionJavaMySQL() {
        CONN = null;
    }
    
    public Connection getConnection(final String ip, final String port, final String dataBase, final String user, final String password) {
        ROUTE = URL + ip + ":" + port + "/" + dataBase + "?autoReconnect=true&useSSL=false";
        try{
            Class.forName(DRIVER);
            System.out.println("/n/n");
            System.err.println("========================================");
            System.out.println("Intentando conectar a la base de datos..");
            CONN = DriverManager.getConnection(ROUTE, user, password);
            
            if (CONN != null){
                System.out.println(" Conexion establecida..");
                System.err.println("========================================");
            }
        } catch (ClassNotFoundException | SQLException e){
            System.err.println(" Error al conectar..");
            System.err.println("Error: " + e);
            System.err.println("========================================");
        }
        return CONN;
    }
    
    public void disconnect(){
        try {
            CONN.close();
            System.out.println("/n/n");
            System.err.println("========================================");
            System.err.println("Conexion de la base de datos terminada..");
            System.err.println("========================================");
        } catch (SQLException e) {
            System.out.println("/n/n");
            System.err.println("==========================================");
            System.err.println("Error al desconectar de la base de datos..");
            System.err.println("Error: " + e);
            System.err.println("==========================================");
        }
    }
}
