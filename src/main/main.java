package main;

import java.util.Scanner;

import DAO.produtoDAO;
import DAO.usuarioDAO;
import entity.produto;
import entity.usuario;

public class main {
    
    public static void main (String[] args) {

        Scanner ler = new Scanner(System.in);
        usuario pessoa = new usuario();
        produto produto = new produto();
        usuarioDAO usuario = new usuarioDAO();
        produtoDAO produtoDAO = new DAO.produtoDAO();
        int menu=99;

        System.out.println("[1] Usuário\n[2] Produto\nInforme a opção desejada: ");
        menu = ler.nextInt();

        switch (menu) {
            
            case 1:
                int opcao_usuario = 3;

                System.out.print("[1] Cadastrar usuario\n[2] Consultar usuario\nInforme a opção desejada: ");
                opcao_usuario = ler.nextInt();

                if (opcao_usuario == 1) {
                    
                    System.out.print("Informe o cpf do usuário: ");
                    pessoa.setCpf(ler.next());

                    System.out.print("Informe o nome do usuário: ");
                    pessoa.setNome(ler.next());

                    System.out.print("Informe o email do usuário: ");
                    pessoa.setEmail(ler.next());

                    System.out.print("Informe a senha do usuário: ");
                    pessoa.setSenha(ler.next());

                    usuario.cadastrar_usuario(pessoa);
                
                }  else if (opcao_usuario == 2) {

                    System.out.print("Informe o CPF no formato '000.000.000-00': ");
                    pessoa.setCpf(ler.next());

                    usuario.consultar_usuario(pessoa);

                    System.out.print("\n\nCPF: " + pessoa.getCpf()
                                + "\nNome: " + pessoa.getNome()
                                + "\nEmail: " + pessoa.getEmail()
                                + "\nSenha: " + pessoa.getSenha());
                }
                break;

            case 2:

                int opcao_produto = 3;

                System.out.print("[1] Cadastrar produto\n[2] Consultar produto\nInforme a opção desejada: ");
                opcao_produto = ler.nextInt();

                if (opcao_produto == 1) {
                    ler.nextLine();
                    System.out.print("Informe a decrição do produto: ");
                    produto.setDescricao(ler.nextLine());

                    System.out.print("Informe valor do produto: ");
                    produto.setValor(ler.nextDouble());

                    produtoDAO.cadastrar_produto(produto);
                } else if (opcao_produto == 2) {
                    System.out.print("Informe o código do produto: ");
                    produto.setCodigo(ler.nextInt());

                    produto.consultar_produto(produto);

                    System.out.print("\n\nCódigo: " + produto.getCodigo()
                                + "\nDescrição: " + produto.getDescricao()
                                + "\nValor: R$" + produto.getValor();
                }
                break;

        }
        
        ler.close();
    }
}
