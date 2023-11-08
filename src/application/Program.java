package application;


import java.util.Locale;
import java.util.Scanner;

import entities.Formulario;
import entities.Pergunta;
import entities.Usuario;
import util.CadastrarUsuario;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Formulario form = new Formulario();
		CadastrarUsuario cadastro = new CadastrarUsuario();
		
		form.lerFormulario();
		
		int opcao = 0;
        do {
            System.out.println("Selecione uma opcao:");
            System.out.println("1 - Cadastrar usuario");
            System.out.println("2 - Listar todos usuarios cadastrados");
            System.out.println("3 - Cadastrar nova pergunta no formulario");
            System.out.println("4 - Deletar pergunta do formulario");
            System.out.println("5 - Pesquisar usuario por nome ou idade ou email");
            System.out.println("6 - Perguntas *****teste*******");
            
            
            // ... outras opções do menu

            opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("=== CADASTRO DE USUARIO ===");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String emai = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    System.out.print("Altura: ");
                    double altura = sc.nextDouble();
                    
//                	for(int i =0; i<form.getPerguntas().size(); i++) {
//                		System.out.println(form.getPerguntas().get(i));
//                		
//                	} 
//                 
                    Usuario user = new Usuario(nome, emai, idade, altura);
                    cadastro.cadastrarUsuario(user);
                    
                	System.out.println(user.toString());
                	
                    break;
                case 2:
                    // Lógica para listar usuários cadastrados
                	System.out.println("=== BUSCAR USUARIO ===");
                	System.out.println(cadastro.listarUsuarios());
                    break;
                // ... outras opções do menu
                    
                case 3:
                	//logica para cadastrar nova pergunta no formulario
                	System.out.println("=== NOVA PERGUNTA ===");                	
                	String textoPergunta = sc.nextLine();
                	form.adicionaPergunta(new Pergunta(textoPergunta));                	
                	break;
                	
                case 4:
                	System.out.println("=== DELETAR PERGUNTA ===");
                	System.out.println("Informe o numero da pergunta");
                	int index = sc.nextInt();
                	form.removerPergunta(index);
                	break;
                	
                case 5:
                	System.out.println("=== PESQUISAR USUARIO ===");
                	System.out.print("Informe algum dado do usuario: ");
                	String parametro = sc.nextLine();
                	System.out.println("=== Dados do usuario ===");
                	System.out.println(cadastro.consultaUsuario(parametro));
                	
                case 6:
                	System.out.println("Ver perguntas: ");
                	for(Pergunta Pergunta : form.getPerguntas()) {
                		System.out.println(Pergunta.getTextoPergunta());
                	}
                	break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);		
		
	sc.close();	
  }
}