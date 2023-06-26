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
