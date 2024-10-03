public class No {
	private Personalidade dado;
	private No proximo;
	
	public No(Personalidade dado) {
		this.dado =  dado;
		this.proximo = null;
	}

	public Personalidade obterDado() {
		return dado;
	}

	public void definirDado(Personalidade dado) {
		this.dado = dado;
	}

	public No obterProximo() {
		return proximo;
	}

	public void definirProximo(No proximo) {
		this.proximo = proximo;
	}
	
}