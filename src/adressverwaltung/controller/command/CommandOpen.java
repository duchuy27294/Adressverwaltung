/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller.command;

import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import java.io.File;
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
    
    public CommandOpen(AdressverwaltungModel model, AdressverwaltungView view){
        this.model = model;
        this.view = view;
        this.preferences = Preferences.userRoot().node(this.getClass().getName()); 
        this.preferences.get(CommandOpen.KEY,CommandOpen.DEFAULT_VALUE);
    }

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
