/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adressverwaltung.controller.command;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author duchu
 */
public class CommandInvoker {
    private HashMap<Object, CommandInterface> commands;
    private Stack<CommandInterface> undoStack;
    
    /**
     * Constructs CommandInvoker
     */
    public CommandInvoker(){
        this.commands = new HashMap<>();
        this.undoStack = new Stack<>();
    }
    
    /**
     * Adds new Command-DP with a new associated key
     * @param key Object to be called to access command
     * @param value Command
     */
    public void addCommand(Object key, CommandInterface value){
        this.commands.put(key,value);
    }
    
    /**
     * Clear undo stack
     */
    public void clearUndoStack(){
        this.undoStack.clear();
    }
    
    /**
     * Executes command with associated key in parameter
     * @param key Key of command to be called
     */
    public void executeCommand(Object key){
        CommandInterface command = commands.get(key);
        command.execute();
        if (command.isUndoable()){
          undoStack.push(command);
        }
    }
  
    /**
     * Undoes the last command in undoStack
     */
    public void undoCommand(){
        if (!undoStack.isEmpty()){
            undoStack.pop().undo();
        }
    }
}
