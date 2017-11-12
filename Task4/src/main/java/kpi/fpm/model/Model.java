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

    public List<Note> getNotebook(){
        return notebook;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public long getLastAddTime() {
        return lastAddTime;
    }
}
