import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x;
		
		System.out.println("On est des génies");
		System.out.println("\n\t Merci de rentrer le message à coder ou à décoder\n");
		String Entree_clavier = sc.nextLine();
		System.out.println("Merci, vous avez rentré :\t" + Entree_clavier);
		
		do {
			System.out.println("Rentrez une valeur svp\n(1) pour convertir du morse ou (2) pourconvertir en morse");
			Scanner choix = new Scanner(System.in);
			x = choix.nextInt();
		}while((x!=1)&&(x!=2));
		
		switch(x) {
			case 1:
				System.out.println("Vous avez rentré 1");
				break;
				
			case 2:
				System.out.println("Vous avez rentré 2");
				break;
				
			default:												//Prévoir au cas où une valeur autre que 1 ou 2 est entrée et que la boucle n'a pas fonctionné
				System.out.println("Une erreur est intervenue");
		}
		
		
	}

}
