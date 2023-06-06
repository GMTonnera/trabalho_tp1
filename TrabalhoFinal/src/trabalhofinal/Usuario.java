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
    
    Usuario(int id, String nome, String curso, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
    }
}
