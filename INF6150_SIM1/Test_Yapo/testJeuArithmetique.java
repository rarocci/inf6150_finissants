/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chrisictiantelemaque
 */
public class testJeuArithmetique {

    public static void main(String[] params) {
            test1();
            test2();
            test3();
            test4();
        
    }

    public static void test1() {
        char operation = JeuArithmetique.operationAuHasard();
        if ((operation == '+') || (operation == '-')
                               || (operation == '*') || (operation == '/')
                               || (operation == '%') || (operation == '^')){
            System.out.println("test1 JeuArithmetique.operationAuHasard() reussi");
        }else System.out.println("test1 JeuArithmetique.operationAuHasard() erreur");
    }
    
    public static void test2() {
        char operation = JeuArithmetique.operationAuHasardSansExposant();
        if ((operation == '+') || (operation == '-')
                               || (operation == '*') || (operation == '/')
                               || (operation == '%')){
            System.out.println("test2 JeuArithmetique.operationAuHasardSansExposant() reussi");
        }else System.out.println("test2 JeuArithmetique.operationAuHasardSansExposant() erreur");
    }
    
    public static void test3() {
        int nombre = JeuArithmetique.operandeCareeCubeAuHasard();
        if ((nombre == 2) || (nombre == 3)){
            System.out.println("test3 JeuArithmetique.operandeCareeCubeAuHasard() reussi");
        }else System.out.println("test3 JeuArithmetique.operandeCareeCubeAuHasard() erreur");
    }
    
    public static void test4() {
        int nombre = JeuArithmetique.operandeExposantAuHasard();
        if ((nombre >= 2) || (nombre <= 10)){
            System.out.println("test4 JeuArithmetique.operandeExposantAuHasard() reussi");
        }else System.out.println("test4 JeuArithmetique.operandeExposantAuHasard() erreur");
    }
}
