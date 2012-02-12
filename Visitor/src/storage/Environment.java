/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author shintaro
 */
public class Environment implements TreeModel, TreeNode{
    
    List<DiskArray> diskArrays;
    

    public List<DiskArray> getDiskArrays() {
        return diskArrays;
    }

    public void setDiskArrays(List<DiskArray> diskArrays) {
        this.diskArrays = diskArrays;
    }

    @Override
    public Object getRoot() {
        return this;
    }

    @Override
    public Object getChild(Object o, int i) {
        if(o instanceof Environment){
            if(this.equals(o)){
                return ((Environment)o).getChildAt(i);
            }else{
                return null;
            }
        }else if (o instanceof DiskArray){
            if(this.diskArrays.contains((DiskArray)o)){
                return ((DiskArray)o).getChildAt(i);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public int getChildCount(Object o) {
        if(o instanceof Environment){
            if(this.equals(o)){
                return ((Environment)o).getChildCount();
            }else{
                return 0;
            }
        }else if (o instanceof DiskArray){
            if(this.diskArrays.contains((DiskArray)o)){
                return ((DiskArray)o).getChildCount();
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    @Override
    public boolean isLeaf(Object o) {
        if(o instanceof Environment){
            return false;
        }else if (o instanceof DiskArray){
            return false;
        }else if (o instanceof Volume){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void valueForPathChanged(TreePath tp, Object o) {
       
    }

    @Override
    public int getIndexOfChild(Object o, Object o1) {
        if(o instanceof Environment){
            if(this.equals(o)){
                return ((Environment)o).diskArrays.indexOf(o);
            }else{
                return 0;
            }
        }else if (o instanceof DiskArray){
            if(this.diskArrays.contains((DiskArray)o)){
                return ((DiskArray)o).volumes.indexOf(o);
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    @Override
    public void addTreeModelListener(TreeModelListener tl) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener tl) {
    }

    @Override
    public TreeNode getChildAt(int i) {
        return diskArrays.get(i);
    }

    @Override
    public int getChildCount() {
        return diskArrays.size();
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode tn) {
        return diskArrays.indexOf(tn);
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration children() {
        return new Enumeration(){
            
            Iterator iterator = Environment.this.diskArrays.iterator();

            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            @Override
            public Object nextElement() {
                return iterator.next();
            }
            
        };
    }
}
