package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;
import entities.Client;

public class ClientRepository {
    
    
    //select
    public  List<Client> selectAll(){
         List<Client> clients= new ArrayList<>();
       try {
          
          Class.forName("com.mysql.cj.jdbc.Driver");
        
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir2_java" 
                    , "root", "");
       
           Statement statement = conn.createStatement();
    
        
           ResultSet rs=   statement.executeQuery("select * from Client");
             while (rs.next()) {
           
                 Client cl=new Client();
                 cl.setId(rs.getInt("id_cl"));
                 cl.setNomComplet(rs.getString("nomComplet_cl"));
                 cl.setTelephone(rs.getString("telephone_cl"));
                 cl.setEmail(rs.getString("email_cl"));
                 clients.add(cl);
             }
             rs.close();
             conn.close();
        } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement de Driver");
        }
       catch (SQLException e) {
        System.out.println("Erreur de Connexion a la BD");
      }
        return  clients;
    }
    public  Client selectByTelephone(String telephone){
        Client cl=null;
     try {
       
        Class.forName("com.mysql.cj.jdbc.Driver");
      
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir2_java" 
                  , "root", "");
      
         Statement statement = conn.createStatement();
         ResultSet rs=   statement.executeQuery("select * from Client where telephone_cl like '"+telephone+"'");
           if (rs.next()) {
    
            cl=new Client();
            cl.setId(rs.getInt("id_cl"));
            cl.setNomComplet(rs.getString("nomComplet_cl"));
            cl.setTelephone(rs.getString("telephone_cl"));
            cl.setEmail(rs.getString("email_cl"));
           }
           rs.close();
           conn.close();
      } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement de Driver");
      }
     catch (SQLException e) {
        System.out.println("Erreur de Connexion a la BD");
    }
      return  cl;
     }
   
    public  void insert(Client Client){
     try {
        
          Class.forName("com.mysql.cj.jdbc.Driver");
    
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir2_java" 
                    , "root", "");
          
             Statement statement = conn.createStatement();
            
             int nbreLigne=statement.executeUpdate("INSERT INTO Client (telephone_cl, nomComplet_cl, email_cl) VALUES ('"+Client.getTelephone()+"', '"+Client.getNomComplet()+"', '"+Client.getEmail()+"')");
             conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        }
       catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
      }
     }
}
