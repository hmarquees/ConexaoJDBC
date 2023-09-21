package main;

import java.util.Scanner;

import DAO.produtoDAO;
import DAO.usuarioDAO;
import entity.produto;
import entity.usuario;

public class main {
    
    public static void main (String[] args) {

        Scanner ler = new Scanner(System.in);
        usuario pessoa1 = new usuario();
        produto produto = new produto();
        usuarioDAO usuario = new usuarioDAO();
        produtoDAO produtoDAO = new DAO.produtoDAO();
        int menu=99;

        System.out.println("[1] Usuário\n[2] Produto\nInforme a opção desejada: ");
        menu = ler.nextInt();

        switch (menu) {
            
            case 1:
                int opcao = 3;

                System.out.print("[1] Cadastrar usuario\n[2] Consultar usuario\nInforme a opção desejada: ");
                opcao = ler.nextInt();

                if (opcao == 1) {
                    
                    System.out.print("Informe o cpf do usuário: ");
                    pessoa1.setCpf(ler.next());

                    System.out.print("Informe o nome do usuário: ");
                    pessoa1.setNome(ler.next());

                    System.out.print("Informe o email do usuário: ");
                    pessoa1.setEmail(ler.next());

                    System.out.print("Informe a senha do usuário: ");
                    pessoa1.setSenha(ler.next());

                    usuario.cadastrar_usuario(pessoa1);
                
                }  else if (opcao == 2) {

                    System.out.print("Informe o CPF no formato '000.000.000-00': ");
                    pessoa1.setCpf(ler.next());

                    usuario.consultar_usuario(pessoa1);

                    System.out.print("\n\nCPF: " + pessoa1.getCpf()
                                + "\nNome: " + pessoa1.getNome()
                                + "\nEmail: " + pessoa1.getEmail()
                                + "\nSenha: " + pessoa1.getSenha());
                }
                break;

            case 2:
                ler.nextLine();
                System.out.print("Informe a decrição do produto: ");
                produto.setDescricao(ler.nextLine());

                System.out.print("Informe valor do produto: ");
                produto.setValor(ler.nextDouble());

                produtoDAO.cadastrar_produto(produto);


        }
        
        ler.close();
    }
}
