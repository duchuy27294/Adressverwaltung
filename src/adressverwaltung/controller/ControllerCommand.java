/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller;

import adressverwaltung.controller.command.CommandAdd;
import adressverwaltung.controller.command.CommandInvoker;
import adressverwaltung.controller.command.CommandOpen;
import adressverwaltung.controller.command.CommandRemove;
import adressverwaltung.controller.command.CommandSave;
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
        this.view.getBtnUndo().addActionListener(this::undo);
        this.view.getBtnOpen().addActionListener(this);
        this.view.getMniOpen().addActionListener(this);
        this.view.getMniSave().addActionListener(this);
        this.view.getBtnSave().addActionListener(this);
    }
    
    public void registerCommands(){
        CommandAdd cmdAdd = new CommandAdd(this.model,this.view);
        CommandRemove cmdRemove = new CommandRemove(this.model, this.view);
        CommandOpen cmdOpen = new CommandOpen(this.model, this.view);
        CommandSave cmdSave = new CommandSave(this.model,this.view);
        
        this.invoker.addCommand(this.view.getBtnAdd(), cmdAdd);
        this.invoker.addCommand(this.view.getPmiMiAdd(),cmdAdd);
        this.invoker.addCommand(this.view.getBtnRemove(), cmdRemove);
        this.invoker.addCommand(this.view.getPmiMiRemove(),cmdRemove);
        this.invoker.addCommand(this.view.getMniOpen(),cmdOpen);
        this.invoker.addCommand(this.view.getBtnOpen(), cmdOpen);
        this.invoker.addCommand(this.view.getBtnSave(), cmdSave);
        this.invoker.addCommand(this.view.getMniSave(), cmdSave);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object key = evt.getSource();
        invoker.executeCommand(key);
    }
    
    public void undo(ActionEvent evt){
        this.invoker.undoCommand();
    }
}
