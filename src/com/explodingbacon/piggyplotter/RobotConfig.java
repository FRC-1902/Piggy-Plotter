package com.explodingbacon.piggyplotter;

public class RobotConfig extends javax.swing.JFrame {

    public Robot robot = null;
    
    public double rX = 0;
    public double rY = 0;
    public double rWidth = 0;
    public double rHeight = 0;
    
    public double distanceL = 0;
    public double distanceR = 0;
    public double distanceU = 0;
    public double distanceD = 0;
    
    public RobotConfig(Robot robot) {
        initComponents();
        this.robot = robot;
        widthBox.setText(robot.width + "");
        lengthBox.setText(robot.height + "");   
        rX = robot.x;
        rY = robot.y;
        rWidth = robot.width;
        rHeight = robot.height;
        angleBox.setText(robot.angle + "");
        boolean broke = false;
        for (CommandGroup cg : robot.commandGroups) {
            for (Command c : cg.commands) {
                if (c instanceof DriveCommand) {
                    angleLabel.setVisible(false);
                    angleBox.setVisible(false);
                    angleBox.setEnabled(false);
                    broke = true;
                    break;
                }
            }
            if (broke) break;
        }
        refreshDistances();
    }
    
    public void refreshDistances() {
        FieldPiece found = null;
        for (double x=rX; x > 0; x--) {
            for (double y = 0; y < rHeight; y++) {
                double realX = Main.scaleUp(x);
                double realY = Main.scaleUp(rY + y);            
                for (Entity e : Board.field.parts) {                   
                    if (e.getRect().contains(realX, realY) && isValid(e)) {
                        found = (FieldPiece) e;
                        distanceLeft.setText("(Left) Distance from " + found.display + ":");
                        distanceLeftBox.setText(rX - (found.x + found.width) + "");
                        if (distanceLeftBox.getText().length() > 5) {
                            distanceLeftBox.setText(Math.round(Double.parseDouble(distanceLeftBox.getText())) + "");
                        }                       
                        break;
                    }
                }
                if (found != null) {
                    break;
                }
            }
            if (found != null) {
                break;
            }
        }
        if (found == null) {
            distanceLeft.setText("(Left) Distance from Arena Wall:");
            distanceLeftBox.setText(rX + "");
        }
        found = null;
        for (double x = rX; x < Board.field.arena.width; x++) {
            for (double y = 0; y < rHeight; y++) {
                double realX = Main.scaleUp(x);
                double realY = Main.scaleUp(rY + y);            
                for (Entity e : Board.field.parts) {                   
                    if (e.getRect().contains(realX, realY) && isValid(e)) {
                        found = (FieldPiece) e;
                        distanceRight.setText("(Right) Distance from " + found.display + ":");
                        distanceRightBox.setText(found.x - (rX + rWidth) + "");
                        if (distanceRightBox.getText().length() > 5) {
                            distanceRightBox.setText(Math.round(Double.parseDouble(distanceRightBox.getText())) + "");
                        }
                        break;
                    }
                }
                if (found != null) {
                    break;
                }
            }
            if (found != null) {
                break;
            }
        }
        if (found == null) {
            distanceRight.setText("(Right) Distance from Arena Wall:");
            distanceRightBox.setText(Board.field.arena.width - (rX + rWidth) + "");
        }
        found = null;
        for (double y = rY; y > -1; y--) {
            for (double x = 0; x < rWidth; x++) {
                double realX = Main.scaleUp(rX + x);
                double realY = Main.scaleUp(y);            
                for (Entity e : Board.field.parts) {                   
                    if (e.getRect().contains(realX, realY) && isValid(e)) {
                        found = (FieldPiece) e;
                        distanceUp.setText("(Up) Distance from " + found.display + ":");
                        distanceUpBox.setText(rY - (found.y + found.height) + "");
                        if (distanceUpBox.getText().length() > 5) {
                            distanceUpBox.setText(Math.round(Double.parseDouble(distanceUpBox.getText())) + "");
                        }
                        break;
                    }
                }
                if (found != null) {
                    break;
                }
            }
            if (found != null) {
                break;
            }
        }
        if (found == null) {
            distanceUp.setText("(Up) Distance from Arena Wall:");
            distanceUpBox.setText(rY + "");
        }
        found = null;
        for (double y = rY; y < Board.field.arena.height; y++) {
            for (double x = 0; x < rWidth; x++) {
                double realX = Main.scaleUp(rX + x);
                double realY = Main.scaleUp(y);            
                for (Entity e : Board.field.parts) {                   
                    if (e.getRect().contains(realX, realY) && isValid(e)) {
                        found = (FieldPiece) e;
                        distanceDown.setText("(Down) Distance from " + found.display + ":");
                        distanceDownBox.setText(found.y - (rY + rHeight) + "");
                        if (distanceDownBox.getText().length() > 5) {
                            distanceDownBox.setText(Math.round(Double.parseDouble(distanceDownBox.getText())) + "");
                        }
                        break;
                    }
                }
                if (found != null) {
                    break;
                }
            }
            if (found != null) {
                break;
            }
        }
        distanceL = Double.parseDouble(distanceLeftBox.getText());
        distanceR = Double.parseDouble(distanceRightBox.getText());
        distanceU = Double.parseDouble(distanceUpBox.getText());
        distanceD = Double.parseDouble(distanceDownBox.getText());
    }
    
