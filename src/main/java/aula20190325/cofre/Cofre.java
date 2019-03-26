package aula20190325.cofre;

public class Cofre {
	private final int SEM_SENHA = -1;
	private boolean aberto = true;
	private int senha = SEM_SENHA;

	public void fechar(int senha) {
		if (!this.aberto) {
			throw new RuntimeException("Cofre j� est� fechado!");
		}
		aberto = false;		
		this.senha = senha;
	}
	public void abrir(int senha) {
		if (this.aberto) {
			throw new RuntimeException("Cofre j� est� aberto!");
		}
		if (this.senha == senha) {
			aberto = true;
			this.senha = SEM_SENHA;
		} else {
			RuntimeException exce��o = new RuntimeException("Beeeeeep! Senha incorreta!");
			throw exce��o;			
		}
	}
	public boolean isAberto() {
		return aberto;
	}
}
