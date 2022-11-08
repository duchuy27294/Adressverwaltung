/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adressverwaltung.controller.command;

/**
 *
 * @author huyubuntu
 */
public interface CommandInterface {

    /**
     * Executes command
     */
    public void execute();

    /**
     * Undoes command if possible
     */
    public void undo();

    /**
     * Returns true if command is undoable
     * @return true if command is undoable
     */
    public boolean isUndoable();
    //public void redo();
}