    public boolean isValid(Entity e) {
        return (e instanceof FieldPiece && !(e instanceof Robot) && ((FieldPiece) e).display != null && !((FieldPiece) e).display.equals("null") && !((FieldPiece) e).display.equals("Arena") && !e.getRect().intersects(robot.getRect()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        widthBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lengthBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        distanceLeft = new javax.swing.JLabel();
        distanceRight = new javax.swing.JLabel();
        distanceUp = new javax.swing.JLabel();
        distanceDown = new javax.swing.JLabel();
        distanceLeftBox = new javax.swing.JTextField();
        distanceRightBox = new javax.swing.JTextField();
        distanceUpBox = new javax.swing.JTextField();
        distanceDownBox = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        angleLabel = new javax.swing.JLabel();
        angleBox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Robot Configuration");
        setResizable(false);

        jLabel1.setText("Robot Width:");

        widthBox.setText("32");
        widthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widthBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("All distances and sizes are in inches (in.)");

        lengthBox.setText("32");
        lengthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lengthBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Robot Length:");

        distanceLeft.setText("Distance from ARENA_WALL_L:");

        distanceRight.setText("Distance from ARENA_WALL_R:");

        distanceUp.setText("Distance from SCORING_PLATFORM_2:");

        distanceDown.setText("Distance from the STEP:");

        distanceLeftBox.setText("32");
        distanceLeftBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceLeftBoxActionPerformed(evt);
            }
        });

        distanceRightBox.setText("32");
        distanceRightBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceRightBoxActionPerformed(evt);
            }
        });

        distanceUpBox.setText("32");
        distanceUpBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceUpBoxActionPerformed(evt);
            }
        });

        distanceDownBox.setText("32");
        distanceDownBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceDownBoxActionPerformed(evt);
            }
        });

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        delete.setText("Delete Robot");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        angleLabel.setText("Starting Angle:");

        angleBox.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lengthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(widthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(angleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(angleBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(distanceDown)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(distanceDownBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(distanceRight)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(distanceRightBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(distanceUp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(distanceUpBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(distanceLeft)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(distanceLeftBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(widthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(angleLabel)
                    .addComponent(angleBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lengthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(distanceLeft)
                    .addComponent(distanceLeftBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(distanceRight)
                    .addComponent(distanceRightBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(distanceUp)
                    .addComponent(distanceUpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(distanceDown)
                    .addComponent(distanceDownBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm)
                    .addComponent(cancel)
                    .addComponent(delete))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        robot.x = rX;
        robot.y = rY;
        robot.width = rWidth;
        robot.height = rHeight;
        robot.angle = Double.parseDouble(angleBox.getText());
        Board.robot = robot;
        Board.field.parts.add(robot);
        dispose();
    }//GEN-LAST:event_confirmActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void distanceLeftBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceLeftBoxActionPerformed
        double diff = distanceL - (Double.parseDouble(distanceLeftBox.getText()));
        rX -= diff;
        refreshDistances();
    }//GEN-LAST:event_distanceLeftBoxActionPerformed

    private void distanceRightBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceRightBoxActionPerformed
        double diff = distanceR - (Double.parseDouble(distanceRightBox.getText()));
        rX += diff;
        refreshDistances();
    }//GEN-LAST:event_distanceRightBoxActionPerformed

    private void distanceUpBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceUpBoxActionPerformed
        double diff = distanceU - (Double.parseDouble(distanceUpBox.getText()));
        rY -= diff;
        refreshDistances();
    }//GEN-LAST:event_distanceUpBoxActionPerformed

    private void distanceDownBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceDownBoxActionPerformed
        double diff = distanceD - (Double.parseDouble(distanceDownBox.getText()));
        rY += diff;
        refreshDistances();
    }//GEN-LAST:event_distanceDownBoxActionPerformed

    private void widthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widthBoxActionPerformed
        rWidth = Double.parseDouble(widthBox.getText());
        refreshDistances();
    }//GEN-LAST:event_widthBoxActionPerformed

    private void lengthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lengthBoxActionPerformed
        rHeight = Double.parseDouble(lengthBox.getText());
        refreshDistances();
    }//GEN-LAST:event_lengthBoxActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        robot.commandGroups.clear();
        Board.field.parts.remove(robot);
        Board.robot = null;
        dispose();
    }//GEN-LAST:event_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField angleBox;
    private javax.swing.JLabel angleLabel;
    private javax.swing.JButton cancel;
    private javax.swing.JButton confirm;
    private javax.swing.JButton delete;
    private javax.swing.JLabel distanceDown;
    private javax.swing.JTextField distanceDownBox;
    private javax.swing.JLabel distanceLeft;
    private javax.swing.JTextField distanceLeftBox;
    private javax.swing.JLabel distanceRight;
    private javax.swing.JTextField distanceRightBox;
    private javax.swing.JLabel distanceUp;
    private javax.swing.JTextField distanceUpBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField lengthBox;
    private javax.swing.JTextField widthBox;
    // End of variables declaration//GEN-END:variables
}
