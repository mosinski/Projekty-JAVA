import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class liczby extends JFrame
{ Button przy1,przy2,przy3,przy4,przy5,przy6,przy7;
  static int x,y,c;
  static double d;
   
  public liczby() {
    super("Działania na liczbach");
    ActionListener a = new MyActionListener();
    getContentPane().setLayout(new FlowLayout());
    getContentPane().setBackground(Color.blue);
	JLabel arg1 = new JLabel("<html>" + "<b><i><u><font size=+2>Co chcesz zrobić: ");
	arg1.setForeground(Color.red);
	getContentPane().add(arg1);
    JButton przy1 = new JButton("Dodawanie");
    przy1.setActionCommand("Dodawanie"); 
    przy1.addActionListener(a);
    getContentPane().add(przy1);
    JButton przy2 = new JButton("Odejmowanie");
	przy2.setActionCommand("Odejmowanie"); 
    przy2.addActionListener(a);
    getContentPane().add(przy2); 
    JButton przy3 = new JButton("Mnożenie");
	przy3.setActionCommand("Mnożenie"); 
    przy3.addActionListener(a);
    getContentPane().add(przy3); 
    JButton przy4 = new JButton("Dzielenie");
	przy4.setActionCommand("Dzielenie"); 
    przy4.addActionListener(a);
    getContentPane().add(przy4);
    JButton przy5 = new JButton("Potęgowanie");
	przy5.setActionCommand("Potęgowanie"); 
    przy5.addActionListener(a);
    getContentPane().add(przy5);
    JButton przy6 = new JButton("Pierwiastek");
	przy6.setActionCommand("Pierwiastek"); 
    przy6.addActionListener(a);
    getContentPane().add(przy6);
    JButton przy7 = new JButton("Wyjście");
    przy7.setFont(new Font("Arial", Font.BOLD, 16));
    przy7.setForeground(Color.white);
    przy7.setBackground(Color.black);
	przy7.setActionCommand("Wyjście"); 
    przy7.addActionListener(a);
    getContentPane().add(przy7);      
    setSize(350, 200);
    setVisible(true);
}
  class MyActionListener implements ActionListener { 
  public void actionPerformed(ActionEvent ae) {
  String s = ae.getActionCommand(); 
  if (s.equals("Dodawanie")){
  String a = JOptionPane.showInputDialog("Wpisz Argument A:");
  String b = JOptionPane.showInputDialog("Wpisz Argument B:");
  x = Integer.parseInt(a);
  y = Integer.parseInt(b);
  c=x+y;
  JOptionPane.showMessageDialog(null, "Wynik to: " + c,"Działanie: "+x+" + "+y+" = "+ c,
    JOptionPane.PLAIN_MESSAGE);
  } 
  else if (s.equals("Odejmowanie")){ 
  String a = JOptionPane.showInputDialog("Wpisz Argument A:");
  String b = JOptionPane.showInputDialog("Wpisz Argument B:");
  x = Integer.parseInt(a);
  y = Integer.parseInt(b);
  c=x-y;
  JOptionPane.showMessageDialog(null, "Wynik to: " + c,"Działanie: "+x+" - "+y+" = "+ c,
    JOptionPane.PLAIN_MESSAGE);
  }
  else if (s.equals("Mnożenie")){ 
  String a = JOptionPane.showInputDialog("Wpisz Argument A:");
  String b = JOptionPane.showInputDialog("Wpisz Argument B:");
  x = Integer.parseInt(a);
  y = Integer.parseInt(b);
  c=x*y;
  JOptionPane.showMessageDialog(null, "Wynik to: " + c,"Działanie: "+x+" * "+y+" = "+ c,
    JOptionPane.PLAIN_MESSAGE);
  } 
  else if (s.equals("Dzielenie")){ 
  String a = JOptionPane.showInputDialog("Wpisz Argument A:");
  String b = JOptionPane.showInputDialog("Wpisz Argument B:");
  x = Integer.parseInt(a);
  y = Integer.parseInt(b);
  c=x/y;
  JOptionPane.showMessageDialog(null, "Wynik to: " + c,"Działanie: "+x+" / "+y+" = "+ c,
    JOptionPane.PLAIN_MESSAGE);
  }
  else if (s.equals("Potęgowanie")){ 
  String a = JOptionPane.showInputDialog("Podaj liczbę która ma być spotegowana: " );
  String b = JOptionPane.showInputDialog("Podaj potęge liczby: ");
  x = Integer.parseInt(a);
  y = Integer.parseInt(b);
  c = (int)Math.pow(x, y);
  JOptionPane.showMessageDialog(null, "Wynik to: " + c,"Działanie: "+x+" ^ "+y+" = "+ c,
    JOptionPane.PLAIN_MESSAGE);
  }
  else if (s.equals("Pierwiastek")){ 
  String a = JOptionPane.showInputDialog("Podaj której pierwiastek mam obliczyć: " );
  x = Integer.parseInt(a);
  d = (double)Math.sqrt(x); 
  JOptionPane.showMessageDialog(null, "Wynik to: " + d,"Działanie: "+x+" % 2 = "+ d,
    JOptionPane.PLAIN_MESSAGE);
  } 
  else if (s.equals("Wyjście")){
    System.exit(0);
  } 
  }
}
  public static void main(String argv[]) {
    new liczby();
  }
}
