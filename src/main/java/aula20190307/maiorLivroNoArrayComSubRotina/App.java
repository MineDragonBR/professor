package aula20190307.maiorLivroNoArrayComSubRotina;

public class App {

	public static void main(String[] args) {
		Livro[] livros = criarArrayDeLivros();
		Livro maior = recuperarMaiorLivroDoArray(livros);
		if (maior == null) {
			System.out.println("N�o h� livros para testar!");
		} else {
			System.out.println("O maior livro � " + maior.titulo + " com " + maior.numeroDePaginas + " p�ginas.");
		}
	}

	private static Livro[] criarArrayDeLivros() {
		return new Livro[] { 
				new Livro("B�blia Sagrada", 899), 
				new Livro("Big Java", 100),
				new Livro("UML Applied", 210), 
				new Livro("Software Engineering", 725) };
	}

	public static Livro recuperarMaiorLivroDoArray(Livro[] livros) {
		if (livros == null || livros.length == 0) {
			return null;
		}
		Livro maior = livros[0];
		for (int contador = 0; contador < livros.length; contador++) {
			Livro atual = livros[contador];
			if (atual.numeroDePaginas > maior.numeroDePaginas) {
				maior = atual;
			}
		}
		return maior;
	}

}
