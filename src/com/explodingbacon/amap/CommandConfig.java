package com.explodingbacon.amap;

import java.util.ArrayList;
import java.util.List;

public class CommandConfig extends javax.swing.JFrame {

    public List<String> data = new ArrayList<>();
    public Double x = null;
    public Double y = null;
    public Command c = null;
    
    public CommandConfig(double x, double y) {
        initComponents();
        this.x = x;
        this.y = y;
        updateDataList();
    }
    
    public CommandConfig(Command c) {
        initComponents();
        this.c = c;
        int index = 0;
        for (String s : c.data.get(0)) {
            if (index == 0) {
                commandNameField.setText(s);
            } else {
                data.add(s);
            }
            index++;
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

        addDataField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addDataFieldKeyTyped(evt);
            }
        });

        addDataButton.setText("Add");
        addDataButton.setEnabled(false);
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
                            .addComponent(addDataField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(commandNameField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(moveUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(moveDownButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(commandNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(addDataField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addComponent(addDataButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(moveUpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moveDownButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmButton)))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataButtonActionPerformed
        data.add(addDataField.getText());
        addDataField.setText("");
        addDataFieldKeyTyped(null);
        updateDataList();
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

    private void addDataFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addDataFieldKeyTyped
        if (!addDataField.getText().equals("")) {
            addDataButton.setEnabled(true);
        } else {
            addDataButton.setEnabled(false);
        }
    }//GEN-LAST:event_addDataFieldKeyTyped

    private void moveUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpButtonActionPerformed
        shiftIndex(data, dataList.getSelectedValue() + "", -1);
        updateDataList();
    }//GEN-LAST:event_moveUpButtonActionPerformed

    private void moveDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownButtonActionPerformed
        shiftIndex(data, dataList.getSelectedValue() + "", 1);
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
            if (c == null) {
                c = new Command(x, y, dataArray);
                Board.robot.commands.add(c);
            } else {
                c.data = new ArrayList<>();
                c.data.add(dataArray);
            }
            dispose();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void commandNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commandNameFieldKeyTyped
        if (!commandNameField.getText().equals("")) {
            confirmButton.setEnabled(true);
        } else {
            confirmButton.setEnabled(false);
        }
    }//GEN-LAST:event_commandNameFieldKeyTyped
  
    public void shiftIndex(List<String> list, String s, int change) {
        int index = 0;
        for (String s2 : list) {
            if (s2.equals(s)) {
                break;
            }
            index++;
        }
        data.remove(s);
        data.add(index + change, s);
    }
    
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
