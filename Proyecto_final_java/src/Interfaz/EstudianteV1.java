package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.usuario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class EstudianteV1 extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField celular;
	private static PrintWriter out;
	private static BufferedReader in;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstudianteV1 frame = new EstudianteV1(out, in);
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
	public EstudianteV1(PrintWriter out1, BufferedReader in1) {
		
		out=out1;
		in=in1;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox<String> materias = new JComboBox<String>();
		materias.addItem("Seleccionar...");
		materias.addItem("Calculo 1");
		materias.addItem("Calculo 2");
		materias.addItem("Algebra Linal");
		materias.addItem("Probabilidad");
		materias.addItem("Estadisticas");
		materias.addItem("Microeconom\u00EDa 1");
		materias.addItem("Microeconom\u00EDa 2");
		materias.addItem("Macroeconom\u00EDa 1");
		materias.addItem("Macroeconom\u00EDa 2");
		contentPane.setLayout(null);
		
		JComboBox<String> ubicacion = new JComboBox<String>();
		ubicacion.setBounds(453, 515, 154, 25);
		ubicacion.addItem("Seleccionar...");
		ubicacion.addItem("Edificio Cabal");
		ubicacion.addItem("Edificio Santa Fe");
		ubicacion.addItem("Claustro");
		ubicacion.addItem("Torre 1");
		ubicacion.addItem("Torre 2");
		ubicacion.addItem("Torre 3");
		ubicacion.addItem("Casur de la 7ma");
		ubicacion.addItem("Casa Pedro Fermin");
		ubicacion.addItem("Jockey");
		ubicacion.addItem("Casur");
		contentPane.add(ubicacion);
		

		materias.setBounds(452, 446, 154, 25);
		contentPane.add(materias);
		
		celular = new JTextField();
		celular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char vchar=arg0.getKeyChar();
				if(!(Character.isDigit(vchar))
					|| (vchar==KeyEvent.VK_BACK_SPACE)
					||(vchar==KeyEvent.VK_DELETE)){
					arg0.consume();
				}
			}
		});
		celular.setBounds(452, 383, 154, 25);
		contentPane.add(celular);
		celular.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(452, 323, 318, 25);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JButton continuar = new JButton("Continuar");
		continuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nom= nombre.getText();
				String cel1=celular.getText();
				Double cel=Double.valueOf(cel1);
				String mat=materias.getSelectedItem().toString();
				usuario a=new usuario();
				a.setNombre(nom);
				a.setCelular(cel);
				a.setMateria(mat);
				String ubi=ubicacion.getSelectedItem().toString();
				switch(ubi) {
				case "Seleccionar...":
					a.setUbicacionX(87);
					a.setUbicacionY(90);
					break;
				case "Edificio Cabal":
					a.setUbicacionX(24);
					a.setUbicacionY(70);
					break;
				case "Edificio Santa Fe":
					a.setUbicacionX(76);
					a.setUbicacionY(76);
					break;
				case "Claustro":
					a.setUbicacionX(51);
					a.setUbicacionY(18);
					break;
				case "Torre 1":
					a.setUbicacionX(78);
					a.setUbicacionY(20);
					break;
				case "Torre 2":
					a.setUbicacionX(74);
					a.setUbicacionY(33);
					break;
				case "Torre 3":
					a.setUbicacionX(37);
					a.setUbicacionY(90);
					break;
				case "Casur de la 7ma":
					a.setUbicacionX(98);
					a.setUbicacionY(1);
					break;
				case "Casa Pedro Fermin":
					a.setUbicacionX(9);
					a.setUbicacionY(19);
					break;
				case "Jockey":
					a.setUbicacionX(47);
					a.setUbicacionY(87);
					break;
				case "Casur":
					a.setUbicacionX(78);
					a.setUbicacionY(4);
					break;
				default:
					a.setUbicacionX(0);
					a.setUbicacionY(0);
					break;
				}
					
				String linea="s/";
				linea=linea+a.getNombre();
				linea=linea+"/";
				linea=linea+a.getCelular();
				linea=linea+"/";
				linea=linea+a.getUbicacionX();
				linea=linea+"/";
				linea=linea+a.getUbicacionY();
				linea=linea+"/";
				linea=linea+a.getMateria();
				out.println(linea);
				out.flush();
				
				
				a.EscribirEstudiante();
				EstudianteV2 ventana=new EstudianteV2(a,in);
				ventana.setVisible(true);
				dispose();
				
				
				
			}
		});
		continuar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continuar.setBounds(570, 569, 140, 31);
		contentPane.add(continuar);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n:");
		lblUbicacin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUbicacin.setBounds(333, 506, 138, 31);
		contentPane.add(lblUbicacin);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMateria.setBounds(333, 446, 138, 31);
		contentPane.add(lblMateria);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCelular.setBounds(333, 383, 138, 31);
		contentPane.add(lblCelular);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombre.setBounds(333, 323, 138, 31);
		contentPane.add(lblNombre);
		
		JLabel TITULO_ESTUDIANTE = new JLabel("ESTUDIANTE");
		TITULO_ESTUDIANTE.setForeground(new Color(0, 0, 0));
		TITULO_ESTUDIANTE.setHorizontalAlignment(SwingConstants.CENTER);
		TITULO_ESTUDIANTE.setFont(new Font("Bernard MT Condensed", Font.BOLD, 50));
		TITULO_ESTUDIANTE.setBounds(463, 212, 416, 90);
		contentPane.add(TITULO_ESTUDIANTE);
		
		JLabel FONDO = new JLabel("ESTUDIANTE");
		FONDO.setIcon(new ImageIcon("..//Proyecto_final_java//imagenes//6.png"));
		FONDO.setBounds(0, 0, 1280, 700);
		contentPane.add(FONDO);
	}
}
