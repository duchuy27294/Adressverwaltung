/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huyubuntu
 */
public class ControllerInit {
    private AdressverwaltungModel model;
    private AdressverwaltungView view;
    
    public ControllerInit(AdressverwaltungModel model, AdressverwaltungView view){
        this.model = model;
        this.view = view;
    }
    
    public void init(){
      int spaltenAnzahl = this.model.getColumnCount();
      int zeilenAnzahl = this.model.getRowCount();
      
      List<String> columnNames = new ArrayList<>();
      for (int i = 0; i < spaltenAnzahl; i++){
          columnNames.add(this.model.getColumnName(i));
      }
      DefaultTableModel tableModel = new DefaultTableModel(columnNames.toArray(),0);
      for (int i = 0; i < zeilenAnzahl; i++){
          List<String> rowData = new ArrayList<>();
          for (int j = 0; j < spaltenAnzahl; j++){
              rowData.add((String)this.model.getValueAt(i,j));
          }
          tableModel.addRow(rowData.toArray());
      }
      
      this.view.getTable().setModel(tableModel);
      this.view.pack();   
    }
}
