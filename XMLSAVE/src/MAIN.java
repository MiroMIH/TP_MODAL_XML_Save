import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class MAIN {
	
	public static void save(Exception e, String type) {
		File f = new File("C:\\test\\exception.xml");
		try {
			FileWriter fw=new FileWriter(f,true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.newLine();
			bw.write("<Exception>");
			bw.write("<Date>");
			bw.write(new Date().toString());
			bw.write("</Date>");
			bw.write("<Message>" + e.getMessage() + "</Message>");
			bw.write("<Class>" + e.getStackTrace()[0].getClassName() + "</Class>");
			bw.write("<Type>" + type + "</Type>");
//			bw.write("<Date>" + new Date() + "</Date>");
			
			
 
	//		bw.write()
			bw.write("</Exception>");
			//CLOSE STREAM
			bw.close();
			fw.close();
		}
		catch(IOException ex) {
			System.out.println("ERROR WHILE WRITING THE FILE : "+ex.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\test\\exception.xml");
		try {
			FileWriter fw=new FileWriter(f,false);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.newLine();
			bw.write("<Exceptions N=\"0\">");
			bw.close();
			fw.close();
		}
		catch(IOException ex) {
			System.out.println("ERROR WHILE WRITING THE FILE : "+ex.getMessage());
		}
		
		for(int i=0; i<5; i++) {
			try
			{
					int x = 0;
					int y = 5 / x;
			}
			catch(ArithmeticException e)
			{
					System.out.println(e.getMessage());
					save(e, "Exception artithmetique");
			}
			catch(Exception e)
			{
					System.out.println(e.getMessage());
					save(e, "Exception");
			}
		}
		
		
		try {
			FileWriter fw=new FileWriter(f,true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.newLine();
			bw.write("</Exceptions>");
			bw.close();
			fw.close();
		}
		catch(IOException ex) {
			System.out.println("ERROR WHILE WRITING THE FILE : "+ex.getMessage());
		}
			
	}

}
