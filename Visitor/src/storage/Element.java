/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author shintaro
 */
public interface Element {
    public void accept(Visitor visitor);
}
