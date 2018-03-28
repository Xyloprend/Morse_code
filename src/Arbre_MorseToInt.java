public class Arbre_MorseToInt {

    // Nos variables

    private Arbre_MorseToInt gauche;
	private Arbre_MorseToInt droite;
	public char lettre;
	
	
	// Nos constructeurs

    /**
     * Constructeur pour un Arbre
     * @param lettre
     */
	public Arbre_MorseToInt(char lettre)
    {
	    this.lettre = lettre;
	    gauche = null;
	    droite = null;
	}

    /**
     * Constructeur pour un Arbre
     * @param lettre
     * @param gauche
     * @param droite
     */
	public Arbre_MorseToInt(char lettre, Arbre_MorseToInt gauche, Arbre_MorseToInt droite)
	{
		this.lettre = lettre;
        this.gauche = gauche;
        this.droite = droite;
	}
	
	// Nos fonctions

    /**
     * Fonction récursive permet de ressortir une lettre en fonction d'une suite de char représentant du morse
     * Exemple : prend en entrée ".-." et ressort 'R'
     * @param morse
     * @return
     */
    public char search(char tab[]) {
        // code temporaire pour la compilation
    //Hugo : attention c'est baptiste qui le fait, le faire en parallele : avant mercredi soir
    	if (tab.length > 1) {
    		if (tab[0] == '-') {
    			return gauche.search(tab??????]);//Baptiste :Comment on peut faire pour récursivement incrémenter la valeur ?
    		}
    		else {
    			return droite.search(tab[?????]);//Baptiste :Comment on peut faire pour récursivement incrémenter la valeur ?
    		}
    	}
    	else {
    		if (tab[0] == '.') {
    			return gauche.lettre;
    		}
    		else {
    			return droite.lettre;
    		}
    	}
    	
    	
        return 'a';
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
        // Ben : Effectivement tu dois check les caractère mais cette solution est trop ... éléctronique :')
        // C'est une table de vérité là, ça fonctionne (enfin j'espère) mais j'aime pas trop
        // Au choix vérifie le caractère de la même façon que dans le parser (oui tu dois le trouver pour ça)
        // PS : le triple ou peut fonctionner mais cette implémentation est fausse, tu peut la corriger pour t'entrainer
        // pour t'aider à la coriger voici un exemple du String input : ".-. --. -.-"
        // Cette input est valable mais dans ton code il ressorira un false ;)

		char[] morse = input.toCharArray();

		for (int i = 0; i < morse.length; i++) {
			if(morse[i] != 32){
                if(morse[i] != 45) {
                    if (morse[i] != 46) {
                        return false;
                    }
                }
			}
		}
    	return true;
    }

}

 /*
public char[] parser(String phrase) {
	char[] tableau= new char[phrase.length()];	// création d'un tableau de caractère
	int i;

	for(i=0; i<phrase.length(); i++)
	{
												// tableau[i] = phrase[i];  Pourquoi ça ne marche pas ça ? JE me doute que c'est le string mais bon ..
		tableau[i] = phrase.charAt(i);			// On recopie une phrase dans un tableau de caractères
	}

	if(i==phrase.length()) {	tableau[i]='\0';	}	//On clot le tableau

		return tableau;
	}*/