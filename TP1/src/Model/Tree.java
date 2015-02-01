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
    
    public boolean addChildren(List<String> IPs) 
    {
     try{
            List<Node> _myNewChildren = new ArrayList<Node>();
            List<Node> _myEmptyChildren = new ArrayList<Node>();

            for(int i=0; i<_myNodes.size(); i++)
            {
                if(_myNodes.get(i).getChildren().isEmpty())
                {
                    for(int j=0; j<IPs.size(); j++)
                    {
                        _myNewChildren.add(new Node(IPs.get(j), _myEmptyChildren));
                        _myNodes.add(new Node(IPs.get(j), _myEmptyChildren));
                    }

                   _myNodes.get(i).setChildren(_myNewChildren);
                    
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
    
    public List<String> getIPs(String ligne)
    {
        List<String> liste = new ArrayList<>();
        
        Pattern p = Pattern.compile("([0-9]{1,3}\\.){3}[0-9]{1,3}");
        Matcher m = p.matcher(ligne);
        while (m.find()) 
        {
            System.out.println(m.group()) ;
            liste.add(m.group());
        }
        //System.out.println("\n");
         
       

    return liste;
    }
    
}