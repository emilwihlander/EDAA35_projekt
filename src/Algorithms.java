import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Algorithms {
	/**
	 * First param defines input filename, second which algorithm, third numbers of times to sort it.
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			return;
		}
		
		File file = new File(args[0]);
		int times = Integer.parseInt(args[2]);
		String alg = args[1];
		ArrayList<Integer> al = new ArrayList<Integer>();
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextInt()) {
				al.add(sc.nextInt());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int size = al.size();
		int[] list = new int[size];
		
		for (int i = 0; i < size; i++) {
			list[i] = al.get(i);
		}
		
		long[] result = new long[times];
		for (int i = 0; i < times; i++) {
			if (alg.equals("bubbleSort")) {
				result[i] = bubbleSort(list);
			} else if (alg.equals("selectionSort")) {
				result[i] = selectionSort(list);
			} else if (alg.equals("insertionSort")) {
				result[i] = insertionSort(list);
			} else if (alg.equals("combSort")) {
				result[i] = combSort(list);
			}
		}
		
		try {
			PrintWriter writer = new PrintWriter(args[1] + "_" + args[0] + "_" + args[2] + ".txt", "UTF-8");
			for (int i = 0; i < times; i++) {
				writer.println(String.valueOf(result[i]));
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static long bubbleSort(int[] list) {
		long startTime = System.nanoTime();
		int l = list.length;
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 1; i < l; i++) {
				if (list[i]<list[i-1]) {
					int tmp = list[i];
					list[i] = list[i-1];
					list[i-1] = tmp;
					swapped = true;
				}
			}
			l -= 1; //Optimering.
		}
		
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
	private static long selectionSort(int[] list) {
		long startTime = System.nanoTime();
		
		int l = list.length;
		for (int i = 0; i < l - 1; i++) {
			int min = i;
			
			for (int j = i+1; j < l; j++) {
				if (list[min] > list[j]) {
					min = j;
				}
			}
			
			if (min != i) {
				int tmp = list[i];
				list[i] = list[min];
				list[min] = tmp;
			}
		}
		
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
	private static long insertionSort(int[] list) {
		long startTime = System.nanoTime();

		int l = list.length;
		for (int i = 1; i < l; i++) {
			int tmp = list[i];
			int j = i-1;
			while (j >= 0 && list[j] > tmp) {
				list[j+1] = list[j];
				j -= 1;
			}
			list[j+1]= tmp;
		}
		
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
	private static long combSort(int[] list) {
		long startTime = System.nanoTime();

		int l = list.length;
		int gap = l;
		double shrink = 1.3;
		boolean swapped = true;
		
		while (swapped || gap != 1) {
			gap = (int) (gap/shrink);
			
			if (gap < 1) {
				gap = 1;
			}
			
			int i = 0;
			swapped = false;
			
			while (i+gap < l) {
				if (list[i] > list[i+gap]) {
					int tmp = list[i];
					list[i] = list[i+gap];
					list[i+gap] = tmp;
					swapped = true;
				}
				
				if (list[i] == list[i+gap]) {
					swapped = true;
				}
				i += 1;
			}
		}
		
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
}
