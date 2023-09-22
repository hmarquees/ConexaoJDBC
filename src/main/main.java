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

        while (menu != 0) {
            System.out.println("\n[1] Usuário\n[2] Produto\n[0] Sair\nInforme a opção desejada: ");
            menu = ler.nextInt();
        
            switch (menu) {
                
                case 1:
                    int opcao_usuario = 99;

                    System.out.print("[1] Cadastrar usuario\n[2] Consultar usuario\n[3] Atualizar usuário\n[4] Excluir usuário\nInforme a opção desejada: ");
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
                    
                    } else if (opcao_usuario == 2) {

                        System.out.print("Informe o CPF no formato '000.000.000-00': ");
                        pessoa.setCpf(ler.next());

                        usuario.consultar_usuario(pessoa);

                        System.out.println("\n\nCPF: " + pessoa.getCpf()
                                    + "\nNome: " + pessoa.getNome()
                                    + "\nEmail: " + pessoa.getEmail()
                                    + "\nSenha: " + pessoa.getSenha());
                    } else if (opcao_usuario == 3) {
                        System.out.println("Informe o CPF no formato '000.000.000-00': ");
                        pessoa.setCpf(ler.next());

                        System.out.println("Informe o novo nome do usuário: ");
                        pessoa.setNome(ler.next());

                        System.out.println("Informe o novo e-mail do usuário: ");
                        pessoa.setEmail(ler.next());

                        System.out.println("Informe a nova senha do usuário: ");
                        pessoa.setSenha(ler.next());

                        usuario.atualizar_usuario(pessoa);
                    } else if (opcao_usuario == 4) {
                        System.out.println("Informe o CPF no formato '000.000.000-00': ");
                        pessoa.setCpf(ler.next());

                        usuario.excluir_usuario(pessoa);
                    }
                    break;

                case 2:

                    int opcao_produto = 99;

                    System.out.print("[1] Cadastrar produto\n[2] Consultar produto\n[3] Atualizar produto\n[4] Excluir produto\nInforme a opção desejada: ");
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

                        produtoDAO.consultar_produto(produto);

                        System.out.println("\n\nCódigo: " + produto.getCodigo()
                                    + "\nDescrição: " + produto.getDescricao()
                                    + "\nValor: R$" + produto.getValor());
                    } else if (opcao_produto == 3) {
                        System.out.println("Informe o código do produto: ");
                        produto.setCodigo(ler.nextInt());

                        ler.nextLine();
                        System.out.println("Informe a nova descrição do produto: ");
                        produto.setDescricao(ler.nextLine());

                        System.out.println("Informe o novo valor do produto: ");
                        produto.setValor(ler.nextDouble());

                        produtoDAO.atualizar_produto(produto);
                    } else if (opcao_produto == 4) {
                        System.out.println("Informe o código do produto que deseja excluir: ");
                        produto.setCodigo(ler.nextInt());
                        
                        produtoDAO.excluir_produto(produto);
                    }
                    break;
                
                case 0:
                    System.exit(0);
                
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
        ler.close();
    }
}
