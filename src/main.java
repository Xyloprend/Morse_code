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

        Arbre_IntToMorse source = new Arbre_IntToMorse();
        source.buildSource();

        switch(x) {
			case 1: {
                System.out.println("Vous avez choisi de convertir un message en morse");

                String Entree_clavier;
                Arbre_MorseToInt mti = new Arbre_MorseToInt('/');

                // System.out.println(mti);

                mti.ajout(source);

                // System.out.println(mti);

                do {
                    System.out.println("Un espace = carctere suivant | Deux espaces = mot suivant");
                    System.out.println("Veuillez saisir votre messsage en morse :");
                    Scanner sc = new Scanner(System.in);
                    Entree_clavier = sc.nextLine();
                } while (!mti.check_typo(Entree_clavier));

                System.out.println("Merci, vous avez rentrer :\t" + Entree_clavier);

                System.out.println(mti.search(mti.parser(Entree_clavier)));

                break;
            }
			case 2: {
                System.out.println("Vous avez choisi de convertir du texte en morse :");

                String Entree_clavier;
                System.out.println("Veuillez saisir votre messsage texte :");
                Scanner sc = new Scanner(System.in);
                Entree_clavier = sc.nextLine();

                System.out.println("Merci, vous avez rentrer :\t" + Entree_clavier);

                source.search(Entree_clavier);

                break;
            }
            case 3 : {
                System.out.println("Démo technique : \n Génération de l'arbre : ");

                Arbre_IntToMorse test = new Arbre_IntToMorse();
                test.to_test();

                System.out.println("Affichage de l'arbre : ");
                System.out.println(test);

                char car;

                System.out.println("Veuillez saisir un caractère à ajouter :");
                Scanner sc1 = new Scanner(System.in);
                car = sc1.next().charAt(0);
                System.out.println("Vous avez choisi le caractère :" + car);

                test.ajout(car,"    ");
                System.out.println("Voici l'arbre après l'ajout de " + car);
                System.out.println(test);

                System.out.println("Veuillez saisir un caractère à rechercher :");
                Scanner sc2 = new Scanner(System.in);
                car = sc2.next().charAt(0);
                System.out.println("Vous avez choisi le caractère :" + car);

                System.out.println("Recherche de son équivalant en morse :");
                String morse = test.search(car);

                System.out.println(morse);

                if(test.check_typo(morse)) {
                    System.out.println("Suppresion d'un élément de l'arbre :");
                    test = test.delete(car);
                    System.out.println("Affichage de l'arbre après la suppresion du char 's' ");
                    System.out.println(test);
                }

                break;
            }
			default://Pr�voir au cas o� une valeur autre que 1 ou 2 est entr�e et que la boucle n'a pas fonctionn�
				System.out.println("Une erreur est intervenue");
		}
		
		
	}
}
