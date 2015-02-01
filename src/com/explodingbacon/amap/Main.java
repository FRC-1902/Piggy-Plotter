package com.explodingbacon.amap;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        menu = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        openRobotButton = new javax.swing.JMenuItem();
        saveRobotButton = new javax.swing.JMenuItem();
        openFieldButton = new javax.swing.JMenuItem();
        saveAutoButton = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        undoCommand = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A-MAP");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );

        robotButton.setText("Robot");
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

        driveButton.setText("Drive");
        driveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driveButtonActionPerformed(evt);
            }
        });

        file.setText("File");

        openRobotButton.setText("Open Robot");
        openRobotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openRobotButtonActionPerformed(evt);
            }
        });
        file.add(openRobotButton);

        saveRobotButton.setText("Save Robot");
        saveRobotButton.setToolTipText("");
        saveRobotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRobotButtonActionPerformed(evt);
            }
        });
        file.add(saveRobotButton);

        openFieldButton.setText("Open Field");
        openFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFieldButtonActionPerformed(evt);
            }
        });
        file.add(openFieldButton);

        saveAutoButton.setText("Save Autonomous");
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

        undoCommand.setText("Undo last Command");
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(robotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(robotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(driveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(commandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void openRobotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openRobotButtonActionPerformed
    }//GEN-LAST:event_openRobotButtonActionPerformed

    private void saveRobotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRobotButtonActionPerformed
    }//GEN-LAST:event_saveRobotButtonActionPerformed

    private void openFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFieldButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("FRC Field Files", "field");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File field = chooser.getSelectedFile();
            if (field.exists()) {
                Board.pieces.clear();
                try {
                   BufferedReader br = new BufferedReader(new FileReader(field));
                   String info = br.readLine();
                   for (String command : info.split("]")) {
                       String[] s = command.split(":");
                       if (s[0].equals("tote")) {
                           new Tote(Double.parseDouble(s[1]), Double.parseDouble(s[2]), new Color(Integer.parseInt(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5])), Boolean.parseBoolean(s[6]));
                       } else {
                           new FieldPiece(Double.parseDouble(s[1]), Double.parseDouble(s[2]), Double.parseDouble(s[3]), Double.parseDouble(s[4]), new Color(Integer.parseInt(s[5]), Integer.parseInt(s[6]), Integer.parseInt(s[7])), Boolean.parseBoolean(s[8]),s[9]);
                       }
                   }
                   br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_openFieldButtonActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        if (Board.robot != null && !Board.robot.commands.isEmpty()) {
            
        }
    }//GEN-LAST:event_editActionPerformed

    private void undoCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoCommandActionPerformed
        if (Board.robot != null && !Board.robot.commands.isEmpty()) {
            Board.robot.commands.remove(Board.robot.commands.get(Board.robot.commands.size() - 1));
        }
    }//GEN-LAST:event_undoCommandActionPerformed

    private void saveAutoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAutoButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Autonomous Files (.auto)", "auto");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file.exists()) {
                file.delete();
            }
            try {
                 file.createNewFile();
                 BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                 String data = "";
                 for (Command c : Board.robot.commands) {
                     for (String[] array : c.data) {
                         String command = "";
                         for (String s : array) {
                             command = command + s + (s == array[array.length - 1] ? "]" : ":");
                         }
                         data = data + command;
                     }
                 }
                 bw.write(data);
                 bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveAutoButtonActionPerformed

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
                //if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                //}
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
        //</editor-fold>

        /* Create and display the form */
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
    private javax.swing.JMenuItem openRobotButton;
    public static javax.swing.JToggleButton robotButton;
    private javax.swing.JMenuItem saveAutoButton;
    private javax.swing.JMenuItem saveRobotButton;
    private javax.swing.JMenuItem undoCommand;
    // End of variables declaration//GEN-END:variables
}
