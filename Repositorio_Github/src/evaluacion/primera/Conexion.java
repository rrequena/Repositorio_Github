package evaluacion.primera;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



/**
 * Si quer�is que adaptar esta clase a vuestra pr�ctica, s�lo deber�ais modificar
 * el fichero de propiedades ajust�ndolo a vuestras necesidades (el de log y el de db
 * 
 * Ya no es Singleton, pero incluye la secci�n de c�digo static, para que teng�is un ejemplo
 * de otra cosita nueva ;)
 * 
 * @date 03-06-2015
 * @author Vale
 *
 */
public class Conexion {

	static Connection conn = null;
	static ResultSet rset = null;
	static Statement stmt = null;
	private static Conexion conexion = new Conexion();
	
	private Conexion() // El constructor
	{
		
	}
	
	public Connection nueva_conexion()
	{
	try
	{
		//registro el driver, en realidad, hago que se ejecuten unas pocas l�neas de la clase OracleDriver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// m�todo equivalente al anterior
		//Sea como sea, es, <<oye, si te piden una conexi�n, se la pides a esa clase!>>
		conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "RRG111");
	        stmt = conn.createStatement();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return conn;   
	}
	
	
	
	
	public static Connection obtenerConexion () throws SQLException
	{
		return conexion.nueva_conexion();
		
	}
	
	public static void liberarRecursos (Connection conn, Statement stmt, ResultSet rset)
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
	
}