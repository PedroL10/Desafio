package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import entities.Usuario;

public class CadastrarUsuario {

	private List<Usuario> usuarios = new ArrayList<>();
	
	public CadastrarUsuario () {};
	
	
	public void cadastrarUsuario (Usuario user) {
		if(validarNovoUsuario(user)) {
			
		usuarios.add(user);
		salvarUsuarioEmArquivo(user);
		System.out.println("Usuario cadastrado com sucesso");
		}		
	}
	
	   private boolean validarNovoUsuario(Usuario user) {
	        // Validações do usuário, como email único, idade mínima, etc.
	        if (user.getEmail() == null || user.getEmail().isEmpty() || !user.getEmail().contains("@")) {
	            System.out.println("Email inválido.");
	            return false;
	        }
	        if (user.getNomeCompleto() == null || user.getNomeCompleto().isEmpty() || user.getNomeCompleto().length() < 10) {
	            System.out.println("Nome inválido. Deve ter pelo menos 10 caracteres.");
	            return false;
	        }
	        if (user.getIdade() <= 18) {
	            System.out.println("Idade inválida. Deve ser maior que 18 anos.");
	            return false;
	        }
	        if (user.getAltura() <= 0) {
	            System.out.println("Altura inválida.");
	            return false;
	        }

	        for (Usuario u : usuarios) {
	            if (u.getEmail().equals(user.getEmail())) {
	                System.out.println("Este email já foi cadastrado.");
	                return false;
	            }
	        }

	        return true;
	    }
	   
	    private void salvarUsuarioEmArquivo(Usuario user) {
	        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(user.getNomeCompleto().toUpperCase() + ".txt")))) {
	            writer.println("1 - " + user.getNomeCompleto());
	            writer.println("2 - " +user.getEmail());
	            writer.println("3 - " +user.getIdade());
	            writer.println("4 - " +user.getAltura());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    public List<String> listarUsuarios() {
	    	List<String> nomes = new ArrayList<>();
	        for (Usuario user : usuarios) {
	        	nomes.add(user.getNomeCompleto());
	        }
	        return nomes;
	    }	    
	
		public Usuario consultaUsuario(String parametro) {
	    	
	    	for(Usuario u : usuarios) {
	    		if(u.getNomeCompleto().contains(parametro) || u.getEmail().contains(parametro) || u.getIdade() == Integer.parseInt(parametro))   	return u;	    		    			
	    			
	    	}
			return null;	    	
	    	
	    }
	
}

















