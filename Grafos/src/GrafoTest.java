import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoTest
{
	@Test
	public void agregarAristaTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 2);
		assertTrue( grafo.existeArista(0, 2) );
	}
	
	@Test
	public void agregarIndicesInvertidosTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 3);
		assertTrue( grafo.existeArista(3, 1) );
	}
	
	@Test
	public void aristaInexistenteTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 3);
		assertFalse( grafo.existeArista(1, 2) );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregadoErroneoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(-1, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sinLoopsTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(3, 3);
	}
	
	@Test
	public void eliminarAristaTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2);

		grafo.eliminarArista(1, 2);
		assertFalse( grafo.existeArista(1, 2) );
	}

	@Test
	public void eliminarCruzadoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2);

		grafo.eliminarArista(1, 2);
		assertFalse( grafo.existeArista(2, 1) );
	}
}






