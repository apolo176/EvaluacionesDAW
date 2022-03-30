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

public class VentanaHola extends JFrame {

	private JPanel Holamundo;
	private JTextField txtUwu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaHola frame = new VentanaHola();
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
	public VentanaHola() {
		setResizable(false);
		setTitle("Hola ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Holamundo = new JPanel();
		Holamundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Holamundo);
		Holamundo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola Mundo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Vivaldi", Font.ITALIC, 53));
		lblNewLabel.setBounds(0, 0, 411, 142);
		Holamundo.add(lblNewLabel);
		
		txtUwu = new JTextField();
		txtUwu.setBackground(UIManager.getColor("Button.background"));
		txtUwu.setText("uwu");
		txtUwu.setFont(new Font("Vladimir Script", Font.BOLD | Font.ITALIC, 44));
		txtUwu.setBounds(0, 0, 446, 70);
		Holamundo.add(txtUwu);
		txtUwu.setColumns(10);
	}
}
