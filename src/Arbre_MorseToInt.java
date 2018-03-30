import java.util.Arrays;

public class Arbre_MorseToInt {

    // Nos variables

    private Arbre_MorseToInt gauche;
	private Arbre_MorseToInt droite;
	public char lettre;
	
	
	// Nos constructeurs

    /**
     * Constructeur pour un Arbre avec pour seul paramètre sa lettre
     * @param lettre
     */
	public Arbre_MorseToInt(char lettre)
    {
	    this.lettre = lettre;
	    gauche = null;
	    droite = null;
	}

	// Nos fonctions

    /**
     * Fonction search qui permet de faire la recherche lettre par lettre
     * Depuis un tableau de String, puis les assemble pour ressortir un string
     * @param to_search
     * @return
     */
    public String search(String[] to_search) {
	    String tmp = "Votre message en clair est : \n";

	    for (String lettre : to_search) {
	        if(lettre.equals("")) {
	            tmp += "\n";
            } else {
	            tmp += this.search(lettre.toCharArray());
            }
        }

        return tmp;
    }

    /**
     * Fonction récursive permet de ressortir une lettre en fonction d'une suite de char représentant du morse
     * Exemple : prend en entrée ".-." et ressort 'R'
     * @param tab
     * @return
     */
    public char search(char tab[]) {
    	if (tab.length > 1) {
    		if (tab[0] == '-') {
    			return gauche.search(Arrays.copyOfRange(tab, 1, tab.length));
    		}
    		else {
    			return droite.search(Arrays.copyOfRange(tab, 1, tab.length));
    		}
    	}
    	else {
    		if (tab[0] == '-') {
    			return gauche.lettre;
    		}
    		else {
    			return droite.lettre;
    		}
    	}
    }

    /**
     * Fonction récursives permettant de générer un arbre morse à partir
     * d'un arbre source contenant les caractere et leur équivalant en morse
     * @param read
     */
    public void ajout(Arbre_IntToMorse read){
        Arbre_IntToMorse tmp;
        tmp = read;
        if (tmp.getGauche() != null) {
            ajout(tmp.getGauche());
        }
        if (tmp.getDroite() != null) {
            ajout(tmp.getDroite());
        }
        ajout(tmp.getMorse().toCharArray(), tmp.getLettre());
    }

    /**
     * Attribue la bonne valeur de lettre à un noeud de l'arbre
     * @param morse
     * @param value
     */
    public void ajout(char[] morse, char value) {
        if (morse.length > 1) {
            if (morse[0] == '-') {
                if (gauche == null)
                    gauche = new Arbre_MorseToInt(' ');
                gauche.ajout(Arrays.copyOfRange(morse, 1, morse.length), value);
            }
            else {
                if(droite == null)
                    droite = new Arbre_MorseToInt(' ');
                droite.ajout(Arrays.copyOfRange(morse, 1, morse.length), value);
            }
        }
        else {
            if (morse[0] == '-') {
                if (gauche == null)
                    gauche = new Arbre_MorseToInt(' ');
                gauche.lettre = value;
            }
            else {
                if(droite == null)
                    droite = new Arbre_MorseToInt(' ');
                droite.lettre = value;
            }
        }
    }

    /**
     * Fonction itérative prenant l'input de l'utilistateur et ressort un tableau de string
     * Chaque String du tableau correspond à un caractère écrit en Morse (ex : ".-.")
     * @param input
     * @return
     */
    public String[] parser(String input) {
        return input.split(" ");
    }

    /**
     * Fonction qui contrôle le texte de l'utilisateur, ici l'utilisateur doit avoir saisi du morse
     * par conséquent si le String input comprend autre chose que '.', '-' ou ' ' alors return False
     * Sinon return True
     * @param input
     * @return
     */
    public boolean check_typo(String input) {

		char[] morse = input.toCharArray();

        for (int i = 0; i < morse.length; i++) {
            if(morse[i] != 32 && morse[i] != 45 && morse[i] != 46) {
                return false;
            }
        }
    	return true;
    }

    /**
     * Re défini la sortie standard lors de l'appel d'u objet de cette classe
     * @return
     */
    @Override
    public String toString() {
        System.out.println("Voici l'arbre : ");
        this.node_print(1);
        return "Fin de l'Arbre";
    }

    /**
     * Fonction récursive permettant d'afficher un arbre graphiquement
     * @param current_level
     */
    private void node_print(int current_level) {
        String tmp = "";

        if (droite != null) { // Si le fils droite existe on appelle la fonction d'affichage dessus
            droite.node_print(current_level + 1);
        }
        for (int i = 0; i < current_level; i++) {
            // Permet la gestion des espaces pour l'affichage graphique
            tmp += "    ";
        }
        // Affiche la lettre de l'arbre
        System.out.println(tmp + lettre);

        if (gauche != null) { // Si le fils gauche existe on appelle la fonction d'affichage dessus
            gauche.node_print(current_level + 1);
        }
    }

}