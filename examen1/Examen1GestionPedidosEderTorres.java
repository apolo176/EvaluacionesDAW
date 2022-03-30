package examen1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;
import java.awt.Font;

public class Examen1GestionPedidosEderTorres extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 20211124L;
	private JPanel contentPane;
	private JPanel panelCampos;
	private JLabel lblCodigoPedido;
	private JTextField txtCodigoPedido;
	private JLabel lblPrecioUnitario;
	private JTextField txtPrecioUnitario;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	
	private JPanel panelListas;
	private JList<String> lstCodigosPedidos;
	private DefaultListModel<String> dlmCodigosPedidos;
	private JList<Double> lstPreciosUnitarios;
	private DefaultListModel<Double> dlmPreciosUnitarios;
	private JList<Integer> lstCantidades;
	private DefaultListModel<Integer> dlmCantidades;
	private JList<Double> lstTotalesLineas;
	private DefaultListModel<Double> dlmTotalesLineas;
	
	private JPanel panelTotales;
	private JLabel lblTotalPedidos;
	private JLabel lblTotalPedidosValor;
	private JLabel lblIVA;
	private JLabel lblIVAValor;
	private JLabel lblTotalFinal;
	private JLabel lblTotalFinalValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen1GestionPedidosEderTorres frame = new Examen1GestionPedidosEderTorres();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Examen1GestionPedidosEderTorres() {
		setTitle("Examen1GestionPedidos - Txema De Miguel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelCampos = new JPanel();
		contentPane.add(panelCampos, BorderLayout.NORTH);
		
		lblCodigoPedido = new JLabel("Codigo Pedido");
		panelCampos.add(lblCodigoPedido);
		
		txtCodigoPedido = new JTextField();
		txtCodigoPedido.setText("PX");
		txtCodigoPedido.setHorizontalAlignment(SwingConstants.LEFT);
		panelCampos.add(txtCodigoPedido);
		txtCodigoPedido.setColumns(10);
		
		lblPrecioUnitario = new JLabel("Precio Unitario");
		panelCampos.add(lblPrecioUnitario);
		
		txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setText("1.0");
		txtPrecioUnitario.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrecioUnitario.setColumns(10);
		panelCampos.add(txtPrecioUnitario);
		
		lblCantidad = new JLabel("Cantidad");
		panelCampos.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setText("1");
		txtCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		txtCantidad.setColumns(10);
		panelCampos.add(txtCantidad);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		panelCampos.add(btnInsertar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
	
		panelCampos.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panelCampos.add(btnLimpiar);
		
		panelListas = new JPanel();
		contentPane.add(panelListas, BorderLayout.CENTER);
		panelListas.setLayout(new GridLayout(0, 4, 0, 0));
		
		// Modelo de datos de la lista de CodigosPedidos
		dlmCodigosPedidos = new DefaultListModel<String>();
		
		// lista de CodigosPedidos
		lstCodigosPedidos = new JList<String>();
		lstCodigosPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// asocio el DefaultListModel a la lista de CodigosPedidos
		lstCodigosPedidos.setModel(dlmCodigosPedidos);
		lstCodigosPedidos.addListSelectionListener(this);

		// Modelo de datos de la lista de PreciosUnitarios
		dlmPreciosUnitarios = new DefaultListModel<Double>();

		// lista de PreciosUnitarios
		lstPreciosUnitarios = new JList<Double>();
		lstPreciosUnitarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// asocio el DefaultListModel a la lista de PreciosUnitarios
		lstPreciosUnitarios.setModel(dlmPreciosUnitarios);
		lstPreciosUnitarios.addListSelectionListener(this);

		// Modelo de datos de la lista de Cantidades
		dlmCantidades = new DefaultListModel<Integer>();

		// lista de Cantidades
		lstCantidades = new JList<Integer>();
		lstCantidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// asocio el DefaultListModel a la lista de Cantidades
		lstCantidades.setModel(dlmCantidades);
		lstCantidades.addListSelectionListener(this);

		// Modelo de datos de la lista de TotalesLineas
		dlmTotalesLineas = new DefaultListModel<Double>();
		
		// lista de TotalesLineas
		lstTotalesLineas = new JList<Double>();
		
		lstTotalesLineas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// asocio el DefaultListModel a la lista de TotalesLineas
		lstTotalesLineas.setModel(dlmTotalesLineas);
		lstTotalesLineas.addListSelectionListener(this);

		
		// añado las listas a panelListas
		panelListas.add(lstCodigosPedidos);
		panelListas.add(lstPreciosUnitarios);
		panelListas.add(lstCantidades);
		panelListas.add(lstTotalesLineas);
		
		// panelTotales
		panelTotales = new JPanel();
		contentPane.add(panelTotales, BorderLayout.SOUTH);
		
		lblTotalPedidos = new JLabel("Total Pedidos");
		lblTotalPedidos.setHorizontalAlignment(SwingConstants.LEFT);
		panelTotales.add(lblTotalPedidos);
		/**
		 * Error que tube en el examen, no leer bien la variable?
		 */
		lblTotalPedidosValor = new JLabel("0");
		lblTotalPedidosValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalPedidosValor.setHorizontalAlignment(SwingConstants.LEFT);
		panelTotales.add(lblTotalPedidosValor);
		
		lblIVA = new JLabel("IVA (21%)");
		lblIVA.setHorizontalAlignment(SwingConstants.LEFT);
		panelTotales.add(lblIVA);
		
		lblIVAValor = new JLabel("0.0");
		lblIVAValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIVAValor.setHorizontalAlignment(SwingConstants.LEFT);
		panelTotales.add(lblIVAValor);
		
		lblTotalFinal = new JLabel("Total Final");
		lblTotalFinal.setHorizontalAlignment(SwingConstants.LEFT);
		panelTotales.add(lblTotalFinal);
		
		lblTotalFinalValor = new JLabel("0.0");
		lblTotalFinalValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalFinalValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelTotales.add(lblTotalFinalValor);
		
	}

	void CalcularTotales(int posicion) {
		Double Acumulador = 0.0;
		Double IVA = 0.0;
		Double VFinal;
		for (posicion = 0; posicion < dlmTotalesLineas.getSize(); posicion++) {
			Acumulador = Acumulador + dlmTotalesLineas.getElementAt(posicion);
			// lblTotalPedidosValor
			lblTotalPedidosValor.setText("" + Acumulador);
			IVA = ((Acumulador * 21) / 100);
			lblIVAValor.setText("" + IVA);
			VFinal = IVA + Acumulador;
			lblTotalFinalValor.setText("" + VFinal);

		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Obtenemos sobre que componente se realiza el evento
		Object o= e.getSource();
		String CodigoPedido=txtCodigoPedido.getText();
		double PrecioUnitario=Double.parseDouble(txtPrecioUnitario.getText()) ;
		int Cantidad=Integer.parseInt(txtCantidad.getText());
		String Pedido = "";
		int cont=0;
		if(o==btnInsertar)
		{
			
		
			//Si txtCodigo no tiene nada
			if(CodigoPedido.isEmpty())
			{
				JOptionPane.showMessageDialog(this, (String) "Error al insertar, el campo Codigo Pedido no puede estar vacio!", "ERROR",JOptionPane.ERROR_MESSAGE);				
				
			}
			else
			{
				//Si su DLM tiene ese valor ya introducido
				if(dlmCodigosPedidos.contains(CodigoPedido))
				{
					JOptionPane.showMessageDialog(this, (String) "Error al insertar. El pedido de Codigo "+CodigoPedido+" ya esta en la lista", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				//Si no, introduce los valores 
				else
				{
					//Aqui necesitamos un bucle que recorra las posiciones de la lista y ordene Alfanumericamente( no mde dio tiemo a acaarlo)
					for(cont=0;cont<dlmCodigosPedidos.getSize();cont++)
					{
					Pedido = dlmCodigosPedidos.getElementAt(cont);
						if(CodigoPedido.compareTo(Pedido)>0)
							{
							 dlmCodigosPedidos.add(cont,CodigoPedido);
								dlmPreciosUnitarios.add(cont,PrecioUnitario);
								dlmCantidades.add(cont,Cantidad);
								double TotalLinea= Cantidad*PrecioUnitario;
								dlmTotalesLineas.add(cont,TotalLinea);
							}
						
						//dlmCodigosPedidos.addElement(CodigoPedido);
						//dlmPreciosUnitarios.addElement(PrecioUnitario);
						//dlmCantidades.addElement(Cantidad);
						//double TotalLinea= Cantidad*PrecioUnitario;
						//dlmTotalesLineas.addElement(TotalLinea);
						
							}
						
					CalcularTotales(cont);	
					
				}
			
			}
		}
			//Sino contiene nada
		

			
	
		else if(o==btnBorrar)
		{
			if(dlmCodigosPedidos.isEmpty())
			{
				txtCodigoPedido.setText("PX");
				txtPrecioUnitario.setText("1.0");
				txtCantidad.setText("1");
			}
			
			//si no hay nada seleccionado
			else if (lstCodigosPedidos.isSelectionEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para borrar",
						"ERROR", JOptionPane.ERROR_MESSAGE, null);
			} 
			else {
				int posicion = lstCodigosPedidos.getSelectedIndex();
				dlmCodigosPedidos.removeElementAt(posicion);
				dlmCantidades.removeElementAt(posicion);
				dlmPreciosUnitarios.removeElementAt(posicion);
				dlmTotalesLineas.removeElementAt(posicion);
				lstCodigosPedidos.setSelectedIndex(0);
			}
			CalcularTotales(cont);
		}
		//Limpiar
		else
		{
			
			
			if(dlmCodigosPedidos.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String)"Error, la lista ya esta vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				dlmCodigosPedidos.clear();
				dlmCantidades.clear();
				dlmPreciosUnitarios.clear();
				dlmTotalesLineas.clear();
				lblTotalPedidos.setText("0.0");

				lblIVAValor.setText("0.0");
		
				lblTotalFinalValor.setText("0.0");
				
			}
		}
		}
	
		public void valueChanged( ListSelectionEvent e) {
			/**
			 * escucha de eventos
			 * instancia o de la clase java Object
			 * en cuando se seleciona una fila muestra datos en la posicion de la lista
			 *
			 */
			Object o = e.getSource();
			int posicion;
			posicion = ((JList<String>) o).getSelectedIndex();
			lstCodigosPedidos.setSelectedIndex(posicion);
			lstCantidades.setSelectedIndex(posicion);
			lstPreciosUnitarios.setSelectedIndex(posicion);
			lstTotalesLineas.setSelectedIndex(posicion);
		}
	
	
}
	


