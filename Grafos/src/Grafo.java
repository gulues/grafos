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
	
	// Como es un m�todo para eliminar una arista?
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

	// El nuevo v�rtice tiene r�tulo n, si antes hab�a n v�rtices
	public void agregarVertice()
	{
		int n = getVertices();
		boolean[][] nueva = new boolean[n+1][n+1];
		
		for(int i=0; i<n; ++i)
		for(int j=0; j<n; ++j)
			nueva[i][j] = _adj[i][j];
		
		_adj = nueva;
	}

	// Retorna el grado (cantidad de vecinos) del v�rtice i
	public int getGrado(int i)
	{
		chequearVertice(i, "el grado");
		return getVecinos(i).size();
	}
	
	// Retorna el conjunto de vecinos de un v�rtice
	public ArrayList<Integer> getVecinos(int i)
	{
		chequearVertice(i, "los vecinos");
		
		ArrayList<Integer> vecinos = new ArrayList<Integer>();
		for(int j=0; j<getVertices(); ++j) if( j != i )
		{
			if( existeArista(i, j) )
				vecinos.add(j);
		}
		
		return vecinos;			
	}

	// Cantidad de v�rtices del grafo
	public int getVertices()
	{
		return _adj.length;
	}	

	// Verifica que un �ndice corresponda a un v�rtice v�lido
	private void chequearVertice(int i, String consulta)
	{
		if( i < 0 || i >= getVertices())
			throw new IllegalArgumentException("Se intent� consultar " + consulta + " de un v�rtice inexistente! i = " + i);
	}

	// Verifica que los v�rtices puedan corresponder a una arista
	private void chequearArista(int i, int j, String accion)
	{
		if( i < 0 || i >= getVertices() )
			throw new IllegalArgumentException("Se intent� " + accion + " una arista con un v�rtice inexistente! i = " + i);
		
		if( j < 0 || j >= getVertices() )
			throw new IllegalArgumentException("Se intent� " + accion + " una arista con un v�rtice inexistente! j = " + j);
		
		if( i == j )
			throw new IllegalArgumentException("Se intent� " + accion + " una arista con dos vertices iguales! i, j = " + i);
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

		for(Integer v: rueda.getVecinos(5))
			System.out.println(v);
	}
}






