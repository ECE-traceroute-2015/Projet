/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author lionelgrondin
 */
	
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import Model.Tree;
import Model.Node;
import java.util.ArrayList;
import java.util.List;
import org.graphstream.ui.swingViewer.Viewer;

public class Graph 
{
    public static boolean newGraph(Tree _mytree)
        {
            

            SingleGraph graph = new SingleGraph("Tutorial 1");
            List<Node> _myNodes = _mytree.getMyNodes();
            /*graph.addNode("A" );
            graph.addNode("B" );
            graph.addNode("C" );*/
            for(int i=0; i<_myNodes.size(); i++)
            {
                if (i>1)
                {
                System.out.println("ok");
                org.graphstream.graph.Node n = graph.addNode(_myNodes.get(i).getAddress());
                n.addAttribute("ui.label", _myNodes.get(i).getAddress());
                //n.addAttribute("xy", 2,i);
               
               
                }
                
            }
            for(int i=0; i<_myNodes.size(); i++)
            {
                if (i>1)
                {
                for(int j=0; j<_myNodes.get(i).getChildren().size();j++)
                {
                    String test = Integer.toString(i)+":"+Integer.toString(j);
                    org.graphstream.graph.Edge e=graph.addEdge(test,_myNodes.get(i).getAddress(),_myNodes.get(i).getChildren().get(j).getAddress());
                    e.addAttribute("ui.label",test );
                }
                }
            }
            graph.addAttribute("ui.stylesheet", "url('file:stylesheet')");
            Viewer viewer = graph.display();
            //viewer.disableAutoLayout();
            
            return true;
        }
    
}