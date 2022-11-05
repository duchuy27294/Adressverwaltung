/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package adressverwaltung.controller;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTable;

/**
 *
 * @author huy
 */
public class ControllerOeffnen 
{
  private AdressverwaltungModel model;
  private AdressverwaltungView view;
  
  public ControllerOeffnen(AdressverwaltungModel model, AdressverwaltungView view)
  {
    this.model = model;
    this.view = view;
  }
  
  public void registerEvents(){
      this.view.getBtnOeffnen().addActionListener(this::oeffnen);
      this.view.getMniOeffnen().addActionListener(this::oeffnen);
  }
  
  private void oeffnen(ActionEvent evt){
      int wahl = this.view.getFcOeffnen().showOpenDialog(this.view);
      if (wahl == JFileChooser.APPROVE_OPTION){
          File f = this.view.getFcOeffnen().getSelectedFile();
          this.view.getTpDatei().setText(f.getAbsolutePath());
      }
      this.view.pack();
  }
}
