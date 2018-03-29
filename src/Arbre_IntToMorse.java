public class Arbre_IntToMorse {

    // Nos variables

    private Arbre_IntToMorse gauche;
    private Arbre_IntToMorse droite;
    public char lettre;
    public int ascii;

    public Arbre_IntToMorse() {
        lettre = ' ';
        ascii = lettre;
        gauche = null;
        droite = null;
    }

    public Arbre_IntToMorse(char lettre) {
        this.lettre = lettre;
        ascii = lettre;
        gauche = null;
        droite = null;
    }

    public Arbre_IntToMorse(char lettre, Arbre_IntToMorse g, Arbre_IntToMorse d) {
        this.lettre = lettre;
        ascii = lettre;
        gauche = g;
        droite = d;
    }

    public Arbre_IntToMorse ajout(char lettre) {
        if(this.ascii == 32 || this.ascii == lettre) {
            this.lettre = lettre;
            this.ascii = lettre;
            return this;
        } else if(this.ascii < lettre) {
            if (this.droite == null) {
                this.droite = new Arbre_IntToMorse(lettre);
            } else {
                droite.ajout(lettre);
            }
        } else {
            if (this.gauche == null) {
                this.gauche = new Arbre_IntToMorse(lettre);
            } else {
                gauche.ajout(lettre);
            }
        }
        return this;
    }

    public Arbre_IntToMorse buildSource() {
        char[] all = {'a','5','2','0','1','3','4','7','6','8','9','n','h','t','e','l','p','w','c','g','u','y','b','d','f','i','j','k','m','o','q','r','s','v','x','z'};
        for (char lettre : all) {
            this.ajout(lettre);
        }
        return this;
    }

    public Arbre_IntToMorse delete(char lettre) {
        if(ascii == 32 || ascii == lettre) {

            return this;
        } else if(ascii < lettre) {
            if (droite == null) {
                return this;
            } else if (droite.ascii == lettre ){
                if(droite.gauche == null && droite.droite == null) {
                    gauche = null;
                    return this;
                } else {

                }
            } else {
                droite.delete(lettre);
            }
        } else { /* Faire le même else dans la partie au dessus et faire un test sur un petit arbre ou sur la source au choix*/
            if (gauche == null) {
                return this;
            } else if (gauche.ascii == lettre ){
                if(gauche.gauche == null) {
                    gauche = gauche.droite;
                } else {
                    if (gauche.droite == null) {
                        gauche = gauche.gauche;
                    } else {
                        gauche.replacerFils();
                    }
                }
            } else {
                gauche.delete(lettre);
            }
        }
        return this;
    }

    public Arbre_IntToMorse replacerFils(){
        if(droite == null)
            return gauche;
        else
            return gauche.replacerFils();
    }

    @Override
    public String toString() {
        System.out.println("Voici l'arbre : ");
        main.node_print(this,1,5);
        return "Fin de l'Arbre";
    }

    public Arbre_IntToMorse getGauche() {
        return gauche;
    }

    public Arbre_IntToMorse getDroite() {
        return droite;
    }
}
