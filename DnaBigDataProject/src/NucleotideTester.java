import java.io.File;
import java.io.IOException;
import java.util.*;

public class NucleotideTester {

	public static void main(String[] args) throws IOException {
		File dnaFile = new File("src/nucleotidePairsTester100.csv");
		Nucleotide object1 = new Nucleotide(dnaFile, "src/BinaryFile");
		double base10Fraction = object1.process();
		
		boolean bool2 = object1.base10File.exists();
		System.out.println("Does object1.base10File exists()? " + bool2);
		
		System.out.println(base10Fraction);
		
		//read binary file
		System.out.println("\nReading from binary file:" );
		Scanner read = new Scanner(object1.file);
		while(read.hasNext()) {
			System.out.println(read.next());
		}
		read.close();
				
		//read int base 10 file
		System.out.println("\nReading from int file:" );
		Scanner read2 = new Scanner(object1.base10File);
		while(read2.hasNext()) {
			System.out.println(read2.next());
		}
		read2.close();
		
	}//end main

}
