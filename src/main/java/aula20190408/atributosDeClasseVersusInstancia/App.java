package aula20190408.atributosDeClasseVersusInstancia;

public class App {
	private static float vers�o = 1.0f; 
	
	public static void main(String[] args) {		
		Pessoa fulano = new Pessoa();
		Pessoa beltrano = new Pessoa("Beltrano de Almeida",33);
		Pessoa[] maringaenses = new Pessoa[400000];
		for (int i = 0; i < maringaenses.length; i++) {
			maringaenses[i] = new Pessoa("Nome " + i, 33);
			
		}		
		//System.out.println(fulano.getNome());
		//System.out.println(beltrano.getNome());
		App minhaAppzinha = new App();
		minhaAppzinha.exibirPessoaNoConsole(fulano);
		minhaAppzinha.exibirPessoaNoConsole(beltrano);
		System.out.println(App.vers�o);
		
	}
	
	public void exibirPessoaNoConsole(Pessoa p) {
		System.out.println(App.vers�o);
		System.out.println(p.getNome());
	}

}
