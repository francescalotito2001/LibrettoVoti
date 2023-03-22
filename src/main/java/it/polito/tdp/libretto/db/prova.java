package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.model.Voto;

public class prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=root"; //stringa di connesione per il database creato
		//creo un oggetto connessione
		
		
		
		try {
		Connection conn = DriverManager.getConnection(jdbcURL);
		
		Statement st = conn.createStatement();
		
		//uso st per interrogare i dati del database
		//la stringa sql e' quella che vogliamo eseguire
		String sql = "SELECT corso, punti, data "
				+ "FROM voto";
		
		//eseguo la stringa
		ResultSet re = st.executeQuery(sql);
		
		List <Voto> voti = new ArrayList<Voto>();		
		
		//chiamo il metodo next per accedere ai valori
		while(re.next()) {	//nel while perche la prima iterazione avvera' dopo aver chiamato il metodo next
			String corso = re.getString("corso");
			int punti = re.getInt("punti");
			
//			System.out.println(corso + " = "+ punti);
			
			Voto v = new Voto(corso, punti, null);
			voti.add(v);
			
			}
		 //quando non serve piu' la connessione con il DB si chiude la connessione
		conn.close();
		
		System.out.println(voti);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
