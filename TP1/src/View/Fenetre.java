/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;


import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.GraphController;

/**
 *
 * @author Larbish
 */
public class Fenetre extends JFrame implements ActionListener {
    
   // private JPanel pan;
    
    private JButton button_graph;
    private JButton button_graphAuto;
    private JTextField field_IPaddress;
    private JLabel label_IPaddress;
    private JLabel label_IPaleatoire;
    private JLabel label_IPdonne;
    private String str_IPaleatoire;
   
    
    public Fenetre(){
    
       
    super("Projet TraceRoute");
    // mise en page (layout) de la fenetre visible
        setLayout(null);
        setBounds(0, 0, 400, 400);
        setResizable(true);
        setVisible(true);
        this.setLocationRelativeTo(null);
     
        
        //pan = new JPanel();
        label_IPaddress = new JLabel("Adresse IP :");
        field_IPaddress = new JTextField();
        button_graph = new JButton("Générer Graphe");
        button_graphAuto = new JButton("Générer graphe vers adresse IP aléatoire");
        label_IPaleatoire = new JLabel("");
        label_IPdonne = new JLabel("");
        
        //field_IPaddress.setPreferredSize(new Dimension(100, 20));
        label_IPaddress.setBounds(90, -30, 100, 200);
        field_IPaddress.setBounds(190, 60, 100, 20);
        button_graph.setBounds(55, 120, 270, 50);
        button_graphAuto.setBounds(55, 220, 270, 50);
  
        //this.setContentPane(pan);
        setBackground(Color.WHITE);   
        add(label_IPaddress);
        add(field_IPaddress);
        add(button_graph);
        add(button_graphAuto);
        
        
        //ajout action listener
        button_graph.addActionListener(this);
        button_graphAuto.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try{
            if (ae.getActionCommand().equals("Générer Graphe")) {

                this.remove(label_IPdonne);
                String _finalIP = new String(field_IPaddress.getText());
                boolean traceGraph = Controller.GraphController.traceGraph(_finalIP); 
                label_IPdonne = new JLabel("Un graphe vers l'adresse " + field_IPaddress.getText() + " a été créé.");
                this.add(label_IPdonne);
                label_IPdonne.setBounds(60, 80, 350, 200);
                
            }
            else if(ae.getActionCommand().equals("Générer graphe vers adresse IP aléatoire"))
            {
                this.remove(label_IPaleatoire);
                String addressIPauto = Controller.GraphController.traceGraphAuto();   
                label_IPaleatoire = new JLabel("Un graphe vers l'adresse " + addressIPauto + " a été créé.");
                this.add(label_IPaleatoire);
                label_IPaleatoire.setBounds(40, 180, 350, 200);
                
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
