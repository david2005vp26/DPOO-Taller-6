package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.mapa.PanelMapaVisualizar;
import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    // El panel donde se editan los detalles del restaurante
    
    private PanelEditarRestaurante panelDetalles;

    // El panel con los botones para agregar un restaurante o cerrar la ventana
    
    private PanelBotonesAgregar panelBotones;

    // El panel para marcar la ubicación del restaurante

    private PanelMapaAgregar panelMapa;

    // La ventana principal de la aplicación 
    
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
    	this.ventanaPrincipal = principal;
        setLayout(new BorderLayout());

        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(2, 1));

        panelDetalles = new PanelEditarRestaurante();
        panelInferior.add(panelDetalles);

        panelBotones = new PanelBotonesAgregar(this);
        panelInferior.add(panelBotones);

        add(panelInferior, BorderLayout.SOUTH);

        // Termina de configurar la ventana
        pack();
        setTitle("Agregar Restaurante");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    // Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
  
    public void agregarRestaurante( ){
    	try
        {

            String nombre = panelDetalles.getNombre();
            int calificacion = panelDetalles.getCalificacion();
            boolean visitado = panelDetalles.getVisitado();
            int[] x = panelMapa.getCoordenadas();
            
            ventanaPrincipal.agregarRestaurante(nombre, calificacion, x[0], x[1], visitado);
            cerrarVentana();
        }
        catch (IllegalArgumentException e)
        {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    // Cierra la ventana sin crear un nuevo restaurante

    public void cerrarVentana( )
    {
        dispose( );
    }

}
