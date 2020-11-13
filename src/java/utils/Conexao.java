/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author User
 */
public class Conexao {
     public static Connection conectar(){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/aulasjsf";
        String user = "postgres";
        String password = "postgres";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro de conexão");
        }
        return con;        
    }
     
     public static Connection conectar(String url, String user, String password){
        Connection con = null;        
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Erro de conexão");
        }
        return con;        
    }
     
    public static void desconectar(Connection con){
         try {
             con.close();
         } catch (SQLException ex) {
             System.out.println("Erro ao fechar a conexão");
         }
    }
}
