package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.conexao;
import entity.produto;

public class produtoDAO {

    public void cadastrar_produto (produto produto) {
        String query = "INSERT INTO produto (descricao, preco) VALUES (?, ?)"; 
        
        conexao nova_conexao = new conexao();
        Connection conectar = nova_conexao.getConexao();
        PreparedStatement preparar = null;
        
        try {
            preparar = conectar.prepareStatement(query);
            preparar.setString(1, produto.getDescricao());
            preparar.setDouble(2, produto.getValor());
            preparar.execute();
        } catch (SQLException erro_cadastrar_usuario) {
            System.out.println("Erro ao cadastrar usuário no banco de dados!\n" + erro_cadastrar_usuario.getMessage());
        }
    }
    
}
