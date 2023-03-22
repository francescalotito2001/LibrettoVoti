package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.model.Voto;

public class VotoDAO {
	//non deve avere nessuan variabile privata
	//offre una serie di metodi che possono essere chiamati quando vogliono
	//DAO = data access process

	//definisco i metodi d'accesso al mio DB
	
	public List<Voto> listaVotiMetodo(){
		//String jdbcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=root"; //stringa di connesione per il database creato
		//creo un oggetto connessione
		
		
		
		try {
		Connection conn = DBConnect.getConnection(); 	//la get conection e' chiamata dalla classeDBConnect
		
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
			LocalDate data = re.getDate("data").toLocalDate();
			
//			System.out.println(corso + " = "+ punti);			
			Voto v = new Voto(corso, punti, data);
			voti.add(v);
			}
		
//		quando non serve piu' la connessione con il DB si chiude la connessione
		conn.close();		
		return voti;
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		

	}
	
	public void createVoto(Voto v) {
		/*String sql =" INSERT INTO `librettovoti`.`voto` (`corso`, `punti`, `data`) " +
				"VALUES ('" +v.getNomeCorso() +"', "+ v.getVotoEsame()+ ",  '"+v.getDataEsame()+"')";*/
		String sql =" INSERT INTO voto (`corso`, `punti`, `data`) "
				+ "VALUES (?, ?, ?);";
		
		
		try {
			Connection con = DBConnect.getConnection();
			PreparedStatement st = con.prepareStatement(sql);
			
			st.executeUpdate();	//Update perce' e' un insert
			
			//devo assegnare dei valori effettivi a questi paramentri con dei metodi set, al posto dei ?
			st.setString(1, v.getNomeCorso()); 	//primo paramentro: indice	
			st.setInt(2, v.getVotoEsame());
//			st.setDate(3, v.getDataEsame());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public Voto readVoto(String corso) {
		
	}

	public List<Voto> searchVotoPuntiMaggiori(int punti){
		
	}*/
}
