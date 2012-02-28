import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class liczby_ver3 extends JFrame
{ Button przy1,przy2,przy3,przy4,przy5,przy6,przy7,przy8,przy9;
  JTextField textField1 = new JTextField(15);
  static String tekst="";
  static String tekst2="";
  static String wynik="";
  static int a,b,c,w;
  static double f; 
  DecimalFormat zao = new DecimalFormat("#.##");
  public liczby_ver3() {
    super("Działania na liczbach");
    ActionListener a = new MyActionListener();
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(textField1);
    Font Monospaced = new Font("monospaced",Font.PLAIN, 32);		
	textField1.setFont(Monospaced);
    JButton przy1 = new JButton(" + ");
    przy1.setActionCommand("Dodawanie"); 
    przy1.setFont(new Font("Arial", Font.BOLD, 18));
    przy1.addActionListener(a);
    getContentPane().add(przy1);
    JButton przy2 = new JButton("  –  ");
	przy2.setActionCommand("Odejmowanie");
	przy2.setFont(new Font("Arial", Font.BOLD, 18)); 
    przy2.addActionListener(a);
    getContentPane().add(przy2); 
    JButton przy3 = new JButton("  *  ");
	przy3.setActionCommand("Mnożenie");
	przy3.setFont(new Font("Arial", Font.BOLD, 18)); 
    przy3.addActionListener(a);
    getContentPane().add(przy3);
    JButton przy4 = new JButton(" ÷ ");
	przy4.setActionCommand("Dzielenie");
	przy4.setFont(new Font("Arial", Font.BOLD, 18)); 
    przy4.addActionListener(a);
    getContentPane().add(przy4);
    JButton przy5 = new JButton(" x^y  ");
	przy5.setActionCommand("Potęgowanie"); 
	przy5.setFont(new Font("Arial", Font.BOLD, 18));
    przy5.addActionListener(a);
    getContentPane().add(przy5);
    JButton przy6 = new JButton(" ²√ ");
	przy6.setActionCommand("Pierwiastek");
	przy6.setFont(new Font("Arial", Font.BOLD, 18)); 
    przy6.addActionListener(a);
    getContentPane().add(przy6);
    JButton przy7 = new JButton("    =    ");
	przy7.setActionCommand("Wynik");
	przy7.setFont(new Font("Arial", Font.BOLD, 18)); 
    przy7.addActionListener(a);
    getContentPane().add(przy7);
    JButton przy8 = new JButton("Wyjście");
    przy8.setFont(new Font("Arial", Font.BOLD, 16));
    przy8.setForeground(Color.white);
    przy8.setBackground(Color.black);
	przy8.setActionCommand("Wyjście"); 
    przy8.addActionListener(a);
    getContentPane().add(przy8);
    JButton przy9 = new JButton("C / AC");
    przy9.setFont(new Font("Arial", Font.ITALIC, 16));
    przy9.setForeground(Color.green);
    przy9.setBackground(Color.black);
	przy9.setActionCommand("Czyść"); 
    przy9.addActionListener(a);
    getContentPane().add(przy9);        
    setSize(305, 220);
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
  else if (s.equals("Mnożenie")){ 
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
  else if (s.equals("Potęgowanie")){
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
  else if (s.equals("Wyjście")){
  System.exit(0);
  }
  else if (s.equals("Czyść")){
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
