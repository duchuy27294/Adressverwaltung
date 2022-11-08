/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller.command;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;

/**
 *
 * @author duchu
 */
public class CommandClose implements CommandInterface {
    
    private AdressverwaltungModel model;
    private AdressverwaltungView view;
    
    /**
     * Construct Command-DP CommandClose associated with Model and View
     * @param model Model of Adressverwaltung
     * @param view View of Adressverwaltung
     */
    public CommandClose(AdressverwaltungModel model, AdressverwaltungView view){
        this.model = model;
        this.view = view;
    }

    /**
     * Close program
     */
    @Override
    public void execute() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.exit(0);
    }

    /**
     * Does nothing because this command is not undoable
     */
    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Returns true if command is undoable
     * @return false
     */
    @Override
    public boolean isUndoable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return false;
    }
    
}
