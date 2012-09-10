import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.io.FileInputStream;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.text.*;
import javax.swing.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class wulgator extends JFrame 
{ 
  JTextArea ta = new JTextArea(35, 50);
  JTextField textField1 = new JTextField(10);
  JCheckBoxMenuItem checkAction1 = new JCheckBoxMenuItem("Tryb Edycji");
  static String txt,tekst,kolor_prog="",tryb_ed="";
  static int t,e;
  
  public wulgator() {
    super("\t\t\t.:: PROGRAM WULGARNOŚĆ TEKSTU ::.");
    ActionListener a = new MyActionListener();
    getContentPane().setLayout(new FlowLayout());

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    menuBar.setBackground(Color.lightGray );
    JMenu plikMenu = new JMenu("Plik");
    JMenu edycjaMenu = new JMenu("Edycja");
    JMenu ustawieniaMenu = new JMenu("Ustawienia");
    menuBar.add(plikMenu);
    menuBar.add(edycjaMenu);
    menuBar.add(ustawieniaMenu);
    JMenuItem kolorystyka = new JMenuItem("Kolorystyka");
    kolorystyka.setActionCommand("kolorystyka");
    kolorystyka.addActionListener(a);
    ustawieniaMenu.add(kolorystyka);
    JMenuItem skrotyKlawiszowe = new JMenuItem("Skróty Klawiszowe");
    skrotyKlawiszowe.setActionCommand("skroty"); 
    skrotyKlawiszowe.addActionListener(a);
    ustawieniaMenu.add(skrotyKlawiszowe);
    JMenuItem openAction = new JMenuItem("Otwórz");
    openAction.setActionCommand("Wczytaj"); 
    openAction.addActionListener(a);
    openAction.setAccelerator(KeyStroke.getKeyStroke(
    KeyEvent.VK_O, ActionEvent.ALT_MASK));
    plikMenu.add(openAction);
    edycjaMenu.add(checkAction1);
    checkAction1.setActionCommand("trybEdycji");
    checkAction1.addActionListener(a);

    JMenuItem exitAction = new JMenuItem("Exit",KeyEvent.VK_T);
    exitAction.setActionCommand("Wyjście");
    exitAction.setAccelerator(KeyStroke.getKeyStroke(
    KeyEvent.VK_Q, ActionEvent.ALT_MASK)); 
    exitAction.addActionListener(a);
    plikMenu.addSeparator();
    plikMenu.add(exitAction);
    
    JLabel arg1 = new JLabel("Wczytany plik:");
	getContentPane().add(arg1);
	
	getContentPane().add(textField1);
	textField1.setForeground(Color.red);
	textField1.setEditable(false);
	
	getContentPane().add(ta);
    JScrollPane scroll = new JScrollPane(ta);
	getContentPane().add(scroll);
	ta.setForeground(Color.darkGray);

			  StringBuilder text=new StringBuilder("");
        try
        {
            BufferedReader li=new BufferedReader (new FileReader("licencja.txt"));
            BufferedReader ust=new BufferedReader (new FileReader("ustawienia.txt"));
            ust.readLine();
            ust.readLine();
            kolor_prog += ust.readLine();
            ust.readLine();
            tryb_ed += ust.readLine();
			
            while (li.ready())
            {
                text.append(li.readLine()+"\n");
            }
            li.close();
            ust.close();
             }
                                 catch (IOException e1) {
                                        System.out.println("Brak Pliku licencja.txt!");
                                        System.exit(2);
                                }
    String licencja=new String(text);	
	ta.setText(licencja);
	t = Integer.parseInt(kolor_prog);
	e = Integer.parseInt(tryb_ed);
	
	if (t==1){getContentPane().setBackground(Color.white);}
	else if (t==2){getContentPane().setBackground(Color.lightGray);}
	else if (t==3){getContentPane().setBackground(Color.gray);}
	else if (t==4){getContentPane().setBackground(Color.darkGray);}
	else if (t==5){getContentPane().setBackground(Color.black);}
	else if (t==6){getContentPane().setBackground(Color.red);}
	else if (t==7){getContentPane().setBackground(Color.pink);}
	else if (t==8){getContentPane().setBackground(Color.orange);}
	else if (t==9){getContentPane().setBackground(Color.yellow);}
	else if (t==10){getContentPane().setBackground(Color.green);}
	else if (t==11){getContentPane().setBackground(Color.magenta);}
	else if (t==12){getContentPane().setBackground(Color.cyan);}
	else if (t==13){getContentPane().setBackground(Color.blue);}
	
	if (e==0){ta.setEditable(false);}
	else if (e==1){
	     ta.setEditable(true);
	     checkAction1.setSelected(true);
	}
	
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocation(300,20);
    setSize(580, 630);
    setVisible(true);
}
  class MyActionListener implements ActionListener { 
  public void actionPerformed(ActionEvent ae){
  String s = ae.getActionCommand();
  
  if (s.equals("Wczytaj")){
	 String tekst="";
	 String wulgaryzm="";
	 String sciezka="";
	 int licznik_wulgaryzmow=0;
	JFileChooser fileopen = new JFileChooser();
	FileFilter filter = new FileNameExtensionFilter("pliki tekstowe", "txt");
	fileopen.addChoosableFileFilter(filter);
	int ret = fileopen.showDialog(null, "Otwórz");
	if (ret == JFileChooser.APPROVE_OPTION) {
		File file = fileopen.getSelectedFile();
		String nazw = new String(file.getName());
		String zbior_wulg="wulgaryzmy.txt";
		textField1.setText(nazw);
		if(!nazw.endsWith(".txt2"))
		{
			RandomAccessFile raf = null;
			RandomAccessFile tek = null;
			try {raf = new RandomAccessFile(zbior_wulg, "rw");} 
				catch (FileNotFoundException e) {
					System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
					System.exit(1);
				}
			try {tek = new RandomAccessFile(file, "rw");} 
				 catch (FileNotFoundException e) {
					System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
					System.exit(1);
				 }
		    long poz=0, dlug_pliku=0;
		    try {
				dlug_pliku = tek.length();
				tek.seek(0); // "skok" na początek pliku
				while (poz < dlug_pliku)
				{tekst += tek.readLine()+"\n";
				 poz= tek.getFilePointer();	 
				 }
			 }
			catch (IOException e) {
					System.out.println("BŁĄD ODCZYTU Z PLIKU!");
					System.exit(2);
				} 
			
			long pozycja=0, dlugoscpliku=0;
			// SWOBODNY ODCZYT Z PLIKU
			try {
				dlugoscpliku = raf.length();
				raf.seek(0); // "skok" na początek pliku
				while (pozycja < dlugoscpliku)
				{wulgaryzm = raf.readLine();
				 pozycja= raf.getFilePointer();
				 int j =0;
				while((j=(tekst.indexOf(wulgaryzm,j)+1))>0){
				System.out.println(wulgaryzm);
				licznik_wulgaryzmow++;}
		
				 }
			 } 
				 catch (IOException e2) {
					System.out.println("BŁĄD ODCZYTU Z PLIKU!");
					System.exit(3);
				} 
			}	
			    //String tekst = new String(byte[] bytes, String charsetName)
				ta.setText(tekst);
			}
  }
  else if (s.equals("trybEdycji")){
			if (checkAction1.isSelected()){
					System.out.println("Tryb Edycji Włączony");
					tryb_ed="1";
					ta.setEditable(true);
				}
			else {
					System.out.println("Tryb Edycji Wyłączony");
					tryb_ed="0";
					ta.setEditable(false);
				}
  }
  else if (s.equals("Wyjście")){
  txt=".: Ustawienia Programu :.\nKolorystyka:\n"+kolor_prog+"\nTryb Edycji:\n"+tryb_ed;
  FileWriter writer;
    try {
      writer = new FileWriter("ustawienia.txt");
      //char c = txt;
      System.out.println(txt);
      writer.write(txt);
      writer.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  System.exit(0);
  
  }
  }
}
  public static void main(String argv[]) { 
    new wulgator();
  }
}
