
public class testNombreOperateur {
	/*
	 * Permet de s assurer que le nombre aleatoire genere est varie toujours
	 * entre 1 et 2.
	 */
	public static void main (String[] params)
	{
		int i = 0;
		do
		{
			++i;
			System.out.print(Tp2.nombreOperateur() + " ");
		} while (i != 10);
	}
}
