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
	public Arbre_MorseToInt(char lettre) {

	}

    /**
     * Constructeur pour un Arbre
     * @param lettre
     * @param gauche
     * @param droite
     */
	public Arbre_MorseToInt(char lettre, Arbre_MorseToInt gauche, Arbre_MorseToInt droite)
	{

	}
	
	// Nos fonctions

    /**
     * Fonction récursive permet de ressortir une lettre en fonction d'une suite de char représentant du morse
     * Exemple : prend en entrée ".-." et ressort 'R'
     * @param morse
     * @return
     */
    public char search(String morse) {
        // code temporaire pour la compilation
        return 'a';
    }

    /**
     * Fonction itérative prenant l'input de l'utilistateur est ressort un tableau de string
     * Chaque String tu tableau correspond à un caractère écrit en Morse (ex : ".-.")
     * @param input
     * @return
     */
	public String[] parser(String input) {
        // code temporaire pour la compilation
        String[] tmp = new String[20];
        return tmp;
    }

    /**
     * Fonction qui contrôle le texte de l'utilisateur, ici l'utilisateur doit avoir saisi du morse
     * par conséquent si le String input comprend autre chose que '.', '-' ou ' ' alors return False
     * Sinon return True
     * @param input
     * @return
     */
    public boolean check_typo(String input) {
        // code temporaire pour la compilation
        return true;
    }

}
