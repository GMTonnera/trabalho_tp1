/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.util.ArrayList;

/**
 *
 * @author Vini
 */
/*
CLASSE OrganizadorService --> Classe responsável por fornecer servições para 
                              alterar/criar objetos da Classe Organizador no 
                              banco de dados.
    

    ATRIBUTO connect: Variável do tipo ConnectDB responsável por realizar a
conexão com o banco de dados;


    MÉTODO createOrganizador: Método responsável por criar um Organizador;
    
    MÉTODO findOneOrganizador: Método responsável por achar um Organizador no 
banco de dados dado um id;

    MÉTODO findAllOrganizador(): Método responsável por achar todos os objetos
Organizador presentes no banco de dados;    

    MÉTODO deleteOrganizador: Deleta um organizador do banco de dados dado um 
id;

    MÉTODO updateOrganizador: Altera um organizador do banco de dados dado um 
id;

*/
public class OrganizadorService {
  ConnectDB connect = new ConnectDB();

  public void createOrganizador(Organizador organizador) {
      
    this.connect.createOrganizador(organizador);
  }   

  public Organizador findOneOrganizador(int id) {
    return this.connect.findOrganizador(id);
  }

  public ArrayList<Organizador> findAllOrganizador() {
    return this.connect.findAllOrganizador();
  }

  public void deleteOrganizador(int id) {
    this.connect.deleteOrganizador(id);
  }
  
  public void updateOrganizador(Organizador o) {
    this.connect.updateOrganizador(o);
  }
}
