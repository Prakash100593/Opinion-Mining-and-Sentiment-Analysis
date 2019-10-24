/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.featureextraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author seabirds
 */
public class DBConnection 
{
    Statement stt;
    Connection con;
   public static Connection DBConnection()
    {
        try
        {
               Class.forName("com.mysql.jdbc.Driver");
               String url="jdbc:mysql://127.0.0.1:3306/opinion";
               Connection con=DriverManager.getConnection(url,"root","");
               //stt=con.createStatement();
               return con;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
        
    }
}
