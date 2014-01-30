public class Tp2 {

	public static int saisirDegreDifficulte() {
		int level = 0;
		boolean acces = true;
		do {
			System.out.print("Choisissez un degre de difficulte" +
					" (1-facile, 2-moyen, 3-difficile ou 4-extreme) : ");
			level = Clavier.lireInt();

			if ((1 <= level) && (level <= 4)) {
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

	public static void main(String[] params) {
		String nameUser = "";
		int difficulte = 0;
		String choix = "";
		int operande1, operande2, correction = 0, resultat = 0;
		boolean acces2 = true;
		boolean acces3 = true;
		int i = 0;
		int compteur = 0;
		float score = 0;
		char operation = ' ';
		String pourcentage = "";
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

		do {
			i = 0;
			acces2 = true;
			choix = saisirReponseOuiNon();

			if (choix.compareTo("OUI") == 0 || choix.compareTo("O") == 0
					|| choix.compareTo("o") == 0 || choix.compareTo("oui") == 0) {
				j++;
				if (difficulte.compareTo("moyen") == 0
						|| difficulte.compareTo("MOYEN") == 0) {
					JeuArithmetique.choisirDegreDifficulte(JeuArithmetique
							.getMoyen());
				}
				if (difficulte.compareTo("facile") == 0
						|| difficulte.compareTo("FACILE") == 0) {
					JeuArithmetique.choisirDegreDifficulte(JeuArithmetique
							.getFacile());
				}
				if (difficulte.compareTo("difficile") == 0
						|| difficulte.compareTo("DIFFICILE") == 0) {
					JeuArithmetique.choisirDegreDifficulte(JeuArithmetique
							.getDifficile());
				}
				if (difficulte.compareTo("extreme") == 0
						|| difficulte.compareTo("EXTREME") == 0) {
					JeuArithmetique.choisirDegreDifficulte(JeuArithmetique
							.getExtreme());
				}

				operation = JeuArithmetique.operationAuHasard();
				System.out.println("nombre expo "+JeuArithmetique.getNombreExposant());
				if (JeuArithmetique.getNombreExposant() == 1) {
					operande1 = JeuArithmetique.operandeExposantAuHasard();
					operande2 = JeuArithmetique.operandeCareeCubeAuHasard();
					JeuArithmetique.setNombreExposant(0);
				} else {
					operande1 = JeuArithmetique.operandeAuHasard();
					operande2 = JeuArithmetique.operandeAuHasard();
				}

				System.out.println(operande1 + " " + operation + " "
						+ operande2 + " = ?");

				System.out.println("");
				do {
					i++;
					System.out.print("Entrez votre reponse : ");
					resultat = Clavier.lireInt();
					if (operation == '+')
						correction = operande1 + operande2;
					if (operation == '*')
						correction = operande1 * operande2;
					if (operation == '-')
						correction = operande1 - operande2;
					if (operation == '/')
						correction = operande1 / operande2;
					if (operation == '%')
						correction = operande1 % operande2;
					if (operation == '^')
						correction = (int) Math.pow(operande1, operande2);

					if (resultat == correction) {
						System.out.println("Bravo " + nom
								+ " ! Bonne reponse !");
						acces2 = false;
					} else {
						System.out.println("Desole " + nom
								+ ", ce n'est pas la bonne reponse.");
					}
					if (i == 3) {
						System.out.println(nom + ", la reponse est : "
								+ correction);
						acces2 = false;
					}

				} while (acces2);// ajouter la condition de s il trouve la
									// reponse juste avant trois tentative.
			} else {

				score = (score / 3) / j;
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
				acces3 = false;
			}

			score = score + 4 - i;
		} while (acces3);

	} // main
} // Tp2
