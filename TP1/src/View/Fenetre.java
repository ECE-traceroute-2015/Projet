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

/**
 *
 * @author Larbish
 */
public class Fenetre extends JFrame implements ActionListener {
    
   // private JPanel pan;
    
    private JButton graph;
    private JTextField field_IPaddress;
   private JLabel label_IPaddress;
   
    
    public Fenetre(){
    
    super("Projet TraceRoute");
    // mise en page (layout) de la fenetre visible
        setLayout(null);
        setBounds(0, 0, 400, 400);
        setResizable(true);
        setVisible(true);
        this.setLocationRelativeTo(null);
     
        
        //pan = new JPanel();
        label_IPaddress = new JLabel("Adresse IP:");
        field_IPaddress = new JTextField();
        graph = new JButton("Générer Graphe");
        
        
        //field_IPaddress.setPreferredSize(new Dimension(100, 20));
        label_IPaddress.setBounds(100, 000, 100, 200);
        field_IPaddress.setBounds(200, 90, 100, 20);
        graph.setBounds(130, 150, 125, 100);
        
  
        //this.setContentPane(pan);
        setBackground(Color.WHITE);   
        add(label_IPaddress);
        add(field_IPaddress);
        add(graph);
 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
