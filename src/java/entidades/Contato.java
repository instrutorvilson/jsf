/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conexao;

/**
 *
 * @author User
 */
public class Contato {
   private int id;  
   private String nome;
   private String email;
   private String fone;
   
   public Contato(){
       //
   }

    public Contato(String nome, String email, String fone) {       
        this.nome = nome;
        this.email = email;
        this.fone = fone;        
    }
   
   
   
   public boolean salvar(){
       Connection con = Conexao.conectar();
       String sql = "insert into contato(nome, email, fone)"
               + " values(?,?,?)";
       try {
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setString(1, this.nome);
           stm.setString(2, this.email);
           stm.setString(3, this.fone);
           stm.execute();
       } catch (SQLException ex) {
           return  false;
       }      
       return true;
   }
   
   public List<Contato> consultar(){
      List<Contato> lista = new ArrayList<>();
      Connection con = Conexao.conectar();
       try {
           PreparedStatement stm = con.prepareStatement("select * from contato");
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
               Contato ct = new Contato();
               ct.id = rs.getInt("id");
               ct.nome = rs.getString("nome");
               ct.email = rs.getString("email");
               ct.fone = rs.getString("fone");
               lista.add(ct);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Contato.class.getName()).log(Level.SEVERE, null, ex);
       }      
      return lista;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
