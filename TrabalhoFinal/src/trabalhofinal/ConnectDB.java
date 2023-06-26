/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Vini
 */
/*
CLASSE ConnectDB --> Classe usada para faezr as interações com o banco de dados.

    1. MÉTODO connect: Método que faz a conexão com o banco de dados e retorna um 
objeto Connection para que outras classe possam acessar o banco de dados;

    2. MÉTODO dropTables: Método utilizado para realizar a operação SQL Drop em 
todas as tables do banco de dados;

    3. MÉTODO createTables: Método utilizado para criar todas as tabelas do banco
de dados;

    4. MÉTODO insertTorneio: Método utilizado para inserir um novo objeto da
classe Torneio na table Torneio do banco de dados;

    5. MÉTODO findTorneio: Método utilizado para achar um torneio com um id
específico no banco de dados. Caso o tornio não seja encontrado, o método 
retorna um objeto Torneio instanciado pelo contrutor padrão da classe;

    6. MÉTODO finAllTorneio: Método utilizado para acessar todos os torneios
presentes no banco de dados. Retorna uma ArrayList<Torneio>;
    
    7. MÉTODO updateTorneio: Método utilizado para atualizar um objeto Torneio
presente na tabela Torneio do banco de dados;
    
    8. MÉTODO findAllTorneioParticipante: Método que retorna uma
ArrayList<Participante> contendo todos os participantes de um dado torneio;

    9. MÉTODO findAllTorneioPartidas:  Método que retorna uma ArrayList<Partida>
contendo todas as partidas de um determinado torneio;

    10. MÉTODO inscreverParticipante: Método responsável por armazenar a inscrição
de uma participante em um torneio no banco de dados;

    11. MÉTODO deleteTorneio: Método resposável por deletar um determinado torneio
do banco de dados;

    12. MÉTODO resestDB: Método resposável por resetar o banco de dados, recriando
as tabelas;

    13. MÉTODO createOrganizador: Armazena um novo objeto Organizador no banco de 
dados;

    14. MÉTODO findOrganizador: Método responsável por achar um determiando 
Organizador no banco de dados. Caso não seja exista, retorna um objeto 
Organizador instanciado pelo construtor padrão;

    15. MÉTODO  findAllOrganizador: Método responsável por retornar uma 
ArrayList<Organiador> contendo todos os organizadores cadastrados no banco de
dados;
    
    16. MÉTODO updateOrganizador: Método responsável por modificar um organizador 
cadastrado no bando de dados;

    17. MÉTODO deleteOrganizador: Método responsável por apagar do banco de dados
um determinado organizador;

    18. MÉTODO createParticipante: Método responsável por armazenar um novo 
Participante no banco de dados;

    19. MÉTODO findParticipante: Método responsável por achar um determiando 
Participante no banco de dados. Caso não seja exista, retorna um objeto 
Participante instanciado pelo construtor padrão;

    20. MÉTODO findAllParticipante: Método responsável por retornar uma 
ArrayList<Participante> contendo todos os participantes cadastrados no banco de
dados;
    
    21. MÉTODO updateParticipante: Método responsável por modificar um participante 
cadastrado no bando de dados;
    
    22. MÉTODO deleteParticipante: Método responsável por apagar do banco de dados
um determinado Participante;

    23. MÉTODO createPartida: Método responsável por armazenar uma nova Partida no 
banco de dados;

    MÉTODO findPartida: Método responsável por achar uma determianda Partida no
banco de dados. Caso não seja exista, retorna um objeto Partida instanciado pelo
construtor padrão;

    24. MÉTODO updatePartidaResultado: Método responsável por atualizar o resultado
de retornar uma Partida cadastrada no banco de dados;
    
    25. MÉTODO deletePartida: Método responsável por apagar do banco de dados
uma determinada Partida;

    26. MÉTODO inscreverEmTorneio: Inscreve um participante em um torneio;

    27. MÉTODO criarTorneio: Cria um torneio;
*/






