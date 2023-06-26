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
CLASSE TorneioService --> Classe responsável por fornecer servições para 
                          alterar/criar objetos da Classe Torneio no banco de
                          dados.
    

    ATRIBUTO connect: Variável do tipo ConnectDB responsável por realizar a
conexão com o banco de dados;


    MÉTODO createTorneio: Método responsável por criar um Torneio;
    
    MÉTODO findOneTorneio: Método responsável por achar um Torneio no banco de
dados dado um id;

    MÉTODO findAllTorneio: Método responsável por achar todos os objetos Torneio
presentes no banco de dados;    

    MÉTODO deleteTorneio: Deleta um Torneio do banco de dados dado um id;

    MÉTODO findAllTorneioParticipante: Acha todos os Participantes de um torneio
do banco de dados dado um id;

    MÉTODO findAllTorneioPartida: Acha todos as Partidas de um torneio do banco
de dados dado um id;
    
    MÉTODO updateTorneio: Altera as informações de um Torneio do banco de dados dado
um id;

*/
public class TorneioService {
  ConnectDB db = new ConnectDB();

  TorneioService() {}

  public void createTorneio(Torneio torneio, int organizador_id) {        
    this.db.insertTorneio(torneio);
      
    this.db.criarTorneio(organizador_id, torneio.getId());
  }   

  public Torneio findOneTorneio(int id) {
    return this.db.findTorneio(id);
  }

  public ArrayList<Torneio> findAllTorneio() {
    return this.db.findAllTorneio();
  }

  public void deleteTorneio(int id) {
    this.db.deleteTorneio(id);
  }

  public ArrayList<Participante> findAllTorneioParticipante(int torneio_id) {
    return this.db.findAllTorneioParticipante(torneio_id);
  }
  
  public ArrayList<Partida> findAllTorneioPartida(int torneio_id) {
    return this.db.findAllTorneioPartidas(torneio_id);
  }

  public void updateTorneio(Torneio t) {
    this.db.updateTorneio(t);
  }
}