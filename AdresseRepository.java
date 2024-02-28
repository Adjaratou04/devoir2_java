package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import entities.Client;
import entities.Adresse;


public class AdresseRepository {
    public void insert(Adresse adresse){
        
      }

      public List<Adresse> selectAll(){
         List<Adresse> adresses=new ArrayList<>();
          try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir2_java" 
                   , "root", "");
             Statement statement = conn.createStatement();
             String sql="SELECT * FROM `adresse` c, client cl a WHERE c.client_id=cl.id_client ;";
             ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {
        

              Client  cl=new Client();
                cl.setId(rs.getInt("id_cl"));
                cl.setNomComplet(rs.getString("nomComplet_cl"));
                cl.setTelephone(rs.getString("telephone_cl"));
                cl.setEmail(rs.getString("email_cl"));
               
            }
            statement.close();
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement de Driver");
       }
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
       return  adresses;
      }
}
