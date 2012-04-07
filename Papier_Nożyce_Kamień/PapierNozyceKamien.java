import java.io.*;
import java.util.Random;

public class PapierNozyceKamien
{
static String a,b;
static int x,komp,czlowiek;

public static void main(String args[]) throws IOException
{
System.out.println("|-------------------------------------|");
System.out.println ("|.:Witaj w Grze Papier Nożyce Kamień:.|");
System.out.println("|-------------------------------------|\n");
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
System.out.println("Wybieram:");
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
	System.out.println("Komputer wybrał Kamień. Wygrałeś!!");}
else if (czlowiek==1&&komp==2){
	System.out.println("Komputer wybrał Nożyczki. Przegrałeś!!");}
else if (czlowiek==2&&komp==1){
	System.out.println("Komputer wybrał Papier. Wygrałeś!!");}
else if (czlowiek==2&&komp==3){
	System.out.println("Komputer wybrał Kamień. Przegrałeś!!");}
else if (czlowiek==3&&komp==1){
	System.out.println("Komputer wybrał Papier. Przegrałeś!!");}
else if (czlowiek==3&&komp==2){
	System.out.println("Komputer wybrał Nożyczki. Wygrałeś!!");}
else {
	System.out.println("Komputer wybrał to samo. Remis!!");}
}}