public class ConnectDB {
  public static Connection connect() {
    Connection conn = null;
    // db parameters
    String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\db\\sinuqueiro.db";
    
    try {
      // create a connection to the database
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection(url);
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

    return conn;
  }

  public static void dropTables() {
    Connection conn = connect();

    String dropCriarTorneio = "DROP TABLE criarTorneio";

    String dropInscricao = "DROP TABLE inscricao";

    String dropPartida = "DROP TABLE partida";

    String dropTorneio = "DROP TABLE torneio";

    String dropParticipante = "DROP TABLE participante";

    String dropOrganizador = "DROP TABLE organizador";

    try {
      Statement stmt = conn.createStatement();
      // create a new table
      stmt.execute(dropCriarTorneio);
      stmt.execute(dropInscricao);
      stmt.execute(dropPartida);
      stmt.execute(dropTorneio);
      stmt.execute(dropParticipante);
      stmt.execute(dropOrganizador);
      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void createTables() {
    Connection conn = connect();

    String ParticipanteTable = "CREATE TABLE IF NOT EXISTS participante (\n"
        + "	id integer PRIMARY KEY,\n"
        + "    nome text NOT NULL,\n"
        + "    curso text NOT NULL,\n"
        + "    email text UNIQUE NOT NULL,\n"
        + "    senha text NOT NULL,\n"
        + "    numVitorias integer NOT NULL,\n"
        + "    numDerrotas integer,\n"
        + "    capotesRecebidos integer,\n"
        + "    capotesAplicados integer,\n"
        + "    numTorneiosJogados integer,\n"
        + "    numTorneiosVencidos integer\n"
        + ");";

    String OrganizadorTable = "CREATE TABLE IF NOT EXISTS organizador (\n"
        + "    id integer PRIMARY KEY,\n"
        + "    nome text NOT NULL,\n"
        + "    curso text NOT NULL,\n"
        + "    email text UNIQUE NOT NULL,\n"
        + "    senha text NOT NULL,\n"
        + "    numTorneiosCriados integer\n"
        + ");";

    String PartidaTable = "CREATE TABLE IF NOT EXISTS partida (\n"
        + "    id integer PRIMARY KEY,\n"
        + "    torneio_id INTEGER NOT NULL,\n"
        + "    primeiroJogador_id INTEGER NOT NULL,\n"
        + "    segundoJogador_id  INTEGER NOT NULL,\n"
        + "    primeiroJogadorPontuacao intege DEFAULT 0,\n"
        + "    segundoJogadorPontuacao integer DEFAULT 0,\n"
        + "    capote integer DEFAULT 0,\n"
        + "    FOREIGN KEY (torneio_id)\n"
        + "        REFERENCES torneio (id)\n"
        + "           ON DELETE CASCADE\n"
        + "           ON UPDATE NO ACTION,\n"
        + "    FOREIGN KEY (primeiroJogador_id)\n"
        + "        REFERENCES participante (id)\n"
        + "           ON DELETE CASCADE\n"
        + "           ON UPDATE NO ACTION,\n"
        + "    FOREIGN KEY (segundoJogador_id)\n"
        + "        REFERENCES participante (id)\n"
        + "           ON DELETE CASCADE\n"
        + "           ON UPDATE NO ACTION\n"
        + ");";

    String TorneioTable = "CREATE TABLE IF NOT EXISTS torneio (\n"
        + "    id integer PRIMARY KEY,\n"
        + "    tipo integer NOT NULL,\n"
        + "    maxParticipantes integer NOT NULL,\n"
        + "    minParticipantes integer NOT NULL,\n"
        + "    numJogosPartida integer NOT NULL,\n"
        + "    status integer NOT NULL,\n"
        + "    nome text NOT NULL,\n"
        + "    descricao text NOT NULL,\n"
        + "    local text NOT NULL,\n"
        + "    regras text NOT NULL,\n"
        + "    dataInicio text NOT NULL,\n"
        + "    dataInicioInscricao text NOT NULL,\n"
        + "    periodoTorneio integer NOT NULL,\n"
        + "    periodoInscricao integer NOT NULL,\n"
        + "    partidaAtual integer NOT NULL,\n"
        + "    numPartidas integer NOT NULL\n"
        + ");";

    String InscricaoTable = "CREATE TABLE IF NOT EXISTS inscricao (\n"
        + "participante_id INTEGER,\n"
        + "torneio_id INTEGER,\n"
        + "PRIMARY KEY (participante_id, torneio_id),\n"
        + "FOREIGN KEY (participante_id)\n"
        + "   REFERENCES participante (id)\n"
        + "       ON DELETE CASCADE\n"
        + "       ON UPDATE NO ACTION,\n"
        + "FOREIGN KEY (torneio_id)\n"
        + "   REFERENCES torneio (id)\n"
        + "       ON DELETE CASCADE\n"
        + "       ON UPDATE NO ACTION\n"
        + ");";

    String CriarTorneioTable = "CREATE TABLE IF NOT EXISTS criarTorneio (\n"
        + "organizador_id INTEGER,\n"
        + "torneio_id INTEGER,\n"
        + "PRIMARY KEY (organizador_id, torneio_id),\n"
        + "FOREIGN KEY (organizador_id)\n"
        + "   REFERENCES organizador (id)\n"
        + "       ON DELETE CASCADE\n"
        + "       ON UPDATE NO ACTION,\n"
        + "FOREIGN KEY (torneio_id)\n"
        + "   REFERENCES torneio (id)\n"
        + "       ON DELETE CASCADE\n"
        + "       ON UPDATE NO ACTION\n"
        + ");";

    try (
        Statement stmt = conn.createStatement()) {
      // create a new table
      stmt.execute(ParticipanteTable);
      stmt.execute(OrganizadorTable);
      stmt.execute(PartidaTable);
      stmt.execute(TorneioTable);
      stmt.execute(InscricaoTable);
      stmt.execute(CriarTorneioTable);

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void insertTorneio(Torneio torneio) {
        Connection conn = connect();

        
        String sql = "INSERT INTO torneio("
                   + "id,"
                   + "maxParticipantes,"
                   + "minParticipantes,"
                   + "nome,"
                   + "descricao,"
                   + "local,"
                   + "regras,"
                   + "numJogosPartida,"
                   + "status,"
                   + "dataInicio,"
                   + "dataInicioInscricao,"
                   + "periodoTorneio,"
                   + "periodoInscricao,"
                   + "tipo,"
                   + "partidaAtual,"
                   + "numPartidas"
                   + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        int tipo = torneio instanceof MataMata ? 0 : 1;
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, torneio.getId());
            pstmt.setInt(2, torneio.getMaxParticipantes());
            pstmt.setInt(3, torneio.getMinParticipantes());
            pstmt.setString(4, torneio.getNome());
            pstmt.setString(5, torneio.getDescricao());
            pstmt.setString(6,torneio.getLocal());
            pstmt.setString(7, torneio.getRegras());
            pstmt.setInt(8, torneio.getNumJogosPartida());
            pstmt.setInt(9, torneio.getStatusTorneio());
            pstmt.setString(10, torneio.getDataInicio().toString());
            pstmt.setString(11, torneio.getDataInicioInscricao().toString());
            pstmt.setInt(12, torneio.getPeriodoTorneio());
            pstmt.setInt(13, torneio.getPeriodoInscricao());
            pstmt.setInt(14, tipo);
            pstmt.setInt(15, torneio.getNumPartidas());
            pstmt.setInt(16, torneio.getPartidaAtual());

            pstmt.executeUpdate();
     
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

  public Torneio findTorneio(int id) {
    Connection conn = connect();

    String sql = "SELECT * FROM torneio WHERE id = ?";

    Torneio torneio = new Torneio();

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      ResultSet rs = pstmt.executeQuery();

      torneio.setId(rs.getInt("id"));
      torneio.setNome(rs.getString("nome"));
      torneio.setLocal(rs.getString("local"));
      torneio.setRegras(rs.getString("regras"));
      torneio.setDescricao(rs.getString("descricao"));
      torneio.setDataInicio(LocalDate.parse(rs.getString("dataInicio")));
      torneio.setDataInicioInscricao(LocalDate.parse(rs.getString("dataInicioInscricao")));
      torneio.setStatusTorneio(rs.getInt("status"));
      torneio.setPeriodoTorneio(rs.getInt("periodoTorneio"));
      torneio.setPeriodoInscricao(rs.getInt("periodoInscricao"));
      torneio.setNumJogosPartida(rs.getInt("numJogosPartida"));
      torneio.setMaxParticipantes(rs.getInt("maxParticipantes"));
      torneio.setMinParticipantes(rs.getInt("minParticipantes"));
      torneio.setNumPartidas(rs.getInt("numPartidas"));
      torneio.setPartidaAtual(rs.getInt("partidaAtual"));

      String queryOrganizadorId = "SELECT * FROM criarTorneio WHERE torneio_id = ?";

      pstmt = conn.prepareStatement(queryOrganizadorId);
      pstmt.setInt(1, torneio.getId());

      rs = pstmt.executeQuery();

      int organizadorId;

      organizadorId = rs.getInt("organizador_id");

      String queryOrganizadorData = "SELECT * FROM organizador WHERE id = ?";

      pstmt = conn.prepareStatement(queryOrganizadorData);
      pstmt.setInt(1, organizadorId);

      rs = pstmt.executeQuery();

      Organizador organizador = new Organizador();

      organizador.setId(rs.getInt("id"));
      organizador.setNome(rs.getString("nome"));
      organizador.setCurso(rs.getString("curso"));
      organizador.setEmail(rs.getString("email"));
      organizador.setSenha(rs.getString("senha"));
      organizador.setNumTorneiosCriados(rs.getInt("numTorneiosCriados"));

      torneio.setOrganizador(organizador);

      conn.close();

      return torneio;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return torneio;
  }

  public ArrayList<Torneio> findAllTorneio() {
    Connection conn = connect();
    ArrayList<Torneio> res = new ArrayList<>();

    String sql = "SELECT * FROM torneio";
    
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        Torneio torneio;
        
        if (rs.getInt("tipo") == 0) {
          torneio = new MataMata();
        } else {
          torneio = new Liga();
        }

        torneio.setId(rs.getInt("id"));
        torneio.setNome(rs.getString("nome"));
        torneio.setLocal(rs.getString("local"));
        torneio.setRegras(rs.getString("regras"));
        torneio.setDescricao(rs.getString("descricao"));
        torneio.setDataInicio(LocalDate.parse(rs.getString("dataInicio")));
        torneio.setDataInicioInscricao(LocalDate.parse(rs.getString("dataInicioInscricao")));
        torneio.setStatusTorneio(rs.getInt("status"));
        torneio.setPeriodoTorneio(rs.getInt("periodoTorneio"));
        torneio.setPeriodoInscricao(rs.getInt("periodoInscricao"));
        torneio.setNumJogosPartida(rs.getInt("numJogosPartida"));
        torneio.setMaxParticipantes(rs.getInt("maxParticipantes"));
        torneio.setMinParticipantes(rs.getInt("minParticipantes"));
        torneio.setNumPartidas(rs.getInt("numPartidas"));
        torneio.setPartidaAtual(rs.getInt("partidaAtual"));

        String queryOrganizadorId = "SELECT * FROM criarTorneio WHERE torneio_id = ?";

        PreparedStatement relPstmt = conn.prepareStatement(queryOrganizadorId);
        relPstmt.setInt(1, torneio.getId());

        ResultSet relRs = relPstmt.executeQuery();

        int organizadorId = relRs.getInt("organizador_id");

        String queryOrganizadorData = "SELECT * FROM organizador WHERE id = ?";

        PreparedStatement orgPstmt = conn.prepareStatement(queryOrganizadorData);
        orgPstmt.setInt(1, organizadorId);

        ResultSet orgRs = orgPstmt.executeQuery();

        Organizador organizador = new Organizador();

        organizador.setId(orgRs.getInt("id"));
        organizador.setNome(orgRs.getString("nome"));
        organizador.setCurso(orgRs.getString("curso"));
        organizador.setEmail(orgRs.getString("email"));
        organizador.setSenha(orgRs.getString("senha"));
        organizador.setNumTorneiosCriados(orgRs.getInt("numTorneiosCriados"));

        torneio.setOrganizador(organizador);
        res.add(torneio);
      }
      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return res;
  }

  public void updateTorneio(Torneio t) {
    Connection conn = connect();

    String sql = "UPDATE torneio SET " 
      + "nome = ?," 
      + "local = ?," 
      + "regras = ?,"
      + "descricao = ?,"
      + "dataInicio = ? "
      + "dataInicioInscricao = ?,"
      + "status = ?,"
      + "periodoTorneio = ?,"
      + "periodoInscricao = ?,"
      + "numJogosPartida = ?,"
      + "maxParticipantes = ?,"
      + "minParticipantes = ?,"
      + "numPartidas = ?,"
      + "partidaAtual = ? "
      + "WHERE id = ?";
    
     try {
       PreparedStatement pstmt = conn.prepareStatement(sql);

       pstmt.setString(1, t.getNome());
       pstmt.setString(2, t.getLocal());
       pstmt.setString(3, t.getRegras());
       pstmt.setString(4, t.getDescricao());
       pstmt.setString(5, t.getDataInicio().toString());
       pstmt.setString(6, t.getDataInicioInscricao().toString());
       pstmt.setInt(7, t.getStatusTorneio());
       pstmt.setInt(8, t.getPeriodoTorneio());
       pstmt.setInt(9, t.getPeriodoInscricao());
       pstmt.setInt(10, t.getNumJogosPartida());
       pstmt.setInt(11, t.getMaxParticipantes());
       pstmt.setInt(12, t.getMinParticipantes());
       pstmt.setInt(13, t.getNumPartidas());
       pstmt.setInt(14, t.getPartidaAtual());

       pstmt.executeUpdate();

       conn.close();
     } catch(SQLException e) {
       System.out.println(e.getMessage());
     }
  }

  public ArrayList<Participante> findAllTorneioParticipante(int torneio_id) {
    Connection conn = connect();

    ArrayList<Participante> res = new ArrayList<>();

    String sql = "SELECT * FROM inscricao WHERE torneio_id = ?";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, torneio_id);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        Participante participante = new Participante();

        int participanteId = rs.getInt("participante_id");

        String getParticipante = "SELECT * FROM participante WHERE id = ?";

        PreparedStatement pStatement = conn.prepareStatement(getParticipante);
        pStatement.setInt(1, participanteId);

        ResultSet rSet = pStatement.executeQuery();

        participante.setId(rSet.getInt("id"));
        participante.setNome(rSet.getString("nome"));
        participante.setEmail(rSet.getString("email"));
        participante.setCurso(rSet.getString("curso"));
        participante.setSenha(rSet.getString("senha"));
        participante.setNumVitorias(rSet.getInt("numVitorias"));
        participante.setNumDerrotas(rSet.getInt("numDerrotas"));
        participante.setCapotesAplicados(rSet.getInt("capotesAplicados"));
        participante.setCapotesRecebidos(rSet.getInt("capotesRecebidos"));
        participante.setNumTorneiosJogados(rSet.getInt("numTorneiosJogados"));
        participante.setNumTorneiosVencidos(rSet.getInt("numTorneiosVencidos"));

        res.add(participante);
      }
      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return res;
  }

  public ArrayList<Partida> findAllTorneioPartidas(int torneio_id) {
    Connection conn = connect();

    ArrayList<Partida> res = new ArrayList<>();

    String sql = "SELECT * FROM partida WHERE torneio_id = ?";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, torneio_id);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        Partida partida = findPartida(rs.getInt("id"));

        res.add(partida);
      }
      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return res;
  }

