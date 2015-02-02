/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;


import Model.Node;
import Model.Tree;
import View.Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Larbish
 */
public class MainController {

    
    private static BufferedReader getOutput(Process p) {   

        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static BufferedReader getError(Process p) {
        return new BufferedReader(new InputStreamReader(p.getErrorStream()));
    }

   
    public static void main(String[] args) {
    System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
    Node _myRoot = new Node("123");
    
    Tree _myTree = new Tree(_myRoot);
    
    
    Process p = null;

    try {
        String commande = "java -jar ./lib/fakeroute.jar www.ece.fr";
        p = Runtime.getRuntime().exec(commande);

    } catch (IOException e) {
        e.printStackTrace();
    }


    BufferedReader output = getOutput(p);
    BufferedReader error = getError(p);
    String ligne = "";
    List<String> _listeIPs = new ArrayList<>();

    try{

        while ((ligne = output.readLine()) != null) {
            //System.out.println("**********************");
            //System.out.println(ligne);
            //System.out.println("**********************");
            _listeIPs = _myTree.getIPs(ligne);
            boolean _myBool = _myTree.addChildren(_listeIPs);
            if(_myBool)
            {
                System.out.println("Children add\n");
            }
            else 
            {
                System.out.println("Children not add");
            }
            
            
            
        }

        while ((ligne = error.readLine()) != null) {
            System.out.println(ligne);

        }
        
        _myTree.displayTree();
   
         boolean ex;
         ex = View.Graph.newGraph(_myTree);
    }
     catch (IOException e) {
        e.printStackTrace();
    }



}
  
}
   