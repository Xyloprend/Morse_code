import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 0;
		
		do {
			System.out.println("Rentrez une valeur svp\n\t(1) pour convertir du morse \n\t(2) pour convertir en morse\n\t(3) pour la démo technique");
			Scanner choix = new Scanner(System.in);
			x = choix.nextInt();
		}while((x!=1)&&(x!=2)&&(x!=3));
		
		switch(x) {
			case 1:
				System.out.println("Vous avez choisi de convertir un message en morse");

				String Entree_clavier;
                Arbre_MorseToInt mti = new Arbre_MorseToInt('/');

				do {
                    System.out.println("Veuillez saisir votre messsage :");
                    Scanner sc = new Scanner(System.in);
                    Entree_clavier = sc.nextLine();
                } while (!mti.check_typo(Entree_clavier));

                System.out.println("Merci, vous avez rentr� :\t" + Entree_clavier);
                // génération de l'arbre

                System.out.println(mti.search(mti.parser(Entree_clavier)));

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
                test = test.delete('s');
                System.out.println("Affichage de l'arbre après la suppresion du char 's' ");
                System.out.println(test);
                break;
            }
			default://Pr�voir au cas o� une valeur autre que 1 ou 2 est entr�e et que la boucle n'a pas fonctionn�
				System.out.println("Une erreur est intervenue");
		}
		
		
	}
}
