package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String pass = "";

    private static Connection conectar;

    //contrutor da classe, verifica se o objeto conexao é nulo, se sim, estabelece a conexao através do DriverManager, se não, retorna a conexão existente
    public conexao() {
        try {
            if (conectar == null) {
                conectar = DriverManager.getConnection(url, user, pass);
                System.out.println("Conexão com o banco de dados realizada com sucesso!");
            } else {
                System.out.println("Conexão com o banco de dados realizada com sucesso!");
            }
        } catch (SQLException erro_conectar_banco) {
            System.out.println("Falha ao conectar com o banco de dados!\n" + erro_conectar_banco.getMessage());
        }
    }

    //método para retornar a conexão
    public Connection getConexao() {
        return this.conectar;
    }

    //método sem retorno para finalizar a conexão
    public void finalizar_conexao() {
        try {
            conectar.close();
        } catch (SQLException erro_finalizar_conexao){
            System.out.println("Falha ao finalizar conexão com o banco de dados!\n" + erro_finalizar_conexao.getMessage());
        }
    }
    
}
