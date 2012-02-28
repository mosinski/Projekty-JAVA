import java.io.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileInputStream;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.text.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Plik_edycja_okienko extends JFrame
{ Button przy1,przy2,przy3,przy4,przy5,przy6,przy7;
  JTextArea ta = new JTextArea(35, 50);
  JTextField textField1 = new JTextField(10);
  JTextField textField2 = new JTextField(10);
  JTextField textField3 = new JTextField(3);
  JTextField textField4 = new JTextField(3);
  static String tlo_zapis="";
  static String kolor_zapis="";
  static String czcionka_zapis="";
  static String wielkosc_zapis="";
  static String tekst="";
  static String tekst1="";
  static String tekst2="";
  static String nazw="";
  static String str;
  static String objectAsString;
  static int t,x,y,z;
                
  public Plik_edycja_okienko(){
    super("\t\t\t.:: PROGRAM EDYTOR TEKSTU ::.");
    ActionListener a = new MyActionListener();
    getContentPane().setLayout(new FlowLayout());  
    JLabel arg1 = new JLabel("Wczytany plik:");
	getContentPane().add(arg1);
	getContentPane().add(textField1);
	textField1.setForeground(Color.red);
	textField1.setEditable(false);
	JLabel arg2 = new JLabel("Czcionka:");
	getContentPane().add(arg2);
    getContentPane().add(textField2);
    textField2.setForeground(Color.red);
    textField2.setEditable(false);
    JLabel arg3 = new JLabel("Kolor:");
	getContentPane().add(arg3);
	getContentPane().add(textField3);
    textField3.setEditable(false);
    JLabel arg4 = new JLabel("Tło:");
	getContentPane().add(arg4);
    getContentPane().add(textField4);
    textField4.setEditable(false);
	getContentPane().add(ta);
    JScrollPane scroll = new JScrollPane(ta);
	getContentPane().add(scroll);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon nowy = new ImageIcon("ikony/nowy.gif");
    JButton przy7 = new JButton();
    przy7.setIcon(nowy); 
    przy7.setToolTipText("Nowy..");
	przy7.setActionCommand("Nowy"); 
    przy7.addActionListener(a);
    getContentPane().add(przy7);
    ImageIcon wczytaj = new ImageIcon("ikony/wczytaj.jpg");
    JButton przy1 = new JButton();
    przy1.setIcon(wczytaj); 
    przy1.setToolTipText("Wczytaj..");
	przy1.setActionCommand("Wczytaj"); 
    przy1.addActionListener(a);
    getContentPane().add(przy1);
    ImageIcon zapisz = new ImageIcon("ikony/zapisz.jpg");
    JButton przy2 = new JButton();
    przy2.setIcon(zapisz); 
    przy2.setToolTipText("Zapisz..");
	przy2.setActionCommand("Zapisz"); 
    przy2.addActionListener(a);
    getContentPane().add(przy2);
    ImageIcon zapisz_jako = new ImageIcon("ikony/zapisz_jako.jpg");
    JButton przy3 = new JButton();
    przy3.setIcon(zapisz_jako); 
    przy3.setToolTipText("Zapisz jako..");
	przy3.setActionCommand("Zapisz_jako"); 
    przy3.addActionListener(a);
    getContentPane().add(przy3);
    ImageIcon czcionka = new ImageIcon("ikony/czcionka.gif");
    JButton przy4 = new JButton();
    przy4.setIcon(czcionka); 
    przy4.setToolTipText("Czcionka..");
	przy4.setActionCommand("Czcionka"); 
    przy4.addActionListener(a);
    getContentPane().add(przy4);
    ImageIcon tlo = new ImageIcon("ikony/tlo.gif");
    JButton przy5 = new JButton();
    przy5.setIcon(tlo); 
    przy5.setToolTipText("Tło..");
	przy5.setActionCommand("Tło"); 
    przy5.addActionListener(a);
    getContentPane().add(przy5); 
    ImageIcon wyjscie = new ImageIcon("ikony/exit.png");
    JButton przy6 = new JButton();
    przy6.setIcon(wyjscie); 
    przy6.setToolTipText("Wyjście..");
	przy6.setActionCommand("Wyjście"); 
    przy6.addActionListener(a);
    getContentPane().add(przy6);
    setSize(600, 660);
    setVisible(true);  
}
  class MyActionListener implements ActionListener { 
  public void actionPerformed(ActionEvent ae){
  String s = ae.getActionCommand();
  
  if (s.equals("Nowy")){
	  String now_nazw = JOptionPane.showInputDialog("Podaj nazwe pliku (bez rozszerzenia!):");
		nazw =new String (now_nazw);
		Object[] options = {" TXT2 "," TXT "};
		int n = JOptionPane.showOptionDialog(null,"W jakim formacie chcesz zapisać plik ??\n\ntxt = zwykły format przechowuje zawartość tekstową\ntxt2 = przechowuje zawartość tekstową oraz czcionki i kolory",
		"Jaki format txt/txt2",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		if(n==0){nazw+=".txt2";}
		else if(n==1){nazw+=".txt";}
		textField1.setText(nazw);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(nazw); //Otwieranie pliku 
			t=0;
			z=2;
			x=0;
			y=12;
			JOptionPane.showMessageDialog(null, "Twój plik został poprawnie Stworzony.");
			} 
			catch(IOException ex){
			 System.out.println("Błąd operacji na pliku: "+ex);
			}			
  }
  else if (s.equals("Wczytaj")){
	 String tekst="";
	JFileChooser fileopen = new JFileChooser();
	FileFilter filter = new FileNameExtensionFilter("pliki tekstowe", "txt");
	fileopen.addChoosableFileFilter(filter);
	int ret = fileopen.showDialog(null, "Otwórz");
	if (ret == JFileChooser.APPROVE_OPTION) {
		File file = fileopen.getSelectedFile();
		String nazw = new String(file.getName());
		textField1.setText(nazw);
		if(!nazw.endsWith(".txt2"))
		{
			RandomAccessFile raf = null;
			try {raf = new RandomAccessFile(nazw, "rw");} 
				catch (FileNotFoundException e) {
					System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
					System.exit(1);
				}
			long pozycja=0, dlugoscpliku=0;
			// SWOBODNY ODCZYT Z PLIKU
			try {
				dlugoscpliku = raf.length();
				raf.seek(0); // "skok" na początek pliku
				while (pozycja < dlugoscpliku)
				{tekst += raf.readLine()+"\n";
				 pozycja= raf.getFilePointer();}
				 } 
				 catch (IOException e1) {
					System.out.println("BŁĄD ODCZYTU Z PLIKU!");
					System.exit(2);
				} 
			}
		else{
		RandomAccessFile raf = null;
		try {raf = new RandomAccessFile(nazw, "rw");} 
		catch (FileNotFoundException e) {
					System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
					System.exit(1);
				}
		
			long pozycja=0, dlugoscpliku=0;
			// SWOBODNY ODCZYT Z PLIKU
		try {
				dlugoscpliku = raf.length();
				raf.seek(0); // "skok" na początek pliku
				tlo_zapis += raf.readLine();
				kolor_zapis += raf.readLine();
				czcionka_zapis +=raf.readLine();
				wielkosc_zapis +=raf.readLine();
				while (pozycja < dlugoscpliku){
						tekst += raf.readLine()+"\n";
						pozycja= raf.getFilePointer();
					}
				t = Integer.parseInt(tlo_zapis);	
				z = Integer.parseInt(kolor_zapis);
				x = Integer.parseInt(czcionka_zapis);
				y = Integer.parseInt(wielkosc_zapis);
				
				
			    if (z==0){
					textField3.setBackground(Color.white);
		            ta.setForeground(Color.white);}
				else if (z==1){
					textField3.setBackground(Color.cyan);
		            ta.setForeground(Color.cyan);}
		        else if (z==2){
					textField3.setBackground(Color.black);
		            ta.setForeground(Color.black);}    
		        else if (z==3){
					textField3.setBackground(Color.red);
		            ta.setForeground(Color.red);}
				else if (z==4){
					textField3.setBackground(Color.blue);
		            ta.setForeground(Color.blue);}
				else if (z==5){
					textField3.setBackground(Color.pink);
		            ta.setForeground(Color.pink);}
		        else if (z==6){
					textField3.setBackground(Color.DARK_GRAY);
		            ta.setForeground(Color.DARK_GRAY);}
		        else if (z==7){
					textField3.setBackground(Color.yellow);
		            ta.setForeground(Color.yellow);}
		        else if (z==8){
					textField3.setBackground(Color.green);
		            ta.setForeground(Color.green);}
		            
		        if (t==0){ta.setBackground(Color.white);
		        textField4.setBackground(Color.white);}
				else if (t==1){ta.setBackground(Color.black);
				textField4.setBackground(Color.black);}
				else if (t==2){ta.setBackground(Color.red);
				textField4.setBackground(Color.red);}
				else if (t==3){ta.setBackground(Color.blue);
				textField4.setBackground(Color.blue);}
				else if (t==4){ta.setBackground(Color.gray);
				textField4.setBackground(Color.gray);}
				else if (t==5){ta.setBackground(Color.pink);
				textField4.setBackground(Color.pink);}
				else if (t==6){ta.setBackground(Color.green);
				textField4.setBackground(Color.green);}
				else if (t==7){ta.setBackground(Color.yellow);
				textField4.setBackground(Color.yellow);}
				
		        if (x==0){Font Arial = new Font("arial",Font.PLAIN, y);
					textField2.setText("Arial "+y);
					ta.setFont(Arial);}
				else if (x==1){Font Algerian = new Font("algerian",Font.PLAIN, y);
					textField2.setText("Algerian "+y);
					ta.setFont(Algerian);}
				else if (x==2){Font TimesRoman = new Font("TimesRoman",Font.PLAIN, y);
					textField2.setText("TimesRoman "+y);
					ta.setFont(TimesRoman);}
				else if (x==3){Font Courier = new Font("courier",Font.PLAIN, y);
					textField2.setText("Courier "+y);
					ta.setFont(Courier);}
				else if (x==4){Font Serif = new Font("serif",Font.PLAIN, y);
					textField2.setText("Serif "+y);
					ta.setFont(Serif);}
				else if (x==5){Font Sansserif = new Font("sansserif",Font.PLAIN, y);
					textField2.setText("Sansserif "+y);
					ta.setFont(Sansserif);}
				else if (x==6){Font Monospaced = new Font("monospaced",Font.PLAIN, y);		
					textField2.setText("Monospaced "+y);
					ta.setFont(Monospaced);}
				} catch (IOException e1) {
					System.out.println("BŁĄD ODCZYTU Z PLIKU!");
					System.exit(2);
				} 
			}		
				ta.setText(tekst);
			}
  }
  else if (s.equals("Zapisz")){
	  tekst2 ="";
	  nazw = "";
	  nazw += textField1.getText();
	  if(nazw.endsWith(".txt2")){
				tekst2 +=t+"\n";
				tekst2 +=z+"\n";
				tekst2 +=x+"\n";
				tekst2 +=y+"\n";
				String tekst = new String(ta.getText());
				tekst2 +=tekst;
				StringBuffer sb = new StringBuffer(tekst2);
				String str = new String(sb.toString());
				FileOutputStream fos = null;
				try {
						fos = new FileOutputStream(nazw); //Otwieranie pliku 
						for(int i = 0; i < str.length(); i++){
						fos.write((int)str.charAt(i)); //Zapis bajt po bajcie każdego znaku...
						}
						JOptionPane.showMessageDialog(null, "Twój plik został poprawnie Zapisany.");
						} 
						catch(IOException ex){
						System.out.println("Błąd operacji na pliku: "+ex);
						}
		}
	 else if(nazw.endsWith(".txt")){
		  String tekst = new String(ta.getText());
		  tekst2 +=tekst;
		  StringBuffer sb = new StringBuffer(tekst2);
		  String str = new String(sb.toString());
		  FileOutputStream fos = null;
			try {
					fos = new FileOutputStream(nazw); //Otwieranie pliku 
					for(int i = 0; i < str.length(); i++){
					fos.write((int)str.charAt(i)); //Zapis bajt po bajcie każdego znaku...
					}
					JOptionPane.showMessageDialog(null, "Twój plik został poprawnie Zapisany.");
					} 
					catch(IOException ex){
					System.out.println("Błąd operacji na pliku: "+ex);
					}
				}
	else if(nazw.length() == 0){
		JOptionPane.showMessageDialog(null,"Brak nazwy pliku. Aby stworzyć plik naciśnij \"Nowy\"","Błąd. Brak nazwy!",JOptionPane.ERROR_MESSAGE);
  }
}
  else if (s.equals("Zapisz_jako")){
	  tekst2 ="";
	  nazw = "";
	  nazw += textField1.getText();
	  Object[] options = {" TXT2 "," TXT "};
		int n = JOptionPane.showOptionDialog(null,"W jakim formacie chcesz zapisać plik ??\n\n.txt   = zwykły format przechowuje zawartość tekstową\n.txt2 = przechowuje zawartość tekstową oraz czcionki i kolory\n\n",
		"Zapisz jako..",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		if (n==0 && nazw.endsWith(".txt")){
				nazw+="2";
				textField1.setText(nazw);
				tekst2 +=t+"\n";
				tekst2 +=z+"\n";
				tekst2 +=x+"\n";
				tekst2 +=y+"\n";
				String tekst = new String(ta.getText());
				tekst2 +=tekst;
				StringBuffer sb = new StringBuffer(tekst2);
				String str = new String(sb.toString());
				FileOutputStream fos = null;
				try {
						fos = new FileOutputStream(nazw); //Otwieranie pliku 
						for(int i = 0; i < str.length(); i++){
						fos.write((int)str.charAt(i)); //Zapis bajt po bajcie każdego znaku...
						}
						JOptionPane.showMessageDialog(null, "Twój plik został poprawnie Zapisany.");
						} 
						catch(IOException ex){
						System.out.println("Błąd operacji na pliku: "+ex);
						}
			}
			else if (n==0 && nazw.endsWith(".txt2")){
				tekst2 +=t+"\n";
				tekst2 +=z+"\n";
				tekst2 +=x+"\n";
				tekst2 +=y+"\n";
				String tekst = new String(ta.getText());
				tekst2 +=tekst;
				StringBuffer sb = new StringBuffer(tekst2);
				String str = new String(sb.toString());
				FileOutputStream fos = null;
				try {
						fos = new FileOutputStream(nazw); //Otwieranie pliku 
						for(int i = 0; i < str.length(); i++){
						fos.write((int)str.charAt(i)); //Zapis bajt po bajcie każdego znaku...
						}
						JOptionPane.showMessageDialog(null, "Twój plik został poprawnie Zapisany.");
						} 
						catch(IOException ex){
						System.out.println("Błąd operacji na pliku: "+ex);
						}
				}
			else if (n==1 && nazw.endsWith(".txt")){
				String tekst = new String(ta.getText());
				tekst2 +=tekst;
				StringBuffer sb = new StringBuffer(tekst2);
				String str = new String(sb.toString());
				FileOutputStream fos = null;
				try {
						fos = new FileOutputStream(nazw); //Otwieranie pliku 
						for(int i = 0; i < str.length(); i++){
						fos.write((int)str.charAt(i)); //Zapis bajt po bajcie każdego znaku...
						}
						JOptionPane.showMessageDialog(null, "Twój plik został poprawnie Zapisany.");
						} 
						catch(IOException ex){
						System.out.println("Błąd operacji na pliku: "+ex);
						}
			}
			else if (n==1 && nazw.endsWith(".txt2")){
				textField1.setText(nazw.substring(0,(nazw.length()-1)));
				nazw = textField1.getText();
				String tekst = new String(ta.getText());
				tekst2 +=tekst;
				StringBuffer sb = new StringBuffer(tekst2);
				String str = new String(sb.toString());
				FileOutputStream fos = null;
				try {
						fos = new FileOutputStream(nazw); //Otwieranie pliku 
						for(int i = 0; i < str.length(); i++){
						fos.write((int)str.charAt(i)); //Zapis bajt po bajcie każdego znaku...
						}
						JOptionPane.showMessageDialog(null, "Twój plik został poprawnie Zapisany.");
						} 
						catch(IOException ex){
						System.out.println("Błąd operacji na pliku: "+ex);
						}
				
			}
			
		
  }
  else if (s.equals("Czcionka")){ 
	    Object[] czcionki = {"Arial","Algerian","TimesRoman","Courier","Serif","Sansserif","Monospaced"};
	    Object[] kolory = {"Biały","Cyan","Czarny","Czerwony","Niebieski","Różowy","Szary","Żółty","Zielony"};
		String cos = (String)JOptionPane.showInputDialog(null,"Wybierz czcionke:","Czcionka",JOptionPane.PLAIN_MESSAGE,null,czcionki,czcionki[0]);
	    String wielkosc = JOptionPane.showInputDialog(null,"Wpisz wielkość czcionki:");
		y = Integer.parseInt(wielkosc);
		String kol = (String)JOptionPane.showInputDialog(null,"Wybierz kolor:","Kolor",JOptionPane.PLAIN_MESSAGE,null,kolory,kolory[2]);
	    if (cos=="Arial"){
			Font Arial = new Font("Arial",Font.PLAIN, y);
			textField2.setText("Arial "+y);
            ta.setFont(Arial);
            x=0;}
		else if (cos=="Algerian"){
			Font Algerian = new Font("Algerian",Font.PLAIN, y);
			textField2.setText("Algerian "+y);
            ta.setFont(Algerian);
            x=1;}
		else if (cos=="TimesRoman"){
			Font TimesRoman = new Font("TimesRoman",Font.PLAIN, y);
			textField2.setText("TimesRoman "+y);
            ta.setFont(TimesRoman);
            x=2;}
		else if (cos=="Courier"){
			Font Courier = new Font("courier",Font.PLAIN, y);
			textField2.setText("Courier "+y);
            ta.setFont(Courier);
            x=3;}
		else if (cos=="Serif"){
			Font Serif = new Font("serif",Font.PLAIN, y);
			textField2.setText("Serif "+y);
            ta.setFont(Serif);
            x=4;}
		else if (cos=="Sansserif"){
			Font Sansserif = new Font("sansserif",Font.PLAIN, y);
			textField2.setText("Sansserif "+y);
            ta.setFont(Sansserif);
            x=5;}
		else if (cos=="Monospaced"){
			Font Monospaced = new Font("monospaced",Font.PLAIN, y);		
			textField2.setText("Monospaced "+y);
            ta.setFont(Monospaced);
            x=6;}
            
		if (kol=="Biały"){
		textField3.setBackground(Color.white);
		ta.setForeground(Color.white);
		z=0;}
		else if (kol=="Cyan"){
		textField3.setBackground(Color.cyan);
		ta.setForeground(Color.cyan);
		z=1;}
		else if (kol=="Czarny"){
		textField3.setBackground(Color.black);
		ta.setForeground(Color.black);
		z=2;}
		else if (kol=="Czerwony"){
		textField3.setBackground(Color.RED);
		ta.setForeground(Color.red);
		z=3;}
		else if (kol=="Niebieski"){
		textField3.setBackground(Color.blue);
		ta.setForeground(Color.blue);
		z=4;}
		else if (kol=="Różowy"){
		textField3.setBackground(Color.pink);
		ta.setForeground(Color.pink);
		z=5;}
		else if (kol=="Szary"){
		textField3.setBackground(Color.DARK_GRAY);
		ta.setForeground(Color.DARK_GRAY);
		z=6;}
		else if (kol=="Żółty"){
		textField3.setBackground(Color.yellow);
		ta.setForeground(Color.yellow);
		z=7;}
		else if (kol=="Zielony"){
		textField3.setBackground(Color.green);
		ta.setForeground(Color.green);
		z=8;}

		String tekst1 = new String(ta.getText());
		ta.setText(tekst1);
  }
  else if (s.equals("Tło")){ 
	    JFrame frame = new JFrame("Wybór Tła");
		JPanel panel = new JPanel(new GridLayout(0, 1));
		JRadioButton aRadioButton = new JRadioButton("Biały");
		aRadioButton.setBackground(Color.white);
		JRadioButton bRadioButton = new JRadioButton("Czarny");
		bRadioButton.setBackground(Color.black);
		JRadioButton cRadioButton = new JRadioButton("Czerwony");
		cRadioButton.setBackground(Color.red);
		JRadioButton dRadioButton = new JRadioButton("Niebieski");
		dRadioButton.setBackground(Color.blue);
		JRadioButton eRadioButton = new JRadioButton("Szary");
	    eRadioButton.setBackground(Color.gray);
		JRadioButton fRadioButton = new JRadioButton("Różowy");
		fRadioButton.setBackground(Color.pink);
		JRadioButton gRadioButton = new JRadioButton("Zielony");
		gRadioButton.setBackground(Color.green);
		JRadioButton hRadioButton = new JRadioButton("Żółty");
		hRadioButton.setBackground(Color.yellow);
		
		ActionListener bialyActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        ta.setBackground(Color.white);
        textField4.setBackground(Color.white);
        t=0;}};
		ActionListener czarnyActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        ta.setBackground(Color.black);
        textField4.setBackground(Color.black);
        t=1;}};
        ActionListener czerwonyActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        ta.setBackground(Color.red);
        textField4.setBackground(Color.red);
        t=2;}};
        ActionListener niebActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        ta.setBackground(Color.blue);
        textField4.setBackground(Color.blue);
        t=3;}};
        ActionListener szaryActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        ta.setBackground(Color.gray);
        textField4.setBackground(Color.gray);
        t=4;}};
        ActionListener rozActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        ta.setBackground(Color.pink);
        textField4.setBackground(Color.pink);
        t=5;}};
        ActionListener zielActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        ta.setBackground(Color.green);
        textField4.setBackground(Color.green);
        t=6;}};
        ActionListener zoltyActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        ta.setBackground(Color.yellow);
        textField4.setBackground(Color.yellow);
        t=7;}};

		panel.add(aRadioButton);
		panel.add(bRadioButton);
		panel.add(cRadioButton);
		panel.add(dRadioButton);
		panel.add(eRadioButton);
		panel.add(fRadioButton);
		panel.add(gRadioButton);
		panel.add(hRadioButton);

		aRadioButton.addActionListener(bialyActionListener);
		bRadioButton.addActionListener(czarnyActionListener);
		cRadioButton.addActionListener(czerwonyActionListener);
		dRadioButton.addActionListener(niebActionListener);
		eRadioButton.addActionListener(szaryActionListener);
		fRadioButton.addActionListener(rozActionListener);
		gRadioButton.addActionListener(zielActionListener);
		hRadioButton.addActionListener(zoltyActionListener);

		frame.add(panel);
		frame.setSize(300, 200);
		frame.setVisible(true);
  }
  else if (s.equals("Wyjście")){
  System.exit(0);
  }
  }
}
  public static void main(String argv[]) { 
    new Plik_edycja_okienko();
  }
}
