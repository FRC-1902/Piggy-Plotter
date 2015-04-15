package com.explodingbacon.piggyplotter;

import com.explodingbacon.piggyplotter.fields.CustomField;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main extends javax.swing.JFrame {

    public static double multiplier = 2;
    public static JToggleButton selected = null;
    
    public Main() {
        initComponents();
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new Board();
        robotButton = new javax.swing.JToggleButton();
        commandButton = new javax.swing.JToggleButton();
        driveButton = new javax.swing.JToggleButton();
        resetButton = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        openFieldButton = new javax.swing.JMenuItem();
        saveAutoButton = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        undoCommand = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Piggy Plotter");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        robotButton.setText("Add Robot");
        robotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robotButtonActionPerformed(evt);
            }
        });

        commandButton.setText("Command");
        commandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandButtonActionPerformed(evt);
            }
        });

        driveButton.setText("Drive To");
        driveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driveButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset Auto");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        file.setText("File");

        openFieldButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFieldButton.setText("Open Field");
        openFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFieldButtonActionPerformed(evt);
            }
        });
        file.add(openFieldButton);

        saveAutoButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveAutoButton.setText("Export Autonomous");
        saveAutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAutoButtonActionPerformed(evt);
            }
        });
        file.add(saveAutoButton);

        menu.add(file);

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        undoCommand.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undoCommand.setText("Undo Drive");
        undoCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoCommandActionPerformed(evt);
            }
        });
        edit.add(undoCommand);

        menu.add(edit);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(driveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(robotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(robotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(driveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void driveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driveButtonActionPerformed
        if (driveButton.isSelected()) {
            updateButtons(driveButton);
        } else {
            updateButtons(null);
        }
    }//GEN-LAST:event_driveButtonActionPerformed

    private void robotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robotButtonActionPerformed
        if (robotButton.isSelected()) {
            updateButtons(robotButton);
        } else {
            updateButtons(null);
        }
    }//GEN-LAST:event_robotButtonActionPerformed

    private void commandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandButtonActionPerformed
        if (commandButton.isSelected()) {
            updateButtons(commandButton);
        } else {
            updateButtons(null);
        }
    }//GEN-LAST:event_commandButtonActionPerformed

    private void openFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFieldButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("FRC Field Files", "field");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File field = chooser.getSelectedFile();
            if (field.exists()) {
                Board.field = new CustomField(field);
            }
        }
    }//GEN-LAST:event_openFieldButtonActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        if (Board.robot != null && !Board.robot.commandGroups.isEmpty()) {
            //TODO something
        }
    }//GEN-LAST:event_editActionPerformed

    private void undoCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoCommandActionPerformed
        if (Board.robot != null && !Board.robot.commandGroups.isEmpty()) {
            CommandGroup deadOwner = null;
            Command dead = null;
            for (CommandGroup cg : Board.robot.commandGroups) {
                for (Command c : cg.commands) {
                    if (c instanceof DriveCommand) {
                        deadOwner = cg;
                        dead = c;
                    }
                }
            }
            if (dead != null) {
                Board.robot.angle -= ((DriveCommand)dead).angle;
                deadOwner.commands.remove(dead);
                Board.field.parts.remove(dead);
            }
        }
    }//GEN-LAST:event_undoCommandActionPerformed

    private void saveAutoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAutoButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        chooser.setApproveButtonText("Save");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Autonomous Files (.auto)", "auto");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File saveFile = chooser.getSelectedFile();    
            if (!saveFile.getName().contains(".auto")) {
                saveFile = new File(saveFile.getAbsoluteFile() + ".auto");
            }
            if (saveFile.exists()) {
                saveFile.delete();
            }
            try {
                 saveFile.createNewFile();
                 BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));
                 String data = "";
                for (CommandGroup cg : Board.robot.commandGroups) {
                    for (Command c : cg.commands) {
                        for (String[] array : c.data) {
                            String command = "";
                            for (String s : array) {
                                command = command + s + (s.equals(array[array.length - 1]) ? "]" : ":");
                            }
                            data = data + command;
                        }
                    }
                }
                bw.write(data);
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveAutoButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        Board.field.parts.remove(Board.robot);
        Board.robot = null;
    }//GEN-LAST:event_resetButtonActionPerformed

    public void updateButtons(JToggleButton button) {
        if (button == driveButton) {
            selected = driveButton;
            robotButton.setSelected(false);
            commandButton.setSelected(false);
        } else if (button == robotButton) {
            selected = robotButton;
            driveButton.setSelected(false);
            commandButton.setSelected(false);
        } else if (button == commandButton) {
            selected = commandButton;
            driveButton.setSelected(false);
            robotButton.setSelected(false);
        } else {
            selected = null;
            driveButton.setSelected(false);
            robotButton.setSelected(false);
            commandButton.setSelected(false);
        }
    }
    
    public static double sign(double d) {
        double sign = (Math.abs(d) / d);
        if (sign >= 0) {
            sign = 1;
        } else {
            sign = -1;
        }
        return sign;
    }
    
    public static int scaleUp(double d) {
        return (int) (Math.round(d * Main.multiplier));
    }
    
    public static int scaleDown(double d) {
        return (int) (Math.round(d / Main.multiplier));
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JToggleButton commandButton;
    public static javax.swing.JToggleButton driveButton;
    private javax.swing.JMenu edit;
    private javax.swing.JMenu file;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem openFieldButton;
    private javax.swing.JButton resetButton;
    public static javax.swing.JToggleButton robotButton;
    private javax.swing.JMenuItem saveAutoButton;
    private javax.swing.JMenuItem undoCommand;
    // End of variables declaration//GEN-END:variables
}
