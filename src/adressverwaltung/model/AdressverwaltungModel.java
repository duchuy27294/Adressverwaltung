/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressverwaltung.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author le
 */
public class AdressverwaltungModel extends AbstractTableModel
{
  private ArrayList<ArrayList<String>> daten;
  private ArrayList<String> adressEintraegeDaten;
  private ArrayList<String> adressEintraegeNamen;
  
    /**
     * Constructs a AdressverwaltungModel which already contains 2 columns (Name and Telefon) and 1 Row ("Lehner","122345")
     */
  public AdressverwaltungModel()
  {
    adressEintraegeDaten = new ArrayList<>();
    adressEintraegeNamen = new ArrayList<>();
    daten = new ArrayList<>();
    adressEintraegeNamen.add("Name");
    adressEintraegeDaten.add("Lehner");
    adressEintraegeNamen.add("Telefon");
    adressEintraegeDaten.add("122345");
    daten.add(adressEintraegeDaten);
  }

    /**
     * Returns the number of rows
     * @return number of rows
     */
    @Override
  public int getRowCount()
  {
    return daten.size();
  }

    /**
     * Returns the number of columns
     * @return number of columns
     */
    @Override
  public int getColumnCount()
  {
    return adressEintraegeDaten.size();
  }

    /**
     * Returns the object at [row][col]
     * @param row Row
     * @param col Column
     * @return object at [row][col]
     */
    @Override
  public Object getValueAt(int row, int col)
  {
    return daten.get(row).get(col);
  }

    /**
     * Sets a new value to object at [row][col]
     * @param value New value
     * @param row Row
     * @param col Column
     */
    @Override
  public void setValueAt(Object value, int row, int col)
  {
    daten.get(row).set(col, (String)value);
  }
  
    /**
     * Return true if the cell at [row][col] is editable
     * @param row Row
     * @param col Column
     * @return true if the cell at [row][col] is editable
     */
    @Override
  public boolean isCellEditable(int row, int col)
  {
    return true;
  }
  
    /**
     * Returns column name
     * @param col Column
     * @return column name
     */
    @Override
  public String getColumnName(int col)
  {
    return adressEintraegeNamen.get(col);
  }
  
    /**
     * Adds a new line to model
     */
    public void eintragHinzufuegen()
  {
    adressEintraegeDaten = new ArrayList<>();
    adressEintraegeNamen.forEach(s -> adressEintraegeDaten.add(s));
    daten.add(adressEintraegeDaten);
    this.fireTableDataChanged();
  }
  
    /**
     * Removes line
     * @param row Row
     */
    public void eintragLoeschen(int row)
  {
    daten.remove(row);
    this.fireTableDataChanged();
  }
  
    /**
     * Adds a new column
     * @param name Name of new column
     */
    public void spalteHinzufuegen(String name)
  {
    adressEintraegeNamen.add(name);
  }
  
    /**
     * Saves model in a file
     * @param datei File to be saved
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void datenSpeichern(File datei) throws FileNotFoundException, IOException
  {
    FileOutputStream fos = new FileOutputStream(datei);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(daten);
    oos.writeObject(adressEintraegeNamen);
    oos.flush();
    oos.close();
  }
  
    /**
     * Loads new model from file
     * @param datei File to be opened 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void datenLesen(File datei) throws FileNotFoundException, IOException, ClassNotFoundException
  {
    FileInputStream fis = new FileInputStream(datei);
    BufferedInputStream bis = new BufferedInputStream(fis);
    ObjectInputStream ois = new ObjectInputStream(bis);
    daten = (ArrayList<ArrayList<String>>)ois.readObject();
    adressEintraegeNamen = (ArrayList<String>)ois.readObject();
    adressEintraegeDaten = daten.get(daten.size()-1);
    ois.close();
    this.fireTableDataChanged();
  }
  
}