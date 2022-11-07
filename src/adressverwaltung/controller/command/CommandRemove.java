/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller.command;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author huyubuntu
 */
public class CommandRemove implements CommandInterface {
    
    private AdressverwaltungModel model;
    private AdressverwaltungView view;
    private Stack<SimpleEntry<Integer,List<String>>> undoStack;
    
    public CommandRemove(AdressverwaltungModel model, AdressverwaltungView view){
        this.model = model;
        this.view = view;
        this.undoStack = new Stack<>();
    }
    
    @Override
    public void execute() {
        List<String> rowData = new ArrayList<>();
        int selectedRow = this.view.getTable().getSelectedRow();
        
        if (selectedRow != -1){
            for (int i = 0; i < this.model.getColumnCount(); i++){
                rowData.add((String)this.model.getValueAt(selectedRow,i));
            }
            SimpleEntry row = new SimpleEntry<>(selectedRow,rowData);
            this.undoStack.push(row);
            this.model.eintragLoeschen(selectedRow);
        }
    }

    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (!this.undoStack.isEmpty()){
            //DefaultTableModel tableModel = (DefaultTableModel)this.view.getTable().getModel();
            SimpleEntry<Integer,List<String>> row = this.undoStack.pop();
            this.model.eintragHinzufuegen();
            for (int i = this.model.getRowCount()-1; i > row.getKey(); i--){
                for (int j = 0; j < this.model.getColumnCount(); j++){
                    String newVal = (String)this.model.getValueAt(i-1,j);
                    this.model.setValueAt(newVal, i, j);
                }
            }
            for (int i = 0; i < 2; i++){
                this.model.setValueAt(row.getValue().get(i),row.getKey(),i);
            }
        }
    }

    @Override
    public boolean isUndoable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return true;
    }
    
}
