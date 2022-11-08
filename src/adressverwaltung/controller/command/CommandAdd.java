/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller.command;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import java.util.Stack;

/**
 *
 * @author huyubuntu
 */
public class CommandAdd implements CommandInterface {
    
    private AdressverwaltungModel model;
    private AdressverwaltungView view;
    private Stack<Integer> undoStack;
    
    /**
     * Constructs Command-DP CommandAdd associated with Model and View
     * @param model Model of Adressverwaltung
     * @param view View of Adressverwaltung
     */
    public CommandAdd(AdressverwaltungModel model, AdressverwaltungView view){
        this.model = model;
        this.view = view;
        this.undoStack = new Stack<>();
    }
    
    /**
     * Adds new row to table
     */
    @Override
    public void execute() {
        this.undoStack.push(this.model.getRowCount());
        this.model.eintragHinzufuegen();
    }

    /**
     * Removes the last added row from table
     */
    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (!this.undoStack.isEmpty()){
            this.model.eintragLoeschen(this.undoStack.pop());
        }
    }

    /**
     * Returns true if command is undoable
     * @return true
     */
    @Override
    public boolean isUndoable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return true;
    }
    
}
