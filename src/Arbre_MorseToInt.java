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

	    // pour chaque lettre en morse représenter par une string
	    for (String lettre : to_search) {
	        if(lettre.equals("")) {
	            // ajout d'un retour à la ligne pour afficher mieux chaque mot
	            tmp += "\n";
            } else {
	            // ajout de la lettre trouvé dans notre string qui sera return
	            tmp += this.search(lettre.toCharArray());
            }
        }

        return tmp;
    }

    /**
     * Fonction récursive permet de ressortir une lettre en fonction d'une suite de char représentant du morse
     * Exemple : prend en entrée ".-." et ressort 'R'
     *
     * Benjamin : profil info
     *  Petite justification sur l'usage de : Arrays.copyOfRange
     *  A la base je pensais leur faire écrire une fonction qui effectue la même action.
     *
     *  Une simpke boucle for avec un if i != 0 dedans pour ré-ecrire
     *  le tableau à partir de l'index 1 avant de le return
     *
     *  Puis je me suis dis que en programation c'est bien de savoir comment ça fonctionne mais
     *  c'est tous aussi bien de ne pas perde de temps à re écrire un code existant mais plutôt de le ré-utiliser
     *
     *  Cette fonction ne touchant ni au arbre ni à la récursivité je ne pense que ça pose un soucis
     *  toutefois nous adorons les retours donc n'hésiter pas
     *
     * @param tab
     * @return
     */
    public char search(char tab[]) {
        // si la lettre en morse n'est pas encore arrivé au dernier caractere
    	if (tab.length > 1) {
    	    // si le premier caractere est un '-' alors on se dirige vers la gauche
    		if (tab[0] == '-') {
    		    //pour appeler la même fonction récursivement mais à l'index + 1
    			return gauche.search(Arrays.copyOfRange(tab, 1, tab.length));
    		}
    		// sinon on se dirige vers la droite
    		else {
                //pour appeler la même fonction récursivement mais à l'index + 1
    			return droite.search(Arrays.copyOfRange(tab, 1, tab.length));
    		}
    	}
    	else { // ici on atteint le dernier caractere de la lettre en morse
            // même principe gauche / droite mais cette fois on return la lettre pour avoir une fin à la fonction récursive
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

        //Vérifier l'utilité de tmp ici

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
     * Cette fonction modifie l'objet courant directement par conséquent on peut l'écrire sans return (en void)
     * @param morse
     * @param value
     */
    public void ajout(char[] morse, char value) {
        // encore une fois on ajoute la lettre à l'arbe qu'une fois au dernier caracter morse atteins
        if (morse.length > 1) {
            // même principe que search sur le déplacement droite / gauche
            if (morse[0] == '-') {
                // si gauche est null alors il faut l'instancier avec un new avant toute opération
                if (gauche == null)
                    gauche = new Arbre_MorseToInt(' ');
                // appel récursive de la fonction ajout avec l'index +1 afin d'atteindre le dernier caractere du morse
                gauche.ajout(Arrays.copyOfRange(morse, 1, morse.length), value);
            }
            else {
                // si droite est null alors il faut l'instancier avec un new avant toute opération
                if(droite == null)
                    droite = new Arbre_MorseToInt(' ');
                // même principe mais pour la droite
                droite.ajout(Arrays.copyOfRange(morse, 1, morse.length), value);
            }
        }
        // Dans le cas ou l'on est au derneir caractere du morse
        else {
            // même principe que search sur le déplacement droite / gauche
            if (morse[0] == '-') {
                // toujours pareille vérifier que l'instance existe avant de l'utiliser
                if (gauche == null)
                    gauche = new Arbre_MorseToInt(' ');
                // attribution d'une lettre à un noeud de l'arbre
                gauche.lettre = value;
            }
            else {
                // toujours pareille vérifier que l'instance existe avant de l'utiliser
                if(droite == null)
                    droite = new Arbre_MorseToInt(' ');
                // attribution d'une lettre à un noeud de l'arbre
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