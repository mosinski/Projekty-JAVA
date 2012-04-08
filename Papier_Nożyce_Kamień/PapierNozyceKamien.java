import java.io.*;
import java.util.Random;

public class PapierNozyceKamien
{
static String a,b,c;
static int x,komp,czlowiek,wynik_komp=0,wynik_czlowiek=0,licznik = 0,ponownie;

public static void main(String args[]) throws IOException
{
System.out.println("|-------------------------------------|");
System.out.println ("|.:Witaj w Grze Papier Nożyce Kamień:.|");
System.out.println("|-------------------------------------|\n");
while(licznik<1){
System.out.println(">>Do ilu wygranych chcesz grać?");
System.out.print("=>");
BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in), 1);
a = stdin.readLine(); // odczyt danych ze strumienia wej.
try {
x = Integer.parseInt(a);
} catch (NumberFormatException e) {
	System.out.println("Należy podać liczbę!");
	System.exit(0);
}
System.out.println("Gra ustawiona jest do "+a+" wygranych.");
while(wynik_czlowiek<x&&wynik_komp<x){
System.out.println("\nWybieram:");
System.out.println("1.Papier.\n2.Nożyce.\n3.Kamień.");
System.out.print("=>");
BufferedReader wybor = new BufferedReader(new InputStreamReader(System.in), 1);
b = wybor.readLine(); // odczyt danych ze strumienia wej.
try {
czlowiek = Integer.parseInt(b);
} catch (NumberFormatException e) {
	System.out.println("Należy podać liczbę!");
	System.exit(0);
}
Random losuj = new Random();
komp = losuj.nextInt(3)+1;
if (czlowiek==1&&komp==3){
	System.out.println("Komputer wybrał Kamień. Wygrałeś!!");
	wynik_czlowiek++;}
else if (czlowiek==1&&komp==2){
	System.out.println("Komputer wybrał Nożyczki. Przegrałeś!!");
	wynik_komp++;}
else if (czlowiek==2&&komp==1){
	System.out.println("Komputer wybrał Papier. Wygrałeś!!");
	wynik_czlowiek++;}
else if (czlowiek==2&&komp==3){
	System.out.println("Komputer wybrał Kamień. Przegrałeś!!");
	wynik_komp++;}
else if (czlowiek==3&&komp==1){
	System.out.println("Komputer wybrał Papier. Przegrałeś!!");
	wynik_komp++;}
else if (czlowiek==3&&komp==2){
	System.out.println("Komputer wybrał Nożyczki. Wygrałeś!!");
	wynik_czlowiek++;}
else {System.out.println("Komputer wybrał to samo. Remis!!");}
	  System.out.println("\n||:Aktualny Status Wygranych:||\n    Komputer: "+wynik_komp+"    Gracz: "+wynik_czlowiek);
}
if(wynik_czlowiek>wynik_komp){
System.out.println("\n|====================|");
System.out.println("| .:: ZWYCIĘSTWO ::. |\n| Końcowy wynik  "+wynik_komp+":"+wynik_czlowiek+" |");
System.out.println("|====================|");}
else if(wynik_komp>wynik_czlowiek){
System.out.println("\n|====================|");
System.out.println("| .::  PRZEGRANA ::. |\n| Końcowy wynik  "+wynik_komp+":"+wynik_czlowiek+" |");
System.out.println("|====================|");}
else{
System.out.println("\n|====================|");
System.out.println("| .::   REMIS   ::.  |\n| Końcowy wynik  "+wynik_komp+":"+wynik_czlowiek+" |");
System.out.println("|====================|");}
System.out.println("\nCzy chcesz zagrać ponownie ? 1-Tak 2-Nie");
System.out.print("=>");
BufferedReader koniec = new BufferedReader(new InputStreamReader(System.in), 1);
c = koniec.readLine(); // odczyt danych ze strumienia wej.
try {
ponownie = Integer.parseInt(c);
} catch (NumberFormatException e) {
	System.out.println("Należy podać liczbę!");
	System.exit(0);
}
if(ponownie==1){
	wynik_komp=0;
	wynik_czlowiek=0;}
else if(ponownie==2){
	System.out.println("Zapraszam Ponownie!");
	licznik=1;}
}
}}
