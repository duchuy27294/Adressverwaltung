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
import javax.swing.table.DefaultTableModel;

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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        DefaultTableModel tableModel = (DefaultTableModel)this.view.getTable().getModel();
        List<String> rowData = new ArrayList<>();
        int selectedRow = this.view.getTable().getSelectedRow();

        for (int i = 0; i < tableModel.getColumnCount(); i++){
            rowData.add((String)tableModel.getValueAt(selectedRow,i));
        }
        SimpleEntry row = new SimpleEntry<>(selectedRow,rowData);
        this.undoStack.push(row);
        tableModel.removeRow(selectedRow);
        this.view.getTable().setModel(tableModel);
    }

    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (!this.undoStack.isEmpty()){
            DefaultTableModel tableModel = (DefaultTableModel)this.view.getTable().getModel();
            SimpleEntry<Integer,List<String>> row = this.undoStack.pop();
            tableModel.insertRow((int)row.getKey(),row.getValue().toArray());
            this.view.getTable().setModel(tableModel);
        }
    }

    @Override
    public boolean isUndoable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return true;
    }
    
}
