/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller.command;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;

/**
 *
 * @author duchu
 */
public class CommandOpen implements CommandInterface {
    
    private AdressverwaltungModel model;
    private AdressverwaltungView view;
    private Preferences preferences;
    private static final String KEY = "Path";
    private static final String DEFAULT_VALUE = "";
    
    /**
     * Constructs Command-DP CommandOpen associated with Model and View 
     * @param model Model of Adressverwaltung
     * @param view View of Adressverwaltung
     */
    public CommandOpen(AdressverwaltungModel model, AdressverwaltungView view){
        this.model = model;
        this.view = view;
        this.preferences = Preferences.userRoot().node(this.getClass().getName()); 
        this.preferences.get(CommandOpen.KEY,CommandOpen.DEFAULT_VALUE);
    }

    /**
     * Reads and loads new data model from chosen file
     */
    @Override
    public void execute() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        JFileChooser fc = this.view.getFcOpen();
        if (!this.preferences.get(CommandOpen.KEY,CommandOpen.DEFAULT_VALUE).equals(CommandOpen.DEFAULT_VALUE)){
            fc.setCurrentDirectory(new File(this.preferences.get(CommandOpen.KEY,CommandOpen.DEFAULT_VALUE )));
        }
        int choice = this.view.getFcOpen().showOpenDialog(this.view);
        if (choice == JFileChooser.APPROVE_OPTION){
            File f = this.view.getFcOpen().getSelectedFile();
            this.view.getTpDatei().setText(f.getAbsolutePath());
            this.preferences.put(CommandOpen.KEY, f.getAbsolutePath());
            try{
                this.model.datenLesen(f);
            }
            catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CommandOpen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.view.pack();
    }

    /**
     * Does nothing because this command is undoable
     */
    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Returns true if command is undoable
     * @return false
     */
    @Override
    public boolean isUndoable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return false;
    }
    
}
