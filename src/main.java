import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x;
		
		System.out.println("On est des g�nies");
		System.out.println("\n\t Merci de rentrer le message � coder ou � d�coder\n");
		String Entree_clavier = sc.nextLine();
		System.out.println("Merci, vous avez rentr� :\t" + Entree_clavier);
		
		do {
			System.out.println("Rentrez une valeur svp\n(1) pour convertir du morse ou (2) pourconvertir en morse");
			Scanner choix = new Scanner(System.in);
			x = choix.nextInt();
		}while((x!=1)&&(x!=2));
		
		switch(x) {
			case 1:
				System.out.println("Vous avez rentr� 1");
				break;
				
			case 2:
				System.out.println("Vous avez rentr� 2");
				break;
				
			default:												//Pr�voir au cas o� une valeur autre que 1 ou 2 est entr�e et que la boucle n'a pas fonctionn�
				System.out.println("Une erreur est intervenue");
		}
		
		
	}

}
