import java.util.Random;

public class Tp2 {
	
	final static int CHANCE_TOTAL = 3;
	final static int LEVEL_MIN = 1;
	final static int LEVEL_MAX = 4;
	final static int NBRE_OPERATEUR_MIN = 1;
	final static int NBRE_OPERATEUR_MAX = 2;
	
	
	/**
	 * saisirDegreDifficulte permet de saisir le niveau de difficulte
	 * voulu. Elle s assure que la valeur entree est dans l'intervalle
	 * specifie
	 * @return Un Entier qui represente le niveau de difficulte
	 */
	public static int saisirDegreDifficulte() {
		int level = 0;
		boolean acces = true;
		do {
			System.out.print("Choisissez un degre de difficulte" +
					" (1-facile, 2-moyen, 3-difficile ou 4-extreme) : ");
			level = Clavier.lireInt();

			if ((LEVEL_MIN <= level) && (level <= LEVEL_MAX)) {
				acces = false;
			} else {
				System.out.println("*** choix invalide");
			}
		} while (acces);

		return level;
	}

	/*public static String saisirReponseOuiNon() {
		String reponse = "";
		boolean acces1 = true;
		do {
			System.out.println("");
			System.out
					.print("Voulez-vous effectuer une operation (repondez par o ou n) ? ");
			reponse = Clavier.lireString();

			if (reponse.compareTo("o") == 0 || reponse.compareTo("n") == 0
					|| reponse.compareTo("O") == 0
					|| reponse.compareTo("N") == 0
					|| reponse.compareTo("oui") == 0
					|| reponse.compareTo("non") == 0
					|| reponse.compareTo("OUI") == 0
					|| reponse.compareTo("NON") == 0) {
				acces1 = false;
			} else {
				System.out.println("*** choix invalide");
			}
		} while (acces1);

		return reponse;
	}*/

	/**
	 * nombreOperateur determine combien d operateurs on aura pour
	 * l operation en cours
	 * @return Un entier dont la valeur est 1 ou 2
	 */
	public static int nombreOperateur()
	{
		Random rand = new Random();
		return rand.nextInt(NBRE_OPERATEUR_MAX - NBRE_OPERATEUR_MIN + 1) +
														NBRE_OPERATEUR_MIN;
	}
	
	public static int determinerCorrection(int operande1, int opreande2,
			int operande3, int nbreOperateur, char operation1, char operation2)
	{
		int resultat = 0;
		
		switch(nbreOperateur)
		{
		
		}
		return resultat;
	}
	
	private static int determinerCorrectionUnOperateur(int operande1,
			int operande2, char operation1)
	{
		int resultat = 0;
		switch (operation1)
		{
			case '+': resultat = operande1 + operande2;
					  break;
			case '-': break;
		}
		return resultat;
	}
	
	/**
	 * fonction principale
	 * @param params n est pas pris en compte
	 */
	public static void main(String[] params) {
		String nameUser = "", pourcentage = "";
		int difficulte = 0, operande1 = 0, operande2 = 0, operande3 = 0;
		int nbreOperateur = 0,  resultat = 0, correction = 0;
		boolean nextChance = true, nextTurn = true;
		int chance = 0, compteur = 0;
		float score = 0;
		char operation1 = ' ', operation2 = ' ';
		
		System.out.println("Ce programme demande a l utilisateur de saisir" +
				" son nom, choisir le degre de difficulte et continuer " +
				"de proposer des operations arithmetiques tant que " +
				"l utilisateur n ecrit pas FIN a la suite d une reponse " +
				"et si l utilisateur tape FIN, il lui donne le resultat" +
				" obtenu en fonction des operations faites et du nombre" +
				" de tentatives faites avant de trouver le bon " +
				"resultas(3 tentatives max)");

		System.out.print("Veuillez donner votre nom : ");
		nameUser = Clavier.lireString();

		System.out.println("Bienvenue " + nameUser + " !");
		difficulte = saisirDegreDifficulte();
		
		switch (difficulte)
		{
			case 1: JeuArithmetique.choisirDegreDifficulte(
									JeuArithmetique.getFacile());
					System.out.println("Niveau choisi: Facile.");
					break;
			case 2: JeuArithmetique.choisirDegreDifficulte(
									JeuArithmetique.getMoyen());
					System.out.println("Niveau choisi: Moyen.");
					break;
			case 3: JeuArithmetique.choisirDegreDifficulte(
									JeuArithmetique.getDifficile());
					System.out.println("Niveau choisi: Difficile.");
					break;
			case 4: JeuArithmetique.choisirDegreDifficulte(
									JeuArithmetique.getExtreme());
					System.out.println("Niveau choisi: Extreme.");
					break;
		}
			
		do {
				chance = 0;
				nextChance = true;
				++compteur;
				
				nbreOperateur = nombreOperateur();
				switch (nbreOperateur)
				{
					case 1: operation1 = JeuArithmetique.operationAuHasard();
							if (operation1 == '^')
							{
								operande1 = JeuArithmetique.
											operandeExposantAuHasard();
								operande2 = JeuArithmetique.
											operandeCareeCubeAuHasard();
							} else
							{
								operande1 = JeuArithmetique.operandeAuHasard();
								operande2 = JeuArithmetique.operandeAuHasard();
							}
							System.out.println(operande1 + " " + operation1 + 
									" " + operande2 + " = ?");
							break;
					case 2:	do
							{
								operation1 = JeuArithmetique.
													operationAuHasard();
								operation2 = JeuArithmetique.
													operationAuHasard();
							} while (operation1 == '^' || operation2 == '^');
							operande1 = JeuArithmetique.operandeAuHasard();
							operande2 = JeuArithmetique.operandeAuHasard();
							operande3 = JeuArithmetique.operandeAuHasard();
							System.out.println(operande1 + " " + operation1 + 
									" " + operande2 + " " + operation2 +
									" " + operande3 + " = ?");
							break;
				}
				
				System.out.println("");
				do {
					++chance;
					System.out.print("Entrez votre reponse : ");
					resultat = Clavier.lireInt();
					if (operation1 == '+')
						correction = operande1 + operande2;
					if (operation1 == '*')
						correction = operande1 * operande2;
					if (operation1 == '-')
						correction = operande1 - operande2;
					if (operation1 == '/')
						correction = operande1 / operande2;
					if (operation1 == '%')
						correction = operande1 % operande2;
					if (operation1 == '^')
						correction = (int) Math.pow(operande1, operande2);

					if (resultat == correction) {
						System.out.println("Bravo " + nameUser
								+ " ! Bonne reponse !");
						nextChance = false;
					} else {
						System.out.println("Desole " + nameUser
								+ ", ce n'est pas la bonne reponse.");
					}
					if (chance == 3) {
						System.out.println(nameUser + ", la reponse est : "
								+ correction);
						nextChance = false;
					}

				} while (nextChance);
			score = score + 4 - chance;
		} while (nextTurn);
		
		score = (score / 3) / compteur;
		if (score < 0.45) {
			pourcentage = "mediocre"; // le programme donnera la mention
										// appropriee en fonction du
										// score obtenu
		} else if ((score >= 0.45) && (score < 0.60)) {
			pourcentage = "passable";
		} else if ((score >= 0.60) && (score < 0.75)) {
			pourcentage = "bien";
		} else if ((score >= 0.75) && (score < 0.90)) {
			pourcentage = "tres bien";
		} else if (score >= 0.90) {
			pourcentage = "excellent";
		}
		System.out.println("score = " + ((int) Math.ceil(score * 100))
				+ " avec la mention: " + pourcentage);
	} // main
} // Tp2
