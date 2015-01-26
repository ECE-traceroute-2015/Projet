/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import Model.Tree;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author lionelgrondin
 */
public class TP1 {
    
    private static BufferedReader getOutput(Process p) {   
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static BufferedReader getError(Process p) {
        return new BufferedReader(new InputStreamReader(p.getErrorStream()));
    }


    public static void main(String[] args) throws IOException {
        
    
        Process p = null;
        DefaultMutableTreeNode _myRoot = null;
        
        
        
        try {
            String commande = "java -jar ./lib/fakeroute.jar www.ece.fr";
            p = Runtime.getRuntime().exec(commande);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        BufferedReader output = getOutput(p);
        BufferedReader error = getError(p);
        String ligne = "";

        try{
            
            while ((ligne = output.readLine()) != null) {
                System.out.println(ligne);
            }
            
            while ((ligne = error.readLine()) != null) {
                System.out.println(ligne);
            }
        }
         catch (IOException e) {
            e.printStackTrace();
        }

        
        
        
        
        
       
    }
    
}
