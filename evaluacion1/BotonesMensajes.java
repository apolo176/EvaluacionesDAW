package evaluacion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BotonesMensajes extends JFrame {

	private JPanel Holamundo;
	private JTextField textField;
	private Panel panel_1;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotonesMensajes frame = new BotonesMensajes();
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
	public BotonesMensajes() {
		setResizable(false);
		setTitle("Hola ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Holamundo = new JPanel();
		Holamundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Holamundo);
		Holamundo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		Holamundo.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(40);
		
		panel_1 = new Panel();
		Holamundo.add(panel_1, BorderLayout.CENTER);
		
		btn1 = new JButton("Hola");
		btn1.setBounds(0, 5, 199, 86);
		
		btn2 = new JButton("Kaixo");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setBounds(0, 111, 199, 86);
		
		btn3 = new JButton("Agur");
		btn3.setBounds(217, 111, 209, 86);
		
		btn4 = new JButton("Adios");
		btn4.setBounds(217, 5, 209, 86);
		panel_1.setLayout(null);
		panel_1.add(btn1);
		panel_1.add(btn2);
		panel_1.add(btn3);
		panel_1.add(btn4);
		
		JLabel Mensaje = new JLabel("No hay mensaje");
		Mensaje.setBounds(10, 201, 138, 13);
		panel_1.add(Mensaje);
	}
}
