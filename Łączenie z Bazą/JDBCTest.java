import java.sql.*;
import java.io.*;
import java.sql.Connection;

public class JDBCTest {
	static String s;
	static String p="";
	static String powtorka;
	static String odp;
	static String arg1;
	static String arg2;
	static String arg3;
	static String arg4;
	static String arg5;
	static String arg6;
	static String tabela;
	static int x;
	
	public void passwordExample() {
        
        Console console = System.console();
        if (console == null) {
            System.out.println("Podałeś puste hasło..");
            System.exit(0);
        }
        char passwordArray[] = console.readPassword("Podaj hasło: ");
        String str=new String(passwordArray);  
		p +=str;
    }
 
	public static void main(String[] args) throws IOException{			
		String url = "jdbc:postgresql://localhost/mosinski";

		try {
			Class.forName("org.postgresql.Driver");
			System.out.print("Podaj nazwe użytkownika: ");
			BufferedReader uzyt = new BufferedReader(new InputStreamReader(System.in), 1);
			s = uzyt.readLine();
			new JDBCTest().passwordExample();
			Connection db = DriverManager.getConnection(url, s, p);
			Statement st = db.createStatement();
			System.out.println("\nPołączono z bazą..");
			int licznik = 1;
			while(licznik < 2){
			System.out.println(".::MENU::.");
			System.out.println("1.Wyświetlanie tabel");
			System.out.println("2.Dodawanie do tabel");
			System.out.println("3.Usuwanie tabel");
			System.out.print("> ");
			BufferedReader pyt1 = new BufferedReader(new InputStreamReader(System.in), 1);
			odp = pyt1.readLine();
			x = Integer.parseInt(odp);
			if (x==1){
			System.out.print("Którą tabele chcesz wyświetlić:\ngabinety_zabiegowe\nlekarze\noperacje\npacjenci\npielegniarki\n> ");
			BufferedReader pyt2 = new BufferedReader(new InputStreamReader(System.in), 1);
			tabela = pyt2.readLine();
			ResultSet rs = st.executeQuery("SELECT * FROM "+tabela);
			System.out.println("\tTabela "+tabela);
			while (rs.next()) {
				System.out.println(""+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			System.out.println("");
			rs.close();
			}
			if (x==2){
			System.out.print("\n1.gabinety_zabiegowe\n2.lekarze\n3.operacje\n4.pacjenci\n5.pielegniarki\n>");
			BufferedReader pyt2 = new BufferedReader(new InputStreamReader(System.in), 1);
			tabela = pyt2.readLine();
			x = Integer.parseInt(tabela);
			if (x==1){
			System.out.print("\nPodaj numer gabinetu: ");
			BufferedReader pyt3 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg1 = pyt3.readLine();
			System.out.print("\nPodaj nazwe gabinetu: ");
			BufferedReader pyt4 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg2 = pyt4.readLine();
			int count=st.executeUpdate("insert into gabinety_zabiegowe(numer_gabinetu, nazwa) values ('"+arg1+"', '"+arg2+"');");
			}
			if (x==2){
			System.out.print("\nPodaj imię nowego lekarza: ");
			BufferedReader pyt5 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg1 = pyt5.readLine();
			System.out.print("\nPodaj nazwisko nowego lekarza: ");
			BufferedReader pyt6 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg2 = pyt6.readLine();
			System.out.print("\nPodaj specjalizacje nowego lekarza: ");
			BufferedReader pyt7 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg3 = pyt7.readLine();
			int count=st.executeUpdate("insert into lekarze(imie, nazwisko, specjalizacja) values ('"+arg1+"', '"+arg2+"', '"+arg3+"');");
			}
			if (x==3){
			System.out.print("\nPodaj pesel operowanego pacjenta");
			BufferedReader pyt8 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg1 = pyt8.readLine();
			System.out.print("\nPodaj rodzaj operacji: ");
			BufferedReader pyt9 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg2 = pyt9.readLine();	
			System.out.print("\nPodaj nr lekarza operującego: ");
			BufferedReader pyt3 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg3 = pyt3.readLine();
			System.out.print("\nPodaj nr pielegniarki asystującej: ");
			BufferedReader pyt4 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg4 = pyt4.readLine();
			System.out.print("\nPodaj date operacji 'DD-MM-RRRR': ");
			BufferedReader pyt5 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg5 = pyt5.readLine();
			System.out.print("\nPodaj nr gabinetu w którym będzie operacja: ");
			BufferedReader pyt6 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg6 = pyt6.readLine();
			int count=st.executeUpdate("insert into operacje(pesel_operowanego, rodzaj_operacji,lekarz_operujący, pieleg_asystujące, data, nr_gabinetu) values ('"+arg1+"','"+arg2+"','"+arg3+"','"+arg4+"','"+arg5+"','"+arg6+"');");
			}
			if (x==4){
			System.out.print("\nPodaj imię nowego pacjenta: ");
			BufferedReader pyt3 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg1 = pyt3.readLine();
			System.out.print("\nPodaj nazwisko nowego pacjenta: ");
			BufferedReader pyt4 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg2 = pyt4.readLine();	
			System.out.print("\nPodaj płeć M/K: ");
			BufferedReader pyt5 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg3 = pyt5.readLine();
			System.out.print("\nPodaj pesel: ");
			BufferedReader pyt6 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg4 = pyt6.readLine();
			System.out.print("\nPodaj miejscowosc zamieszkania: ");
			BufferedReader pyt7 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg5 = pyt7.readLine();
			System.out.print("\nPodaj ulice zamieszkania: ");
			BufferedReader pyt8 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg6 = pyt8.readLine();
			int count=st.executeUpdate("insert into pacjenci(imie, nazwisko, plec, pesel, miasto, ulica_dom) values ('"+arg1+"','"+arg2+"','"+arg3+"','"+arg4+"','"+arg5+"','"+arg6+"');");	
		}
			if (x==5){
			System.out.print("\nPodaj imię nowej pielegniarki: ");
			BufferedReader pyt9 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg1 = pyt9.readLine();
			System.out.print("\nPodaj nazwisko nowej pielegniarki: ");
			BufferedReader pyt10 = new BufferedReader(new InputStreamReader(System.in), 1);
			arg2 = pyt10.readLine();		
			int count=st.executeUpdate("insert into pielegniarki(imie, nazwisko) values ('"+arg1+"', '"+arg2+"');");
			}
		}
		if (x==3){
			System.out.print("\n1.gabinety_zabiegowe\n2.lekarze\n3.operacje\n4.pacjenci\n5.pielegniarki\nKtórą tabele chcesz usunąć: ");
			BufferedReader pyt2 = new BufferedReader(new InputStreamReader(System.in), 1);
			tabela = pyt2.readLine();
			int count=st.executeUpdate("drop table "+tabela+";");		
			}
			System.out.print("\nCzy chcesz wyjść z programu ? Nie=1 Tak=2\n> ");
			BufferedReader pow = new BufferedReader(new InputStreamReader(System.in), 1);
			powtorka= pow.readLine();
			licznik = Integer.parseInt(powtorka);
		}
		st.close();
		} catch (SQLException e) {
			System.err.println("Wyjatek z zapytania SQL: " + e.getMessage());
			e.printStackTrace(System.err);
		} catch (ClassNotFoundException e) {
			System.err
					.println("Wyjatek przy ladowaniu klas: " + e.getMessage());
			e.printStackTrace(System.err);
		}

	}
}

