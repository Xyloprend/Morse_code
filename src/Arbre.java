
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
	
	
			// Nos fonctions
	//fonction pour s�parer chaque caract�re dans une phrase de 'i' caract�res
	public char[] parser(String phrase) {
		char[] tableau= new char[phrase.length()];
		int i;
		
		for(i=0; i<phrase.length(); i++)
		{
			// tableau[i] = phrase[i];  Pourquoi �a ne marche pas �a ? JE me doute que c'est le string mais bon ..
			tableau[i] = phrase.charAt(i);
		}
		
		if(i==phrase.length()) {	tableau[i]='\0';	}
		
		return tableau;
	}
	
	
	//fonction poour rechercher un caract�re dans notre arbre
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
