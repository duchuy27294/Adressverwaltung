/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package adressverwaltung;

import adressverwaltung.controller.ControllerCommand;
import adressverwaltung.controller.ControllerMain;
import adressverwaltung.controller.ControllerOeffnen;
import adressverwaltung.model.AdressverwaltungModel;
import adressverwaltung.view.AdressverwaltungView;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author huy
 */
public class Start 
{
  public Start()
  {
      AdressverwaltungView view = new AdressverwaltungView();
      AdressverwaltungModel model = new AdressverwaltungModel();
      ControllerMain ctlrMain = new ControllerMain(model,view);
      ControllerOeffnen ctlrOeffnen = new ControllerOeffnen(model,view);
      ControllerCommand ctlrCommand = new ControllerCommand(model,view);
      ctlrOeffnen.registerEvents();
      ctlrCommand.registerEvents();
      ctlrCommand.registerCommands();
      view.setVisible(true);
  }

  public static void main(String[] args) 
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception ex)
    {
      JOptionPane.showMessageDialog(null, ex.toString());
    }
    new Start();
  }

}
