/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Node;
import Model.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Random;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author lionelgrondin
 */
public class GraphController 
{
    private static BufferedReader getOutput(Process p) {   

        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static BufferedReader getError(Process p) {
        return new BufferedReader(new InputStreamReader(p.getErrorStream()));
    }
    public static boolean traceGraph(String adresse)
    {
        System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

    //InetAddress localIP =  InetAddress.getLocalHost();
    Node _myRoot = new Node("123");
    
    Tree _myTree = new Tree(_myRoot);
    
    
    Process p = null;

    try {
        String commande = "java -jar ./lib/fakeroute.jar 3.3.3.3";
        p = Runtime.getRuntime().exec(commande);

    } catch (IOException e) {
        e.printStackTrace();
    }


    BufferedReader output = getOutput(p);
    BufferedReader error = getError(p);
    String ligne = "";
    List<String> _listeIPs = new ArrayList<>();
    String destination = "";

    try{
        while ((ligne = output.readLine()) != null) {
            //System.out.println("**********************");
            //System.out.println(ligne);
            //System.out.println("**********************");
                    
                    InetAddress destinationIP =InetAddress.getByName(adresse);
                    destination = destinationIP.getHostAddress();
                    
            _listeIPs = _myTree.getIPs(ligne,destination);
            boolean _myBool = _myTree.addChildren(_listeIPs);
            if(_myBool)
            {
                System.out.println("Children add\n");
            }
            else 
            {
                System.out.println("Children not add");
            }
            _listeIPs.clear();
            
            
            
        }
        _listeIPs.add(adresse);
        _myTree.addChildren(_listeIPs);

        while ((ligne = error.readLine()) != null) {
            System.out.println(ligne);

        }
        
        _myTree.displayTree();


        
         System.out.println("\n");
        
        System.out.println( _myTree.getMyNodes().get(2).getAddress());
        
        for(int i=0; i<_myTree.getMyNodes().get(2).getChildren().size() ; i++)
        {
            System.out.println("mes noeuds:");
            _myTree.getMyNodes().get(2).getChildren().get(i).displayNode();
        }
        
        

   
         boolean ex;
         ex = View.Graph.newGraph(_myTree);

    }
     catch (IOException e) {
        e.printStackTrace();
    }





        return true; 
    }
    
    public static boolean traceGraphAuto()
    {
        String adresseIP;
        Random rand = new Random();
        adresseIP = Integer.toString(rand.nextInt(256))+"."+Integer.toString(rand.nextInt(256))+"."+Integer.toString(rand.nextInt(256))+"."+Integer.toString(rand.nextInt(256));
        traceGraph(adresseIP);
        return true;
    }
    
    
}