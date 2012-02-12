/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.HashSet;

/**
 *
 * @author shintaro
 */
public interface Subject {
    public void nortifyObserver();    
    public void addObserver(Observer observer);
    public void deleteObserver(Observer observer);
}
