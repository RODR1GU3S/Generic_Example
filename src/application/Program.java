package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//	Instancia o serviço de impressão configurado para trabalhar com Integer
		PrintService<Integer> printService = new PrintService<>();

		System.out.print("How many values? ");
		int totalValues = sc.nextInt();

//	Lê os valores informados pelo usuário e adiciona ao serviço
		for (int i = 0; i < totalValues; i++) {
			Integer value = sc.nextInt();
			printService.addValue(value);
		}

//	Imprime todos os valores inseridos
		printService.print();

//	Exibe o primeiro valor da lista
		Integer firstValue = printService.first();
		System.out.println("First: " + firstValue);

		sc.close();
	}
}

/*
## 🧠 O que se aprende com esse código?

1. **Uso de Generics**:
   - Você pode criar classes reutilizáveis que funcionam com qualquer tipo.
   - A tipagem forte (ex: `Integer`) evita erros em tempo de compilação.

2. **Encapsulamento e boas práticas**:
   - A lógica de armazenar e imprimir valores está separada do `main`.
   - Isso torna o código limpo e modular.

3. **Tratamento de exceção**:
   - `IllegalStateException` no método `first()` protege contra erros de acesso a listas vazias.



Passo a passo de forma didática.
 Esse código serve para demonstrar o uso de **Generics** em Java,
  que permite criar classes e métodos que funcionam com qualquer tipo de dado,
   de forma segura e reutilizável.


## 👨‍🏫 Visão Geral do Projeto

Esse projeto tem duas classes principais:
- `Example_Generics` (classe principal `main`)
- `PrintService<T>` (classe genérica de serviço)


## 📄 Arquivo: `Example_Generics.java`

package application;
import java.util.Scanner;
import services.PrintService;


### Importações
- `Scanner`: Para ler dados do teclado.
- `PrintService`: A classe genérica que imprime valores.


### Método principal

public class Example_Generics {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

- Cria o objeto `Scanner` para ler entradas do usuário.

		PrintService<Integer> ps = new PrintService<>();

- Aqui está o uso de **Generics**: o `PrintService` foi configurado para trabalhar com o tipo `Integer`.
  Isso significa que só aceitará números inteiros.


		System.out.print("How many values? ");
		int n = sc.nextInt();

- Pergunta quantos valores o usuário vai digitar.


		for(int i = 0; i < n; i++) {
			Integer value = sc.nextInt();
			ps.addValue(value);
		}

- Lê os `n` valores digitados e adiciona cada um deles no `PrintService`.


		ps.print();
		Integer x = ps.first();
		System.out.println("First: " + x);

- Imprime todos os valores e mostra o primeiro da lista.

		sc.close();
	}
}
- Fecha o `Scanner`.


## 📄 Arquivo: `PrintService.java`

package services;
import java.util.ArrayList;
import java.util.List;
```

### Classe Genérica

public class PrintService<T> {

- Essa é uma **classe genérica**, indicada pelo `<T>`.
  O `T` é um tipo qualquer que será especificado quando a classe for usada.


### Atributo

	private List<T> list = new ArrayList<>();

- Cria uma lista do tipo `T` (que no exemplo do `main` será `Integer`).


### Método: `addValue`

	public void addValue(T value) {
		list.add(value);
	}

- Adiciona um valor à lista.


### Método: `first`

	public T first() {
		if (list.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		return list.get(0);
	}

- Retorna o primeiro elemento da lista, ou lança uma exceção se estiver vazia.


### Método: `print`

	public void print() {
		System.out.print("[");
		if (!list.isEmpty()) {
			System.out.print(list.get(0));
		}
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", " + list.get(i));
		}
		System.out.println("]");
	}

- Imprime todos os elementos da lista no formato: `[1, 2, 3]`.


O código pode ser adaptado para funcionar com `String`, `Double`,
ou até mesmo um tipo personalizado (como `Pessoa`).
*/