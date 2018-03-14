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
		this.lettre = lettre;
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
		this.gauche = new Arbre_MorseToInt(lettre, gauche, droite);
		this.droite = new Arbre_MorseToInt(lettre, gauche, droite); //ca fait pas une boucle infinie ça ?
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
     * Fonction itérative prenant l'input de l'utilistateur et ressort un tableau de string
     * Chaque String du tableau correspond à un caractère écrit en Morse (ex : ".-.")
     * @param input
     * @return
     */
    // Je pense pas que ça marche ça, on a faire confirmer par ben car s'il y a plusieurs esapces, on est niqué
	public String[] parser(String input) {
        // code temporaire pour la compilation
        String[] tmp = new String[26];
        int i = 0;
        int j = 0;
        
        while (i<26) {
        
        	if (input.indexOf(' ') != -1) {
        		tmp[i] = input;
        	}
        	else {
        		tmp[i] = input.substring(j, input.indexOf(' ')); //permet d'extraire une partie d'une chaine jusqu'à un caractere en aprticulier (ici espace)
        	}
        	i++;
        }
        
        System.out.println(tmp[i] + '\n');
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
    	if(input==" "||input=="."||input=="_"){
    		return true;
    	}
    	else{
   			return false;
   		}
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