  public void inscreverParticipante(int torneio_id, int participante_id) {
    Connection conn = connect();

    String sql = "INSERT INTO inscricao("
        + "torneio_id,"
        + "participante_id"
        + ") VALUES(?,?)";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, torneio_id);
      pstmt.setInt(2, participante_id);

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

  }

  public void deleteTorneio(int id) {
    Connection conn = connect();

    String sql = "DELETE FROM TABLE torneio WHERE id = ?";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, id);

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void resetDB() {
    dropTables();
    createTables();
  }

  public void createOrganizador(Organizador organizador) {
    Connection conn = connect();

    String sql = "INSERT INTO organizador("
        + "id,"
        + "nome,"
        + "curso,"
        + "email,"
        + "senha,"
        + "numTorneiosCriados"
        + ") VALUES(?,?,?,?,?,?)";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, organizador.getId());
      pstmt.setString(2, organizador.getNome());
      pstmt.setString(3, organizador.getCurso());
      pstmt.setString(4, organizador.getEmail());
      pstmt.setString(5, organizador.getSenha());
      pstmt.setInt(6, organizador.getNumTorneiosCriados());

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public Organizador findOrganizador(int id) {
    Connection conn = connect();

    Organizador organizador = new Organizador();

    String queryOrganizadorData = "SELECT * FROM organizador WHERE id = ?";

    try {

      PreparedStatement pstmt = conn.prepareStatement(queryOrganizadorData);
      pstmt.setInt(1, id);

      ResultSet rs = pstmt.executeQuery();

      organizador.setId(rs.getInt("id"));
      organizador.setNome(rs.getString("nome"));
      organizador.setCurso(rs.getString("curso"));
      organizador.setEmail(rs.getString("email"));
      organizador.setSenha(rs.getString("senha"));
      organizador.setNumTorneiosCriados(rs.getInt("numTorneiosCriados"));
      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return organizador;
  }

  public ArrayList<Organizador> findAllOrganizador() {
    Connection conn = connect();

    ArrayList<Organizador> res = new ArrayList<>();

    String queryOrganizadorData = "SELECT * FROM organizador";

    try {
      PreparedStatement pstmt = conn.prepareStatement(queryOrganizadorData);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        Organizador organizador = new Organizador();

        organizador.setId(rs.getInt("id"));
        organizador.setNome(rs.getString("nome"));
        organizador.setCurso(rs.getString("curso"));
        organizador.setEmail(rs.getString("email"));
        organizador.setSenha(rs.getString("senha"));
        organizador.setNumTorneiosCriados(rs.getInt("numTorneiosCriados"));

        res.add(organizador);
      }
      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return res;
  }

  public void updateOrganizador(Organizador o) {
    Connection conn = connect();

    String sql = "UPDATE organizador SET " 
      + "nome = ?," 
      + "email = ?," 
      + "curso = ?,"
      + "senha = ?,"
      + "numTorneiosCriados = ? "
      + "WHERE id = ?";
    
     try {
       PreparedStatement pstmt = conn.prepareStatement(sql);

       pstmt.setString(1, o.getNome());
       pstmt.setString(2, o.getEmail());
       pstmt.setString(3, o.getCurso());
       pstmt.setString(4, o.getSenha());
       pstmt.setInt(5, o.getNumTorneiosCriados());
       pstmt.setInt(6, o.getId());

       pstmt.executeUpdate();

       conn.close();
     } catch(SQLException e) {
       System.out.println(e.getMessage());
     }

  }

  public void deleteOrganizador(int id) {
    Connection conn = connect();

    String sql = "DELETE FROM TABLE organizador WHERE id = ?";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void createParticipante(Participante participante) {
    Connection conn = connect();

    String sql = "INSERT INTO participante("
        + "id,"
        + "nome,"
        + "curso,"
        + "email,"
        + "senha,"
        + "numVitorias,"
        + "numDerrotas,"
        + "capotesRecebidos,"
        + "capotesAplicados,"
        + "numTorneiosJogados,"
        + "numTorneiosVencidos"
        + ") VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, participante.getId());
      pstmt.setString(2, participante.getNome());
      pstmt.setString(3, participante.getCurso());
      pstmt.setString(4, participante.getEmail());
      pstmt.setString(5, participante.getSenha());
      pstmt.setInt(6, participante.getNumVitorias());
      pstmt.setInt(7, participante.getNumDerrotas());
      pstmt.setInt(8, participante.getCapotesRecebidos());
      pstmt.setInt(9, participante.getCapotesAplicados());
      pstmt.setInt(10, participante.getNumTorneiosJogados());
      pstmt.setInt(11, participante.getNumTorneiosVencidos());

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public Participante findParticipante(int id) {
    Connection conn = connect();

    Participante participante = new Participante();

    String sql = "SELECT * FROM participante WHERE id = ?";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      ResultSet rs = pstmt.executeQuery();

      participante.setId(rs.getInt("id"));
      participante.setNome(rs.getString("nome"));
      participante.setEmail(rs.getString("email"));
      participante.setCurso(rs.getString("curso"));
      participante.setSenha(rs.getString("senha"));
      participante.setNumVitorias(rs.getInt("numVitorias"));
      participante.setNumDerrotas(rs.getInt("numDerrotas"));
      participante.setCapotesAplicados(rs.getInt("capotesAplicados"));
      participante.setCapotesRecebidos(rs.getInt("capotesRecebidos"));
      participante.setNumTorneiosJogados(rs.getInt("numTorneiosJogados"));
      participante.setNumTorneiosVencidos(rs.getInt("numTorneiosVencidos"));

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return participante;
  }

  public ArrayList<Participante> findAllParticipante() {
    Connection conn = connect();

    ArrayList<Participante> res = new ArrayList<>();

    String sql = "SELECT * FROM participante";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        Participante participante = new Participante();

        participante.setId(rs.getInt("id"));
        participante.setNome(rs.getString("nome"));
        participante.setEmail(rs.getString("email"));
        participante.setCurso(rs.getString("curso"));
        participante.setSenha(rs.getString("senha"));
        participante.setNumVitorias(rs.getInt("numVitorias"));
        participante.setNumDerrotas(rs.getInt("numDerrotas"));
        participante.setCapotesAplicados(rs.getInt("capotesAplicados"));
        participante.setCapotesRecebidos(rs.getInt("capotesRecebidos"));
        participante.setNumTorneiosJogados(rs.getInt("numTorneiosJogados"));
        participante.setNumTorneiosVencidos(rs.getInt("numTorneiosVencidos"));

        res.add(participante);
      }

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return res;
  }

  public void updateParticipante(Participante p) {
    Connection conn = connect();

    String sql = "UPDATE partida SET " 
      + "nome = ?," 
      + "email = ?," 
      + "curso = ?,"
      + "senha = ?,"
      + "numVitorias = ?,"
      + "numDerrotas = ?,"
      + "capotesAplicados = ?,"
      + "capotesRecebidos = ?,"
      + "numTorneioJogados = ?,"
      + "numTorneiosVencidos = ? "
      + "WHERE id = ?";
    
     try {
       PreparedStatement pstmt = conn.prepareStatement(sql);

       pstmt.setString(1, p.getNome());
       pstmt.setString(2, p.getEmail());
       pstmt.setString(3, p.getCurso());
       pstmt.setString(4, p.getSenha());
       pstmt.setInt(5, p.getNumVitorias());
       pstmt.setInt(6, p.getNumDerrotas());
       pstmt.setInt(7, p.getCapotesAplicados());
       pstmt.setInt(8, p.getCapotesRecebidos());
       pstmt.setInt(9, p.getNumTorneiosJogados());
       pstmt.setInt(10, p.getNumTorneiosVencidos());
       pstmt.setInt(11, p.getId());

       pstmt.executeUpdate();

       conn.close();
     } catch(SQLException e) {
       System.out.println(e.getMessage());
     }
  }

  public void deleteParticipante(int id) {
    Connection conn = connect();

    String sql = "DELETE FROM TABLE participante WHERE id = ?";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void createPartida(Partida partida, int torneio_id) {
    Connection conn = connect();

    String sql = "INSERT INTO partida("
        + "id,"
        + "torneio_id,"
        + "primeiroJogador_id,"
        + "segundoJogador_id"
        + ") VALUES(?,?,?,?)";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, partida.getId());
      pstmt.setInt(2, torneio_id);
      pstmt.setInt(3, partida.getP1().getId());
      pstmt.setInt(4, partida.getP2().getId());

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public Partida findPartida(int id) {
    Connection conn = connect();

    Partida partida = new Partida();

    String sql = "SELECT * FROM partida WHERE id = ?";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      ResultSet rs = pstmt.executeQuery();

      partida.setId(rs.getInt("id"));

      Participante p1 = findParticipante(rs.getInt("primeiroJogador_id"));
      Participante p2 = findParticipante(rs.getInt("segundoJogador_id"));

      partida.setP1(p1);
      partida.setP2(p2);

      partida.setCapote(rs.getInt("capote") == 1 ? true : false);

      ArrayList<Integer> Resultado = new ArrayList<>();

      Resultado.add(rs.getInt("primeiroJogadorPontuacao"));
      Resultado.add(rs.getInt("segundoJogadorPontuacao"));

      partida.setResultado(Resultado);
      
      conn.close(); 
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return partida;
  }

  public void updatePartidaResultado(int id_partida, int p1pontos, int p2pontos, boolean capote) {
    Connection conn = connect();

    String sql = "UPDATE partida SET primeiroJogadorPontuacao = ?, segundoJogadorPontuacao = ?, capote = ? WHERE id = ?";
    
   try {
     PreparedStatement pstmt = conn.prepareStatement(sql);

     pstmt.setInt(1, p1pontos);
     pstmt.setInt(2, p2pontos);
     pstmt.setInt(3, capote ? 1 : 0);
     pstmt.setInt(4, id_partida);

     pstmt.executeUpdate();

     conn.close();
   } catch(SQLException e) {
     System.out.println(e.getMessage());
   }
  }

  public void deletePartida(int id) {
    Connection conn = connect();

    String sql = "DELETE FROM partida WHERE id = ?";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, id);

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    
  
  }

  public void inscreverEmTorneio(int participante_id, int torneio_id) {
    Connection conn = connect();

    String sql = "INSERT INTO inscricao("
        + "participante_id,"
        + "torneio_id"
        + ") VALUES(?,?)";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, participante_id);
      pstmt.setInt(2, torneio_id);

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void criarTorneio(int organizador_id, int torneio_id) {
    Connection conn = connect();

    String sql = "INSERT INTO criarTorneio("
        + "organizador_id,"
        + "torneio_id"
        + ") VALUES(?,?)";

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, organizador_id);
      pstmt.setInt(2, torneio_id);

      pstmt.executeUpdate();

      conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }


  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws ClassNotFoundException {
    resetDB();
    // Torneio torn = findTorneio(1);
    //
    // System.out.println(torn.getNome());
    // System.out.println(torn.organizador.getNome());
  }
}

// class PartidaService {
// public static void createPartida(Partida partida, int torneio_id, int
// primeioJogador_id, int segundoJogador_id) {
// ConnectDB.createPartida(partida, torneio_id, primeioJogador_id,
// segundoJogador_id);
// }
//
// public static void findOnePartida() {
//
// }
//
// public static void findAllPartida() {}
//
// public static void addPatidaResult() {}
//
// public static void deletePartida() {}
// }