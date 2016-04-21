package makeIndata;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class almostNotSortedIndata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nbr = 2000;
		Random rand = new Random(42);
		try {
			PrintWriter writer = new PrintWriter("almost_not_sorted_" + nbr, "UTF-8");
			for (int i = nbr; i > 0; i--) {
				switch(i) {
				case(498): {
					writer.println(rand.nextInt(2) + i + 1);
					break;
				}
				case(499): {
					writer.println(rand.nextInt(1) + i + 1);
					break;
				}
				case(500): {
					writer.println(500);
					break;
				}
				default: {
					writer.println(rand.nextInt(3) + i + 1);
					break;
				}
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fel filnamn");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
