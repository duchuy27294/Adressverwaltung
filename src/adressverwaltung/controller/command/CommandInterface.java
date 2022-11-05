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
    public void execute();
    public void undo();
    public boolean isUndoable();
    //public void redo();
}
