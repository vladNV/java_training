/*
 *  Model
 *
 *  13.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm.model;

import java.util.LinkedList;
import java.util.List;

/**
 * This class contains notes in notebook.
 */
public class Model {

    /**
     * This is notebook.
     */
    private List<Note> notebook;
    /**
     * Last time update.
     */
    private long lastUpdateTime;
    /**
     * Last time addition.
     */
    private long lastAddTime;

    /**
     * Initialize new notebook, on based {@link java.util.LinkedList}
     */
    public Model() {
        this.notebook = new LinkedList<>();
    }

    /**
     * Adds new note to notebook.
     * @param element is the note {@link Note}.
     */
    public void add(Note element) {
        notebook.add(element);
        lastAddTime = System.currentTimeMillis();
    }

    public boolean contains(Note element){
        return notebook.contains(element);
    }

    public List<Note> getNotebook(){
        return notebook;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public long getLastAddTime() {
        return lastAddTime;
    }

    /**
     * Returns <tt>true</tt> if notebook contains this login. Otherwise,
     * returns <tt>false</tt>.
     * @param login a string whose presence in this is to be tested.
     * @return <tt>true</tt> if this list contains the specified element
     */
    public boolean containsLogin(String login){
        for (Note aNotebook : notebook) {
            if (aNotebook.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
