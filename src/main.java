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
		}while((x!=1)&&(x!=2));
		
		switch(x) {
			case 1:
				System.out.println("Vous avez choisi 1");
				Arbre_MorseToInt test = new Arbre_MorseToInt('a');
				System.out.println(test.check_typo( Entree_clavier));
				break;
				
			case 2:
				System.out.println("Vous avez choisi 2");
                Arbre_IntToMorse itm = new Arbre_IntToMorse();
                itm.buildSource();
                System.out.println(itm);
				break;

            /* case 3 : Demo technique */
			default:												//Pr�voir au cas o� une valeur autre que 1 ou 2 est entr�e et que la boucle n'a pas fonctionn�
				System.out.println("Une erreur est intervenue");
		}
		
		
	}

    public static void node_print(Arbre_IntToMorse bis, int current_level, int max_level)
    {
        int i;

        String tmp = "";

        if (bis != null) {
            node_print(bis.getDroite(), current_level + 1, max_level);
            for (i = 0; i < current_level; i++) {
                tmp += "    ";
            }
            System.out.println(tmp + bis.lettre);
            node_print(bis.getGauche(), current_level + 1, max_level);
        } else {
            if (current_level < max_level) {
                node_print(null, current_level + 1, max_level);
                for (i = 0; i < current_level; i++) {
                    tmp += "    ";
                }
                System.out.println(tmp + "..\n");
                node_print(null, current_level + 1, max_level);
            }
        }
    }
}
