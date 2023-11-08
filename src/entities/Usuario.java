package entities;

public class Usuario {

	private String nomeCompleto;
	private String email;
	private int idade;
	private double altura;
	
	public Usuario() {}

	public Usuario(String nomeCompleto, String email, int idade, double altura) {
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.idade = idade;
		this.altura = altura;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return nomeCompleto + "\n"
			   + email + "\n"
			   + idade + "\n"
			   + altura;
			
	}
	
	
	
}