package miniProjeto;

public class ListaDuplamenteEncadeadaNoCabeça implements TListaMiniProjeto{

	private TNo inicio;

	public ListaDuplamenteEncadeadaNoCabeça() {
		this.inicio = new TNo(null);
	}

	@Override
	public void add(String s) throws Exception {
		TNo novo = new TNo(s);
		if(inicio.proximo == null) {
			inicio.proximo = novo;
			novo.anterior = inicio;
			return;
		}
		TNo aux = inicio.proximo;

		while (aux.proximo != null) {
			if(s.equals(aux.dado))
				throw new Exception("Elemento repetido !");
			aux = aux.proximo;
		}
		aux.proximo = novo;
		novo.anterior = aux;

	}

	@Override
	public void add(String s, int i) throws Exception {
		if(i < 0 || i >= size()) {
			throw new Exception("Indice invalido !");
		}
		TNo aux = inicio.proximo;
		
		while(aux != null) {
			if(s.equals(aux.dado))
				throw new Exception("Elemento repetido !");	
			aux = aux.proximo;
		}
		TNo novo = new TNo(s);
		if(i == 0) {
			novo.proximo = inicio.proximo;
			if(inicio.proximo != null) {
				inicio.proximo.anterior = novo;
			}
			inicio.proximo = novo;
			novo.anterior = inicio.proximo;
			return;
		}

		aux = inicio.proximo;
		for(int j = 1;j<i;j++) {
			aux = aux.proximo;		
		}
		novo.proximo = aux.proximo;
		if (aux.proximo != null) {
			aux.proximo.anterior = novo;
		}
		aux.proximo = novo;
		novo.anterior = aux;

	}

	@Override
	public String removeIndex(int i) throws Exception {
		if(inicio.proximo == null)
			throw new Exception("Lista vazia!");
		TNo lixo = null;
		if(i == 0) {
			lixo = inicio.proximo;
			inicio.proximo = lixo.proximo;
			return lixo.dado;
		}
		TNo aux = inicio.proximo;
		for(int j = 0;j<i;j++) {
			aux = aux.proximo;
		}
		lixo = aux;
		if (aux.proximo != null) {
			aux.proximo.anterior = aux.anterior;
		}

		aux.anterior.proximo = aux.proximo;
		return lixo.dado;
	}

	@Override
	public void removeElem(String s) throws Exception {
		if(inicio.proximo == null)
			throw new Exception("Lista vazia !");
		int cont = 0;
		TNo aux = inicio.proximo;
		while(aux != null) {
			if(s.equals(aux.dado)) {
				removeIndex(cont);
				break;
			}
			aux = aux.proximo;
			cont++;
		}

	}

	@Override
	public String previous(String s) throws Exception {
		if(s.equals(inicio.proximo))
			return null;
		TNo aux = inicio.proximo;
		while(aux != null) {
			if(s.equals(aux.dado)) {
				return aux.anterior.dado;
			}
			aux = aux.proximo;
		}
		throw new Exception("Elemento não encontrado!");
	}

	@Override
	public int index(String s) throws Exception {
		TNo aux = inicio.proximo;
		int cont = 0;
		while(aux != null) {
			if(s.equals(aux.dado)) {
				return cont;
			}
			aux = aux.proximo;
			cont++;
		}
		throw new Exception("Elemento não encontrado!");
	}

	@Override
	public String elemen(int i) throws Exception {
		if(i < 0 || i >= size())
			throw new Exception("Indice invalido !");
		TNo aux = inicio.proximo;
		for(int j = 0;j<i;j++) {
			aux = aux.proximo;
		}
		return aux.dado;
	}

	@Override
	public int size() {
		TNo aux = inicio.proximo;
		int cont = 0;
		while(aux != null) {
			aux = aux.proximo;
			cont++;
		}
		return cont;
	}

	@Override
	public String first() {
		if(inicio.proximo == null)
			return null;
		return inicio.proximo.dado;
	}

	@Override
	public String last() {
		if(inicio.proximo == null)
			return null;
		TNo aux = inicio.proximo;
		while(aux.proximo != null) {
			aux = aux.proximo;
		}
		return aux.dado;
	}

	@Override
	public String maior() {
		if (inicio.proximo == null)
	        return null;
	    TNo aux = inicio.proximo;
	    String maior = aux.dado;	    
	    while(aux.proximo != null) {	    		    	    		
	    	
	    		if(aux.proximo.dado.compareTo(maior) > 0)
	    			maior = aux.proximo.dado;
	    		aux = aux.proximo;
	    	}
	    return maior;
	}

	@Override
	public void print() {
		System.out.print("Lista -> ");
		TNo aux = inicio.proximo;
		while(aux != null) {
			System.out.print(aux.dado+" -> ");
			aux = aux.proximo;		
		}
		System.out.println(" Nuul");

	}
}
