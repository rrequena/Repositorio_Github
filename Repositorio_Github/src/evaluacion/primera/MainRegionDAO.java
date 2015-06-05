package evaluacion.primera;

import java.sql.SQLException;
import java.util.List;

public class MainRegionDAO {
	
	public static void main(String[] args) {
	try {
			 
			List<RegionDTO> lista_regiones = RegionDAO.obtenerTodas();
			System.out.println(lista_regiones);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al recuperar la lista de regiones de la base de datos");	
		}
	try {
			 
			List<RegionDTO> region_buscada = RegionDAO.obtenerUnaRegion();
			System.out.println(region_buscada);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al recuperar la región de la base de datos");	
		} 
	try {
		 
		List<RegionDTO> region_introducida = RegionDAO.introducirUnaRegion();
		System.out.println(region_introducida);
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Error al introducir la región en la base de datos");	
	} 
	}

}
