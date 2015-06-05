package evaluacion.primera;

public class InstruccionesSQL {

	public static final String CONSULTAR_TODOS = "SELECT * FROM REGIONS"; 
	public static final String BUSCAR_REGION = "SELECT * FROM REGIONS WHERE REGION_ID = ?"; 
	public static final String INSERTAR_REGION = "INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES (?, ?);";
}
