package org.example.utils;

import java.sql.*;
public class connexionBd {
 

        public static Connection connexion;
        public static Statement inst;

     

        private connexionBd() throws SQLException{
            try{
            Class.forName("oracle.jdbc.driver.OracleDriver");} catch (ClassNotFoundException e) {

                e.printStackTrace();
            }
            connexion= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "pfa2", "pfa2");
            inst=connexion.createStatement();
        }

        public static Statement getInstance(){
            if (inst == null)
                try {
                    new connexionBd();
                }catch(Exception e){
                    System.out.println("--"+e.getMessage());
                }
            return inst;
        }
    }

