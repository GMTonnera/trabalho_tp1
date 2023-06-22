/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhofinal;
import java.time.LocalDate;
import telas.Login;
import java.util.ArrayList;
import trabalhofinal.Organizador;
/**
 *
 * @author guton
 */


public class TrabalhoFinal {

    /**
     * @param args the command line arguments
     */
    public static Usuario login;
    public static ArrayList<Usuario> usuarios = new ArrayList();
    public static int currentUserId = 0;
    public static int currentTornamentId = 0;
    public static ArrayList<Torneio> torneios = new ArrayList();
    public static Torneio currentTorneio;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        TrabalhoFinal.usuarios.add(new Participante(0, "Gustavo", "CiC", "gustavo", "1234"));
        TrabalhoFinal.usuarios.add(new Organizador(1, "Gustavo", "CiC", "gustavo2", "1234"));
        TrabalhoFinal.torneios.add(new MataMata("Mata-mata Teste",
                                                "Torneio do tipo mata-mata de teste",
                                                "Cacomp",
                                                LocalDate.parse("2002-11-13"),
                                                LocalDate.parse("2002-10-13"),
                                                10,
                                                10,
                                                "Sinuquinha",
                                                0,
                                                5,
                                                10, 
                                                1,
                                                (Organizador) TrabalhoFinal.usuarios.get(1)));
        
        TrabalhoFinal.currentUserId = 2;
        TrabalhoFinal.currentTornamentId = 1;
        new Login().setVisible(true);
    }
    
    // Método que cria uma instâcia da classe Participante ou de Organizador e coloca no banco de dados
    public static void createUsuario(String nome, String curso, String email, String senha, int tipo){
        if(tipo == 0){
            // Criar um Participante
            TrabalhoFinal.usuarios.add(new Participante(TrabalhoFinal.currentUserId, nome, curso, email, senha));
        } else{
            // Criar um Organizador
            TrabalhoFinal.usuarios.add(new Organizador(TrabalhoFinal.currentUserId, nome, curso, email, senha));
        }
        
        TrabalhoFinal.currentUserId += 1;
    }
      
    public static boolean checkUsuario(String email, String senha){
        // Verificar se o usuário está no banco de dados
        for(Usuario u : TrabalhoFinal.usuarios){
            if(u.getEmail().equals(email) && u.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
    
    public static void login(String email, String senha){
        // Encontrar o usuário no banco de dados e setar login
        for(Usuario u : TrabalhoFinal.usuarios){
            if(u.getEmail().equals(email) && u.getSenha().equals(senha)){
                TrabalhoFinal.login = u;
                break;
            }
        }
    }
    
    public static void gerarListaTorneios(){
        
    }
    
    public static void criarTorneio(String nome, String descricao, String local, LocalDate dataInicio, LocalDate dataInicioInscricao,int periodoTorneio, int periodoInscricao, 
                                    String regras, int minParticipantes, int maxParticipantes, int numJogosPartida, Organizador organizador, int tipo){
        if(tipo == 0){
            TrabalhoFinal.torneios.add(new MataMata(nome, descricao, local, dataInicio, dataInicioInscricao, periodoTorneio, periodoInscricao, regras, TrabalhoFinal.currentTornamentId, minParticipantes, maxParticipantes, numJogosPartida, organizador));
        } else{
            TrabalhoFinal.torneios.add(new Liga(nome, descricao, local, dataInicio, dataInicioInscricao, periodoTorneio, periodoInscricao, regras, TrabalhoFinal.currentTornamentId, minParticipantes, maxParticipantes, numJogosPartida, organizador));
        }
        TrabalhoFinal.currentTornamentId += 1;
    }
    
    public static void setCurrentTorneio(int i){
        TrabalhoFinal.currentTorneio = TrabalhoFinal.torneios.get(i);
    }
    
    public static void inscricao(){
        TrabalhoFinal.currentTorneio.addParticipante((Participante) TrabalhoFinal.login);
    }
    
    public static boolean isInscrito(){
        for(Participante p : TrabalhoFinal.currentTorneio.getParticipantes()){
            if(p.getId() == TrabalhoFinal.login.getId()){
                return true;
            }
        }
        return false;
    }
    
    public static void cancelarInscricao(){
        TrabalhoFinal.currentTorneio.removeParticipante(TrabalhoFinal.login.getId());
    }
}   
