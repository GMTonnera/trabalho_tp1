/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.sql.*;

/**
 *
 * @author Vini
 */
public class ConnectDB {
     public static Connection connect() {  
        Connection conn = null;  
        // db parameters  
        String url = "jdbc:sqlite:C:\\trabalho\\TrabalhoFinal\\src\\db\\sinuqueiro.db";  

        try {
            // create a connection to the database
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);  
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }   

    public static void createTables() {
        Connection conn = connect();

        String ParticipanteTable = "CREATE TABLE IF NOT EXISTS participante (\n"
                                 + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
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
                                + "    id integer PRIMARY KEY AUTOINCREMENT,\n"
                                + "    nome text NOT NULL,\n"
                                + "    curso text NOT NULL,\n"
                                + "    email text UNIQUE NOT NULL,\n"
                                + "    senha text NOT NULL,\n"
                                + "    numTorneiosCriados integer\n"
                                + ");";

        String PartidaTable = "CREATE TABLE IF NOT EXISTS partida (\n"
                            + "    id integer PRIMARY KEY AUTOINCREMENT,\n"
                            + "    numjogos integer NOT NULL,\n"
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
                            + "    id integer PRIMARY KEY AUTOINCREMENT,\n"
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
    
    public static void createPartici(Torneio torneio) {
        Connection conn = connect();
        
        String sql = "INSERT INTO torneio("
                   + "maxParticipantes,"
                   + "minParticipantes"
                   + "nome"
                   + "descricao"
                   + "local"
                   + "regras"
                   + "numJogosPartida"
                   + "status"
                   + "dataInicio"
                   + "dataInicioInscricao"
                   + "periodoTorneio"
                   + "periodoInscricao"
                   + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, torneio.getMaxParticipantes());
            pstmt.setInt(2, torneio.getMinParticipantes());
            pstmt.setString(3, torneio.getNome());
            pstmt.setString(4, torneio.getDescricao());
            pstmt.setString(5,torneio.getLocal());
            pstmt.setString(6, torneio.getRegras());
            pstmt.setInt(7, torneio.getNumJogosPartida());
            pstmt.setInt(8, torneio.getStatusTorneio());
     
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }    

    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) throws ClassNotFoundException {  
        connect();  
        createTables();
    }  
}
