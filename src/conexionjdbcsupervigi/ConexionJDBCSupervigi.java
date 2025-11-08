/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionjdbcsupervigi;

/**
 *
 * @author Andres Ortega Co
 */
//Se importa la libreria de java sql
import java.sql.*;

public class ConexionJDBCSupervigi {

 public static void main(String[] args) {
        try {
            String usuario = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/supervigi";
            Connection conexion;
            Statement statement;
            ResultSet rs;
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // TODO code application logic here
            } catch (ClassNotFoundException ex) {
                System.getLogger(ConexionJDBCSupervigi.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
            System.out.println("Aqui insertamos un nuevo usuario");
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO USER(name,last_name,email,phone,password) VALUES('Joaquin','Ardila','joaco@sv.co','3001234567','3691215')");
            rs = statement.executeQuery ("SELECT * FROM USER");
            rs.next();
            do{
                System.out.println(rs.getInt("id_user")+ " : " + rs.getString("name")+" :  " + rs.getString("last_name")+" :" + rs.getString("phone"));
            }while (rs.next());
            
            System.out.println("Aqui borramos el user insertado previamente");
            
            statement.executeUpdate("DELETE t1\n" +
            "FROM \n" +
            "    user t1\n" +
            "INNER JOIN \n" +
            "    user t2 \n" +
            "WHERE \n" +
            "    t1.name = t2.nombre_cargo  " +
            "    AND t1.id_cargo > t2.id_cargo;");
            rs = statement.executeQuery ("SELECT * FROM CARGOS");
            rs.next();
            do{
                System.out.println(rs.getInt("id_user")+ " : " + rs.getString("name")+" :  " + rs.getString("last_name")+" :" + rs.getString("phone"));
            }while (rs.next());
            
            
        } catch (SQLException ex) {
            System.getLogger(ConexionJDBCSupervigi.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
    }
}
    

