/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Model.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.tree.DefaultMutableTreeNode;





/**
 *
 * @author Larbish
 */
public class Tree 
{
    private final Node _root;
    private List<Node> _myNodes = new ArrayList<>();
    
    
    
    public Tree(Node root)
    {
        _root = root;
        _myNodes.add(root);    
    }
    
    public List<Node> getMyNodes()
    {
        return _myNodes;
    }
    
    
    public List<Node> getChildren(Node parent, int nbChild) throws Exception
    {
        try{
            int i;
            List<Node> children = new ArrayList<>(); 

            for(i=0; i<nbChild; i++){
                children.add(parent.getChildren().get(i));      
            }
            
            return children;
            
        }catch(Exception e){
            e.printStackTrace();
        } 
   
        return null;
    }
    
    public boolean addChildren(String IP)
    {
        for(int i=0; i<_myNodes.size(); i++)
            {
                if(_myNodes.get(i).getChildren().isEmpty())
                {
                
                }
            }
        
        return true;
    }
    public boolean addChildren(List<String> IPs) 
    {
       
     try{
            List<Node> _myNewChildren = new ArrayList<Node>();
            List<Node> _myEmptyChildren = new ArrayList<Node>();
            
            int size = _myNodes.size();

            for(int i=0; i<size; i++)
            {
                
                if(_myNodes.get(i).getChildren().isEmpty())
                {
                    for(int j=0; j<IPs.size(); j++)
                    {
                        _myNewChildren.add(new Node(IPs.get(j), _myEmptyChildren));//ajout d'un noeud dans la liste des fils
                        _myNodes.add(new Node(IPs.get(j), _myEmptyChildren));
                    }

                   _myNodes.get(i).setChildren(_myNewChildren);
                   _myNewChildren.clear();
                    
                }     
                
            } 
     }catch(Exception e){
         e.printStackTrace();
         return false;
      }
     
     return true;
     
    }
    
    public void displayTree()
    {
        
        
        for(int i=0; i< this._myNodes.size(); i++)
        {
           System.out.println(i + ":");
           this._myNodes.get(i).displayNode();
        }
    }
    

    public List<String> getIPs(String ligne,String destination)
    {
        List<String> liste = new ArrayList<>();
        
        Pattern p = Pattern.compile("([0-9]{1,3}\\.){3}[0-9]{1,3}");
        Matcher m = p.matcher(ligne);
        while (m.find()) 
        {
            //if(!(m.group().equals(destination)))
            //{
            System.out.println("a" + m.group() + "a") ;
            liste.add(m.group());
            //}
        }
        

        System.out.println("\n");

        System.out.println("\n");

         
       

    return liste;
    }

    
    
}