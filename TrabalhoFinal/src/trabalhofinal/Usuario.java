/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

/**
 *
 * @author guton
 */
abstract public class Usuario {
    protected int id;
    protected String nome, curso, email, senha;
    
    Usuario(){}
    
    Usuario(int id){
        this.id = id;
    }
    
    Usuario(int id, String nome, String curso, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String toString(){
        return String.format("%s, %d", this.nome, this.id);
    }
}
