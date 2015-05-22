package xmlEnJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import arrayListyForEach.Persona;

public class ProcesoSAX {

/** Dado el ejemplo de código, modificar lo necesario para crear
 *  un HashMapde libros con la clave de ISBN
 *  @param args
 */
	
	
	
	
	public static void main(String[] args) {  
        
		
		
	      try {  
	         // Creamos nuestro objeto libro vacío  
	         Libro libro = new Libro();  
	         // Creamos la factoria de parseadores por defecto  
	         XMLReader reader = XMLReaderFactory.createXMLReader();  
	         
	         LibroXML libroXML = new LibroXML (libro);
	         // Añadimos nuestro manejador al reader pasandole el objeto libro  
	         reader.setContentHandler(libroXML);           
	         // Procesamos el xml de ejemplo  
	         reader.parse(new InputSource(new FileInputStream("libro.xml")));  
	         
	         Map <String, Libro> mi_hashmap_de_libros = new HashMap<String, Libro>();
	         
	         mi_hashmap_de_libros.put(libro.getIsbn(), libro);
	         
	         System.out.println(mi_hashmap_de_libros);
	        
	         
	       // System.out.println(libro.toString());   
	        
	      } catch (SAXException e) {  
	         e.printStackTrace();  
	      } catch (IOException e) {  
	         e.printStackTrace();  
	      }  
	  
	   }  
}
