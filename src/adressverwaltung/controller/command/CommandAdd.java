/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller.command;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.table.DefaultTableModel;

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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        DefaultTableModel tableModel = (DefaultTableModel)this.view.getTable().getModel();
        List<String> rowData = new ArrayList<>();
        for (int i = 0; i < this.model.getColumnCount(); i++){
            rowData.add("");
        }
        this.undoStack.push(this.view.getTable().getModel().getRowCount());
        tableModel.addRow(rowData.toArray());
        this.view.getTable().setModel(tableModel);
    }

    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (!this.undoStack.isEmpty()){
            DefaultTableModel tableModel = (DefaultTableModel)this.view.getTable().getModel();
            tableModel.setRowCount(this.undoStack.pop());
            this.view.getTable().setModel(tableModel);
        }
    }

    @Override
    public boolean isUndoable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return true;
    }
    
}
