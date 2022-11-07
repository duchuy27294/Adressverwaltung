/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller.command;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Stack;
import javax.swing.table.AbstractTableModel;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;

/**
 *
 * @author huyubuntu
 */
public class CommandAdd implements CommandInterface {
    
    private AdressverwaltungModel model;
    private AdressverwaltungView view;
    private Stack<Integer> undoStack;
    
    public CommandAdd(AdressverwaltungModel model, AdressverwaltungView view){
        this.model = model;
        this.view = view;
        this.undoStack = new Stack<>();
    }
    
    @Override
    public void execute() {
        this.undoStack.push(this.model.getRowCount());
        this.model.eintragHinzufuegen();
    }

    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (!this.undoStack.isEmpty()){
            this.model.eintragLoeschen(this.undoStack.pop());
        }
    }

    @Override
    public boolean isUndoable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return true;
    }
    
}
