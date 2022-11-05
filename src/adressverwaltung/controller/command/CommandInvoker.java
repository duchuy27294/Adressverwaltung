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
    
    public CommandInvoker(){
        this.commands = new HashMap<>();
        this.undoStack = new Stack<>();
    }
    
    public void addCommand(Object key, CommandInterface value){
        this.commands.put(key,value);
    }
    
    public void clearUndoStack(){
        this.undoStack.clear();
    }
    
    public void executeCommand(Object key){
        CommandInterface command = commands.get(key);
        command.execute();
        if (command.isUndoable()){
          undoStack.push(command);
        }
    }
  
    public void undoCommand(){
        if (!undoStack.isEmpty()){
            undoStack.pop().undo();
        }
    }
}
