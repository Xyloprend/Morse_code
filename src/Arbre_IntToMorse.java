public class Arbre_IntToMorse {

    // Nos variables

    private Arbre_IntToMorse gauche;
    private Arbre_IntToMorse droite;

    private char lettre;
    private int ascii;
    private String morse;

    // Nos constructeur

    /**
     * Constructeur nécéssaire à la création d'un arbre vide pour appeller les fonctions dépendentes
     * (Uniquement utilisé pour appeler la fonction build_source dessus)
     */
    public Arbre_IntToMorse() {
        lettre = ' ';
        ascii = lettre;
        gauche = null;
        droite = null;
    }

    public Arbre_IntToMorse(char lettre, String morse) {
        this.lettre = lettre;
        this.morse = morse;
        ascii = lettre;
        gauche = null;
        droite = null;
    }

    /**
     * Permet d'afficher chaque mot du String (input de l'utilisateur) en morse
     * @param input
     */
    public void search(String input) {
        String tmp = "";
        // Pour chaque lettre du mot passé en parametre
        for (char lettre : input.toCharArray()) {
            // si la lettre est un espace alors on affiche le premier mot et on ré-initialise notre String
            if(lettre == ' ') {
                System.out.println(tmp);
                tmp = "";
            } else {
                // sinon on ajoute la valeur de la lettre en morse dans notre string avec un espace
                tmp += search(lettre) + ' ';
            }
        }
        // Affiche le String tmp (nécéssaire si l'input ne finit pas par un espace)
        System.out.println(tmp);
    }

    /**
     * Ressort le code morse d'un caractère ou un message d'erreur
     * @param lettre
     * @return
     */
    public String search(char lettre) {
        // endpoint de notre fonction récursive, lorsqu'on à trouvé dans notre arbre la bonne valeur on lui renvoie son
        // morse equivalant
        if(this.lettre == lettre) {
            return morse;
        }
        // Sinon on descend dans l'arbre en comparant la valeur d'entré avec la valeur dans l'arbre
        // comparaison faite avec la table ascii
        if(lettre < this.ascii) {
            if(gauche != null) {
                // si l'objet existe on descend dessus pour faire notre recherche
                return gauche.search(lettre);
            } else {
                // sinon c'est que l'input comprend des valeurs non index en morse
                return "\n Le caractère : '" + lettre + "' n'est pas dans notre arbre \n";
            }
        } else {
            if(droite != null) {
                // si l'objet existe on descend dessus pour faire notre recherche
                return droite.search(lettre);
            } else {
                // sinon c'est que l'input comprend des valeurs non index en morse
                return "\n Le caractère : '" + lettre + "' n'est pas dans notre arbre \n";
            }
        }
    }

    /**
     * Prend une lettre et son équivalant en morse et l'ajoute à l'arbre
     * @param lettre
     * @param morse
     * @return
     */
    public Arbre_IntToMorse ajout(char lettre, String morse) {
        // si on trouve le caractere d'intialisation ou une lettre existante alors on attribue la valeur en param
        if (ascii == 32 || ascii == lettre) {
            this.lettre = lettre;
            this.ascii = lettre;
            this.morse = morse;
            return this;
        } else if (ascii < lettre) {
            // ici on crée l'arbre qui marche sur la table ascci par conséquent gauche = < et droite = >
            if (droite == null) { // Si l'espace et libre on l'initialise avec les valeur en param
                droite = new Arbre_IntToMorse(lettre, morse);
            } else {
                // sinon on continue a descendre
                droite.ajout(lettre, morse);
            }
        } else {
            // comme le else if mais à part droite c'est gauche
            if (gauche == null) {
                gauche = new Arbre_IntToMorse(lettre, morse);
            } else {
                gauche.ajout(lettre, morse);
            }
        }
        return this;
    }

    /**
     * Création dynamique d'un arbre contenant tous les caractère du morse code
     * @return
     */
    public Arbre_IntToMorse buildSource() {
        // ici on écrit tous les caracteres gérer par notre/nos arbre avec leur équivalant en morse
        char[] all = {'a', '5', '2', '0', '1', '3', '4', '7', '6', '8', '9', 'n', 'h', 't', 'e', 'l', 'p', 'w', 'c', 'g', 'u', 'y', 'b', 'd', 'f', 'j', 'i', 'k', 'm', 'o', 'r', 'q', 's', 'v', 'x', 'z','-','.','_'};
        String[] morse = {".-",".....","..---","-----",".----","...--","....-","--...","-....","---..","----.","-.","....","-",".",".-..",".--.",".--","-.-.","--.","..-","-.--","-...","-..","..-.",".---","..","-.-","--","---",".-.","--.-","...","...-","-..-","--..","----","---.","..--"};
        // puis on les ajoute dynamiquement
        for (int i=0; i < all.length; i++) {
            this.ajout(all[i],morse[i]);
        }
        return this;
    }

    /**
     * Création dynamique d'un arbre pour la démo technique (3)
     * @return
     */
    public Arbre_IntToMorse to_test() {
        // même chose que la source mais c'est la version légère pour la démo technique (3)
        char[] all = {'n', 'r', 's','g','a','h','o'};
        String[] morse = {"-.",".-.","...","--.",".-","....","---"};
        for (int i=0; i < all.length; i++) {
            this.ajout(all[i],morse[i]);
        }
        return this;
    }

    /**
     * Fonction qui supprime dynamiquement un noeud de l'arbre, reconnu par la lettre passé en parmaètre
     * Return l'arbre courant avec la modification de suppresion
     * @param lettre
     * @return
     */
    public Arbre_IntToMorse delete(char lettre) {
        if (this.lettre == lettre) {
            if (gauche != null) {
                // va chercher le fils le plus à droite de gauche en partant de this
                // pour mettre droite (de this) à sa droite (fils le plus à droite de gauche)
                // plus explicite avec la demo technique
                return gauche.replace(droite);
            } else {
                // pas de gauche on peut return droite sur this pour le delete
                return droite;
            }
        } else {
            // si on à pas trouver la lettre alors on continue la décente classique gauche = < et droite = >
            if (lettre < this.lettre) {
                this.gauche = gauche.delete(lettre);
            } else {
                this.droite = droite.delete(lettre);
            }
        }
        return this;
    }

    /**
     * Ressort le bon fils à replacer avant de delete son noeud parent dans la fonction delete
     * @param source
     * @return
     */
    private Arbre_IntToMorse replace(Arbre_IntToMorse source) {
        // on récupère le fils le plus à droite tous simplement
        // car il sera le plus cohérent à appliquer à notre source plus petit que celui
        // (car notre source est toujours droite)
        if (droite != null)
            droite = droite.replace(source);
        else
            droite = source;
        return this;
    }

    /**
     * Re défini la sortie standard lors de l'appel d'un objet de cette classe
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
     *
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

    // Getter auto-generer pour l'utilisation de la création dynamique du tree-morse
    // Dans la fonction ajout du fichier Arbre_IntToMorse

    public Arbre_IntToMorse getGauche() {
        return gauche;
    }

    public Arbre_IntToMorse getDroite() {
        return droite;
    }

    public String getMorse() {
        return morse;
    }

    public char getLettre() {
        return lettre;
    }
}
