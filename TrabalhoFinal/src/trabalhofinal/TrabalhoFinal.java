/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhofinal;
import java.time.LocalDate;
import telas.Login;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
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
    public static ArrayList<Organizador> organizadores = new ArrayList();
    public static ArrayList<Participante> participantes = new ArrayList();
    public static int currentUserId = 0;
    public static int currentTornamentId = 0;
    public static ArrayList<Torneio> torneios = new ArrayList();
    public static Torneio currentTorneio = new Torneio(-1);
    public static int currentPartidaId = 0;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        adicionarUsuarios(100, 10);
        criarTorneios(10, 10);
        inscreverParticipantes();
        Liga teste = (Liga) TrabalhoFinal.torneios.get(10);
        teste.criarPartidas();
        // new Login().setVisible(true);
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
                                    String regras, Organizador organizador, int tipo){
        if(tipo == 0){
            TrabalhoFinal.torneios.add(new MataMata(nome, descricao, local, dataInicio, dataInicioInscricao, periodoTorneio, periodoInscricao, regras, TrabalhoFinal.currentTornamentId, organizador));
        } else{
            TrabalhoFinal.torneios.add(new Liga(nome, descricao, local, dataInicio, dataInicioInscricao, periodoTorneio, periodoInscricao, regras, TrabalhoFinal.currentTornamentId, organizador));
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
    
    private static void adicionarUsuarios(int n, int m){
        for(int i = 0; i < n; i++){
            Participante p = new Participante(i,
                                             String.format("Gustavo%d", i),
                                            "Ciência da Computação",
                                            String.format("gustavo%d@gmail.com", i),
                                            String.format("senha%d", i));
            TrabalhoFinal.usuarios.add(p);
            TrabalhoFinal.participantes.add(p);
        }
        
        for(int i = 0; i < m; i++){
            Organizador o = new Organizador(i+n,
                                        String.format("Vinicius%d", i),
                                       "Ciência da Computação",
                                       String.format("vinicius%d@gmail.com", i),
                                       String.format("password%d", i));
            TrabalhoFinal.usuarios.add(o);
            TrabalhoFinal.organizadores.add(o);
        }
        TrabalhoFinal.currentUserId = n+m;
    }
    
    private static void criarTorneios(int n, int m){
        Random r = new Random();
        for(int i = 0; i < n; i++){
            long minDay = LocalDate.of(2023, 1, 1).toEpochDay();
            long maxDay = LocalDate.now().toEpochDay();
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate1 = LocalDate.ofEpochDay(randomDay);
            LocalDate randomDate2 = LocalDate.ofEpochDay(randomDay).plusDays(11);
            
            TrabalhoFinal.criarTorneio(String.format("Mata-Mata Test %d", i),
                                       "Torneio do tipo mata-mata criado pelo método privado criarTorneios da classe TrabalhoFinal para testar o aplicativo.",
                                       "Cacomp",
                                       randomDate2,
                                       randomDate1,
                                       10, 
                                       10,
                                       "Sinuquinha",
                                       TrabalhoFinal.organizadores.get(r.nextInt(TrabalhoFinal.organizadores.size())),
                                       0);
        }
        
        for(int i = 0; i < m; i++){
            long minDay = LocalDate.of(2023, 1, 1).toEpochDay();
            long maxDay = LocalDate.now().toEpochDay();
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate1 = LocalDate.ofEpochDay(randomDay);
            LocalDate randomDate2 = LocalDate.ofEpochDay(randomDay).plusDays(11);
            
            TrabalhoFinal.criarTorneio(String.format("Liga Test %d", i),
                                       "Torneio do tipo mata-mata criado pelo método privado criarTorneios da classe TrabalhoFinal para testar o aplicativo.",
                                       "Cacomp",
                                       randomDate2,
                                       randomDate1,
                                       10, 
                                       10,
                                       "Sinuquinha",
                                       TrabalhoFinal.organizadores.get(r.nextInt(TrabalhoFinal.organizadores.size())),
                                       1);
        }
    }
    
    private static void inscreverParticipantes(){
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 9; j++){
                TrabalhoFinal.torneios.get(i).addParticipante(TrabalhoFinal.participantes.get(r.nextInt(TrabalhoFinal.participantes.size())));
            }
        }
        
        for(int i = 10; i < 20; i++){
            for(int j = 0; j < 10; j++){
                TrabalhoFinal.torneios.get(i).addParticipante(TrabalhoFinal.participantes.get(r.nextInt(TrabalhoFinal.participantes.size())));
            }
        }
    }
}   
