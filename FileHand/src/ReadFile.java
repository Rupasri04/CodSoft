import java.io.*;
public class ReadFile {
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\C.B.Rupa sri\\OneDrive\\Desktop\\java\\FileHand\\sample.txt");
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
		
		
		
	}

}
