package snippets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This example take a list of fully qualified filenames and transforms every
 * node in a parent-child relation
 * 
 * @author lorenzo
 *
 */
public class VectorToParentChild {

	public static void main(String[] args) {
		
		System.out.println("Staring app...");

		InputStreamReader isReader = new InputStreamReader(System.in);
		BufferedReader bufReader = new BufferedReader(isReader);

		String inputStr = "";
		while (inputStr != null) {
			try {
				inputStr = bufReader.readLine();
				System.out.println("Line is: [" + inputStr + "]");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Process complete");
	}

}
