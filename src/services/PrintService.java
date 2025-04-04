package services;

import java.util.ArrayList;
import java.util.List;

/*
  Serviço genérico responsável por armazenar e imprimir elementos de qualquer tipo.
  @param <T> Tipo dos elementos a serem manipulados
*/
public class PrintService<T> {

//	Lista interna que armazena os elementos
	private final List<T> elements = new ArrayList<>();

	/*
	 * Adiciona um elemento à lista.
	 * 
	 * @param value elemento a ser adicionado
	 */
	public void addValue(T value) {
		elements.add(value);
	}

	/*
	 * Retorna o primeiro elemento da lista.
	 * 
	 * @return primeiro elemento
	 * 
	 * @throws IllegalStateException se a lista estiver vazia
	 */
	public T first() {
		if (elements.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		return elements.get(0);
	}

	/*
	 * Imprime os elementos no formato de lista, separados por vírgula.
	 */
	public void print() {
		System.out.print("[");

//		Imprime o primeiro elemento (caso exista)
		if (!elements.isEmpty()) {
			System.out.print(elements.get(0));
		}

//	Imprime os demais com vírgula
		for (int i = 1; i < elements.size(); i++) {
			System.out.print(", " + elements.get(i));
		}
		System.out.println("]");
	}
}
