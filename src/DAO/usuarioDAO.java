package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.usuario;
import db.conexao;

public class usuarioDAO {
    usuario u1;
        
    public void cadastrar_usuario (usuario usuario) {
        String query = "INSERT INTO usuario (cpf, nome, email, senha) VALUES (?, ?, ?, ?)"; 
        this.u1 = usuario;
        conexao nova_conexao = new conexao();
        Connection conectar = nova_conexao.getConexao();
        PreparedStatement preparar = null;
        
        try {
            preparar = conectar.prepareStatement(query);
            preparar.setString(1, usuario.getCpf());
            preparar.setString(2, usuario.getNome());
            preparar.setString(3, usuario.getEmail());
            preparar.setString(4, usuario.getSenha());
            preparar.execute();
        } catch (SQLException erro_cadastrar_usuario) {
            System.out.println("Erro ao cadastrar usuário no banco de dados!\n" + erro_cadastrar_usuario.getMessage());
        }
    }

    public void consultar_usuario(usuario usuario) {
        //usuario pessoa1 = new usuario();
        String query = "SELECT cpf, nome, email, senha FROM usuario WHERE cpf = '" + usuario.getCpf() + "'";

        conexao nova_conexao = new conexao();
        Connection conectar = nova_conexao.getConexao();
        
        try {
        
            // Procedimentos para obter os dados de uma tabela
            java.sql.Statement stmt = conectar.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
        
		    while (resultado.next()) {
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setSenha(resultado.getString("senha"));
		    }
            
        } catch (SQLException erro_consulta_usuario) {
            System.out.println("Erro ao consultar o usuario: " + erro_consulta_usuario.getMessage());
            //erro_consulta_usuario.printStackTrace();
        }

    }
}
