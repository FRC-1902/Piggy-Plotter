package com.explodingbacon.piggyplotter;

import java.util.ArrayList;
import java.util.List;

public class CommandConfig extends javax.swing.JFrame {

    public List<String> data = new ArrayList<>();
    public Command c = null;
    public CommandGroupConfig config = null;
    
    public CommandConfig(Command c, CommandGroupConfig config) {
        initComponents();
        this.c = c;
        this.config = config;
        int index = 0;
        if (!c.data.isEmpty()) {
            for (String s : c.data.get(0)) {
                if (index == 0) {
                    commandNameField.setText(s);
                } else {
                    data.add(s);
                }
                index++;
            }
        }
        updateDataList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        commandNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addDataField = new javax.swing.JTextField();
        addDataButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataList = new javax.swing.JList();
        deleteButton = new javax.swing.JButton();
        moveUpButton = new javax.swing.JButton();
        moveDownButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Command Configuration");
        setResizable(false);

        commandNameField.setText("doTheThing");
        commandNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                commandNameFieldKeyTyped(evt);
            }
        });

        jLabel2.setText("Command name:");

        jLabel3.setText("Add data:");

        addDataButton.setText("Add");
        addDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataButtonActionPerformed(evt);
            }
        });

        dataList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        dataList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataList);

        deleteButton.setText("Delete Selected");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        moveUpButton.setText("Move Up");
        moveUpButton.setEnabled(false);
        moveUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpButtonActionPerformed(evt);
            }
        });

        moveDownButton.setText("Move Down");
        moveDownButton.setEnabled(false);
        moveDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Data:");

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addDataField, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(commandNameField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(moveUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(moveDownButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(moveUpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moveDownButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(commandNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(addDataField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(4, 4, 4)
                            .addComponent(addDataButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataButtonActionPerformed
        String text = addDataField.getText();
        if (!text.equals("") && !text.equals(" ")) {
            data.add(addDataField.getText());
            addDataField.setText("");
            updateDataList();
        }
    }//GEN-LAST:event_addDataButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        for (String s : new ArrayList<>(data)) { //Iterate through a COPY of data so that we can delete things from it without getting ConcurrentModificationExceptions
            if (s.equals(dataList.getSelectedValue())) {
                data.remove(s);
                break;
            }
        }
        updateDataList();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void dataListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataListMouseClicked
        boolean moveUpState = false;
        boolean deleteState = false;
        boolean moveDownState = false;
        if (dataList.getSelectedValue() != null) {
            deleteState = true;
            int index = 0;
            for (String s : data) {
                if (s.equals(dataList.getSelectedValue())) {
                    break;
                }
                index++;
            }
            if (index != 0) {
                moveUpState = true;
            }
            if (index != (data.size() - 1)) {
                moveDownState = true;
            }
        }
        moveUpButton.setEnabled(moveUpState);
        deleteButton.setEnabled(deleteState);
        moveDownButton.setEnabled(moveDownState);
    }//GEN-LAST:event_dataListMouseClicked

    private void moveUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpButtonActionPerformed
        Util.shiftIndex(data, dataList.getSelectedValue() + "", -1);
        updateDataList();
    }//GEN-LAST:event_moveUpButtonActionPerformed

    private void moveDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownButtonActionPerformed
        Util.shiftIndex(data, dataList.getSelectedValue() + "", 1);
        updateDataList();
    }//GEN-LAST:event_moveDownButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
            data.add(0, commandNameField.getText());
            String[] dataArray = new String[data.size()];
            int index = 0;
            for (String s : data) {
                dataArray[index] = s;
                index++;
            }          
            c.data = new ArrayList<>();
            c.data.add(dataArray);
            Board.robot.commands.add(c);
            config.addCommand(c);
            dispose();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void commandNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commandNameFieldKeyTyped
        if (!commandNameField.getText().equals("")) {
            confirmButton.setEnabled(true);           
        } else {
            confirmButton.setEnabled(false);
        }
    }//GEN-LAST:event_commandNameFieldKeyTyped

    
    public void updateDataList() {
        Object oldSelected = dataList.getSelectedValue();
        Object[] dataArray = new Object[data.size()];
        int index = 0;
        for (String s : data) {
            dataArray[index] = s;
            index++;
        }
        dataList.setListData(dataArray);
        for (String s : data) {
            if (s.equals(oldSelected)) {
                dataList.setSelectedValue(s, false);
                break;
            }
        }
        dataListMouseClicked(null);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDataButton;
    private javax.swing.JTextField addDataField;
    private javax.swing.JTextField commandNameField;
    private javax.swing.JButton confirmButton;
    private javax.swing.JList dataList;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton moveDownButton;
    private javax.swing.JButton moveUpButton;
    // End of variables declaration//GEN-END:variables
}
