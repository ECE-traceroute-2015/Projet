/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;



/**
 *
 * @author Larbish
 */
public class Tree 
{
    private final Node _root;
    
    
    public Tree(Node root)
    {
        _root = root;
        
    }
    
    
    public List<Node> getChildren(Node parent, int nbChild) throws Exception
    {
        try{
            int i;
            List<Node> children = null; 

            for(i=0; i<nbChild; i++){
                children.add(parent.getChildren().get(i));      
            }
            
            return children;
            
        }catch(Exception e){
            e.printStackTrace();
        } 
   
        return null;
    }
    
}