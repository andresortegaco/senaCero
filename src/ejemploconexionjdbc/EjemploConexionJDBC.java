/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploconexionjdbc;

/**
 *
 * @author Andres Ortega Co
 */
//Se importa la libreria de java sql y s
import java.sql.*;

public class EjemploConexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String usuario = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/tiendamutual";
            Connection conexion;
            Statement statement;
            ResultSet rs;
            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // TODO code application logic here
            } catch (ClassNotFoundException ex) {
                System.getLogger(EjemploConexionJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
            System.out.println("Aqui insertamos un nuevo cargo");
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO CARGOS(nombre_cargo,salario) VALUES('Vigilante','1700000')");
            rs = statement.executeQuery ("SELECT * FROM CARGOS");
            rs.next();
            do{
                System.out.println(rs.getInt("id_cargo")+ " : " + rs.getString("nombre_cargo")+" : " + rs.getString("salario"));
            }while (rs.next());
            
            System.out.println("Aqui borramos el cargo insertado previamente");
            
            statement.executeUpdate("DELETE t1\n" +
            "FROM \n" +
            "    cargos t1\n" +
            "INNER JOIN \n" +
            "    cargos t2 \n" +
            "WHERE \n" +
            "    t1.nombre_cargo = t2.nombre_cargo  " +
            "    AND t1.id_cargo > t2.id_cargo;");
            rs = statement.executeQuery ("SELECT * FROM CARGOS");
            rs.next();
            do{
                System.out.println(rs.getInt("id_cargo")+ " : " + rs.getString("nombre_cargo")+" : " + rs.getString("salario"));
            }while (rs.next());
            
            
        } catch (SQLException ex) {
            System.getLogger(EjemploConexionJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
    }
    
}
