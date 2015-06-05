package evaluacion.primera;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegionDAO {


	private static RegionDTO componerObjeto (ResultSet rs) throws SQLException
	{
		RegionDTO region = null;
		
		int region_id = rs.getInt(1);
		String region_name = rs.getString(2);
		
		region = new RegionDTO(region_id, region_name);
		
		return region; // Creamos el objeto 
	}
	
	public static List<RegionDTO> obtenerTodas () throws SQLException
	{
		List<RegionDTO> lista_regiones = null;
		Connection conexion = null;
		Statement stmt = null;
		ResultSet rs = null;
		RegionDTO regionDTO = null;
		
		
		try {
		
		conexion = Conexion.obtenerConexion(); //Inicio la conexión
		stmt = conexion.createStatement();
		rs = stmt.executeQuery(InstruccionesSQL.CONSULTAR_TODOS);
		lista_regiones = new ArrayList<RegionDTO>();
		while (rs.next())
		{
			regionDTO = componerObjeto(rs);
			lista_regiones.add(regionDTO); // Voy rellenado el array 
			// con los valores de la tabla de Regiones
		}
		} catch (SQLException e) {
			e.printStackTrace();
			lista_regiones = null;
			throw e;
		}
		finally{
			Conexion.liberarRecursos(conexion, stmt, rs); // Desconecto todo
		}
		
		return lista_regiones;
		
	}
	public static RegionDTO obtenerUnaRegion (int region_id) throws SQLException
	{
		RegionDTO region_buscada = null;
		Connection conexion = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
			
			
			conexion = Conexion.obtenerConexion(); // Inicio la conexión
			stmt = conexion.createStatement();
			
			System.out.println("Introduce el ID de la región a buscar: ");
			region_id = sc.nextInt();
			
			pstmt = conexion.prepareStatement(InstruccionesSQL.BUSCAR_REGION);
			pstmt.setInt(1, region_id);
			rs = pstmt.executeQuery();
			
			while (rs.next())
		
			region_buscada = componerObjeto(rs);
			conexion.commit(); // realizamos commit para que la consulta
					// tenga efesto
			
		} catch (SQLException e) {
			e.printStackTrace();
			region_buscada = null;
			throw e;
		}
		finally{
			Conexion.liberarRecursos(conexion, stmt, rs); // Desconecto todo
		}
		
		return region_buscada; // devolvemos la region buscada
		
	}
	
	public static List<RegionDTO> introducirUnaRegion () throws SQLException
	{
		List<RegionDTO> region_introducida = null;
		Connection conexion = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RegionDTO regionDTO = null;
		
		
		try {
			
			conexion = Conexion.obtenerConexion(); // Inicio la conexión
			stmt = conexion.createStatement();
			pstmt.setInt(1, 7); // Le paso el valor del primer ? que es el region_id
			pstmt.setString(2, "GIBRALTAR_ESPAÑOL"); // Le paso el segundo valor del ?
								// que es el region_name
			rs = stmt.executeQuery(InstruccionesSQL.INSERTAR_REGION);
			// En teoria se inserta pero no me hace caso 
			region_introducida = (List<RegionDTO>) componerObjeto(rs);
				// recojo la region introducida para luego mostrarla
				
		} catch (SQLException e) {
			e.printStackTrace();
			region_introducida = null;
			throw e;
		}
		finally{
			Conexion.liberarRecursos(conexion, stmt, rs); // Desconecto todo
		}
		
		return region_introducida; // devolvemos la region introducida si ha ido bien
	}
}
