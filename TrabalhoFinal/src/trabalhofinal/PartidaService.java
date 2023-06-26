/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

/**
 *
 * @author Vini
 */

/*
CLASSE PartidaService --> Classe responsável por fornecer servições para 
                          alterar/criar objetos da Classe Partida no banco de
                          dados.
    

    ATRIBUTO connect: Variável do tipo ConnectDB responsável por realizar a
conexão com o banco de dados;


    MÉTODO createPartida: Método responsável por criar uma Partida;
    
    MÉTODO findOnePartida: Método responsável por achar uma Partida no banco de
dados dado um id;

    MÉTODO addPatidaResult: Método responsável por achar todos os objetos
Partida presentes no banco de dados;    

    MÉTODO deletePartida: Deleta uma Partida do banco de dados dado um id;

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
