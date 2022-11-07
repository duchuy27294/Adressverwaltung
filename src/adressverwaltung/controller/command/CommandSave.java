/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller.command;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;

/**
 *
 * @author duchu
 */
public class CommandSave implements CommandInterface {
    
    private AdressverwaltungModel model;
    private AdressverwaltungView view;
    private Preferences preferences;
    private static final String KEY = "Path";
    private static final String DEFAULT_VALUE = "";

    public CommandSave(AdressverwaltungModel model, AdressverwaltungView view){
        this.model = model;
        this.view = view;
        this.preferences = Preferences.userRoot().node(this.getClass().getName()); 
        this.preferences.get(CommandSave.KEY, CommandSave.DEFAULT_VALUE);
    }
    
    @Override
    public void execute() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        JFileChooser fc = this.view.getFcSave();
        if (!this.preferences.get(CommandSave.KEY,CommandSave.DEFAULT_VALUE).equals(CommandSave.DEFAULT_VALUE)){
            fc.setCurrentDirectory(new File(this.preferences.get(CommandSave.KEY,CommandSave.DEFAULT_VALUE )));
        }
        int choice = this.view.getFcSave().showSaveDialog(this.view);
        if (choice == JFileChooser.APPROVE_OPTION){
            File f = this.view.getFcSave().getSelectedFile();
            this.view.getTpDatei().setText(f.getAbsolutePath());
            this.preferences.put(CommandSave.KEY, f.getAbsolutePath());
            try{
                this.model.datenSpeichern(f);
            }
            catch (IOException ex) {
                Logger.getLogger(CommandSave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.view.pack();
    }

    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isUndoable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return false;
    }
    
}
