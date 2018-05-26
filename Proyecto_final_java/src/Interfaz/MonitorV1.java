package Interfaz;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Clases.monitor;
import Clases.usuario;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class MonitorV1 extends JFrame {
	
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
					MonitorV1 frame = new MonitorV1(out, in);
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
	public MonitorV1(PrintWriter out1, BufferedReader in1) {
		
		out=out1;
		in=in1;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] materias= { "Calculo 1", "Calculo 2", "Algebra Linal", "Probabilidad", "Estadisticas", "Microeconom\u00EDa 1", "Microeconom\u00EDa 2", "Macroeconom\u00EDa 1", "Macroeconom\u00EDa 2"};
		JCheckBox[] boxes=new JCheckBox[materias.length];
		for(int i = 0; i < boxes.length; i++) {
			 boxes[i] = new JCheckBox(materias[i]);
			 boxes[i].setFont(new Font("Tahoma", Font.BOLD, 12));
			 boxes[i].setOpaque(false);
			 boxes[i].setContentAreaFilled(false);
			 boxes[i].setBorderPainted(false);
			 getContentPane().add(boxes[i]);
		}
		boxes[0].setBounds(843, 408, 138, 23);
		boxes[1].setBounds(843, 432, 138, 23);
		boxes[2].setBounds(674, 456, 138, 23);
		boxes[3].setBounds(843, 456, 138, 23);
		boxes[4].setBounds(509, 456, 138, 23);
		boxes[5].setBounds(674, 408, 138, 23);
		boxes[6].setBounds(674, 432, 138, 23);
		boxes[7].setBounds(509, 408, 138, 23);
		boxes[8].setBounds(509, 432, 138, 23);
		
		
		JComboBox<String> ubicacion = new JComboBox<String>();
		ubicacion.setBounds(509, 491, 126, 23);
		ubicacion.addItem("Seleccionar...");
		ubicacion.addItem("Edificio Cabal");
		ubicacion.addItem("Edificio Santa Fe");
		ubicacion.addItem("Claustro");
		ubicacion.addItem("Torre 1");
		ubicacion.addItem("Torre 2");
		ubicacion.addItem("Torre 3");
		ubicacion.addItem("Claustro de la 7ma");
		ubicacion.addItem("Casa Pedro Fermin");
		ubicacion.addItem("Jockey");
		contentPane.add(ubicacion);
		
		JButton continuar = new JButton("Continuar");
		continuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nom= nombre.getText();
				Double cel=Double.valueOf(celular.getText());
				ArrayList<String> mat= new ArrayList<String>();
				mat.add("");
				mat.clear();
			    for(JCheckBox box : boxes) {
			        if(box.isSelected()) {
			            mat.add(box.getText());
			        }
			    }
				monitor c=new monitor(nom,cel,mat);
				String ubi=ubicacion.getSelectedItem().toString();
				switch(ubi) {
				case "Seleccionar...":
					c.setUbicacionX(87);
					c.setUbicacionY(90);
					break;
				case "Edificio Cabal":
					c.setUbicacionX(24);
					c.setUbicacionY(70);
					break;
				case "Edificio Santa Fe":
					c.setUbicacionX(76);
					c.setUbicacionY(76);
					break;
				case "Claustro":
					c.setUbicacionX(51);
					c.setUbicacionY(18);
					break;
				case "Torre 1":
					c.setUbicacionX(78);
					c.setUbicacionY(20);
					break;
				case "Torre 2":
					c.setUbicacionX(74);
					c.setUbicacionY(33);
					break;
				case "Torre 3":
					c.setUbicacionX(37);
					c.setUbicacionY(90);
					break;
				case "Casur de la 7ma":
					c.setUbicacionX(98);
					c.setUbicacionY(1);
					break;
				case "Casa Pedro Fermin":
					c.setUbicacionX(9);
					c.setUbicacionY(19);
					break;
				case "Jockey":
					c.setUbicacionX(47);
					c.setUbicacionY(87);
					break;
				case "Casur":
					c.setUbicacionX(78);
					c.setUbicacionY(4);
					break;
				default:
					c.setUbicacionX(0);
					c.setUbicacionY(0);
					break;
				}
				c.EscribirMonitor();
				String linea="m/";
				linea=linea+c.getNombre();
				linea=linea+"/";
				linea=linea+c.getCelular();
				linea=linea+"/";
				linea=linea+c.getUbicacionX();
				linea=linea+"/";
				linea=linea+c.getUbicacionY();
				for(int i=0; i<c.getMaterias().size();i++) {
					linea=linea+"/";
					linea=linea+c.getMaterias().get(i);
					
				}
				out.println(linea);
				out.flush();
				MonitorV2 ventana1=new MonitorV2(c,out,in);
				
				ventana1.setVisible(true);
				dispose();
			}
		});

		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n:");
		lblUbicacin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUbicacin.setBounds(359, 486, 118, 28);
		contentPane.add(lblUbicacin);
		
		continuar.setToolTipText("");
		continuar.setForeground(new Color(51, 102, 153));
		continuar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		continuar.setBackground(SystemColor.menu);
		continuar.setBounds(579, 556, 135, 31);
		contentPane.add(continuar);
		
		JLabel lblMonitor = new JLabel("MONITOR");
		lblMonitor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonitor.setForeground(Color.BLACK);
		lblMonitor.setFont(new Font("Bernard MT Condensed", Font.BOLD, 50));
		lblMonitor.setBounds(443, 198, 416, 90);
		getContentPane().add(lblMonitor);
		

		
		JLabel lblmateria = new JLabel("Materias:");
		lblmateria.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblmateria.setBounds(359, 408, 110, 28);
		getContentPane().add(lblmateria);
		
		JLabel lblcelular = new JLabel("Celular:");
		lblcelular.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblcelular.setBounds(359, 348, 96, 28);
		getContentPane().add(lblcelular);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblnombre.setBounds(359, 288, 106, 28);
		getContentPane().add(lblnombre);
		
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(509, 288, 318, 23);
		getContentPane().add(nombre);
		
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
		celular.setColumns(10);
		celular.setBounds(509, 348, 154, 23);
		getContentPane().add(celular);
		

		
		JLabel fondo = new JLabel("");
		fondo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fondo.setIcon(new ImageIcon("..//Proyecto_final_java//imagenes//3.png"));
		fondo.setBounds(0, 0, 1280, 720);
		getContentPane().add(fondo);

	}
}
