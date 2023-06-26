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
CLASSE ParticipanteService --> Classe responsável por fornecer servições para 
                               alterar/criar objetos da Classe Participante no
                               banco de dados.
    

    ATRIBUTO connect: Variável do tipo ConnectDB responsável por realizar a
conexão com o banco de dados;


    MÉTODO createParticipante: Método responsável por criar um Participante;
    
    MÉTODO findOneParticipante: Método responsável por achar um Participante no 
banco de dados dado um id;

    MÉTODO findAllParticipante(): Método responsável por achar todos os objetos
Participante presentes no banco de dados;    

    MÉTODO deleteParticipante: Deleta um Participante do banco de dados dado um 
id;

    MÉTODO inscreverParticipante: Inscreve um determinado Participante em um
Torneio do banco de dados;

    MÉTODO updateParticipante: Altera um Participante do banco de dados dado um 
id;

*/
public class ParticipanteService {
  ConnectDB connect = new ConnectDB();

  public void createParticipante(Participante participante) {
    this.connect.createParticipante(participante);
  }   

  public Participante findOneParticipante(int id) {
    return this.connect.findParticipante(id);
  }

  public ArrayList<Participante> findAllParticipante() {
    return this.connect.findAllParticipante();
  }

  public void deleteParticipante(int id) {
    this.connect.deleteParticipante(id);
  }
  
  public void inscreverParticipante(int id_torneio, int id_participante){
      this.connect.inscreverParticipante(id_torneio, id_participante);
  }
  
  public void updateParticipante(Participante p) {
    this.connect.updateParticipante(p);
  }
}
