/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

/**
 *
 * @author guton
 */

/*
CLASSE Usuario --> Classe abstrata pai das Classes Participante e Organizador.
                   Representa um usuáiro do aplicativo, o qual pode ser do tipo
                   Organizador ou Participante;
    
   
    ATRIBUTO id: Variável privada do tipo  int a qual armazena o id do usuário;
    
    ATRIBUTO nome: Variável privada do String a qual armazena o nome do usuário;
    
    ATRIBUTO curso: Variável privada do tipo String a qual armazena o curso do
usuário;
    
    ATRIBUTO email: Variável privada do tipo String a qual armazena o email do
usuário;
    
    ATRIBUTO senha: Variável privada do tipo String a qual armazena a senha do
usuário;

    MÉTODO Usuario(): Construtor Padrão;
    
    MÉTODO Usuario(int id): Construtor que incializa apenas o id do Usuarioo;
    
    MÉTODO Participante(String nome, ..., String senha): Construtor que 
incializa os atributos da classe;
   
    MÉTODO getEmail: Retorna o valor do email;
    
    MÉTODO setEmail: Atribui um novo valor a email;
    
    MÉTODO getId: Atribui um novo valor a id;
    
    MÉTODO getNome: Retorna o valor de nome;
    
    MÉTODO getCurso: Retorna o valor de curso;
    
    MÉTODO getSenha: Retorna o valor de senha;
    
    MÉTODO setId: Atribui um novo valor a id;
    
    MÉTODO setNome: Atribui um novo valor a nome;
    
    MÉTODO getCurso: Atribui um novo valor a curso;
    
    MÉTODO setSenha: Atribui um novo valor a senha;
    
    MÉTODO toString: Retorna uma representação do objeto na forma de String;
 
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
    
    @Override
    public String toString(){
        return String.format("%s, %d", this.nome, this.id);
    }
}
