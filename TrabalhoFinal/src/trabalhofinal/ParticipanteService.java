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
public class ParticipanteService {
  ConnectDB connect = new ConnectDB();

  public void createParticipante(Participante participante) {
    this.connect.createParticipante(participante);
  }   

  public void findOneParticipante(int id) {
    this.connect.findParticipante(id);
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
}
