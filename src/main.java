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
			System.out.println("Rentrez une valeur svp\n(1) pour convertir du morse ou (2) pour convertir en morse");
			Scanner choix = new Scanner(System.in);
			x = choix.nextInt();
		}while((x!=1)&&(x!=2)&&(x!=3));
		
		switch(x) {
			case 1:
				System.out.println("Vous avez choisi 1");
				Arbre_MorseToInt mti = new Arbre_MorseToInt('a');
				System.out.println(mti.check_typo( Entree_clavier));
				break;
				
			case 2:
				System.out.println("Vous avez choisi 2");
                Arbre_IntToMorse itm = new Arbre_IntToMorse();
                itm.buildSource();
                System.out.println(itm);
				break;
            case 3 : {
                System.out.println("Démo technique : \n Génération de l'arbre (avec un ajout dynamique) : ");
                Arbre_IntToMorse test = new Arbre_IntToMorse();
                test.to_test();
                System.out.println("Affichage de l'arbre : ");
                System.out.println(test);
                System.out.println("Suppresion d'un élément de l'arbre :");
                test = test.delete('v');
                System.out.println("Affichage de l'arbre après la suppresion du char 's' ");
                System.out.println(test);
                break;
            }
			default:												//Pr�voir au cas o� une valeur autre que 1 ou 2 est entr�e et que la boucle n'a pas fonctionn�
				System.out.println("Une erreur est intervenue");
		}
		
		
	}
}
