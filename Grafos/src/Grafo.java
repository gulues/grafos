
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
		if( i < 0 || i >= _adj.length )
			throw new IllegalArgumentException("Se intentó " + accion + " una arista con un vértice inexistente! i = " + i);
		
		if( j < 0 || j >= _adj.length )
			throw new IllegalArgumentException("Se intentó " + accion + " una arista con un vértice inexistente! j = " + i);
		
		if( i == j )
			throw new IllegalArgumentException("Se intentó " + accion + " una arista con dos vertices iguales! i, j = " + i);
	}

	// El nuevo vértice tiene rótulo n, si antes había n vértices
	public void agregarVertice()
	{
		int n = _adj.length;
		boolean[][] nueva = new boolean[n+1][n+1];
		
		for(int i=0; i<n; ++i)
		for(int j=0; j<n; ++j)
			nueva[i][j] = _adj[i][j];
		
		_adj = nueva;
	}
	
	public static void main(String[] args)
	{
		Grafo g = new Grafo(5);
		g.existeArista(-1, 120); // Esto explota
	}
}






