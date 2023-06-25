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
public class LigaService {
  ConnectDB connect = new ConnectDB();

  public void createLigaTable(ArrayList<ArrayList<Integer>> tabela, int torneio_id) {
    for(ArrayList<Integer> linha : tabela) {
      this.connect.criarLiga(torneio_id, linha);
    }
  }

  public ArrayList<ArrayList<Integer>> findLigaTable(int torneio_id) {
    return this.connect.findTabelaLiga(torneio_id);
  }

  public void updateLinhaTable(int torneio_id, ArrayList<Integer> line) {
    this.connect.updateRowLiga(torneio_id, line);
  }

  public void deleteLinha(int torneio_id, int participante_id) {
    this.connect.deleteRowLiga(torneio_id, participante_id);
  }

  public void deleteTable(int torneio_id) {
    this.connect.deleteLiga(torneio_id);
  }
}
