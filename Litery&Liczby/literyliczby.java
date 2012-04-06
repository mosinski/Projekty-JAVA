import java.io.*;

public class literyliczby
{
static String s;
static int x;

public static void main(String args[]) throws IOException
{
System.out.println(".:Witaj w Programie:.");
System.out.print("Wpisz x = ");
BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in), 1);
s = stdin.readLine(); // odczyt danych ze strumienia wej.
System.out.println("Oto twój x = "+s);
try {
x = Integer.parseInt(s);
} catch (NumberFormatException e) {
	System.out.println("Twój x składa się z liter. Jego długość to: "+s.length());
	System.exit(0);
}
System.out.println("Twój x jest liczbą.");
if (x>0){
	if(x>=10&&x<100){
	System.out.println("Ta liczba jest dodatnia i dwucyfrowa.");}
	else if (x>=100&&x<1000){
		System.out.println("Ta liczba jest dodatnia i trzycyfrowa.");}}
	else {
	System.out.println("Ta liczba jest ujemna.");}
}
} 
