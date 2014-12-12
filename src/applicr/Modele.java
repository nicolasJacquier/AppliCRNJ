package applicr;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Modele {
	
	private List<PraticienH> praticiensH = new ArrayList<PraticienH>();
	
	private Connection connexion = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt= null;
	
	public Modele(){
		
		connexionBDD();
		
	}
	
	public void connexionBDD()  {
		try {
		
		    Class.forName("com.mysql.jdbc.Driver");
		  
		    String url = "jdbc:mysql://localhost/GsbCRSlam";
		  
		    connexion = DriverManager.getConnection(url, "root", "mysql");
		
		    selectPraticiensH();
	    }
		catch (SQLException e){
			
			System.err.println(e.getMessage());
			
		
	
		} catch (ClassNotFoundException e) {
			
			System.err.println(e.getMessage());
		}
		
	}
	
	
	 public void selectPraticiensH() {
		  System.out.println("Affichage des Praticiens Hesitants :");
		  String query = "SELECT PRA_NOM, PRA_VILLE, PRA_COEFCONFIANCE, PRA_COEFNOTORIETE,RAP_DATE "
		  		+ "FROM PRATICIEN LEFT OUTER JOIN RAPPORT_VISITE ON PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM"
		  		+ " WHERE RAP_DATE IS TRUE";
		  		
		  		
		  try {
			  Statement st = connexion.createStatement();
			  ResultSet rs = st.executeQuery(query);
			
			  while (rs.next()) {
				  String nom = rs.getString("PRA_NOM");
				  String ville = rs.getString("PRA_VILLE") ;
				  int coefC = rs.getInt("PRA_COEFCONFIANCE") ;
				  Date rapDate = rs.getDate("RAPPORT_VISITE.RAP_DATE") ;
				  int coefN = rs.getInt("PRA_COEFNOTORIETE");
				  this.praticiensH.add(new PraticienH(nom,ville,coefC,rapDate, coefN)) ;
				 
				  }
		  }
		  catch (SQLException ex) {System.err.println(ex.getMessage());}
	}
	 
	 
	 
	public List<PraticienH> getPraticiensH() {
		System.out.println("AccesModele::getPraticiensH()") ;
		return this.praticiensH;
	}
	
	
}
