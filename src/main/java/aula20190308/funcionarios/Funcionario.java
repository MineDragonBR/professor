package aula20190308.funcionarios;

public class Funcionario {
	protected String nome;
	protected double salario;
	
	//construtor: permite criar objetos do tipo Funcion�rio 
	//passando o nome e o sal�rio como par�metros
	public Funcionario(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}

}
