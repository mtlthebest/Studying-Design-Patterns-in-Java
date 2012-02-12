/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.Enumeration;
import javax.swing.tree.TreeNode;

/**
 *
 * @author shintaro
 */
public class Volume implements TreeNode, Element{
    
    String name;
    long capacity;
    double usedrate;
    DiskArray diskArray;

    public long getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public double getUsedrate() {
        return usedrate;
    }
    
    public DiskArray getDiskArray(){
        return diskArray;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsedrate(double usedrate) {
        this.usedrate = usedrate;
    }
    
    public void setDiskArray(DiskArray diskArray){
        this.diskArray = diskArray;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Volume other = (Volume) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (Double.doubleToLongBits(this.usedrate) != Double.doubleToLongBits(other.usedrate)) {
            return false;
        }
        if (this.diskArray != other.diskArray && (this.diskArray == null || !this.diskArray.equals(other.diskArray))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 43 * hash + (int) (this.capacity ^ (this.capacity >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.usedrate) ^ (Double.doubleToLongBits(this.usedrate) >>> 32));
        return hash;
    }

    @Override
    public TreeNode getChildAt(int i) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return diskArray;
    }

    @Override
    public int getIndex(TreeNode tn) {
        return -1;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public Enumeration children() {
        return null;
    }
    
    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    

}
