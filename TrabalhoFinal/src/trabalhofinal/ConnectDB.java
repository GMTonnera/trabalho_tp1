/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

/**
 *
 * @author Vini
 */
public class ConnectDB {
     public static Connection connect() throws ClassNotFoundException {  
        Connection conn = null;  
        // db parameters  
        String url = "jdbc:sqlite:C:\\trabalho\\TrabalhoFinal\\src\\db\\sinuqueiro.db";  

        try {
            // create a connection to the database
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }   
/*
    public static CreateTables() {
        Connection conn = connect();

        String ParticipanteTable = "CREATE TABLE IF NOT EXISTS participantes (\n"
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
                            + "    numjogos integer NOT NULL\n"
                            + ");";

        String ResultadosTable = "CREAETE TABLE IF NOT EXISTS resultado (\n"
                               + "    id integer PRIMAY KEY AUTOINCREMENT,\n"
                               + "    partidaId integer NOT NULL,\n"
                               + "    potuacaoJogador1 integer NOT NULL,\n"
                               + "    pontuacaoJogador2 integer NOT NULL,\n"
                               + "    ordem integer NOT NULL,\n"
                               + "    capote integer NOT NULL\n"
                               + "    FOREIGN KEY (partidaId)\n"
                               + "        REFERENCES partida (id)\n"
                               + ");";

        String TorneioTable = "CREAETE TABLE IF NOT EXISTS torneio (\n"
                            + "    id integer PRIMAY KEY AUTOINCREMENT,\n"
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
                            + "    dataInicioInscricao text NOT NULL,\n"
                            + "    periodoTorneio integer NOT NULL,\n"
                            + "    periodoInscricao integer NOT NULL\n"
                            + ");";

    }
*/
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) throws ClassNotFoundException {  
        connect();  
    }  
}
