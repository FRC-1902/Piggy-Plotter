package com.explodingbacon.piggyplotter;

import com.explodingbacon.piggyplotter.field.SelectField;
import com.explodingbacon.piggyplotter.field.CustomField;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main extends javax.swing.JFrame {

    public static double multiplier = 2;
    public static Color robotColor = new Color(30, 30, 30);
    public static JToggleButton selected = null;
    public static Image icon;
    
    public Main() {
        initComponents();
        icon = new ImageIcon(this.getClass().getResource("icon.png")).getImage();
        setIconImage(icon);
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new Board();
        robotButton = new javax.swing.JToggleButton();
        commandButton = new javax.swing.JToggleButton();
        driveButton = new javax.swing.JToggleButton();
        resetButton = new javax.swing.JButton();
        pixelRatioSlider = new javax.swing.JSlider();
        pixelRatioText = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        importField = new javax.swing.JMenuItem();
        selectField = new javax.swing.JMenuItem();
        saveAutoButton = new javax.swing.JMenuItem();
        update = new javax.swing.JMenuItem();
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
            .addGap(0, 645, Short.MAX_VALUE)
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

        pixelRatioSlider.setMaximum(400);
        pixelRatioSlider.setMinimum(100);
        pixelRatioSlider.setValue(200);
        pixelRatioSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pixelRatioSliderStateChanged(evt);
            }
        });

        pixelRatioText.setText("Pixels to inches: 2");

        file.setText("File");

        importField.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        importField.setText("Import Field");
        importField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importFieldActionPerformed(evt);
            }
        });
        file.add(importField);

        selectField.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        selectField.setText("Select Pre-Set Field");
        selectField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFieldActionPerformed(evt);
            }
        });
        file.add(selectField);

        saveAutoButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveAutoButton.setText("Export Autonomous");
        saveAutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAutoButtonActionPerformed(evt);
            }
        });
        file.add(saveAutoButton);

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        file.add(update);

        menu.add(file);

        edit.setText("Edit");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(driveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(robotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(commandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pixelRatioText)
                            .addComponent(pixelRatioSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
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
                        .addComponent(pixelRatioText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pixelRatioSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void importFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFieldActionPerformed
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
    }//GEN-LAST:event_importFieldActionPerformed

    private void undoCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoCommandActionPerformed
        if (Board.robot != null) {
            if (!Board.robot.commandGroups.isEmpty()) {
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
                    Board.robot.angle -= ((DriveCommand) dead).angle;
                    deadOwner.commands.remove(dead);
                }
            } else {
                Board.robot.angle = 0;
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

    private void selectFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFieldActionPerformed
        new SelectField().setVisible(true);
    }//GEN-LAST:event_selectFieldActionPerformed

    private void pixelRatioSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pixelRatioSliderStateChanged
        double value = pixelRatioSlider.getValue() / 100.0;
        pixelRatioText.setText("Pixels to inches: " + value);
        Main.multiplier = value;
    }//GEN-LAST:event_pixelRatioSliderStateChanged

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Updating will completely close Piggy Plotter. Do you want to continue?");
        if (result == 0) {
            try {
                Runtime.getRuntime().exec("java -jar updater.jar");
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
    }//GEN-LAST:event_updateActionPerformed

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
    private javax.swing.JMenuItem importField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JSlider pixelRatioSlider;
    private javax.swing.JLabel pixelRatioText;
    private javax.swing.JButton resetButton;
    public static javax.swing.JToggleButton robotButton;
    private javax.swing.JMenuItem saveAutoButton;
    private javax.swing.JMenuItem selectField;
    private javax.swing.JMenuItem undoCommand;
    private javax.swing.JMenuItem update;
    // End of variables declaration//GEN-END:variables
}
