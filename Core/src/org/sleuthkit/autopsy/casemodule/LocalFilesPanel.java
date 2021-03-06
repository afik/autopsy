/*
 * Autopsy Forensic Browser
 *
 * Copyright 2013 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule;

import java.awt.Dialog;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.corecomponentinterfaces.DataSourceProcessor;
import org.sleuthkit.autopsy.coreutils.MessageNotifyUtil;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.sleuthkit.autopsy.casemodule.Case.CaseType;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.coreutils.PathValidator;

/**
 * Add input wizard subpanel for adding local files / dirs to the case
 */
class LocalFilesPanel extends JPanel {

    private PropertyChangeSupport pcs = null;
    private Set<File> currentFiles = new TreeSet<File>(); //keep currents in a set to disallow duplicates per add
    private boolean enableNext = false;
    private static LocalFilesPanel instance;
    public static final String FILES_SEP = ",";
    private static final Logger logger = Logger.getLogger(LocalFilesPanel.class.getName());
    private String displayName = "";

    /**
     * Creates new form LocalFilesPanel
     */
    private LocalFilesPanel() {
        initComponents();
        customInit();
    }

    static synchronized LocalFilesPanel getDefault() {
        if (instance == null) {
            instance = new LocalFilesPanel();
        }
        return instance;
    }

    private void customInit() {
        localFileChooser.setMultiSelectionEnabled(true);
        errorLabel.setVisible(false);
        selectedPaths.setText("");
        this.displayNameLabel.setText(NbBundle.getMessage(this.getClass(), "LocalFilesPanel.displayNameLabel.text"));
    }

    //@Override
    public String getContentPaths() {
        //TODO consider interface change to return list of paths instead

        if (currentFiles == null) {
            return "";
        }
        StringBuilder b = new StringBuilder();
        for (File f : currentFiles) {
            b.append(f.getAbsolutePath());
            b.append(FILES_SEP);
        }
        return b.toString();
    }

    //@Override
    public void setContentPath(String s) {
        //for the local file panel we don't need to restore the last paths used
        //when the wizard restarts
    }

    //@Override
    public String getContentType() {
        return NbBundle.getMessage(this.getClass(), "LocalFilesPanel.contentType.text");
    }

    //@Override
    public boolean validatePanel() {

        // display warning if there is one (but don't disable "next" button)
        warnIfPathIsInvalid(getContentPaths());

        return enableNext;
    }

    /**
     * Validates path to selected data source and displays warning if it is
     * invalid.
     *
     * @param path Absolute path to the selected data source
     */
    private void warnIfPathIsInvalid(String path) {
        errorLabel.setVisible(false);

        // Path variable for "Local files" module is a coma separated string containg multiple paths
        List<String> pathsList = Arrays.asList(path.split(","));
        CaseType currentCaseType = Case.getCurrentCase().getCaseType();

        for (String currentPath : pathsList) {
            if (!PathValidator.isValid(currentPath, currentCaseType)) {
                errorLabel.setVisible(true);
                errorLabel.setText(NbBundle.getMessage(this.getClass(), "DataSourceOnCDriveError.text"));
                return;
            }
        }
    }

    //@Override
    public void select() {
        reset();
    }

    //@Override
    public void reset() {
        currentFiles.clear();
        selectedPaths.setText("");
        enableNext = false;
        errorLabel.setVisible(false);
        displayName = "";
        this.displayNameLabel.setText(NbBundle.getMessage(this.getClass(), "LocalFilesPanel.displayNameLabel.text"));
    }

    @Override
    public synchronized void addPropertyChangeListener(PropertyChangeListener pcl) {
        super.addPropertyChangeListener(pcl);

        if (pcs == null) {
            pcs = new PropertyChangeSupport(this);
        }

        pcs.addPropertyChangeListener(pcl);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        super.removePropertyChangeListener(pcl);

        pcs.removePropertyChangeListener(pcl);
    }

    public String getFileSetName() {
        return this.displayName;
    }

    @Override
    public String toString() {
        return NbBundle.getMessage(this.getClass(), "LocalFilesDSProcessor.toString.text");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        localFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        selectButton = new javax.swing.JButton();
        infoLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedPaths = new javax.swing.JTextArea();
        errorLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        displayNameLabel = new javax.swing.JLabel();

        localFileChooser.setApproveButtonText(org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.localFileChooser.approveButtonText")); // NOI18N
        localFileChooser.setApproveButtonToolTipText(org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.localFileChooser.approveButtonToolTipText")); // NOI18N
        localFileChooser.setDialogTitle(org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.localFileChooser.dialogTitle")); // NOI18N
        localFileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        org.openide.awt.Mnemonics.setLocalizedText(selectButton, org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.selectButton.text")); // NOI18N
        selectButton.setToolTipText(org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.selectButton.toolTipText")); // NOI18N
        selectButton.setActionCommand(org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.selectButton.actionCommand")); // NOI18N
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(infoLabel, org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.infoLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.clearButton.text")); // NOI18N
        clearButton.setToolTipText(org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.clearButton.toolTipText")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        selectedPaths.setEditable(false);
        selectedPaths.setColumns(20);
        selectedPaths.setRows(5);
        selectedPaths.setToolTipText(org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.selectedPaths.toolTipText")); // NOI18N
        jScrollPane2.setViewportView(selectedPaths);

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(errorLabel, org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.errorLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(displayNameLabel, org.openide.util.NbBundle.getMessage(LocalFilesPanel.class, "LocalFilesPanel.displayNameLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addGap(2, 2, 2))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectButton)
                        .addGap(36, 36, 36)
                        .addComponent(clearButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayNameLabel))
                .addGap(13, 13, 13)
                .addComponent(errorLabel)
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        int returnVal = localFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = localFileChooser.getSelectedFiles();
            for (File f : files) {
                currentFiles.add(f);
            }

            //update label
            StringBuilder allPaths = new StringBuilder();
            for (File f : currentFiles) {
                allPaths.append(f.getAbsolutePath()).append("\n");
            }
            this.selectedPaths.setText(allPaths.toString());
            this.selectedPaths.setToolTipText(allPaths.toString());

        }

        if (!currentFiles.isEmpty()) {
            enableNext = true;
        } else {
            enableNext = false;
        }

        try {
            pcs.firePropertyChange(DataSourceProcessor.DSP_PANEL_EVENT.UPDATE_UI.toString(), false, true);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "LocalFilesPanel listener threw exception", e); //NON-NLS
            MessageNotifyUtil.Notify.show(NbBundle.getMessage(this.getClass(), "LocalFilesPanel.moduleErr"),
                    NbBundle.getMessage(this.getClass(), "LocalFilesPanel.moduleErr.msg"),
                    MessageNotifyUtil.MessageType.ERROR);
        }
    }//GEN-LAST:event_selectButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        reset();

    }//GEN-LAST:event_clearButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String displayName = JOptionPane.showInputDialog("New Display Name: ");
        if (displayName != null && !displayName.equals("")) {
            this.displayName = displayName;
            this.displayNameLabel.setText("Display Name: " + this.displayName);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel displayNameLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFileChooser localFileChooser;
    private javax.swing.JButton selectButton;
    private javax.swing.JTextArea selectedPaths;
    // End of variables declaration//GEN-END:variables
}
