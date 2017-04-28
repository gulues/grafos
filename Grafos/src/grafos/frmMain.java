package grafos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.Demo;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer.ZOOM_BUTTON_STYLE;

public class frmMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain window = new frmMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMapViewer mapViewer = new JMapViewer();
		mapViewer.setZoomButtonStyle(ZOOM_BUTTON_STYLE.HORIZONTAL);
		mapViewer.setTileGridVisible(true);
		mapViewer.setScrollWrapEnabled(true);
		mapViewer.setBounds(10, 11, 759, 599);
		frame.getContentPane().add(mapViewer);
		
		
	}
}
