public class Arbre_IntToMorse {

    // Nos variables

    private Arbre_IntToMorse gauche;
    private Arbre_IntToMorse droite;

    private char lettre;
    private int ascii;
    private String morse;

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

    public String search(char lettre) {
        if(this.lettre == lettre) {
            return morse;
        }
        if(lettre < this.ascii) {
            if(gauche != null) {
                return gauche.search(lettre);
            } else {
                return "Le caractère : '" + lettre + "' n'est pas dans notre arbre";
            }
        } else {
            if(droite != null) {
                return droite.search(lettre);
            } else {
                return "Le caractère : '" + lettre + "' n'est pas dans notre arbre";
            }
        }
    }

    private Arbre_IntToMorse ajout(char lettre, String morse) {
        if (this.ascii == 32 || this.ascii == lettre) {
            this.lettre = lettre;
            this.ascii = lettre;
            return this;
        } else if (this.ascii < lettre) {
            if (this.droite == null) {
                this.droite = new Arbre_IntToMorse(lettre, morse);
            } else {
                droite.ajout(lettre, morse);
            }
        } else {
            if (this.gauche == null) {
                this.gauche = new Arbre_IntToMorse(lettre, morse);
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
        char[] all = {'a', '5', '2', '0', '1', '3', '4', '7', '6', '8', '9', 'n', 'h', 't', 'e', 'l', 'p', 'w', 'c', 'g', 'u', 'y', 'b', 'd', 'f', 'j', 'i', 'k', 'm', 'o', 'r', 'q', 's', 'v', 'x', 'z'};
        String[] morse = {".-",".....","..---","-----",".----","...--","....-","--...","-....","---..","----.","-.","....","-",".",".-..",".--.",".--","-.-.","--.","..-","-.--","-...","-..","..-.","..-.",".---","..","-.-","--","---",".-.","--.-","...","...-","-..-","--.."};
        for (int i=0; i < all.length; i++) {
            this.ajout(all[i],morse[i]);
        }
        return this;
    }

    public Arbre_IntToMorse to_test() {
        char[] all = {'n', 'r', 's','g','a','h','o'};
        String[] morse = {"-.",".-.","...","--.",".-","....","---"};
        for (int i=0; i < all.length; i++) {
            this.ajout(all[i],morse[i]);
        }
        return this;
    }

    public Arbre_IntToMorse delete(char lettre) {
        if (this.lettre == lettre) {
            if (gauche != null) {
                return gauche.replace(droite);
            } else {
                return droite;
            }
        } else {
            if (lettre < this.lettre) {
                this.gauche = gauche.delete(lettre);
            } else {
                this.droite = droite.delete(lettre);
            }
        }
        return this;
    }

    private Arbre_IntToMorse replace(Arbre_IntToMorse source) {
        if (droite != null)
            droite = droite.replace(source);
        else
            droite = source;
        return this;
    }

    /**
     * Re défini la sortie standard lors de l'appel d'u objet de cette classe
     *
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

}
