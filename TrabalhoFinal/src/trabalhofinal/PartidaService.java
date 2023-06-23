/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

/**
 *
 * @author Vini
 */
public class PartidaService {
  ConnectDB db = new ConnectDB();

  public void createPartida(Partida partida, int torneio_id) {
    this.db.createPartida(partida, torneio_id);
  }

  public Partida findOnePartida(int id) {
    return this.db.findPartida(id);
  }

  public void addPatidaResult(int id_partida, int p1pontos, int p2pontos, boolean capote) {
    this.db.updatePartidaResultado(id_partida, p1pontos, p2pontos, capote);
  }

  public void deletePartida(int id) {
    this.db.deletePartida(id);
  }
}
