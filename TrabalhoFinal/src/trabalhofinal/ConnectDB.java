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
public class ConnectDB {
     public static Connection connect() {  
        Connection conn = null;  
        // db parameters  
        String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/sinuqueiro.db";  

        try {
            // create a connection to the database
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);  
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }   

    public void dropTables() {
      Connection conn = connect();

      String dropCriarTorneio = "DROP TABLE criarTorneio";

      String dropInscricao = "DROP TABLE inscricao";

      String dropResultado = "DROP TABLE resultado";
      
      String dropPartida = "DROP TABLE partida";

      String dropTorneio = "DROP TABLE torneio";

      String dropParticipante = "DROP TABLE participante";

      String dropOrganizador = "DROP TABLE organizador";

      try {
          Statement stmt = conn.createStatement();
          // create a new table
          stmt.execute(dropCriarTorneio);
          stmt.execute(dropInscricao);
          stmt.execute(dropResultado);
          stmt.execute(dropPartida);
          stmt.execute(dropTorneio);
          stmt.execute(dropParticipante);
          stmt.execute(dropOrganizador);
      } catch(SQLException e) {
          System.out.println(e.getMessage());
      }
    }

    public void createTables() {
        Connection conn = connect();

        String ParticipanteTable = "CREATE TABLE IF NOT EXISTS participante (\n"
                                 + "	id integer PRIMARY KEY,\n"
                                 + "    nome text NOT NULL,\n"
                                 + "    curso text NOT NULL,\n"
                                 + "    email text UNIQUE NOT NULL,\n"
                                 + "    senha text NOT NULL,\n"
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


        String ResultadosTable = "CREATE TABLE IF NOT EXISTS resultado (\n"
                               + "    id integer PRIMARY KEY AUTOINCREMENT,\n"
                               + "    partidaId integer NOT NULL,\n"
                               + "    potuacaoJogador1 integer NOT NULL,\n"
                               + "    pontuacaoJogador2 integer NOT NULL,\n"
                               + "    ordem integer NOT NULL,\n"
                               + "    capote integer NOT NULL,\n"
                               + "    FOREIGN KEY (partidaId)\n"
                               + "        REFERENCES partida (id)\n"
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
                            + "    periodoInscricao integer NOT NULL\n"
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
            stmt.execute(ResultadosTable);
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
                   + "tipo"
                   + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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

            pstmt.executeUpdate();
     
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
            pstmt.setInt(6,organizador.getNumTorneiosCriados());

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
      } catch(SQLException e) {
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

          while(rs.next()) { 
            Organizador organizador = new Organizador();

            organizador.setId(rs.getInt("id"));
            organizador.setNome(rs.getString("nome"));
            organizador.setCurso(rs.getString("curso"));
            organizador.setEmail(rs.getString("email"));
            organizador.setSenha(rs.getString("senha"));
            organizador.setNumTorneiosCriados(rs.getInt("numTorneiosCriados"));

            res.add(organizador);
          }
      } catch(SQLException e) {
        System.out.println(e.getMessage());
      }

