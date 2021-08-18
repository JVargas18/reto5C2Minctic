package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conector {

    private Connection connect;

    public Conector(String url) {
        super();
        connectDB(url);
    }

    public ResultSet getReq1DB() { 
        String sql = "SELECT SUM(cantidad) AS total, ID_Proyecto AS idProyecto, Pagado, Proveedor " +
                     "FROM Compra WHERE Pagado = 'No' " +  
                     "GROUP BY ID_Proyecto " +
                     "HAVING (total) > 50";
        return executeQuery(sql); 
    } 
    
    public ResultSet getReq2DB() { 
        String sql = "SELECT Proyecto.Fecha_Inicio AS fechaInicio, Tipo.Financiable, Tipo.Estrato, " +
                     "Proyecto.Porcentaje_Cuota_Inicial * 100 AS porcetaje " +
                     "FROM Tipo, Proyecto " +
                     "WHERE Proyecto.ID_Tipo = Tipo.ID_Tipo " +
                     "AND Proyecto.Porcentaje_Cuota_Inicial > 0.2 " +
                     "AND Proyecto.Fecha_Inicio > '2016-12-31' " +
                     "AND Tipo.Estrato >= 5 " +
                     "AND Tipo.Financiable = 0 " +	 
                     "ORDER BY fechaInicio ASC"; 
        return executeQuery(sql); 
    } 
    
    public ResultSet getReq3DB() { 
        String sql = "SELECT proyecto.ID_Proyecto AS idProyecto, compra.pagado " +
                     ", proyecto.Clasificacion AS clasificacion FROM materialconstruccion, compra, proyecto " +
                     "WHERE materialconstruccion.Importado = 'Si' " +
                     "AND compra.ID_MaterialConstruccion = materialconstruccion.ID_MaterialConstruccion " +
                     "AND proyecto.ID_Proyecto = compra.ID_Proyecto " +
                     "AND compra.Pagado IN ('No', 'Parcialmente') " +
                     "AND proyecto.Clasificacion IN ('Apartamento','Apartaestudio') " +
                     "AND proyecto.Acabados = 'No' " +
                     "GROUP BY proyecto.ID_Proyecto " +
                     "ORDER BY proyecto.ID_Proyecto"; 
        return executeQuery(sql); 
    }

    public Connection connectDB(String url) {
        try { 
            connect = DriverManager.getConnection(url, "root", ""); 
        } catch (Exception e) { 
            System.out.println(e.getMessage()); 
        } 
        return connect; 
    } 
    
    public ResultSet executeQuery(String sql) { 
        ResultSet rs = null; 
        try { 
            Statement stmt = connect.createStatement(); 
            rs = stmt.executeQuery(sql); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        return rs; 
    } 
}

