import java.io.*;
import java.util.*;
public class CreateFile {
	public static void main(String[] args) throws IOException{
		File f=new File("C:\\Users\\C.B.Rupa sri\\OneDrive\\Desktop\\java\\FileHand\\sample.txt");
		FileWriter fw=null;
		try {
			fw = new FileWriter(f);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			fw.write("WELCOME HAVE A GOOD DAY");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileReader fr=null;
		try {
			fr=new FileReader(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int a=0;
		try {
			a = fr.read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(a!=-1)
		{
			System.out.print((char)a);
			try {
				a=fr.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		try {
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			fw.close();
			}
		}
	}


