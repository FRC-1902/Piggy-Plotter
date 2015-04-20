package com.explodingbacon.piggyplotter;

import java.util.ArrayList;
import java.util.List;

public class CommandGroupConfig extends javax.swing.JFrame {

    public List<Command> commands = new ArrayList<>();
    public CommandGroup commandGroup = null;
    
    public CommandGroupConfig(CommandGroup commandGroup) {
        initComponents();
        this.commandGroup = commandGroup;
        commands = new ArrayList<>(commandGroup.commands);
        nameField.setText(commandGroup.name);               
        setIconImage(Main.icon);
        updateCommandList();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        commandList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        moveUp = new javax.swing.JButton();
        moveDown = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        addCommand = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        commandField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        deleteGroup = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CommandGroup Configuration");
        setResizable(false);

        commandList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        commandList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commandListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(commandList);

        jLabel1.setText("Commands:");

        moveUp.setText("Move Up");
        moveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpActionPerformed(evt);
            }
        });

        moveDown.setText("Move Down");
        moveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        addCommand.setText("Add");
        addCommand.setEnabled(false);
        addCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCommandActionPerformed(evt);
            }
        });

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        nameField.setText("Command Group");
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        commandField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                commandFieldKeyReleased(evt);
            }
        });

        jLabel3.setText("New Command:");

        deleteGroup.setText("Delete Command Group");
        deleteGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(40, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(deleteGroup))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(moveUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(moveDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(commandField)
                                            .addComponent(jLabel3)
                                            .addComponent(addCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(28, 28, 28))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(236, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(deleteGroup))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(moveUp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(moveDown))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCommand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirm)))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpActionPerformed
        Util.shiftIndex(commands, getSelectedCommand(), -1);
        updateCommandList();
    }//GEN-LAST:event_moveUpActionPerformed

    private void moveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownActionPerformed
        Util.shiftIndex(commands, getSelectedCommand(), 1);
        updateCommandList();
    }//GEN-LAST:event_moveDownActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        commands.remove(getSelectedCommand());
        updateCommandList();
    }//GEN-LAST:event_deleteActionPerformed

    private void commandListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commandListMouseClicked
        boolean state = false;
        if (getSelectedCommand() != null) {
            state = true;
        }
        if (commands.size() > 0 && state) {
            moveUp.setEnabled(commands.get(0) != getSelectedCommand());
            moveDown.setEnabled(commands.get(commands.size() - 1) != getSelectedCommand());
        } else {
            moveUp.setEnabled(false);
            moveDown.setEnabled(false);
        }
        delete.setEnabled(state);
        confirm.setEnabled(!commands.isEmpty());
    }//GEN-LAST:event_commandListMouseClicked

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        commandGroup.commands = commands;
        String name = nameField.getText();
        if (!name.equals("") && !name.equals(" ")) {
            commandGroup.name = name;
        }
        if (!Board.robot.commandGroups.contains(commandGroup)) Board.robot.commandGroups.add(commandGroup);
        dispose();
    }//GEN-LAST:event_confirmActionPerformed

    private void addCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCommandActionPerformed
        Command c = new Command(0,0);
        List<String[]> cData = new ArrayList<>();
        cData.add(commandField.getText().split(" "));
        c.data = cData;
        commands.add(c);
        commandField.setText("");
        commandFieldKeyReleased(null);
        updateCommandList();
    }//GEN-LAST:event_addCommandActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
    }//GEN-LAST:event_nameFieldActionPerformed

    private void commandFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commandFieldKeyReleased
        if (commandField.getText() != null && !commandField.getText().equals("")) {
            addCommand.setEnabled(true);
        } else {
            addCommand.setEnabled(false);
        }
    }//GEN-LAST:event_commandFieldKeyReleased

    private void deleteGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGroupActionPerformed
        Board.robot.commandGroups.remove(commandGroup);
        dispose();
    }//GEN-LAST:event_deleteGroupActionPerformed

    public void addCommand(Command c) {
        commands.add(c);
        updateCommandList();
    }
    
    public Command getSelectedCommand() {
        Object o = commandList.getSelectedValue();
        if (o != null) {
            String data = (String) o;
            for (Command c : commands) {
                if (c.dataToString().equals(data)) {
                    return c;
                }
            }
        }
        return null;
    }
    
    public void updateCommandList() {
        Object oldSelected = commandList.getSelectedValue();
        Object[] dataArray = new Object[commands.size()];
        int index = 0;
        for (Command c : commands) {
            dataArray[index] = c.dataToString();
            index++;
        }
        commandList.setListData(dataArray);
        for (Command c : commands) {
            if (c.dataToString().equals(oldSelected)) {
                commandList.setSelectedValue(c.dataToString(), false);
                break;
            }
        }
        commandListMouseClicked(null);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCommand;
    private javax.swing.JTextField commandField;
    private javax.swing.JList commandList;
    private javax.swing.JButton confirm;
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteGroup;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton moveDown;
    private javax.swing.JButton moveUp;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
