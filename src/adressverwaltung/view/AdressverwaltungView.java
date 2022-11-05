/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package adressverwaltung.view;

import java.awt.FlowLayout;

/**
 *
 * @author huy
 */
public class AdressverwaltungView extends javax.swing.JFrame {

    /**
     * @return the pmiMiAdd
     */
    public javax.swing.JMenuItem getPmiMiAdd() {
        return pmiMiAdd;
    }

    /**
     * @return the pmiMiRemove
     */
    public javax.swing.JMenuItem getPmiMiRemove() {
        return pmiMiRemove;
    }

    /**
     * @return the btnUndo
     */
    public javax.swing.JButton getBtnUndo() {
        return btnUndo;
    }

    /**
     * @return the fcOeffnen
     */
    public javax.swing.JFileChooser getFcOeffnen()
    {
        return fcOeffnen;
    }

    /**
     * Creates new form AdressverwaltungView
     */
    public AdressverwaltungView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pm = new javax.swing.JPopupMenu();
        pmiMiAdd = new javax.swing.JMenuItem();
        pmiMiRemove = new javax.swing.JMenuItem();
        fcOeffnen = new javax.swing.JFileChooser();
        pnContent = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        btnOeffnen = new javax.swing.JButton();
        btnSpeichern = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        scrpTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        pnStatus = new javax.swing.JPanel();
        lbDatei = new javax.swing.JLabel();
        scrpTpDatei = new javax.swing.JScrollPane();
        tpDatei = new javax.swing.JTextPane();
        pnButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuDatei = new javax.swing.JMenu();
        mniOeffnen = new javax.swing.JMenuItem();
        mniSpeichern = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();

        pmiMiAdd.setText("Zeile hinzufügen");
        pm.add(pmiMiAdd);

        pmiMiRemove.setText("Zeile löschen");
        pm.add(pmiMiRemove);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        pnContent.setLayout(new java.awt.BorderLayout());

        toolBar.setRollover(true);

        btnOeffnen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adressverwaltung/view/icons/Open24.gif"))); // NOI18N
        btnOeffnen.setToolTipText("Öffnen");
        btnOeffnen.setFocusable(false);
        btnOeffnen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOeffnen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnOeffnen);

        btnSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adressverwaltung/view/icons/Save24.gif"))); // NOI18N
        btnSpeichern.setToolTipText("Speichern");
        btnSpeichern.setFocusable(false);
        btnSpeichern.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSpeichern.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnSpeichern);

        btnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adressverwaltung/view/icons/Undo24.gif"))); // NOI18N
        btnUndo.setToolTipText("Rückgangig machen");
        btnUndo.setFocusable(false);
        btnUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnUndo);

        pnContent.add(toolBar, java.awt.BorderLayout.PAGE_START);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setComponentPopupMenu(pm);
        scrpTable.setViewportView(table);

        pnContent.add(scrpTable, java.awt.BorderLayout.CENTER);

        lbDatei.setText("Datei");
        pnStatus.add(lbDatei);

        scrpTpDatei.setViewportView(tpDatei);

        pnStatus.add(scrpTpDatei);

        pnContent.add(pnStatus, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnContent);

        btnAdd.setMnemonic('H');
        btnAdd.setText("Hinzufügen");
        pnButtons.add(btnAdd);

        btnRemove.setMnemonic('L');
        btnRemove.setText("Löschen");
        pnButtons.add(btnRemove);

        getContentPane().add(pnButtons);

        menuBar.setToolTipText("");

        menuDatei.setMnemonic('D');
        menuDatei.setText("Datei");

        mniOeffnen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniOeffnen.setMnemonic('\u00d6');
        mniOeffnen.setText("Öffnen");
        menuDatei.add(mniOeffnen);

        mniSpeichern.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniSpeichern.setMnemonic('S');
        mniSpeichern.setText("Speichern");
        menuDatei.add(mniSpeichern);

        menuBar.add(menuDatei);

        menuEdit.setMnemonic('E');
        menuEdit.setText("Edit");
        menuBar.add(menuEdit);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdressverwaltungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdressverwaltungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdressverwaltungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdressverwaltungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdressverwaltungView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnOeffnen;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JButton btnUndo;
    private javax.swing.JFileChooser fcOeffnen;
    private javax.swing.JLabel lbDatei;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuDatei;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenuItem mniOeffnen;
    private javax.swing.JMenuItem mniSpeichern;
    private javax.swing.JPopupMenu pm;
    private javax.swing.JMenuItem pmiMiAdd;
    private javax.swing.JMenuItem pmiMiRemove;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JPanel pnContent;
    private javax.swing.JPanel pnStatus;
    private javax.swing.JScrollPane scrpTable;
    private javax.swing.JScrollPane scrpTpDatei;
    private javax.swing.JTable table;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextPane tpDatei;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnOeffnen
     */
    public javax.swing.JButton getBtnOeffnen() {
        return btnOeffnen;
    }

    /**
     * @return the btnSpeichern
     */
    public javax.swing.JButton getBtnSpeichern() {
        return btnSpeichern;
    }

    /**
     * @return the mniOeffnen
     */
    public javax.swing.JMenuItem getMniOeffnen() {
        return mniOeffnen;
    }

    /**
     * @return the mniSpeichern
     */
    public javax.swing.JMenuItem getMniSpeichern() {
        return mniSpeichern;
    }

    /**
     * @return the table
     */
    public javax.swing.JTable getTable() {
        return table;
    }

    /**
     * @return the tpDatei
     */
    public javax.swing.JTextPane getTpDatei()
    {
        return tpDatei;
    }

    /**
     * @param table the table to set
     */
    public void setTable(javax.swing.JTable table)
    {
        this.table = table;
    }

    /**
     * @return the btnAdd
     */
    public javax.swing.JButton getBtnAdd()
    {
        return btnAdd;
    }

    /**
     * @return the btnRemove
     */
    public javax.swing.JButton getBtnRemove()
    {
        return btnRemove;
    }
}
