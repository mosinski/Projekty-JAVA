import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class liczby_ver3 extends JFrame
{ Button przy1,przy2,przy3,przy4,przy5,przy6,przy7,przy8,przy9;
  JTextField textField1 = new JTextField(14);
  static String tekst="";
  static String tekst2="";
  static String wynik="";
  static int a,b,c,w;
  static double f; 
  DecimalFormat zao = new DecimalFormat("#.##");
  public liczby_ver3() {
    super("Dzialania na liczbach");
    ActionListener a = new MyActionListener();
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(textField1);
    Font Monospaced = new Font("monospaced",Font.PLAIN, 50);		
	textField1.setFont(Monospaced);
	ImageIcon dodawanie = new ImageIcon("ikony/dodawanie.png");
    JButton przy1 = new JButton();
    przy1.setIcon(dodawanie);
    przy1.setBackground(Color.white);
    przy1.setToolTipText("Dodawanie..");
    przy1.setActionCommand("Dodawanie"); 
    przy1.addActionListener(a);
    getContentPane().add(przy1);
    ImageIcon odejmowanie = new ImageIcon("ikony/odejmowanie.png");
    JButton przy2 = new JButton();
    przy2.setIcon(odejmowanie);
    przy2.setBackground(Color.white);
    przy2.setToolTipText("Odejmowanie..");
	przy2.setActionCommand("Odejmowanie"); 
    przy2.addActionListener(a);
    getContentPane().add(przy2); 
    ImageIcon mnozenie = new ImageIcon("ikony/mnozenie.png");
    JButton przy3 = new JButton();
    przy3.setIcon(mnozenie);
    przy3.setBackground(Color.white);
    przy3.setToolTipText("Mnożenie..");
	przy3.setActionCommand("Mnozenie");
    przy3.addActionListener(a);
    getContentPane().add(przy3);
    ImageIcon dzielenie = new ImageIcon("ikony/dzielenie.png");
    JButton przy4 = new JButton();
    przy4.setIcon(dzielenie);
    przy4.setBackground(Color.white);
    przy4.setToolTipText("Dzielenie..");
	przy4.setActionCommand("Dzielenie");
    przy4.addActionListener(a);
    getContentPane().add(przy4);
    ImageIcon potegowanie = new ImageIcon("ikony/potegowanie.png");
    JButton przy5 = new JButton();
    przy5.setIcon(potegowanie);
    przy5.setBackground(Color.white);
    przy5.setToolTipText("Potegowanie..");
	przy5.setActionCommand("Potegowanie"); 
    przy5.addActionListener(a);
    getContentPane().add(przy5);
    ImageIcon pierwiastek = new ImageIcon("ikony/pierwiastek.gif");
    JButton przy6 = new JButton();
    przy6.setIcon(pierwiastek);
    przy6.setBackground(Color.white);
    przy6.setToolTipText("Pierwiastek..");
	przy6.setActionCommand("Pierwiastek");
    przy6.addActionListener(a);
    getContentPane().add(przy6);
    ImageIcon wynik = new ImageIcon("ikony/wynik.png");
    JButton przy7 = new JButton();
    przy7.setIcon(wynik);
    przy7.setBackground(Color.white);
    przy7.setToolTipText("Wynik..");
	przy7.setActionCommand("Wynik"); 
    przy7.addActionListener(a);
    getContentPane().add(przy7);
    ImageIcon czysc = new ImageIcon("ikony/kasowanie.png");
    JButton przy8 = new JButton();
    przy8.setIcon(czysc);
    przy8.setBackground(Color.white);
    przy8.setToolTipText("Kasuj/Wyczyść..");
	przy8.setActionCommand("Czysc"); 
    przy8.addActionListener(a);
    getContentPane().add(przy8);        
    setSize(435, 255);
    setVisible(true);
}
  class MyActionListener implements ActionListener { 
  public void actionPerformed(ActionEvent ae) {
  String s = ae.getActionCommand();
  if (s.equals("Dodawanie")){
   tekst="";
   tekst2="";
   wynik="";
   tekst+= textField1.getText();
   wynik+="1";
   textField1.setText("");
  } 
  else if (s.equals("Odejmowanie")){
   tekst="";
   tekst2="";
   wynik="";
   tekst+= textField1.getText();
   wynik+="2";
   textField1.setText(""); 
  } 
  else if (s.equals("Mnozenie")){ 
   tekst="";
   tekst2="";
   wynik="";
   tekst+= textField1.getText();
   wynik+="3";
   textField1.setText(""); 
  } 
  else if (s.equals("Dzielenie")){ 
   tekst="";
   tekst2="";
   wynik="";
   tekst+= textField1.getText();
   wynik+="4";
   textField1.setText(""); 
  }
  else if (s.equals("Potegowanie")){
   tekst="";
   tekst2="";
   wynik="";
   tekst+= textField1.getText();
   wynik+="5";
   textField1.setText("");
  }
  else if (s.equals("Pierwiastek")){
   tekst="";
   tekst2="";
   wynik="";
   tekst+= textField1.getText();
   int a = Integer.parseInt(tekst);
   f = (double)Math.sqrt(a);
   textField1.setText(""+zao.format(f));
  }
  else if (s.equals("Wynik")){
   tekst2+=textField1.getText();
   int a = Integer.parseInt(tekst);
   int b = Integer.parseInt(tekst2);
   int w = Integer.parseInt(wynik);
   if (w==1){
	   c=a+b;
	   textField1.setText(""+c);
   }
   if (w==2){
	   c=a-b;
	   textField1.setText(""+c);
   }
   if (w==3){
	   c=a*b;
	   textField1.setText(""+c);
   }
   if (w==4){
	   c=a/b;
	   textField1.setText(""+c);
   }
   if (w==5){
	   c = (int)Math.pow(a, b);
	   textField1.setText(""+c);
   }
  }
  else if (s.equals("Czysc")){
   tekst="";
   tekst2="";
   wynik="";
   textField1.setText("");
  }
  }
}
  public static void main(String argv[]) {
    new liczby_ver3();
  }
}
