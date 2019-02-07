import java.util.ArrayList;
import java.util.Scanner;

/**
 * The one and only class of this converter
 */
public class Main {
    /**
     * Scanner object which is declared globally for this class to allow reuse of code
     */
    public static Scanner in = new Scanner(System.in);

    /**
     * Main method for the entire converter
     * @param args
     */
    public static void main(String[] args)
    {
        int k;
        System.out.println("Hexadecimal to Binary/decimal converter\nBy Muazzam Shaheryar\nFor CSC3100");
        boolean closer = false;
        while (!closer)
        {
            showMenu();
            k = in.nextInt();
            switch (k)
            {
                case 1:
                {
                    String hexa = inputGetter();
                    System.out.println(hexa +" in decimal is: "+hexaToDecimal(hexa));
                    break;
                }
                case 2:
                {
                    String hexa = inputGetter();
                    System.out.println(hexa +" in binary is: "+hexaToBinary1(hexa));
                    break;
                }
                case 3:
                {
                    String hexa = inputGetter();
                    System.out.println(hexa +" in binary is: "+hexaToBinary2(hexa));
                    break;
                }
                case 4:
                {
                    System.out.println("Goodbye");
                    closer = true;
                    break;
                }
                default:
                {
                    System.out.println("Wrong input. Input must be from 1-3\n");
                    break;
                }
            }
        }
    }

    /**
     * Method to show the menu
     */
    public static void showMenu()
    {
        System.out.print("1)Hexadecimal to Decimal\n2)Hexadecimal to Binary (without preceding zeros)\n3)" +
                "Hexadecimal to Binary (with Preceding zeros)\n4)Quit\nPlease select a choice: ");
    }

    /**
     * Method to get the input
     * @return returns the obtained hexadecimal from the user
     */
    public static String inputGetter()
    {
        String hexa;
        System.out.print("Please enter the hexadecimal: ");
        hexa = in.next();
        return hexa;
    }

    /**
     * Converts hexadecimal to decimal
     * @param hexa hexadecimal value
     * @return returns the decimal value calculated
     */
    public static double hexaToDecimal(String hexa)
    {
        double finalTotal = 0;
        double y =0;
        double base = Math.pow(16,y);
        char [] container = hexa.toCharArray();
        for(int k =0;k< container.length;k++)
        {
            if(container[k]>= 'a' && container[k]<='z' )
            {
                container[k] = Character.toUpperCase(container[k]);
            }
        }
        for (int i =hexa.length()-1; i >= 0;i--)
        {
            if(container[i] >= 'A' && container[i] <= 'Z')
            {
                finalTotal = finalTotal+((container[i]-55)*base);
                base = Math.pow(16,++y);
            }
            else if(container[i] >= '0'&& container[i] <= '9')
            {
                finalTotal = finalTotal +((container[i]-48)*base);

                base = Math.pow(16,++y);
            }
        }
        return finalTotal;
    }

    /**
     * Converts hexadecimal to binary<br>
     * This method uses the decimal value obtained by calling hexaToDecimal method
     * @param hexa hexadecimal value
     * @return returns the binary value without the preeceding zeros
     */
    public static String hexaToBinary1(String hexa)
    {
        Double q =hexaToDecimal(hexa);
        int f = q.intValue();
        ArrayList <Integer> x = new ArrayList<>();
        while (f > 0)
        {
            x.add(f%2);
            f=f/2;
        }
        StringBuilder total = new StringBuilder();
        for(Integer k : x)
        {
            total.append(k);
        }
        total = total.reverse();
        String finalTotal = total.toString();
        return finalTotal;
    }

    /**
     * Converts hexadecimal to binary<br>
     * This method uses a little more hard coded method to convert to binary, by comparing each char used in the hexadecimal value
     * @param hexa hexadecimal value
     * @return returns a string the has the converted binary value
     */
    public static String hexaToBinary2(String hexa)
    {
        char [] number ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String [] bin ={"0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        StringBuilder temp = new StringBuilder();
        char [] container = hexa.toCharArray();
        for(int k =0;k< container.length;k++)
        {
            if(container[k]>= 'a' && container[k]<='z' )
            {
                container[k] = Character.toUpperCase(container[k]);
            }
        }
        for(int i = 0; i < hexa.length();i++)
        {
            for (int t = 0;t <15;t++)
            {
                if(container[i] == number[t])
                {
                    temp.append(bin[t]);
                }
            }
        }
        String finalTotal = temp.toString();
        return finalTotal;
    }
}
