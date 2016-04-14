package makeIndata;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class almostSortedIndata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nbr = 500;
		Random rand = new Random();
		try {
			PrintWriter writer = new PrintWriter("almost_sorted_2_" + nbr, "UTF-8");
			for (int i = 0; i < nbr; i++) {
				switch(i) {
				case(497): {
					writer.println(rand.nextInt(2) + i + 1);
					break;
				}
				case(498): {
					writer.println(rand.nextInt(1) + i + 1);
					break;
				}
				case(499): {
					writer.println(nbr);
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
