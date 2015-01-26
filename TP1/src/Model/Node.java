/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.List;

/**
 *
 * @author Larbish
 */
public class Node {
    
    private final String _address;
    private final List<Node> _children;
    private final List<Node> _parents;
   
    public Node(String Address, List<Node> children, List<Node> parents)
    {
        _address = Address;
        _children = children; 
        _parents = parents;
    }
    
    public List<Node> getChildren()
    {
        return _children;
    }
    
    public List<Node> getParent()
    {
        return _parents;
    }
    
    public void setChildren(List<Node> children)
    {
        for(Node child : children)
        {
            _children.add(child);
        }
    }
       
    
    public int countChild(Node parent)
    {
        return parent.getChildren().size();
    }
}