import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.zip.*;  

public class Zip_Unzip{
	static int a,b,c,x,y;
    static double f;
	static String wybor,nazw;
    
    public static void main(String argv[]) throws IOException{
    System.out.println(".:MENU:.");
    System.out.println("1.Zip File");
    System.out.println("2.Unzip File\n");
    System.out.print("> ");
    BufferedReader pyt1 = new BufferedReader(new InputStreamReader(System.in), 1);
    String wybor = pyt1.readLine();
    x = Integer.parseInt(wybor);
    if (x==1){
		System.out.println("Podaj nazwe pliku do Zipowania\n");
		System.out.print("> ");
        BufferedReader pyt2 = new BufferedReader(new InputStreamReader(System.in), 1);
		nazw = pyt2.readLine();
		String nowa_nazw = ""+nazw+".zip";
		byte[] buffer = new byte[18024];
		try{
		System.out.println("Trwa Zip'owanie pliku...");	
		ZipOutputStream out = 
		new ZipOutputStream(new FileOutputStream(nowa_nazw));
		out.setLevel(Deflater.DEFAULT_COMPRESSION);
		FileInputStream in = new FileInputStream(nazw);
		out.putNextEntry(new ZipEntry(nazw));
		int len;
		while ((len = in.read(buffer)) > 0){
		out.write(buffer, 0, len);
		}
		out.closeEntry();
		in.close();
		out.close();	
		}
		catch (IllegalArgumentException iae){
		iae.printStackTrace();
		System.exit(0);
		}
		catch (FileNotFoundException fnfe){
		fnfe.printStackTrace();
		System.exit(0);
		}
		catch (IOException ioe){
		ioe.printStackTrace();
		System.exit(0);
		}
	}
	else if(x==2){
		OutputStream out = null;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Podaj nazwe pliku do UnZipowania\n");
		System.out.print("> ");
        BufferedReader pyt2 = new BufferedReader(new InputStreamReader(System.in), 1);
		nazw = pyt2.readLine();
		try {
			if (!nazw.endsWith(".zip")) {
				System.out.println("Invalid file name!");
				System.exit(0);
			} else if (!new File(nazw).exists()) {
				System.out.println("File not exist!");
				System.exit(0);
			}

			ZipInputStream in = new ZipInputStream(new FileInputStream(nazw));
			ZipFile zf = new ZipFile(nazw);
			int a = 0;
			for (Enumeration em = zf.entries(); em.hasMoreElements();) {
				String targetfile = em.nextElement().toString();
				ZipEntry ze = in.getNextEntry();
				out = new FileOutputStream(targetfile);
				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				} // petla do rozpakowania poszczegolnych plikow w zip'ie
				a = a + 1;
			}
			if (a > 0)
			System.out.println("Twój Plik został rozpakowany!");
			out.close();
			in.close();
		} catch (IOException e) {
			System.out.println("Error: Operation failed!");
			System.exit(0);
		}
	}
}
}
