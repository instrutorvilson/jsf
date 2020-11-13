/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Contato;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "contato")
public class BeanContato {
   private String nome;
   private String email;
   private String fone;
   private List<Contato> listaContatos;
   
   public void consultar(){
      listaContatos = new Contato().consultar();
   }

   public void salvar(){
       FacesContext context = FacesContext.getCurrentInstance();
       FacesMessage msgView = null; 
       
       Contato contato = new Contato(this.nome, this.email, this.fone);
       if(contato.salvar()){
          msgView = new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Registro salvo com sucesso","");
          context.addMessage(null, msgView);
       }
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

    public List<Contato> getListaContatos() {
        return listaContatos;
    }

    public void setListaContatos(List<Contato> listaContatos) {
        this.listaContatos = listaContatos;
    }

    
   
}
