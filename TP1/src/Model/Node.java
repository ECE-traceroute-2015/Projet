/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Larbish
 */
public class Node {
    
    private final String _address;
    private List<Node> _children = new ArrayList<>();
    
    public Node(String address, List<Node> children)
    {
        this._children = children;
        this._address = address;     
    }
    
    public Node(String address)
    {
        this._address=address;
    }
    
    public String getAddress()
    {
        return this._address;
    }
    
    public List<Node> getChildren()
    {
        return this._children;
    }
    
    
    
    public void setChildren(List<Node> children)
    {
        for(Node child : children)
        //for(int i=0; i<children.size(); i++)
        {
            _children.add(child);
        }
    }
       
    
    public int countChild(Node parent)
    {
        return parent.getChildren().size();
    }
    

    public void displayNode()
    {
        System.out.println(_address);
        
    }

}