import java.util.Random;

public class Tp2 {
	
	// modification apportee: ajout de constante pour la maintenance du code
	final static int CHANCE_TOTAL = 3;
	final static int LEVEL_MIN = 1;
	final static int LEVEL_MAX = 4;
	final static int NBRE_OPERATEUR_MIN = 1;
	final static int NBRE_OPERATEUR_MAX = 2;
	
	
	/**
	 * Permet de saisir le niveau de difficulte
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

	/**
	 * Determine combien d operateurs on aura pour
	 * l operation en cours
	 * @return Un entier dont la valeur est 1 ou 2
	 */
	public static int nombreOperateur()
	{
		Random rand = new Random();
		return rand.nextInt(NBRE_OPERATEUR_MAX - NBRE_OPERATEUR_MIN + 1) +
														NBRE_OPERATEUR_MIN;
	}
	
	/**
	 * Resous l equation demandee a l utilsateur
	 * @param operande1 Premier element de l operation (nombre entier)
	 * @param operande2 Second element de l operation (nombre entier)
	 * @param operande3 Troiseme element de l operation (nombre entier)
	 * @param nbreOperateur Nombre d operateur dans l operation (1 ou 2)
	 * @param operation1 Le symbole de la premiere operation (caractere)
	 * @param operation2 Le symbole de la seconde operation (caractere)
	 * @return
	 */
	public static int determinerCorrection(int operande1, int operande2,
			int operande3, int nbreOperateur, char operation1, char operation2)
	{
		int resultat = 0;
		
		switch(nbreOperateur)
		{
			case 1: resultat = determinerCorrectionUnOperateur(
											operande1, operande2, operation1);
					break;
			case 2: if ("*/%".contains("" + operation1))
					{
						resultat = determinerCorrectionDeuxOperateurs(
					  operande1, operande2, operande3, operation1, operation2);
					} else if ("*/%".contains("" + operation2))
					{
						resultat = determinerCorrectionDeuxOperateurs(
					  operande2, operande3, operande1, operation2, operation1);
					} else
					{
						resultat = determinerCorrectionDeuxOperateurs(
					  operande1, operande2, operande3, operation1, operation2);	
					}
		}
		return resultat;
	}
	
	/**
	 * Resous l equation posee a l utilisateur (cas avec 1 operateur)
	 * 
	 * @param operande1 Premier element de l operation (nombre entier)
	 * @param operande2 Second element de l operation (nombre entier)
	 * @param operation1 le symbole de l operation (caractere)
	 * @return Un entier qui est le resultat de l operation
	 */
	private static int determinerCorrectionUnOperateur(int operande1,
			int operande2, char operation1)
	{
		int resultat = 0;
		switch (operation1)
		{
			case '+': resultat = operande1 + operande2;
					  break;
			case '-': resultat = operande1 - operande2;
					  break;
			case '*': resultat = operande1 * operande2;
					  break;
			case '/': resultat = operande1 / operande2;
					  break;
			case '%': resultat = operande1 % operande2;
					  break;
			case '^': resultat = (int) Math.pow(operande1, operande2);
					  break;
		}
		return resultat;
	}
	
	/**
	 * Resous l equation posee a l utilisateur (cas avec 2 operateurs)
	 * 
	 * @param operande1 Premier element de l operation (nombre entier)
	 * @param operande2 Second element de l operation (nombre entier)
	 * @param operande3 Troisieme element de l operation (nombre entier)
	 * @param operation1 Premier operateur de l operation (caractere)
	 * @param operation2 Second operateur de l operation (caractere)
	 * @return Un entier qui est le resultat de l operation 
	 */
	private static int determinerCorrectionDeuxOperateurs(int operande1,
			int operande2, int operande3, char operation1, char operation2)
	{
		int resultat = 0;
		resultat = determinerCorrectionUnOperateur(operande1, operande2, operation1);
		resultat = determinerCorrectionUnOperateur(resultat, operande3, operation2);
		return resultat;
	}
	
	/**
	 * Valide la reponse de l utilisateur.
	 * Elle verifie si l utilisateur a taper fin dans la reponse
	 * a l equation ou non
	 * @return retourne FIN si l utilisateur a taper fin dans sa reponse,
	 * 			sinon retourne la reponse de l utilisateur
	 */
	public static String validerReponse()
	{
		String resultat = Clavier.lireString();
		resultat = resultat.toUpperCase();
		
		if (resultat.endsWith("FIN"))
			resultat = "FIN";
		return resultat;
	}
	
	/**
	 * fonction principale
	 * @param params n est pas pris en compte
	 */
	public static void main(String[] params) {
		/*Amelioration apportee: renommage des variables pour que leur role
		 * 						 soient plus explicite a la lecture de
		 * 						 celles-ci
		 */
		String nameUser = "", pourcentage = "";
		int level = 0, operande1 = 0, operande2 = 0, operande3 = 0;
		int nbreOperateur = 1,  reponse = 0, reponseCorrecte = 0;
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
		level = saisirDegreDifficulte();
		
		switch (level)
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
		System.out.println("INSCRIVEZ 'FIN' DANS LA REPONSE D UNE EQUATION" +
				" POUR TERMINER ET OBTENIR VOTRE SCORE.");
		
		do {
				chance = 0;
				nextChance = true;
				++compteur;
				
				if (level == JeuArithmetique.getExtreme())
				{
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
				} else
				{
					operande1 = JeuArithmetique.operandeAuHasard();
					operande2 = JeuArithmetique.operandeAuHasard();
					operation1 = JeuArithmetique.operationAuHasard();
					System.out.println(operande1 + " " + operation1 + 
							" " + operande2 + " = ?");
				}
				
				System.out.println("");
				do {
					++chance;
					System.out.print("Entrez votre reponse : ");
					String reponse1 = validerReponse();
					
					if (reponse1.equals("FIN"))
					{
						chance = 4;
						--compteur;
						nextChance = false;
						nextTurn = false;
					} else
					{
						reponse = Integer.parseInt(reponse1);
						reponseCorrecte = determinerCorrection(operande1, operande2, 
								operande3, nbreOperateur, operation1, operation2);
						if (reponse == reponseCorrecte) {
							System.out.println("Bravo " + nameUser
									+ " ! Bonne reponse !");
							nextChance = false;
						} else {
							System.out.println("Desole " + nameUser
									+ ", ce n'est pas la bonne reponse.");
						}
						if (chance == 3) {
							System.out.println(nameUser + ", la reponse est : "
									+ reponseCorrecte);
							nextChance = false;
						}
					}
				} while (nextChance);
			score = score + 4 - chance;
		} while (nextTurn);
		
		score = (score / 3) / compteur;
		if (score < 0.45) {
			pourcentage = "mediocre";
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
