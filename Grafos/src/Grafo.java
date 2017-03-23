import java.util.ArrayList;


public class Grafo
{
	// Representamos el grafo por medio de su matriz de adyacencia
	private boolean[][] _adj;

	// El grafo se construye sin aristas
	public Grafo(int verticesIniciales)
	{
		_adj = new boolean[verticesIniciales][verticesIniciales];
	}
	
	// Agregar una arista
	public void agregarArista(int i, int j)
	{
		chequearArista(i, j, "agregar");

		_adj[i][j] = true;
		_adj[j][i] = true;
	}
	
	// Como es un método para eliminar una arista?
	public void eliminarArista(int i, int j)
	{
		chequearArista(i, j, "eliminar");
		
		_adj[i][j] = false;
		_adj[j][i] = false;
	}
	
	// Responde si existe una arista
	public boolean existeArista(int i, int j)
	{
		chequearArista(i, j, "consultar");
		return _adj[i][j];
	}

	// Verifica que los vértices puedan corresponder a una arista
	private void chequearArista(int i, int j, String accion)
	{
		if( i < 0 || i >= getVertices() )
			throw new IllegalArgumentException("Se intentó " + accion + " una arista con un vértice inexistente! i = " + i);
		
		if( j < 0 || j >= getVertices() )
			throw new IllegalArgumentException("Se intentó " + accion + " una arista con un vértice inexistente! j = " + i);
		
		if( i == j )
			throw new IllegalArgumentException("Se intentó " + accion + " una arista con dos vertices iguales! i, j = " + i);
	}

	// El nuevo vértice tiene rótulo n, si antes había n vértices
	public void agregarVertice()
	{
		int n = getVertices();
		boolean[][] nueva = new boolean[n+1][n+1];
		
		for(int i=0; i<n; ++i)
		for(int j=0; j<n; ++j)
			nueva[i][j] = _adj[i][j];
		
		_adj = nueva;
	}

	// Retorna el grado (cantidad de vecinos) del vértice i
	public int getGrado(int i)
	{
		// Código defensivo
		if( i < 0 || i >= getVertices())
			throw new IllegalArgumentException("Se intentó consultar el grado de un vértice inexistente! i = " + i);
		
		int contador = 0;
		for(int j=0; j<getVertices(); ++j) if( j != i )
		{
			if( existeArista(i, j) ) // O(1)
				++contador;
		}
		
		return contador;
	}
	
	// Cantidad de vértices del grafo
	public int getVertices()
	{
		return _adj.length;
	}	
	
	public static void main(String[] args)
	{
		Grafo rueda = new Grafo(6);
		rueda.agregarArista(0, 1);
		rueda.agregarArista(1, 2);
		rueda.agregarArista(2, 3);
		rueda.agregarArista(3, 4);
		rueda.agregarArista(4, 0);
		rueda.agregarArista(0, 5);
		rueda.agregarArista(1, 5);
		rueda.agregarArista(2, 5);
		rueda.agregarArista(3, 5);
		rueda.agregarArista(4, 5);

		for(int i=0; i<=rueda.getVertices(); ++i)
			System.out.println("d(" + i + ") = " + rueda.getGrado(i));
	}
}