      return res;
    }

    public void DeleteOrganizador(int id) {
      Connection conn = connect();

      String sql = "DELETE FROM TABLE organizador WHERE id = ?";

      try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        pstmt.executeQuery();

        conn.close();
      } catch(SQLException e) { 
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
        participante.setNumTorneiosJogados(rs.getInt("numToneiosJogados"));
        participante.setNumTorneiosVencidos(rs.getInt("numToneiosVencidos"));

        conn.close();
      } catch(SQLException e) { 
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

        while(rs.next()) {
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
          participante.setNumTorneiosJogados(rs.getInt("numToneiosJogados"));
          participante.setNumTorneiosVencidos(rs.getInt("numToneiosVencidos"));

          res.add(participante);
        }

        conn.close();
      } catch(SQLException e) { 
        System.out.println(e.getMessage()); 
      }

      return res;
    }

    public void deleteParticipante(int id) {
      Connection conn = connect();

      String sql = "DELETE FROM TABLE participante WHERE id = ?";

      try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        pstmt.executeQuery();

        conn.close();
      } catch(SQLException e) { 
        System.out.println(e.getMessage()); 
      }
    }

    public void createPartida(Partida partida, 
                                    int torneio_id, 
                                    int primeioJogador_id, 
                                    int segundoJogador_id) {
        Connection conn = connect();
        
        String sql = "INSERT INTO partida("
                   + "id,"
                   + "torneio_id,"
                   + "primeiroJogador_id,"
                   + "segundoJogador_id,"
                   + ") VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, partida.getId());
            pstmt.setInt(2, torneio_id);
            pstmt.setInt(3, primeioJogador_id);
            pstmt.setInt(4, segundoJogador_id);

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
      } catch(SQLException e) {
        System.out.println(e.getMessage());
      }

      return partida;
    }

    public void createResultado(int[] pontuacao, int partidaId, int ordem, boolean capote) {
        Connection conn = connect();
        
        String sql = "INSERT INTO partida("
                   + "partidaId,"
                   + "pontuacaoJogador1,"
                   + "pontuacaoJogador2,"
                   + "ordem,"
                   + "capote"
                   + ") VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, partidaId);
            pstmt.setInt(2, pontuacao[0]);
            pstmt.setInt(3, pontuacao[1]);
            pstmt.setInt(4, ordem);
            pstmt.setInt(5, capote ? 1 : 0);

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
                   + "organizador,"
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

          while(rs.next()) {
            Torneio torneio;

            if(rs.getInt("tipo") == 0) {
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

            String queryOrganizadorId = "SELECT * FROM criarTorneio WHERE torneio_id = ?";

            PreparedStatement relPstmt = conn.prepareStatement(queryOrganizadorId);
            relPstmt.setInt(1, torneio.getId());

            ResultSet relRs = relPstmt.executeQuery();

            int organizadorId = relRs.getInt("organizador_id");

            String queryOrganizadorData = "SELECT * FROM organizador WHERE id = ?";

            PreparedStatement orgPstmt = conn.prepareStatement(queryOrganizadorData);
            orgPstmt.setInt(1, organizadorId);  

            ResultSet orgRs = pstmt.executeQuery();

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
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }

      return res;
    }

    public ArrayList<Participante> findAllTorneioParticipante(int torneio_id) {
      Connection conn = connect();

      ArrayList<Participante> res = new ArrayList<>();

      String sql = "SELECT * FROM inscricao WHERE torneio_id = ?";

      try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, torneio_id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
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
          participante.setNumTorneiosJogados(rSet.getInt("numToneiosJogados"));
          participante.setNumTorneiosVencidos(rSet.getInt("numToneiosVencidos"));

          res.add(participante);
        }
      } catch(SQLException e) {
          System.out.println(e.getMessage());
      }

      return res;
    }

    public void deleteTorneio(int id) {
      Connection conn = connect();

      String sql = "DELETE FROM TABLE torneio WHERE id = ?";

      try {
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, id);

        pstmt.executeQuery();
      } catch(SQLException e) {
          System.out.println(e.getMessage());
      }
    }

    public void resetDB() {
      dropTables();
      createTables();
    }


    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) throws ClassNotFoundException {        
      // resetDB();
      // Torneio torn = findTorneio(1);
      //
      // System.out.println(torn.getNome());
      // System.out.println(torn.organizador.getNome());
    }  
}

// class PartidaService {
//   public static void createPartida(Partida partida, int torneio_id, int primeioJogador_id, int segundoJogador_id) {
//     ConnectDB.createPartida(partida, torneio_id, primeioJogador_id, segundoJogador_id); 
//   }
//
//   public static void findOnePartida() {
//
//   }
//
//   public static void findAllPartida() {}
//
//   public static void addPatidaResult() {}
//
//   public static void deletePartida() {}
// }
