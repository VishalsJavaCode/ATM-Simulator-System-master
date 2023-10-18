package ASimulatorSystem;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bms","bms");    
            s =c.createStatement(); 
            System.out.println("Connected To Oracle Server");
          
            
        }catch(Exception e){ 
           // System.out.println(e);
            System.out.println("Opps,Error");
        }  
    }  
    public static void main(String[] args) {
        
    }
}  