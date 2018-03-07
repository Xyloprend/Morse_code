
public class Arbre {
			// Nos variables
	private Arbre gauche;
	private Arbre droite;
	public int n;
	
	
			// Nos constructeurs
	public Arbre(int n) {
		this.n = n;
		gauche = null;
		droite = null;
	}
	
	public Arbre(int n, Arbre gauche, Arbre droite)
	{
		this.n = n;
		
	}
	
			// Nos fonctions
	//fonction pour séparer chaque caractère dans une phrase de 'i' caractères
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
	}
	
	//fonction pour afficher le caractère en fonction du chemin parcouru dans l'arbre
	public char[] affichage() {
		
		
		
	}
	
	
	//fonction poour rechercher un caractère dans notre arbre
	public char search(char[] s) {
		char[] mot = s;
		
		if(mot[0]=='.')
		{
			
		}
		else
		{
			if  // continuer la fonction, mais je pense commencer mal
		}
		
		return s;
	}
	
	
}
