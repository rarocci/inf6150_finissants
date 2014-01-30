
public class testOperationAuHasardSelonLevel {
	public static void main (String[] params)
	{
		int i = 0;
		do
		{
			++i;
			JeuArithmetique.choisirDegreDifficulte(
					JeuArithmetique.getExtreme());
			JeuArithmetique.operationAuHasard();
			System.out.print(JeuArithmetique.getNombreExposant() + " ");
		} while (i != 25);
		
	}
}
