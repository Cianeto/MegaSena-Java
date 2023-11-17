package vnw.backend.t2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*→ O usuário precisa escolher 7 números de 0 a 100. 
 *→ Precisa ser obrigatoriamente um numero inteiro. Caso o usuário digite outro tipo de dado, o programa não pode parar
 *→ Os números escolhidos terão de ser guardados em um vetor
 *→ Os 7 números vencedores terão de ser sorteado pela classe Random do java. 
 *→ Após o final, percorrer o vetor com as respostas e comparar com os 7 números sorteados
 *→ Se o usuário acertar 5 números → Premio de 10 mil reais
 *→ Se o usuário acertar 6 números → Premio de 50 mil reais
 *→ Se o usuário acertar 7 números → Premio de 200 mil reais
 */

public class MegaSena {
	public static void main(String[] args) {
		int[] megasenaNums = gerarNums();
		int[] numsEscolhidos = escolherNums();
		int acertos = 0;
		
		for(int i=0; i<numsEscolhidos.length; i++) {
			if(numsEscolhidos[i] == megasenaNums[i]) {
				acertos++;
			}
		}
		switch(acertos) {
		case 5:
			System.out.println("O usuário acertou 5 números e ganhou um prêmio de 10 mil reais!!");
			break;
		case 6:
			System.out.println("O usuário acertou 6 números e ganhou um prêmio de 50 mil reais!!");
			break;
		case 7:
			System.out.println("O usuário acertou 7 números e ganhou um prêmio de 200 mil reais!!");
			break;
		default:
			System.out.println("Não foi dessa vez..");
			break;
		}
	}
	
	static int[] gerarNums() {
		Random rand = new Random();
		int[] m = {0,0,0,0,0,0,0};
		for(int i=0; i<7; i++) {
			m[i] = rand.nextInt(100);
			System.out.println("Dica secreta.. "+m[i]);
		}
		return m;
	}
	
	static int[] escolherNums() {
		Scanner sc = new Scanner(System.in);
		int[] m = {0,0,0,0,0,0,0};
		for(int i=0; i<7; i++) {
			
			System.out.print("Digite o "+(i+1)+"º valor: ");
			try {
				m[i] = sc.nextInt();
				if(m[i] < 0 || m[i] > 100) {
					throw new InputMismatchException();
				}
			}catch(InputMismatchException e) {
				System.out.println("Valor digitado deve ser um número inteiro entre 0 e 100!");
				sc.nextLine();
				i--;
			}
		}
		sc.close();
		return m;
	}
}
