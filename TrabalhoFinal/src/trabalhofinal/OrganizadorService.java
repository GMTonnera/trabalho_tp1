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
}
