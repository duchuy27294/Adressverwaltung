/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller;

import adressverwaltung.controller.command.CommandAdd;
import adressverwaltung.controller.command.CommandInvoker;
import adressverwaltung.controller.command.CommandRemove;
import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author phamhu75087
 */
public class ControllerCommand implements ActionListener
{
    private AdressverwaltungModel model;
    private AdressverwaltungView view;
    private CommandInvoker invoker;
    
    public ControllerCommand(AdressverwaltungModel model, AdressverwaltungView view){
        this.model = model;
        this.view = view;
        this.invoker = new CommandInvoker();
    }
    
    public void registerEvents(){
        this.view.getBtnAdd().addActionListener(this);
        this.view.getBtnRemove().addActionListener(this);
        this.view.getBtnUndo().addActionListener(this);
    }
    
    public void registerCommands(){
        CommandAdd cmdAdd = new CommandAdd(this.model,this.view);
        CommandRemove cmdRemove = new CommandRemove(this.model, this.view);
        this.invoker.addCommand(this.view.getBtnAdd(), cmdAdd);
        this.invoker.addCommand(this.view.getPmiMiAdd(),cmdAdd);
        this.invoker.addCommand(this.view.getBtnRemove(), cmdRemove);
        this.invoker.addCommand(this.view.getPmiMiRemove(),cmdRemove);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object key = evt.getSource();
        if (key == this.view.getBtnUndo()){
            this.invoker.undoCommand();
        }
        else{
            invoker.executeCommand(key);
        }
    }
}
