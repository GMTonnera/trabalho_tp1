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
import java.util.regex.Pattern;
/**
 *
 * @author guton
 */

/*
CLASSE TrabalhoFinal --> Classe main do projeto. Para iniciar o aplicativo, 
                         executar o método main.
    
   
    ATRIBUTO login: Variável privada do tipo Usuari a qual armazena o usuário
logado no aplicativo;
    
    ATRIBUTO currentTornamentId: Variável privada do tipo int a qual armazena o
id do próximo torneio a ser criado;
    
    ATRIBUTO currentOrganizadorId: Variável privada do tipo int a qual armazena
o id do próximo organizador a ser cadastrado;
    
    ATRIBUTO currentParticipanteId: Variável privada do tipo int a qual armazena
o id do próximo participante a ser cadastrado;

    ATRIBUTO currentTorneio: Variável privada do tipo Torneio a qual armazena o 
Torneio que o usuário está visualizando informações mais detalhadas;
    
    ATRIBUTO currentPartidaId: Variável privada do tipo int a qual armazena o 
id da próxima partida a ser criada;
    
    ATRIBUTO torneios: Variável privada do tipo ArrayList<Torneio> a qual
armazena todos os torneios do banco de dados;
    
    ATRIBUTO participantes: Variável privada do tipo ArrayList<Participante> a
qual armazena todos os participantes do banco de dados;

    ATRIBUTO organizadores: Variável privada do tipo ArrayList<Organizadores> a
qual armazena todos os organizadores do banco de dados;

    
    MÉTODO main: Executa a aplicação;
    
    MÉTODO createUsuario: Método que cria uma instância da classe Participante 
ou da classe Organizador e a coloca no banco de dados;
    
    MÉTODO checkLogin: Verifica se o email e senha pertencem a um usuário;
    
    MÉTODO checkEmail: Verifica se o email de cadastro já foi cadastrado por
outro usuário;
    
    MÉTODO login: Realiza o login;
    
    MÉTODO criarTorneio:Cria um objeto da classe MataMata ou Liga e o armazena
no banco de dados;
    
    MÉTODO setCurrentTorneio: Armazena o torneio que o usuário está
visualizando/editando;
    
    MÉTODO inscricao: Realiza a inscrição de um Participante no torneio
armazenado;
    
    MÉTODO isInscrito: Verifica se um Participante já está inscrito em um
torneio;
    
    
    MÉTODO cancelarInscricao: Cancela a inscrição de uma Participante no torneio
armazenado;
    
    MÉTODO adicionarUsuarios: Método que cria n Participantes e m Organizadores
e os armazena no bancode de dados;

    MÉTODO criarTorneios: Método que cria n torneios do tipo MataMata e m do
tipo Liga e os armazena no banco de dados;
    
    MÉTODO inscreverParticipantesMataMata: Inscreve aleatoriamente Participantes
nos Torneios do tipo Mata-mata;
    
    MÉTODO inscreverParticipantesLiga: Inscreve aleatoriamente Participantes nos
Torneios do tipo Liga();    
    
    
    MÉTODO gerarListaTorneios: Gera a lista de torneios, atualiza o estados dos
torneios e cria as partidas dos torneios;
    
    
    MÉTODO gerarListaParticipantes: Gera a lista de participantes e atualiza o
id do próximo participante a ser criado;
    
    MÉTODO gerarListaOrganizadores: Gera a lista de organizadores e atualiza o 
id do próximo organizador a ser criado;
    
    
    MÉTODO validarEmail: Verifica se o email é válido;    
    
    MÉTODO patternMatches: Verifica se o email segue o padrão regex;
    
    MÉTODO resultadosPartidas: Atribui resultados aleatórios a partidas do banco
de dados;    
    
    MÉTODO deletePartidas: deleta partidas do banco de dados pelo id;
    
    MÉTODO atualizarStatusParticipante: Método usado para atualizar as
estatísticas dos participantes que estão no banco de dados;

    MÉTODO atualizarStatusOrganizador: Método usado para atualizar as
estatísticas dos organizadores que estão no banco de dados;
    
    MÉTODO getIdPartida: Método usado para adquirir o id da próxima a ser 
criada.
*/


