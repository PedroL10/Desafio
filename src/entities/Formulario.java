package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Formulario {
	
	Scanner sc = new Scanner(System.in);
	String sourceFileStr = "src//formulario.txt";	
	
	private List<Pergunta> perguntas = new ArrayList<>();
	
	public Formulario () {};

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}		
	
	public void lerFormulario() {
		   try (BufferedReader reader = new BufferedReader(new FileReader("src//formulario.txt"))) {
	            String linha;
	        

	            while ((linha = reader.readLine()) != null) {
	                System.out.println(linha);
	                Pergunta p = new Pergunta(linha);
	                perguntas.add(p);
	                
	                
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public void adicionaPergunta(Pergunta textoPergunta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFileStr, true))) {        		
        	int contador = perguntas.size();        
        		System.out.print("Digite a pergunta a ser adicionada:");
        		String pergunta = sc.nextLine();			
				bw.write((contador+1) + " - " + pergunta);  	
				System.out.println(contador);
				contador++;			
				bw.newLine();            
			System.out.println("Formulario atualizado !");	            				
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}	               
        
		perguntas.add(textoPergunta);
	}
	
	public void removerPergunta(int index) {
		   try (BufferedReader reader = new BufferedReader(new FileReader("src//formulario.txt"))) {
	                  
	            
	            if(index > 4) {
	            	
	            	perguntas.remove(index - 1);
	            	
	            	 
	            } else {
	            	System.out.println("Nao e possivel apagar as quatro perguntas iniciais");
	            }

	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}