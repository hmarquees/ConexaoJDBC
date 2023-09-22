package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.conexao;
import entity.produto;

public class produtoDAO {

    public void cadastrar_produto(produto produto) {
        String query = "INSERT INTO produto (descricao, preco) VALUES (?, ?)"; 
        
        //realiza a conexão com o banco de dados e cria o objeto preparar para "preparar" e executar a query no banco
        conexao nova_conexao = new conexao();
        Connection conectar = nova_conexao.getConexao();
        PreparedStatement preparar = null;
        
        //prepara a query e tenta executar no banco de dados, caso não consiga, retorna o erro no com SQLException
        try {
            preparar = conectar.prepareStatement(query);
            preparar.setString(1, produto.getDescricao());
            preparar.setDouble(2, produto.getValor());
            preparar.execute();
            System.out.println("Produto cadastrado!");
        } catch (SQLException erro_cadastrar_produto) {
            System.out.println("Erro ao cadastrar usuário no banco de dados!\n" + erro_cadastrar_produto.getMessage());
        }
    }

    public void consultar_produto(produto produto) {
        
        String query = "SELECT descricao, preco FROM produto WHERE codigo = '" + produto.getCodigo() + "'";

        //realiza a conexão com o banco de dados
        conexao nova_conexao = new conexao();
        Connection conectar = nova_conexao.getConexao();
        
        try {
            // Procedimentos para obter os dados de uma tabela
            java.sql.Statement stmt = conectar.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
        
		    while (resultado.next()) {
                produto.setDescricao(resultado.getString("descricao"));
                produto.setValor(resultado.getDouble("preco"));
		    } 
        } catch (SQLException erro_consulta_produto) {
            System.out.println("Erro ao consultar o produto: " + erro_consulta_produto.getMessage());
        }
    }

    public void atualizar_produto(produto produto) {
        String query = "UPDATE produto SET descricao = ?, preco = ? WHERE codigo = ?";
    
        //realiza a conexão com o banco de dados e cria o objeto preparar para "preparar" e executar a query no banco
        conexao nova_conexao = new conexao();
        Connection conectar = nova_conexao.getConexao();
        PreparedStatement preparar = null;

        try {
            preparar = conectar.prepareStatement(query);
            preparar.setString(1, produto.getDescricao());
            preparar.setDouble(2, produto.getValor());
            preparar.setInt(3, produto.getCodigo());
            preparar.execute();
            System.out.println("Produto atualizado!");
        } catch (SQLException erro_atualizar_produto) {
            System.out.println("Erro ao atualizar produto.\n" + erro_atualizar_produto.getMessage());
        }
    }

    public void excluir_produto(produto produto) {
        String query = "DELETE FROM produto WHERE codigo = ?";

        conexao nova_conexao = new conexao();
        Connection conectar = nova_conexao.getConexao();
        PreparedStatement preparar = null;

        try {
            preparar = conectar.prepareStatement(query);
            preparar.setInt(1, produto.getCodigo());
            preparar.execute();
            System.out.println("Produto excluído!");
        } catch (SQLException erro_excluir_produto) {
            System.out.println("Erro ao excluir o produto!\n" + erro_excluir_produto.getMessage());
        }
    }
}
