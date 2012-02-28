import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class liczby_ver2 extends JFrame
{ Button przy1,przy2,przy3,przy4,przy5,przy6,przy7,przy8;
  JTextField textField1 = new JTextField(12);
  JTextField textField2 = new JTextField(12);
  JTextField textField3 = new JTextField(12);
  static int a,b,c;
  static double f; 
  DecimalFormat zao = new DecimalFormat("#.##");
  public liczby_ver2() {
    super("Działania na liczbach");
    ActionListener a = new MyActionListener();
    getContentPane().setLayout(new FlowLayout());
	JLabel arg1 = new JLabel("Argument A: ");
	getContentPane().add(arg1);
    getContentPane().add(textField1);
    JLabel arg2 = new JLabel("Argument B: ");
    getContentPane().add(arg2);
    getContentPane().add(textField2);
    JLabel arg3 = new JLabel("          Wynik: ");
    getContentPane().add(arg3);
    getContentPane().add(textField3);
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
    JButton przy8 = new JButton("Czyść");
    przy8.setFont(new Font("Arial", Font.ITALIC, 16));
    przy8.setForeground(Color.green);
    przy8.setBackground(Color.black);
	przy8.setActionCommand("Czyść"); 
    przy8.addActionListener(a);
    getContentPane().add(przy8);        
    setSize(300, 250);
    setVisible(true);
}
  class MyActionListener implements ActionListener { 
  public void actionPerformed(ActionEvent ae) {
  String s = ae.getActionCommand();
  if (s.equals("Dodawanie")){
  String a = new String(textField1.getText());
  String b = new String(textField2.getText());
  int d = Integer.parseInt(a);
  int e = Integer.parseInt(b);
  c= d+e;
  textField3.setText(""+d+"+"+e+"="+c);
  } 
  else if (s.equals("Odejmowanie")){ 
  String a = new String(textField1.getText());
  String b = new String(textField2.getText());
  int d = Integer.parseInt(a);
  int e = Integer.parseInt(b);
  c= d-e;
  textField3.setText(""+d+"-"+e+"="+c);
  } 
  else if (s.equals("Mnożenie")){ 
  String a = new String(textField1.getText());
  String b = new String(textField2.getText());
  int d = Integer.parseInt(a);
  int e = Integer.parseInt(b);
  c= d*e;
  textField3.setText(""+d+"*"+e+"="+c);
  } 
  else if (s.equals("Dzielenie")){ 
  String a = new String(textField1.getText());
  String b = new String(textField2.getText());
  int d = Integer.parseInt(a);
  int e = Integer.parseInt(b);
  f= d/e;
  textField3.setText(""+d+"/"+e+"="+f);
  }
  else if (s.equals("Potęgowanie")){ 
  String a = new String(textField1.getText());
  String b = new String(textField2.getText());
  int d = Integer.parseInt(a);
  int e = Integer.parseInt(b);
  c = (int)Math.pow(d, e);
  textField3.setText(""+d+"^"+e+"="+c);
  }
  else if (s.equals("Pierwiastek")){
  String a = new String(textField1.getText());
  String b = new String(textField2.getText());
  int d = Integer.parseInt(a);
  int e = Integer.parseInt(b);
  f = (double)Math.sqrt(d);
  textField3.setText(""+d+"%2="+zao.format(f));
  }
  else if (s.equals("Wyjście")){
  System.exit(0);
  }
  else if (s.equals("Czyść")){
  textField1.setText("");
  textField2.setText("");
  textField3.setText("");
  } 
  }
}
  public static void main(String argv[]) {
    new liczby_ver2();
  }
}
