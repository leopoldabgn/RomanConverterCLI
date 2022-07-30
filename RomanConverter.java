
import java.util.Scanner;

public class RomanConverter
{
	
	public static char[] romanNb = new char[] {'I','V','X','L','C','D','M'}; // 1 -> 1399
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String nb;
		int temp;
		boolean bool = true;
		//boolean cli = args.length >= 1 && args[1].equals("-i");
		//System.out.println(args.length+" "+cli);
		while(bool)
		{
			do
			{
				System.out.print("\nGive me a roman numeral to convert : ");
				nb = sc.nextLine();
				
				if(isInteger(nb))
				{
					temp = Integer.parseInt(nb);
					if(temp <= 0)
					{
						System.out.println("Your number must be greater than 0.");
						nb = "null";
					}
					else if(temp >= 4000)
					{
						System.out.println("Your number must be less than 4000.");
						nb = "null";
					}
					
				}
				
			}while(!isInteger(nb));

			System.out.println("\n"+convert(nb));
			System.out.println("\nAnother one ? y/n");
			if(sc.nextLine().toUpperCase().charAt(0) != 'Y')
				bool = false;
		}
		sc.close();
	}

	public static String convert(String nb)
	{
		int n1, n2 = 1;
		String romanNumber = "";
		for(int i=nb.length()-1;i>=0;i--)
		{
			n1 = nb.charAt(i) - '0';
			
			if(n1 >= 1 && n1 <= 3)
			{
				for(int j=0;j<n1;j++)
					romanNumber = getRomanNb(n2)+romanNumber;
			}
			else if(n1 == 4)
			{
				romanNumber = getRomanNb(5*n2)+romanNumber;
				romanNumber = getRomanNb(n2)+romanNumber;
			}
			else if(n1 == 5)
			{
				romanNumber = getRomanNb(n1*n2)+romanNumber;
			}
			else if(n1 >= 6 && n1 <= 8)
			{
				for(int j=6;j<=n1;j++)
					romanNumber = getRomanNb(n2)+romanNumber;
				romanNumber = getRomanNb(5*n2)+romanNumber;
			}
			else if(n1 == 9)
			{
				romanNumber = getRomanNb(n2*10)+romanNumber;
				romanNumber = getRomanNb(n2)+romanNumber;
			}
			n2 *= 10;
		}
		
		return romanNumber;
	}
	
	public static char getRomanNb(int nb)
	{
		switch(nb)
		{
		case 1:
			return romanNb[0];
		case 5:
			return romanNb[1];
		case 10:
			return romanNb[2];
		case 50:
			return romanNb[3];
		case 100:
			return romanNb[4];
		case 500:
			return romanNb[5];
		case 1000:
			return romanNb[6];
		default:
			return '\0';
		}
	}
	
	public static boolean isInteger(String nb)
	{
		try
		{
			Integer.parseInt(nb);
			return true;
		}
		catch(Exception e) 
		{
			return false;
		}
	}
	
}
