/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.tree.TreeNode;

/**
 *
 * @author shintaro
 */
public class DiskArray implements TreeNode, Element{
    String name;
    String ipAddress;
    List<Volume> volumes;
    Environment environment;

    public String getIpAddress() {
        return ipAddress;
    }

    public String getName() {
        return name;
    }

    public List<Volume> getVolumes() {
        return volumes;
    }
    
    public Environment getEnvironment(){
        return environment;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }
    
    public void setEnvironment(Environment environment){
        this.environment = environment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DiskArray other = (DiskArray) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.ipAddress == null) ? (other.ipAddress != null) : !this.ipAddress.equals(other.ipAddress)) {
            return false;
        }
        if (this.volumes != other.volumes && (this.volumes == null || !this.volumes.equals(other.volumes))) {
            return false;
        }
        if (this.environment != other.environment && (this.environment == null || !this.environment.equals(other.environment))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 17 * hash + (this.ipAddress != null ? this.ipAddress.hashCode() : 0);
        hash = 17 * hash + (this.volumes != null ? this.volumes.hashCode() : 0);
        return hash;
    }

    @Override
    public TreeNode getChildAt(int i) {
        return this.volumes.get(i);
    }

    @Override
    public int getChildCount() {
        return this.volumes.size();
    }

    @Override
    public TreeNode getParent() {
        return this.environment;
    }

    @Override
    public int getIndex(TreeNode tn) {
        return this.volumes.indexOf(tn);
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
            
            Iterator iterator = DiskArray.this.volumes.iterator();

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

    @Override
    public String toString(){
        return this.name;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}