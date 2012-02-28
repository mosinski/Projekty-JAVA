import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Random;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.*;

public class Waluty extends JFrame
{ Button przy1,przy2,przy3,przy4,przy5,przy6,podlicz;
  JTextField textField1 = new JTextField(4);
  JTextField textField2 = new JTextField(5);
  float flo_a,flo_b,flo_c,flo_d,flo_e,flo_f,flo_g,flo_h,flo_i;
  float mnoznik,arg_pierwszy,arg_drugi,wynik;
  DecimalFormat zao = new DecimalFormat("#.##");
  String kurs_usd,kurs_gbp,kurs_eur,kurs_cad,kurs_jpy,kurs_chf,kurs_cny,kurs_sek;
  
  public Waluty() {
    super("Wymiana Walut");
    getContentPane().setLayout(new FlowLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    setSize(580, 300);
    setVisible(true);

    try{
    BufferedReader in=new BufferedReader (new FileReader("kursy_walut.txt"));
	kurs_usd = in.readLine();
	kurs_gbp = in.readLine();
	kurs_eur = in.readLine();
	kurs_cad = in.readLine();
	kurs_jpy = in.readLine();
	kurs_chf = in.readLine();
	kurs_cny = in.readLine();
	kurs_sek = in.readLine();
	in.close();
    } catch (IOException e1) {
					System.out.println("BŁĄD ODCZYTU Z PLIKU!");
					System.exit(2);
				}
	final Float flo_b = new Float(kurs_usd);
	final Float flo_c = new Float(kurs_gbp);
	final Float flo_d = new Float(kurs_eur);
	final Float flo_e = new Float(kurs_cad);
	final Float flo_f = new Float(kurs_jpy);
	final Float flo_g = new Float(kurs_chf);
	final Float flo_h = new Float(kurs_cny);
	final Float flo_i = new Float(kurs_sek);

    ImageIcon waluty = new ImageIcon("flagi/waluty.jpg");
    ImageIcon polska = new ImageIcon("flagi/pol.jpg");
    Font Czcionka = new Font("TimesRoman",Font.BOLD, 40);	
	getContentPane().add(textField1);
	textField1.setText("0");
	textField1.setFont(Czcionka);
	textField1.setForeground(Color.blue);
	textField1.setBackground(Color.yellow);
	final JButton przy1 = new JButton();
    przy1.setBackground(Color.white);
    przy1.setIcon(waluty);
    getContentPane().add(przy1);
    final JButton przy3 = new JButton();
    przy3.setBackground(Color.white);
    przy3.setIcon(polska);
    getContentPane().add(przy3);
    getContentPane().add(textField2);
	textField2.setFont(Czcionka);
	textField2.setForeground(Color.red);
	textField2.setEditable(false);
	JButton przy4 = new JButton("   |Przelicz|   ");
    getContentPane().add(przy4);
    
		ActionListener walutaActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	    final int x;
		
		final ImageIcon usd = new ImageIcon("flagi/usd.png");
		final ImageIcon gbp = new ImageIcon("flagi/gbp.png");
		final ImageIcon eur = new ImageIcon("flagi/eur.png");
		final ImageIcon cad = new ImageIcon("flagi/cad.png");
		final ImageIcon jpy = new ImageIcon("flagi/jpy.png");
		final ImageIcon chf = new ImageIcon("flagi/chf.png");
		final ImageIcon cny = new ImageIcon("flagi/cny.png");
		final ImageIcon sek = new ImageIcon("flagi/sek.png");
		
		JFrame frame = new JFrame("Wybór Waluty");
		JPanel panel = new JPanel(new GridLayout(0, 1));
		JRadioButton aRadioButton = new JRadioButton("Dolar Amerykański");
		aRadioButton.setIcon(usd); 
		JRadioButton bRadioButton = new JRadioButton("Funt Brytyjski");
		bRadioButton.setIcon(gbp);
		JRadioButton cRadioButton = new JRadioButton("Euro");
		cRadioButton.setIcon(eur);
		JRadioButton dRadioButton = new JRadioButton("Dolar Kanadyjski");
		dRadioButton.setIcon(cad);
		JRadioButton eRadioButton = new JRadioButton("Jen Japoński");
	    eRadioButton.setIcon(jpy);
		JRadioButton fRadioButton = new JRadioButton("Frank Szwajcarski");
		fRadioButton.setIcon(chf);
		JRadioButton gRadioButton = new JRadioButton("Juan Chiński");
		gRadioButton.setIcon(cny);
		JRadioButton hRadioButton = new JRadioButton("Korona Szwedzka");
		hRadioButton.setIcon(sek);

		ActionListener usdActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        przy1.setIcon(usd); 
        mnoznik=flo_b;
		}};
		ActionListener gbpActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
		przy1.setIcon(gbp); 
		mnoznik=flo_c;
		}};
        ActionListener eurActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        przy1.setIcon(eur); 
        mnoznik=flo_d;      
        }};
        ActionListener cadActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
		przy1.setIcon(cad); 
		mnoznik=flo_e;
        }};
        ActionListener jpyActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        przy1.setIcon(jpy); 
        mnoznik=flo_f;
        }};
        ActionListener chfActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        przy1.setIcon(chf); 
        mnoznik=flo_g;
        }};
        ActionListener cnyActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        przy1.setIcon(cny); 
        mnoznik=flo_h;
        }};
        ActionListener sekActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        przy1.setIcon(sek); 
        mnoznik=flo_i;
        }};
		panel.add(aRadioButton);
		panel.add(bRadioButton);
		panel.add(cRadioButton);
		panel.add(dRadioButton);
		panel.add(eRadioButton);
		panel.add(fRadioButton);
		panel.add(gRadioButton);
		panel.add(hRadioButton);
		
		aRadioButton.addActionListener(usdActionListener);
		bRadioButton.addActionListener(gbpActionListener);
		cRadioButton.addActionListener(eurActionListener);
		dRadioButton.addActionListener(cadActionListener);
		eRadioButton.addActionListener(jpyActionListener);
		fRadioButton.addActionListener(chfActionListener);
		gRadioButton.addActionListener(cnyActionListener);
		hRadioButton.addActionListener(sekActionListener);

		frame.add(panel);
		frame.setSize(250, 300);
		frame.setVisible(true);
		}};
        ActionListener przeliczActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
		final Float arg_pierwszy=new Float(textField1.getText());
		final Float wynik=arg_pierwszy*mnoznik;
		textField2.setText(""+zao.format(wynik)+"zł");
		}};
        przy1.addActionListener(walutaActionListener); 
        przy4.addActionListener(przeliczActionListener);      
}
  public static void main(String argv[]) {
    new Waluty();
  }
}
