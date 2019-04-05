package aula20190405.lista.oo;

public class App {
	
	
	public static void main(String[] args) {
		Cor azul = new Cor(1, "Azul");
		Cor lil�s = new Cor(2,"Lil�s");
		
		ListaDeCor listaCompleta = new ListaDeCor();
		ListaDeCor listaParcial = new ListaDeCor();
		
		//inserirCor(azul, listaCompleta);
		//inserirCor(lil�s, listaCompleta);
		
		listaCompleta.inserirCor(azul);
		listaCompleta.inserirCor(lil�s);
		
		//listaComplesta.cores = new Cor[0];
		
		listaParcial.inserirCor(lil�s);
		
		System.out.println("O tamanho da COMPLETA �: " + listaCompleta.getTamanho());
		System.out.println("O tamanho da PARCIAL �: " + listaParcial.getTamanho());
		
		listaCompleta.listarCores();
		listaParcial.listarCores();
		
	}

}