public class TrabalhoFinal {

    /**
     * @param args the command line arguments
     */
    public static Usuario login;
    public static int currentTornamentId, currentOrganizadorId, currentParticipanteId;
    public static Torneio currentTorneio = new Torneio(-1);
    public static int currentPartidaId = -1;
    public static ArrayList<Torneio> torneios = new ArrayList();
    public static ArrayList<Participante> participantes = new ArrayList();
    public static ArrayList<Organizador> organizadores = new ArrayList();
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // TrabalhoFinal.deletePartidas();
        TrabalhoFinal.gerarListaTorneios();
        TrabalhoFinal.getIdPartida();
        TrabalhoFinal.gerarListaParticipantes();
        TrabalhoFinal.gerarListaOrganizadores();
        // TrabalhoFinal.atualizarStatusOrganizador();
        // TrabalhoFinal.resultadosPartidas();
        // TrabalhoFinal.atualizarStatusParticipante();
        
        // adicionarUsuarios(100, 10);
        // criarTorneios(10, 10);
        // inscreverParticipantesMataMata();
        // inscreverParticipantesLiga();
        // Liga teste = (Liga) TrabalhoFinal.torneios.get(10);
        // teste.criarPartidas();
        new Login().setVisible(true);
    }
    
    // Método que cria uma instâcia da classe Participante ou de Organizador e coloca no banco de dados
    public static void createUsuario(String nome, String curso, String email, String senha, int tipo){
        if(tipo == 0){
            // Criar um Participante
            ParticipanteService ps = new ParticipanteService();
            Participante p = new Participante(TrabalhoFinal.currentParticipanteId, nome, curso, email, senha);
            ps.createParticipante(p);
            TrabalhoFinal.participantes.add(p);
            TrabalhoFinal.currentParticipanteId += 1;
        } else{
            // Criar um Organizador
            OrganizadorService os = new OrganizadorService();
            Organizador o = new Organizador(TrabalhoFinal.currentOrganizadorId, nome, curso, email, senha);
            os.createOrganizador(o);
            TrabalhoFinal.organizadores.add(o);
            TrabalhoFinal.currentOrganizadorId += 1;
        }
    }
    
    // Verifica se o email e senha pertencem a um usuário
    public static boolean checkLogin(String email, String senha){
        // Verificar se o usuário está no banco de dados
        for(Participante p : TrabalhoFinal.participantes){
            if(p.getEmail().equals(email) && p.getSenha().equals(senha)){
                return true;
            }
        }
        
        for(Organizador o : TrabalhoFinal.organizadores){
            if(o.getEmail().equals(email) && o.getSenha().equals(senha)){
                return true;
            }
        }
        
        return false;
    }
    
    // Verifica se o email de cadastro já foi usado
    public static boolean checkEmail(String email){
        for(Participante p : TrabalhoFinal.participantes){
            if(p.getEmail().equals(email)){
                return true;
            }
        }
        
        for(Organizador o : TrabalhoFinal.organizadores){
            if(o.getEmail().equals(email)){
                return true;
            }
        }
        
        return false;
    }
    
    // Realiza o login
    public static void login(String email, String senha){
        // Encontrar o usuário no banco de dados e setar login
        boolean flag = false;
        
        for(Participante p : TrabalhoFinal.participantes){
            if(p.getEmail().equals(email) && p.getSenha().equals(senha)){
                TrabalhoFinal.login = p;
                flag = true;
                break;
            }
        }
        if(!flag){
            for(Organizador o : TrabalhoFinal.organizadores){
                if(o.getEmail().equals(email) && o.getSenha().equals(senha)){
                    TrabalhoFinal.login = o;
                }
            }
        }
    }
    
    // Cria um objeto da classe MataMata ou Liga e o armazena no banco de dados
    public static void criarTorneio(String nome, String descricao, String local, LocalDate dataInicio, LocalDate dataInicioInscricao,int periodoTorneio, int periodoInscricao, 
                                    String regras, Organizador organizador, int tipo){
        
        TorneioService ts = new TorneioService();
        PartidaService ps = new PartidaService();
        
        if(tipo == 0){
            MataMata m = new MataMata(nome, descricao, local, dataInicio, dataInicioInscricao, periodoTorneio, periodoInscricao, regras, TrabalhoFinal.currentTornamentId, organizador);
            m.atualizarEstado();
            ts.createTorneio(m, organizador.getId());
            TrabalhoFinal.torneios.add(m);
            
        } else{
            Liga l = new Liga(nome, descricao, local, dataInicio, dataInicioInscricao, periodoTorneio, periodoInscricao, regras, TrabalhoFinal.currentTornamentId, organizador);
            l.atualizarEstado();
            ts.createTorneio(l, organizador.getId());
            TrabalhoFinal.torneios.add(l);
        }
        TrabalhoFinal.currentTornamentId += 1;
    }
    
    // Armazena o torneio que o usuário está visualizando/editando
    public static void setCurrentTorneio(int id){
        for(Torneio t : TrabalhoFinal.torneios){
            if(t.getId() == id){
                TrabalhoFinal.currentTorneio = t;
            }
        }
    }
    
    // Realiza a inscrição de um Participante no torneio armazenado
    public static void inscricao(){
        ParticipanteService ps = new ParticipanteService();
        ps.inscreverParticipante(TrabalhoFinal.currentTorneio.getId(), TrabalhoFinal.login.getId());
        TrabalhoFinal.currentTorneio.addParticipante((Participante) TrabalhoFinal.login);
    }
    
    // Verifica se um Participante já está inscrito em um torneio
    public static boolean isInscrito(){
        for(Participante p : TrabalhoFinal.currentTorneio.getParticipantes()){
            if(p.getId() == TrabalhoFinal.login.getId()){
                return true;
            }
        }
        return false;
    }
    
    // Cancela a inscriçãod e uma Participante no torneio armazenado
    public static void cancelarInscricao(){
        TrabalhoFinal.currentTorneio.removeParticipante(TrabalhoFinal.login.getId());
    }
    
    // Método que cria n Participantes e m Organizadores e os armazena no bancode de dados
    private static void adicionarUsuarios(int n, int m){
        for(int i = 0; i < n; i++){
            Participante p = new Participante(i,
                                             String.format("Gustavo%d", i),
                                            "Ciência da Computação",
                                            String.format("gustavo%d@gmail.com", i),
                                            String.format("senha%d", i));
            
            ParticipanteService ps = new ParticipanteService();
            ps.createParticipante(p);
            
            TrabalhoFinal.participantes.add(p);
        }
        
        for(int i = 0; i < m; i++){
            Organizador o = new Organizador(i,
                                        String.format("Vinicius%d", i),
                                       "Ciência da Computação",
                                       String.format("vinicius%d@gmail.com", i),
                                       String.format("password%d", i));
            OrganizadorService os = new OrganizadorService();
            os.createOrganizador(o);
            
            TrabalhoFinal.organizadores.add(o);
        }
        TrabalhoFinal.currentParticipanteId = n;
        TrabalhoFinal.currentOrganizadorId = m;
    }
    
    // Método que cria n torneios do tipo MataMata e m do tipo Liga e os armazena no banco de dados
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
    
    // Inscreve aleatoriamente Participantes nos Torneios
    private static void inscreverParticipantesMataMata(){
        ParticipanteService ps = new ParticipanteService();
        for(int i = 0; i < 10; i++){
            System.out.println(String.format("Torneio: %d", i));
            for(int j = i; j < i + 16; j++){
                TrabalhoFinal.torneios.get(i).addParticipante(TrabalhoFinal.participantes.get(j));
                ps.inscreverParticipante(i, j);
            }
        }
    }
    
    
    private static void inscreverParticipantesLiga(){
        ParticipanteService ps = new ParticipanteService();
        for(int i = 10; i < 20; i++){
            System.out.println(String.format("Torneio: %d", i));
            for(int j = i; j < i + 20; j++){
                TrabalhoFinal.torneios.get(i).addParticipante(TrabalhoFinal.participantes.get(j));
                ps.inscreverParticipante(i, j);
            }
        }
    }
    
    
    public static void gerarListaTorneios(){
        TorneioService ts = new TorneioService();
        TrabalhoFinal.torneios = ts.findAllTorneio();
        TrabalhoFinal.currentTornamentId = TrabalhoFinal.torneios.get(TrabalhoFinal.torneios.size()-1).getId()+1;
        PartidaService ps = new PartidaService();
        
        
        for(Torneio t : TrabalhoFinal.torneios){
            t.setParticipantes(ts.findAllTorneioParticipante(t.getId()));
            t.atualizarEstado();
            t.setPartidas(ts.findAllTorneioPartida(t.getId()));
             if(t.getStatusTorneio() == 2 && t.getPartidaAtual() == 0 && t.getPartidas().isEmpty()){
                if(t instanceof MataMata){
                    ((MataMata) t).generateOitavasFinal();
                } else{
                    ((Liga) t).criarPartidas();
                    ((Liga) t).inicializarTabela();
                }
                for(Partida p : t.getPartidas()){
                    ps.createPartida(p, t.getId());
                }
            } else if(t.getStatusTorneio() == 2 && t.getPartidaAtual() == 8 && t instanceof MataMata && t.getPartidas().get(t.getPartidaAtual()-1).getVencedor().getId() != -1){
                ((MataMata) t).refazerParticipantesAtuais();
                ((MataMata) t).generateQuartasFinal();
                for(int i = 0; 8 < 12; i++){
                    ps.createPartida(t.getPartidas().get(i), t.getId());
                }
            } else if(t.getStatusTorneio() == 2 && t.getPartidaAtual() == 12 && t instanceof MataMata && t.getPartidas().get(t.getPartidaAtual()-1).getVencedor().getId() != -1){
                ((MataMata) t).refazerParticipantesAtuais();
                ((MataMata) t).generateSemiFinal();
                for(int i = 0; 12 < 14; i++){
                    ps.createPartida(t.getPartidas().get(i), t.getId());
                }
            } else if(t.getStatusTorneio() == 2 && t.getPartidaAtual() == 14 && t instanceof MataMata && t.getPartidas().get(t.getPartidaAtual()-1).getVencedor().getId() != -1){
                ((MataMata) t).refazerParticipantesAtuais();
                ((MataMata) t).generateFinal();
                ps.createPartida(t.getPartidas().get(14), t.getId());
            } else if(t.getStatusTorneio() >= 2 && t instanceof Liga){
                ((Liga) t).inicializarTabela();
                ((Liga) t).atualizarTabela();
            }
            
            
        }
    }
    
    
    public static void gerarListaParticipantes(){
        ParticipanteService ps = new ParticipanteService();
        TrabalhoFinal.participantes = ps.findAllParticipante();
        TrabalhoFinal.currentParticipanteId = TrabalhoFinal.participantes.get(TrabalhoFinal.participantes.size()-1).getId()+1;
    }
    
    
    public static void gerarListaOrganizadores(){
        OrganizadorService os = new OrganizadorService();
        TrabalhoFinal.organizadores = os.findAllOrganizador();
        TrabalhoFinal.currentOrganizadorId = TrabalhoFinal.organizadores.get(TrabalhoFinal.organizadores.size()-1).getId()+1;
    }
    
    
    public static boolean validarEmail(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        
        return TrabalhoFinal.patternMatches(email, regexPattern);
    }
    
    
    private static boolean patternMatches(String email, String regex){
        return Pattern.compile(regex).matcher(email).matches();
    }
    
    
    private static void resultadosPartidas(){
        PartidaService ps = new PartidaService();
        TorneioService ts = new TorneioService();
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        
        for(Torneio t : TrabalhoFinal.torneios){
            ArrayList<Partida> partidas = ts.findAllTorneioPartida(t.getId());
            for(Partida p : partidas){
                 if(p.getResultado().get(0) == p.getResultado().get(1)){
                    if(r1.nextInt(0, 2) == 1){
                        if(r2.nextInt(0, 2) == 1){
                            ps.addPatidaResult(p.getId(), 8, 0, true);
                        } else{
                            ps.addPatidaResult(p.getId(), 8, r3.nextInt(1, 8), false);
                        }
                    } else{
                        if(r2.nextInt(0, 2) == 1){
                            ps.addPatidaResult(p.getId(), 0, 8, true);
                        } else{
                            ps.addPatidaResult(p.getId(), r3.nextInt(1, 8), 8, false);
                        }
                    }
                }
            }
        }
    }
    
    
    private static void deletePartidas(){
        PartidaService ps = new PartidaService();
        for(int i = 2020; i < 2060; i++){
            ps.deletePartida(i);
        }
    }
    
    private static void atualizarStatusParticipante(){
        ParticipanteService ps = new ParticipanteService();
        for(Participante p : TrabalhoFinal.participantes){
            int nTorneios = 0, nTorneiosV = 0, nVit = 0, nDer = 0, nCapA = 0, nCapR = 0;
            for(Torneio t : TrabalhoFinal.torneios){
                if(t instanceof MataMata){
                    if(p.getId() == ((MataMata)t).getCampeao().getId()){
                        nTorneiosV++;
                    }
                } else{
                    if(p.getId() == ((Liga)t).getCampeao().getId()){
                        nTorneiosV++;
                    }
                }
                for(Participante p2 : t.getParticipantes()){
                    if(p.getId() == p2.getId()){
                        nTorneios++;
                        break;
                    }
                }
                
                for(Partida partida : t.getPartidas()){
                    if(partida.getVencedor().getId() == p.getId()){
                        nVit++;
                        if(partida.getCapote()){
                            nCapA++;
                        }
                    } else if(partida.getPerdedor().getId() == p.getId()){
                        nDer++;
                        if(partida.getCapote()){
                            nCapR++;
                        }
                    }
                }
            }
            p.setNumTorneiosJogados(nTorneios);
            p.setNumTorneiosVencidos(nTorneiosV);
            p.setNumVitorias(nVit);
            p.setNumDerrotas(nDer);
            p.setCapotesAplicados(nCapA);
            p.setCapotesRecebidos(nCapR);
            ps.updateParticipante(p);
        }
    }
    
    private static void atualizarStatusOrganizador(){
        OrganizadorService os = new OrganizadorService();
        for(Organizador o : TrabalhoFinal.organizadores){
            int n = 0;
            for(Torneio t : TrabalhoFinal.torneios){
                if(o.getId() == t.getOrganizador().getId()){
                    n++;
                }
            }
            o.setNumTorneiosCriados(n);
            os.updateOrganizador(o);
        }
        
    }
    
    private static void getIdPartida(){
        for(Torneio t : TrabalhoFinal.torneios){
            for(Partida p : t.getPartidas()){
                if(p.getId() > TrabalhoFinal.currentPartidaId){
                    TrabalhoFinal.currentPartidaId = p.getId();
                }
            }
        }
        TrabalhoFinal.currentPartidaId++;
    }
}   
