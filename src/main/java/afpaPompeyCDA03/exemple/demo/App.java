package afpaPompeyCDA03.exemple.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        Autre.essai();
        ResultSet Resultat=null;
        Connection conn = null;
        String driver ="com.microsoft.sqlserver.jdbc.SQLSERVERDRIVER";        
        String mysqlUser = "sa";
        String mysqlPassword = "root";
    //    String connexionString = "jdbc:sqlserver://localhost:1433/Essai?"; 
        String connexionString = "jdbc:sqlserver://localhost;database=Essai;integratedSecurity=false;user=sa;password=root;"; 
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver" );
      //  conn = DriverManager.getConnection(connexionString, mysqlUser, mysqlPassword);  
        conn = DriverManager.getConnection(connexionString);  
        }
        catch ( ClassNotFoundException e )
        {
            System.out.println("pb class forname");
            
        }
        catch ( Exception e )
        {
            System.out.println("pb connexion");
            System.out.println(e.getMessage());
            e.printStackTrace();
            
        }
        try
       {
                   
           Statement stm = conn.createStatement(); // création d'un objet requête directe 

             // création d'une variable qui référencera l'ensemble des résultats 

           Resultat = stm.executeQuery("SELECT *  FROM tableEssai"); 
           while (Resultat.next())
            {
                System.out.println(Resultat.getString("nom"));
            }
    }   catch ( Exception e )
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
            
        }
    }
}
