package aula20190610.repository_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class App {
	
	public static void main(String[] args) throws Exception{
		/*
		for (int i = 0; i < 1000; i++) {
			long currentTimeMillis = System.currentTimeMillis();
			System.out.println(currentTimeMillis + " � par? " + (currentTimeMillis%2==0));
			
		}
		*/
		
		Cor azul = new Cor(1,"Azul");
		Cor verde = new Cor(2,"Verde");

		CorRepository repo = criarRepositoryAleatoriamente();
		
		repo.incluir(azul);
		repo.incluir(verde);
		
		verde = new Cor(2, "Verde Musgo");
		repo.atualizar(verde); 
		
		listarCores(repo);
		
		repo.excluir(azul.getId());
		
		listarCores(repo);
	}

	
	//DESIGN PATTERN: Factory Method
	private static CorRepository criarRepositoryAleatoriamente() throws Exception {
		CorRepository aleat�rio = null;
		if (System.currentTimeMillis()%2==0) {
			aleat�rio = new CorRepositoryMemory();
		} else {
			Connection conex�o = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/3sadsis2019",
					"postgres",
					"unicesumar");
			aleat�rio = new CorRepositoryJDBC(conex�o);
		}
		return aleat�rio;
	}

	private static void listarCores(CorRepository repo) throws Exception {
		List<Cor> cores = repo.obterTodas();
		
		System.out.println("Listando as cores...");
		for (Cor cor : cores) {
			System.out.println("  " + cor.getNome());
		}
		System.out.println("Fim da listagem.");
	}

}
