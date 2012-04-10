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

public class Gra extends JFrame
{ Button przy1,przy2,przy3,przy4,przy5,przy6,podlicz;
  JTextField textField1 = new JTextField(3);
  JTextField textField2 = new JTextField(3);
  JTextField textField3 = new JTextField(3);
  JTextField textField4 = new JTextField(3);
  Checkbox bonus1,bonus2,bonus3,bonus4,bonus5;
  Checkbox zaznacz1,zaznacz2,zaznacz3,zaznacz4,zaznacz5;
  CheckboxGroup bonus;
 
  public Gra() {
    super("Gra kości");
    getContentPane().setLayout(new FlowLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    setSize(830, 450);
    setVisible(true);
    setResizable(false);
    Font Monospaced = new Font("monospaced",Font.BOLD, 30);		
    Font odstep = new Font("Sansserif",Font.BOLD, 30);
    Font bonusowa = new Font("TimesRoman",Font.BOLD, 25);
    Font mikro = new Font("TimesRoman",Font.BOLD, 5);
	final Random r = new Random();
	final int b1,b2,b3,b4,b5,wynik,wynik_stary,najlepszy;
	final ImageIcon zero = new ImageIcon("kostka/0.jpg"); 
	final ImageIcon jeden = new ImageIcon("kostka/1.jpg");
    final ImageIcon dwa = new ImageIcon("kostka/2.jpg");
	final ImageIcon trzy = new ImageIcon("kostka/3.jpg");
	final ImageIcon cztery = new ImageIcon("kostka/4.jpg");
	final ImageIcon piec = new ImageIcon("kostka/5.jpg");
	final ImageIcon szesc = new ImageIcon("kostka/6.jpg");
	final ImageIcon czysc = new ImageIcon("ikony/clear.png");
	final ImageIcon edycja = new ImageIcon("ikony/edycja.png");
	final ImageIcon user = new ImageIcon("ikony/user.png");	
	final ImageIcon user_male = new ImageIcon("ikony/user-male.png");
	final ImageIcon user_female = new ImageIcon("ikony/user-female.png");
	JLabel arg1 = new JLabel(" Wartość rzutu:  ");
    arg1.setFont(odstep);
	getContentPane().add(arg1);
	getContentPane().add(textField1);
	textField1.setText("0");
	textField1.setFont(Monospaced);
	textField1.setForeground(Color.blue);
	textField1.setEditable(false);
	JLabel arg2 = new JLabel("  Najlepszy rzut:");
	arg2.setFont(odstep);
	getContentPane().add(arg2);
	getContentPane().add(textField2);
	textField2.setEditable(false);
	textField2.setFont(Monospaced);
	textField2.setForeground(Color.blue);
	textField2.setText("0");
	JButton kasuj = new JButton(czysc);
	kasuj.setPreferredSize(new Dimension(32, 32));
	kasuj.setOpaque(false);
	kasuj.setContentAreaFilled(false);
	kasuj.setBorderPainted(false);
	getContentPane().add(kasuj);
	 JLabel arg3 = new JLabel("Łącznie punktów:");
    arg3.setFont(odstep);
    getContentPane().add(arg3);
	getContentPane().add(textField3);
	textField3.setText("0");
	textField3.setFont(Monospaced);
	textField3.setForeground(Color.blue);
	textField3.setEditable(false);
	JLabel space2 = new JLabel("     Ilość rzutów:");
    space2.setFont(odstep);
    getContentPane().add(space2);
    getContentPane().add(textField4);
    textField4.setText("3");
    textField4.setFont(Monospaced);
    textField4.setForeground(Color.blue);
    textField4.setEditable(false);
    
    JButton zmien = new JButton(edycja);
    zmien.setPreferredSize(new Dimension(34, 39));
	zmien.setOpaque(false);
	zmien.setContentAreaFilled(false);
	zmien.setBorderPainted(false);
	getContentPane().add(zmien);
	
	zaznacz1 = new Checkbox("1.                              ");
	getContentPane().add(zaznacz1);
	zaznacz2 = new Checkbox("2.                              ");
	getContentPane().add(zaznacz2);
	zaznacz3 = new Checkbox("3.                              ");
	getContentPane().add(zaznacz3);
	zaznacz4 = new Checkbox("4.                              ");
	getContentPane().add(zaznacz4);
	zaznacz5 = new Checkbox("5.                              ");
	getContentPane().add(zaznacz5);
    final JToggleButton przy1 = new JToggleButton();
    przy1.setBackground(Color.white);
    getContentPane().add(przy1);
    final JToggleButton przy2 = new JToggleButton();
    przy2.setBackground(Color.white);
    getContentPane().add(przy2); 
    final JToggleButton przy3 = new JToggleButton();
    przy3.setBackground(Color.white);
    getContentPane().add(przy3);
    final JToggleButton przy4 = new JToggleButton();
    przy4.setBackground(Color.white);
    getContentPane().add(przy4);
    final JToggleButton przy5 = new JToggleButton();
    przy5.setBackground(Color.white);
    getContentPane().add(przy5);
    final JButton gracz = new JButton(user);
    gracz.setPreferredSize(new Dimension(56, 56));
	gracz.setOpaque(false);
	gracz.setContentAreaFilled(false);
	gracz.setBorderPainted(false);
	getContentPane().add(gracz);
	final JLabel iduser = new JLabel("NoName");
	getContentPane().add(iduser);
    JLabel space = new JLabel("     ");
    space.setFont(Monospaced);
    getContentPane().add(space);
    final JButton przy6 = new JButton("  |LOSUJ|  ");
    przy6.setBackground(Color.black);
    przy6.setForeground(Color.red);
    przy6.setFont(Monospaced);
    getContentPane().add(przy6);
    JLabel space1 = new JLabel("          ");
    space1.setFont(Monospaced);
    getContentPane().add(space1);

	przy1.setIcon(zero);
	przy2.setIcon(zero);
	przy3.setIcon(zero);
	przy4.setIcon(zero);
	przy5.setIcon(zero);

		ActionListener losujActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton przy6 = (AbstractButton) actionEvent.getSource();
        int c1=0,c2=0,c3=0,c4=0,c5=0,w,najlepszy,ilosc,lacznie_int;
        String teraz,ile,lacznie;
        Random a = new Random();
        teraz=textField2.getText();
        ile=textField4.getText();
        lacznie=textField3.getText();
        lacznie_int = Integer.parseInt(lacznie);
        najlepszy = Integer.parseInt(teraz);
        ilosc = Integer.parseInt(ile);
        if(ilosc > 0){
        if(zaznacz1.getState())
		{c1 = a.nextInt(6)+1;} 
		if(zaznacz2.getState())
		{c2 = a.nextInt(6)+1;}
		if(zaznacz3.getState())
		{c3 = a.nextInt(6)+1;}
		if(zaznacz4.getState())
		{c4 = a.nextInt(6)+1;}
		if(zaznacz5.getState())
		{c5 = a.nextInt(6)+1;}
		w=c1+c2+c3+c4+c5;
		ilosc--;
		textField4.setText(""+ilosc);
		if (c1==1){przy1.setIcon(jeden);}
		else if (c1==2){przy1.setIcon(dwa);}
		else if (c1==3){przy1.setIcon(trzy);}
		else if (c1==4){przy1.setIcon(cztery);}
		else if (c1==5){przy1.setIcon(piec);}
		else if (c1==6){przy1.setIcon(szesc);}

		if (c2==1){przy2.setIcon(jeden);}
		else if (c2==2){przy2.setIcon(dwa);}
		else if (c2==3){przy2.setIcon(trzy);}
		else if (c2==4){przy2.setIcon(cztery);}
		else if (c2==5){przy2.setIcon(piec);}
		else if (c2==6){przy2.setIcon(szesc);}
		
		if (c3==1){przy3.setIcon(jeden);}
		else if (c3==2){przy3.setIcon(dwa);}
		else if (c3==3){przy3.setIcon(trzy);}
		else if (c3==4){przy3.setIcon(cztery);}
		else if (c3==5){przy3.setIcon(piec);}
		else if (c3==6){przy3.setIcon(szesc);}
	
		if (c4==1){przy4.setIcon(jeden);}
		else if (c4==2){przy4.setIcon(dwa);}
		else if (c4==3){przy4.setIcon(trzy);}
		else if (c4==4){przy4.setIcon(cztery);}
		else if (c4==5){przy4.setIcon(piec);}
		else if (c4==6){przy4.setIcon(szesc);}

		if (c5==1){przy5.setIcon(jeden);}
		else if (c5==2){przy5.setIcon(dwa);}
		else if (c5==3){przy5.setIcon(trzy);}
		else if (c5==4){przy5.setIcon(cztery);}
		else if (c5==5){przy5.setIcon(piec);}
		else if (c5==6){przy5.setIcon(szesc);}
	
		if(w>najlepszy){najlepszy=w;}
        textField1.setText(""+w);
        textField2.setText(""+najlepszy);
        textField3.setText(""+(w+lacznie_int));		
        }
        else {Object[] options = {" TAK "," NIE "};
		int n = JOptionPane.showOptionDialog(null,"Czy chcesz zagrać jeszcze raz ?",
		"Koniec rzutów!",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		if(n==0){
			textField1.setText("0");
			textField3.setText("0");
			textField4.setText("3");
			przy1.setIcon(zero);
			przy2.setIcon(zero);
			przy3.setIcon(zero);
			przy4.setIcon(zero);
			przy5.setIcon(zero);}
		else if(n==1){System.exit(0);}}
		}};
        ActionListener kasujActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
		textField2.setText("0");	
		}};
		ActionListener zmienActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
		final String aa = JOptionPane.showInputDialog(null,"Do ilu wygranych chcesz grać?");
		textField4.setText(aa);
		}};
		ActionListener graczActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
		final String aa = JOptionPane.showInputDialog(null,"Podaj imię gracza");
		iduser.setText(aa);
		if(aa.endsWith("a")){
		gracz.setIcon(user_female);}
		else{gracz.setIcon(user_male);}
		}};
        przy6.addActionListener(losujActionListener); 
        kasuj.addActionListener(kasujActionListener);  
        zmien.addActionListener(zmienActionListener); 
        gracz.addActionListener(graczActionListener);   
}
  public static void main(String argv[]) {
	JWindow jwin = new JWindow();
    jwin.getContentPane().add(new JLabel("Wczytuje Gre...",SwingConstants.CENTER));
    jwin.setBounds(200, 200, 200, 100);
    jwin.setVisible(true);
    JFrame f = new JFrame("Wczytywanie Textur");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = f.getContentPane();
    JProgressBar progressBar = new JProgressBar();
    progressBar.setStringPainted(true);
    Border border = BorderFactory.createTitledBorder("Wczytuje...");
    progressBar.setBorder(border);
    content.add(progressBar, BorderLayout.NORTH);
    f.setSize(300, 100);
    f.setVisible(true);
    int i=0;
    while(i<99){
    try {
      Thread.sleep(60);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    progressBar.setValue(i);
    i++;
	}
    f.setVisible(false);
    jwin.setVisible(false);
    jwin.dispose();
    new Gra();
  }
}
