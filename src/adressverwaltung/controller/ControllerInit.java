/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;

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
      this.view.getTable().setModel(this.model);
      this.view.pack();   
    }
}
