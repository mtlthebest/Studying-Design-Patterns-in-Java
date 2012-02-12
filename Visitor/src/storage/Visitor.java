/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author shintaro
 */
public interface Visitor {
    public void visit(Volume volume);
    public void visit(DiskArray diskArray);
}
