package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Clases.monitor;
import Clases.usuario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import java.awt.GridLayout;
import java.io.BufferedReader;

public class EstudianteV2 extends JFrame {

	private JPanel contentPane;
	private usuario estudiante;
	private monitor moni;
	private ArrayList<monitor> lista;
	private static BufferedReader in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuario a=new usuario();
					EstudianteV2 frame = new EstudianteV2(a,in);
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
	public EstudianteV2(usuario a, BufferedReader in1) {
		in=in1;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		estudiante=a;
		moni=new monitor();
		ArrayList<monitor> lista1=moni.leerMonitor();
		lista=moni.filtro(lista1,estudiante.getMateria());
		
		String n= estudiante.getNombre();
		
		contentPane.setLayout(null);
		
		JLabel Estudiante = new JLabel(n);
		Estudiante.setBounds(242, 250, 639, 31);
		Estudiante.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(Estudiante);
		
		int size_lista=lista.size();
		
		JPanel mainList = new JPanel(new GridBagLayout());
		mainList.setBounds(205,300, 880, 310); 
        GridBagConstraints gbc = new GridBagConstraints();
        mainList.setVisible(true);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainList.add(new JPanel(), gbc);
        
        JScrollPane scroll =new JScrollPane(mainList);
        scroll.setBounds(205,300, 880, 310); 
        contentPane.add(scroll);

        for (int i = 0; i < size_lista; i++){
        	
        	 monitor w=lista.get(i);
        	
             JPanel panel = new JPanel();
             GridLayout gb=new  GridLayout(0,2);
             panel.setLayout(gb);
               
               
             JLabel lblNombre = new JLabel("Nombre:");
   			 lblNombre.setBounds(40, 11, 65, 20);
   			 lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
   		     lblNombre.setHorizontalTextPosition(JLabel.CENTER);
   		     panel.add(lblNombre);
   			 
   			 String h=w.getNombre();
   			 JLabel lblPorAsignar = new JLabel(h);
   			 lblPorAsignar.setBounds(145, 11, 189, 20);
   			 lblPorAsignar.setHorizontalTextPosition(JLabel.CENTER);
   			 panel.add(lblPorAsignar);
   			 lblPorAsignar.setFont(new Font("Tahoma", Font.BOLD, 13));
   			 
   			 
   			 JLabel lblCelular = new JLabel("Celular:");
  			 lblCelular.setBounds(40, 44, 62, 20);
  			 panel.add(lblCelular);
  			 lblCelular.setFont(new Font("Tahoma", Font.BOLD, 14));
  			
  			 String j=String.valueOf(w.getCelular());
  			 JLabel lblPorAsignar_1 = new JLabel(j);
  			 lblPorAsignar_1.setBounds(145, 42, 152, 20);
  			 panel.add(lblPorAsignar_1);
  			 lblPorAsignar_1.setFont(new Font("Tahoma", Font.BOLD, 14));
  			
  			 JLabel lblMaterias = new JLabel("Materias:");
  			 lblMaterias.setBounds(40, 75, 80, 20);
  			 panel.add(lblMaterias);
  			 lblMaterias.setFont(new Font("Tahoma", Font.BOLD, 14));
  			String z="";
			//no me concatena las palabras
			for(int k=0;k<w.getMaterias().size();k++) {
				String hijo=w.getMaterias().get(k);
				z=z+hijo;
				z=z+", ";
				}
			z=z+".";
//			
  				
  			 JLabel lblPorAsignar_2 = new JLabel(z);
				 lblPorAsignar_2.setBounds(145, 77, 589, 35);
				 panel.add(lblPorAsignar_2);
				 lblPorAsignar_2.setFont(new Font("Tahoma", Font.BOLD, 13));
				 lblPorAsignar_2.setVerticalAlignment(SwingConstants.TOP);
   			
               panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
               GridBagConstraints gb1c = new GridBagConstraints();
               gb1c.gridwidth = GridBagConstraints.REMAINDER;
               gb1c.weightx = 1;
               gb1c.fill = GridBagConstraints.HORIZONTAL;
               mainList.add(panel, gb1c, 0);
        }

        
        
        
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1280, 720);
		fondo.setIcon(new ImageIcon("..//Proyecto_final_java//imagenes//6.png"));
		contentPane.add(fondo);
		

	}
}
