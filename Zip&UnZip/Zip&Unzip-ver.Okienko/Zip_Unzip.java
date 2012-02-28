import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.zip.*;  
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

public class Zip_Unzip extends JFrame {
  Button przy1,przy2,przy3,przy4,przy5,przy6,przy7,przy8;
  JTextField textField1 = new JTextField(12);
  JTextField textField2 = new JTextField(12);
  JTextField textField3 = new JTextField(12);
  static int a,b,c;
  static double f; 
  public Zip_Unzip() {
    super("Zip & UnZip File");
    ActionListener a = new MyActionListener();
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(textField1);
    textField1.setEditable(false);
    JButton przy1 = new JButton("Wybierz Plik");
    przy1.setActionCommand("plik"); 
    przy1.addActionListener(a);
    getContentPane().add(przy1);
    JButton przy2 = new JButton("   ZIP   ");
    przy2.setFont(new Font("Arial", Font.BOLD, 20));
	przy2.setActionCommand("zip"); 
    przy2.addActionListener(a);
    getContentPane().add(przy2); 
    JButton przy3 = new JButton("UnZIP");
    przy3.setFont(new Font("Arial", Font.BOLD, 20));
	przy3.setActionCommand("unzip"); 
    przy3.addActionListener(a);
    getContentPane().add(przy3);
    JButton przy7 = new JButton("Wyjście");
    przy7.setFont(new Font("Arial", Font.BOLD, 16));
    przy7.setForeground(Color.white);
    przy7.setBackground(Color.black);
	przy7.setActionCommand("Wyjście"); 
    przy7.addActionListener(a);
    getContentPane().add(przy7);  
    setSize(300,150);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
  class MyActionListener implements ActionListener { 
  public void actionPerformed(ActionEvent ae) {
  String s = ae.getActionCommand();
  if (s.equals("plik")){
  JFileChooser fileopen = new JFileChooser();
    FileFilter filter = new FileNameExtensionFilter("c files", "c");
    fileopen.addChoosableFileFilter(filter);
    int ret = fileopen.showDialog(null, "Wybierz plik do spakowania");
    if (ret == JFileChooser.APPROVE_OPTION) {
      File file = fileopen.getSelectedFile();
      String nazw = new String(file.getName());
	  textField1.setText(nazw);
  } 
}
  else if (s.equals("zip")){ 
		String nowa_nazw = JOptionPane.showInputDialog("Podaj nazwe dla pliku Zip");
		String nazw = new String(textField1.getText());
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
		JOptionPane.showMessageDialog(null, "Twój plik został poprawnie spakowany.");
  } 
  else if (s.equals("unzip")){ 
		OutputStream out = null;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String nazw = new String(textField1.getText());
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
				JOptionPane.showMessageDialog(null, "Twój plik został poprawnie rozpakowany.");
			out.close();
			in.close();
		} catch (IOException e) {
			System.out.println("Error: Operation failed!");
			System.exit(0);
		}
	}
  else if (s.equals("Wyjście")){
  System.exit(0);
  }
}
}
  public static void main(String argv[]) {
    new Zip_Unzip();
  }
}
