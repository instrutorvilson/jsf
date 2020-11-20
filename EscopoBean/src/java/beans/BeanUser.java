/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ApplicationScoped
@ManagedBean(name = "user")
public class BeanUser {
    private String nome;  
    
    public String teste(){
        return "teste.jsf";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
