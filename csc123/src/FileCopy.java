import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		String data="Some new informatiojn.... This is some data that I want to write into a file!!";
		
		File myFile=new File("D:/TestFiles/newFile.txt");
		FileOutputStream out=null;
		try {
			myFile.createNewFile();//Create new file
			
			out=new FileOutputStream(myFile);
			byte[] dataInBytes=data.getBytes();
			
			out.write(dataInBytes);
			out.flush();
	
		}
		catch(FileNotFoundException fne) {
			System.out.println("File not found!!");
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		finally {
			try {
				out.close();
			}
			catch(IOException ignored) {}
		}	
	}
}


