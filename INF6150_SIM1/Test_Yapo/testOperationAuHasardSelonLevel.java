
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
			System.out.println(JeuArithmetique.getNombreExposant());
		} while (i != 50);
		
	}
}
