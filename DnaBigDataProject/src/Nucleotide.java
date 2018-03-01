import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Nucleotide {
   
   //Fields
	public File file = null;
	public File nucleotideFile = null;
	public File base10File = null;
	private boolean bool = false;
	
   //Constructors
	Nucleotide() {}
	
	Nucleotide(File nucleotideFile, String fileName) throws IOException {
		file = new File(fileName);
		bool = file.exists();
		System.out.println("File created? " + bool);
		this.setNucleotideFile(nucleotideFile);
		base10File = new File("src/intFile");
	}
   
   //Methods
	public void setNucleotideFile(File nucleotideFile) {
		this.nucleotideFile = nucleotideFile;		
	}
	
	public File getNucleotideFile() {
		return nucleotideFile;
	}
	
   
	public double process() throws FileNotFoundException {
		String nuc = "";
		Scanner input = new Scanner(this.nucleotideFile);
		while(input.hasNext()) {
			nuc = nuc + input.next();
		}
		input.close();
		String binary = "";
		for(int i = 0; i < nuc.length(); i++) {
			String m;
			switch(nuc.charAt(i)) {
				case 'A': m = "00"; break;
				case 'T': m = "01"; break;
				case 'C': m = "10"; break;
				case 'G': m = "11"; break;
				default: m = ""; break;
			}
			binary = binary + m;
		}
		java.io.PrintWriter writer = new java.io.PrintWriter(this.file);
		writer.print(binary);
		writer.close();
		char[] numbers = binary.toCharArray();
		double result = 0;
		for(int i = numbers.length - 1; i >= 0; i--) {
			if(numbers[i] == '1') {
				result += Math.pow(2,  (numbers.length - i - 1));
			}
		}
		java.io.PrintWriter writer2 = new java.io.PrintWriter(this.base10File);
		writer2.print(result);
		writer2.close();
		System.out.println("Base Ten of the binary: " + result);		
		result = Math.abs(result);
		result = ((double) result / 2147483647);
		System.out.println("Fraction of base 10: " + result);
		return result;
	}
	
}//end class





