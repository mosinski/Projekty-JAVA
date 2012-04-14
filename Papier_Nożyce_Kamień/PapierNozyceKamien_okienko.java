import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Random;
import java.io.*;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class PapierNozyceKamien_okienko extends JFrame
{ Button przy1,przy2,przy3,przy4;
  static int x=0,komp,czlowiek,wynik_komp=0,wynik_czlowiek=0,licznik = 0,ponownie;
 
  public PapierNozyceKamien_okienko() {
    super("Gra Papier Nożyce Kamień");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	setSize(550, 250);
	final Container c=getContentPane();
	c.setLayout(new BorderLayout(1,1));
	
	final ImageIcon papier = new ImageIcon("obrazki/papier.png"); 
	final ImageIcon nozyce = new ImageIcon("obrazki/nozyczki.png");
    final ImageIcon kamien = new ImageIcon("obrazki/kamien.png");
	final ImageIcon user = new ImageIcon("obrazki/User.png");
	final ImageIcon comp = new ImageIcon("obrazki/computer.png");
	final String iduser = JOptionPane.showInputDialog(null,"Podaj nazwę gracza");
	final String a = JOptionPane.showInputDialog(null,"Do ilu wygranych chcesz grać?");
	x = Integer.parseInt(a);
    final String uzytkownik = "<html>&nbsp;&nbsp;Nick Gracza: ";
    final String ile = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grasz do ";
	final JLabel arg1 = new JLabel(uzytkownik+iduser+ile+x+" wygranych");
	c.add(arg1, BorderLayout.NORTH);
	final JLabel arg2 = new JLabel(user);
	c.add(arg2,BorderLayout.WEST);
	final JLabel arg3 = new JLabel(comp);
	c.add(arg3, BorderLayout.EAST);
	final String napis = "<html>&nbsp;&nbsp;||=====================||<br>";
	final String napis1 = "&nbsp;&nbsp;||:Aktualny Status Wygranych:&nbsp;|| <br>&nbsp;&nbsp;||&nbsp;&nbsp;Gracz:";
	final String napis2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Komputer:";
	final String napis3 = "&nbsp;&nbsp;||<br>&nbsp;&nbsp;||=====================||";
	final JLabel arg4 = new JLabel(napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);
    c.add(arg4, BorderLayout.CENTER);
    setVisible(true);
    JButton przy1 = new JButton("| GRAJ |");
    c.add(przy1, BorderLayout.SOUTH);
	
		ActionListener losujActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton przy1 = (AbstractButton) actionEvent.getSource();
        while(wynik_czlowiek<x&&wynik_komp<x){
		Object[] options = {" PAPIER "," NOŻYCE "," KAMIEŃ "};
		int komputer=0;
		int pytanie = JOptionPane.showOptionDialog(null,"Wybierz z dostępnych opcji:",
		"Wybór",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
		Random losuj = new Random();
	    komputer = losuj.nextInt(3)+1;
		if(pytanie==0&&komputer==3){
			String zwyciestwo1="<html>&nbsp;&nbsp;||=====================||<br>";
			String zwyciestwo2="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.:: ZWYCIĘSTWO ::.<br>";
			String zwyciestwo3="&nbsp;&nbsp;||=====================||<br>";
			wynik_czlowiek++;
			arg2.setIcon(papier);
			arg3.setIcon(kamien);
			arg4.setText(zwyciestwo1+zwyciestwo2+zwyciestwo3+napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
		else if (pytanie==0&&komputer==2){
			String zwyciestwo1="<html>&nbsp;&nbsp;||=====================||<br>";
			String zwyciestwo2="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.:: PRZEGRANA ::.<br>";
			String zwyciestwo3="&nbsp;&nbsp;||=====================||<br>";
			wynik_komp++;
			arg2.setIcon(papier);
			arg3.setIcon(nozyce);
			arg4.setText(zwyciestwo1+zwyciestwo2+zwyciestwo3+napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
		else if (pytanie==0&&komputer==1){
			String zwyciestwo1="<html>&nbsp;&nbsp;||=====================||<br>";
			String zwyciestwo2="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.:: REMIS ::.<br>";
			String zwyciestwo3="&nbsp;&nbsp;||=====================||<br>";
			arg2.setIcon(papier);
			arg3.setIcon(papier);
			arg4.setText(zwyciestwo1+zwyciestwo2+zwyciestwo3+napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
		else if (pytanie==1&&komputer==1){
			String zwyciestwo1="<html>&nbsp;&nbsp;||=====================||<br>";
			String zwyciestwo2="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.:: ZWYCIĘSTWO ::.<br>";
			String zwyciestwo3="&nbsp;&nbsp;||=====================||<br>";
			wynik_czlowiek++;
			arg2.setIcon(nozyce);
			arg3.setIcon(papier);
			arg4.setText(zwyciestwo1+zwyciestwo2+zwyciestwo3+napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
		else if (pytanie==1&&komputer==2){
			String zwyciestwo1="<html>&nbsp;&nbsp;||=====================||<br>";
			String zwyciestwo2="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.:: REMIS ::.<br>";
			String zwyciestwo3="&nbsp;&nbsp;||=====================||<br>";
			arg2.setIcon(nozyce);
			arg3.setIcon(nozyce);
			arg4.setText(zwyciestwo1+zwyciestwo2+zwyciestwo3+napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
		else if (pytanie==1&&komputer==3){
			String zwyciestwo1="<html>&nbsp;&nbsp;||=====================||<br>";
			String zwyciestwo2="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.:: PRZEGRANA ::.<br>";
			String zwyciestwo3="&nbsp;&nbsp;||=====================||<br>";
			wynik_komp++;
			arg2.setIcon(nozyce);
			arg3.setIcon(kamien);
			arg4.setText(zwyciestwo1+zwyciestwo2+zwyciestwo3+napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
		else if (pytanie==2&&komputer==1){
			String zwyciestwo1="<html>&nbsp;&nbsp;||=====================||<br>";
			String zwyciestwo2="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.:: PRZEGRANA ::.<br>";
			String zwyciestwo3="&nbsp;&nbsp;||=====================||<br>";
			wynik_komp++;
			arg2.setIcon(kamien);
			arg3.setIcon(papier);
			arg4.setText(zwyciestwo1+zwyciestwo2+zwyciestwo3+napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
		else if (pytanie==2&&komputer==2){
			String zwyciestwo1="<html>&nbsp;&nbsp;||=====================||<br>";
			String zwyciestwo2="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.:: ZWYCIĘSTWO ::.<br>";
			String zwyciestwo3="&nbsp;&nbsp;||=====================||<br>";
			wynik_czlowiek++;
			arg2.setIcon(kamien);
			arg3.setIcon(nozyce);
			arg4.setText(zwyciestwo1+zwyciestwo2+zwyciestwo3+napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
		else if (pytanie==2&&komputer==3){
			String zwyciestwo1="<html>&nbsp;&nbsp;||=====================||<br>";
			String zwyciestwo2="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.:: REMIS ::.<br>";
			String zwyciestwo3="&nbsp;&nbsp;||=====================||<br>";
			arg2.setIcon(kamien);
			arg3.setIcon(kamien);
			arg4.setText(zwyciestwo1+zwyciestwo2+zwyciestwo3+napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
			}
			String zwyciezca;
			if (wynik_czlowiek>wynik_komp){zwyciezca="!! (: Wygrałeś :) !!";}
			else {zwyciezca="!! ): Przegrałeś :( !!";}
			Object[] options = {" TAK "," NIE "};
			int  ponownie= JOptionPane.showOptionDialog(null,"Czy chcesz zagrać jeszcze raz ?",
			zwyciezca,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
			if (ponownie==0){
			String b = JOptionPane.showInputDialog(null,"Do ilu wygranych chcesz teraz zagrać?");
			x = Integer.parseInt(b);
			String uzytkownik = "<html>&nbsp;&nbsp;Nick Gracza: ";
			String ile = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grasz do ";
			arg1.setText(uzytkownik+iduser+ile+x+" wygranych");
			String napis = "<html>&nbsp;&nbsp;||=====================||<br>";
			String napis1 = "&nbsp;&nbsp;||:Aktualny Status Wygranych:&nbsp;|| <br>&nbsp;&nbsp;||&nbsp;&nbsp;Gracz:";
			String napis2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Komputer:";
			String napis3 = "&nbsp;&nbsp;||<br>&nbsp;&nbsp;||=====================||";
			wynik_czlowiek=0;
			wynik_komp=0;
			arg4.setText(napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);}
			else{System.exit(0);}
		}};
        przy1.addActionListener(losujActionListener);   
}
  public static void main(String argv[]) throws IOException{
    new PapierNozyceKamien_okienko();
  }
}
