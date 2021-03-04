package pruebas;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Hashtable;

import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import JUnit.Junit09_Geometria.dto.Geometria;

class GeometriaPruebas {
	private Geometria geo;
	
	@BeforeEach
	public void inicial() {
		geo=new Geometria();
	}
	
	@Test
	public void testConstructor1() {
		//geo=new Geometria();
		int id=geo.getId();
		int idTest=9;
		
		String nom=geo.getNom();
		String nomTest="Default";
		
		assertEquals(idTest,id);
		assertEquals(nomTest,nom);
	}
	
	@Test
	public void testConstructor2() {
		/*Pruebas al primer constructor para validar
		 * que este recibiendo el parametro y asignandolo
		 * a las variables que estan definidas en la clase*/
		
		int idTest=3;
		geo=new Geometria(idTest);
		int id=geo.getId();
		
		
		String nomTest="Triangulo";
		String nom=geo.getNom();
		
		assertEquals(idTest,id);
		assertEquals(nomTest,nom);
			
	}
	
	/*Este metodo de prueba lo hice de esta forma para que me pruebe
	 * todas las posibilidades que hay de respuesta sin tener que usar mas metodos
	 * solo es una propuesta, note que si lo hago de esta forma la cobertura del proyecto
	 * no aumenta mucho.*/
	 @Test
	    public void testFigura(){
	    	Hashtable<Integer,String> opciones=new Hashtable<Integer,String>();
	    	
	    	opciones.put(0, "Default");//Esta es la opcion por defecto del switch
	    	opciones.put(1, "Cuadrado");
	    	opciones.put(2, "Circulo");
	    	opciones.put(3, "Triangulo");
	    	opciones.put(4, "Rectangulo");
	    	opciones.put(5, "Pentagono");
	    	opciones.put(6, "Rombo");
	    	opciones.put(7, "Romboide");
	    	opciones.put(8, "Trapecio");

	    	String figuraTest;
	    	int idT=0;
	
	    	for(int i=0;i<=8;i++) {
	    		figuraTest=opciones.get(i);
	    		String figura=geo.figura(idT);
	    		Assert.assertEquals(figuraTest,figura);
	    		idT++;
	    		
	    	}
	        
	    }

	@Test
	public void testAreaCuadrado() {
		int areaCuadrado=geo.areacuadrado(4);
		int resultadoE=16;
		
		assertEquals(resultadoE,areaCuadrado);
	}
	
	@Test
	public void testAreaCuadrado2() {
		int areaCuadrado=geo.areacuadrado(6);
		int resultadoE=36;
		/*Esta prueba deberia dar error ya que el resultado
		esperado no es correcto*/
		assertEquals(resultadoE,areaCuadrado);
	}
	
	@Test
	public void testAreaCirculo() {
		//Pasamos el valor de r y nos retorna un double con el area
		double areaCirculo=geo.areaCirculo(6);
		double resultadoE=113.0976;
		
		assertEquals(resultadoE,areaCirculo);
	}
	
	@Test
	public void testAreaTriangulo() {
		//Pasamos el valor de r y nos retorna un double con el area
		double areaTriangulo=geo.areatriangulo(7,15);
		double resultadoE=52.5;
		
		assertEquals(resultadoE,areaTriangulo);
	}
	
	@Test
	public void testAreaRectangulo() {
		
		int areaRectangulo=geo.arearectangulo(10, 34);
		int resultadoE=340;
		
		assertEquals(resultadoE,areaRectangulo);
	}
	
	@Test
	public void testAreaPentagono() {
		//El metodo recibe el perimetro y el apotema
		double areaPentagono=geo.areapentagono(5, 8);
		double resultadoE=20;
		
		assertEquals(resultadoE,areaPentagono);
	}
	
	@Test
	public void testAreaRombo() {
		//Recibe Diagona mayor y diagonal menor
		double areaRombo=geo.arearombo(12, 7);
		double resultadoE=42;
		
		assertEquals(resultadoE,areaRombo);
	}
	
	@Test
	public void testAreaRomboide() {
		//Enviamos al metodo la base y la altura
		int areaRomboide=geo.arearomboide(18, 7);
		int resultadoE=126;
		
		assertEquals(resultadoE,areaRomboide);
	} 
	
	
	@Test
	public void testAreaTrapecio() {
		//Enviamos al metodo la base mayor, base menos y la altura
		double areaTrapecio=geo.areatrapecio(15, 6,8);
		double resultadoE=84;
		
		assertEquals(resultadoE,areaTrapecio);
	}
	
	
	
	@Test
	public void testSetId() {
		geo.setId(10);
		int resultE=10;
		int getId=geo.getId();
		assertEquals(resultE,getId);
	}
	
	@Test
	public void testSetArea() {
		geo.setArea(20.5);
		double resultE=20.5;
		double getArea=geo.getArea();
		assertEquals(resultE,getArea);
	}
	
	@Test
	public void testSetNom() {
		geo.setNom("Triangulo");
		String resultE="Triangulo";
		String getNom=geo.getNom();
		assertEquals(resultE,getNom);
	}
	
	@Test
	public void testToString() {
		geo.setId(6);
		geo.setNom("Rombo");
		geo.setArea(20);
		
		String respuestaE="Geometria [id=" + geo.getId() + ", nom=" + geo.getNom() + ", area=" + geo.getArea() + "]";
		String toString=geo.toString();
		assertEquals(respuestaE,toString);
	}
}
