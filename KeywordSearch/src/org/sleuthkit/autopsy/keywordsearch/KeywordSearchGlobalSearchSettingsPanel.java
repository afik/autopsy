/*
 * Autopsy Forensic Browser
 *
 * Copyright 2012-2014 Basis Technology Corp.
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
package org.sleuthkit.autopsy.keywordsearch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.logging.Level;
import org.netbeans.spi.options.OptionsPanelController;
import org.sleuthkit.autopsy.corecomponents.OptionsPanel;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.ingest.IngestManager;
import org.sleuthkit.autopsy.keywordsearch.KeywordSearchIngestModule.UpdateFrequency;

/**
 * General, not per list, keyword search configuration and status display widget
 */
class KeywordSearchGlobalSearchSettingsPanel extends javax.swing.JPanel implements OptionsPanel {

    private final Logger logger = Logger.getLogger(KeywordSearchGlobalSearchSettingsPanel.class.getName());
//    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Creates new form KeywordSearchConfigurationPanel2
     */
    KeywordSearchGlobalSearchSettingsPanel() {
        initComponents();
        customizeComponents();
    }

    private void activateWidgets() {
        skipNSRLCheckBox.setSelected(KeywordSearchSettings.getSkipKnown());
        showSnippetsCB.setSelected(KeywordSearchSettings.getShowSnippets());
        boolean enable = !IngestManager.getInstance().isIngestRunning();
        skipNSRLCheckBox.setEnabled(enable);
        setTimeSettingEnabled(enable);

        final UpdateFrequency curFreq = KeywordSearchSettings.getUpdateFrequency();
        switch (curFreq) {
            case FAST:
                timeRadioButton1.setSelected(true);
                break;
            case AVG:
                timeRadioButton2.setSelected(true);
                break;
            case SLOW:
                timeRadioButton3.setSelected(true);
                break;
            case SLOWEST:
                timeRadioButton4.setSelected(true);
                break;
            case NONE:
                timeRadioButton5.setSelected(true);
                break;
            case DEFAULT:
            default:
                // default value
                timeRadioButton3.setSelected(true);
                break;
        }
    }

//    @Override
//    public void addPropertyChangeListener(PropertyChangeListener l) {
//        pcs.addPropertyChangeListener(l);
//    }
//
//    @Override
//    public void removePropertyChangeListener(PropertyChangeListener l) {
//        pcs.removePropertyChangeListener(l);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeGroup = new javax.swing.ButtonGroup();
        skipNSRLCheckBox = new javax.swing.JCheckBox();
        filesIndexedLabel = new javax.swing.JLabel();
        filesIndexedValue = new javax.swing.JLabel();
        chunksLabel = new javax.swing.JLabel();
        chunksValLabel = new javax.swing.JLabel();
        settingsLabel = new javax.swing.JLabel();
        informationLabel = new javax.swing.JLabel();
        settingsSeparator = new javax.swing.JSeparator();
        informationSeparator = new javax.swing.JSeparator();
        frequencyLabel = new javax.swing.JLabel();
        timeRadioButton1 = new javax.swing.JRadioButton();
        timeRadioButton2 = new javax.swing.JRadioButton();
        timeRadioButton3 = new javax.swing.JRadioButton();
        timeRadioButton4 = new javax.swing.JRadioButton();
        showSnippetsCB = new javax.swing.JCheckBox();
        timeRadioButton5 = new javax.swing.JRadioButton();

        skipNSRLCheckBox.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.skipNSRLCheckBox.text")); // NOI18N
        skipNSRLCheckBox.setToolTipText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.skipNSRLCheckBox.toolTipText")); // NOI18N
        skipNSRLCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipNSRLCheckBoxActionPerformed(evt);
            }
        });

        filesIndexedLabel.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.filesIndexedLabel.text")); // NOI18N

        filesIndexedValue.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.filesIndexedValue.text")); // NOI18N
        filesIndexedValue.setMaximumSize(null);

        chunksLabel.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.chunksLabel.text")); // NOI18N

        chunksValLabel.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.chunksValLabel.text")); // NOI18N

        settingsLabel.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.settingsLabel.text")); // NOI18N

        informationLabel.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.informationLabel.text")); // NOI18N

        frequencyLabel.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.frequencyLabel.text")); // NOI18N

        timeRadioButton1.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton1.text")); // NOI18N
        timeRadioButton1.setToolTipText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton1.toolTipText")); // NOI18N
        timeRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeRadioButton1ActionPerformed(evt);
            }
        });

        timeRadioButton2.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton2.text")); // NOI18N
        timeRadioButton2.setToolTipText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton2.toolTipText")); // NOI18N
        timeRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeRadioButton2ActionPerformed(evt);
            }
        });

        timeRadioButton3.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton3.text")); // NOI18N
        timeRadioButton3.setToolTipText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton3.toolTipText")); // NOI18N
        timeRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeRadioButton3ActionPerformed(evt);
            }
        });

        timeRadioButton4.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton4.text_1")); // NOI18N
        timeRadioButton4.setToolTipText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton4.toolTipText")); // NOI18N
        timeRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeRadioButton4ActionPerformed(evt);
            }
        });

        showSnippetsCB.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.showSnippetsCB.text")); // NOI18N
        showSnippetsCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSnippetsCBActionPerformed(evt);
            }
        });

        timeRadioButton5.setText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton5.text")); // NOI18N
        timeRadioButton5.setToolTipText(org.openide.util.NbBundle.getMessage(KeywordSearchGlobalSearchSettingsPanel.class, "KeywordSearchGlobalSearchSettingsPanel.timeRadioButton5.toolTipText")); // NOI18N
        timeRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeRadioButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(settingsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(informationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(informationSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(skipNSRLCheckBox)
                            .addComponent(showSnippetsCB)
                            .addComponent(filesIndexedLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(filesIndexedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(frequencyLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timeRadioButton2)
                                    .addComponent(timeRadioButton1)
                                    .addComponent(timeRadioButton3)
                                    .addComponent(timeRadioButton4)
                                    .addComponent(timeRadioButton5)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chunksLabel)
                                .addGap(18, 18, 18)
                                .addComponent(chunksValLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(settingsLabel)
                    .addComponent(settingsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(skipNSRLCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showSnippetsCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frequencyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(informationLabel)
                    .addComponent(informationSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filesIndexedLabel)
                    .addComponent(filesIndexedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chunksLabel)
                    .addComponent(chunksValLabel))
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void timeRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeRadioButton5ActionPerformed
        this.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
//        pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_timeRadioButton5ActionPerformed

    private void skipNSRLCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipNSRLCheckBoxActionPerformed
        this.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
//        pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_skipNSRLCheckBoxActionPerformed

    private void showSnippetsCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSnippetsCBActionPerformed
        this.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
//        pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_showSnippetsCBActionPerformed

    private void timeRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeRadioButton1ActionPerformed
        this.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
//        pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_timeRadioButton1ActionPerformed

    private void timeRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeRadioButton2ActionPerformed
        this.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
//        pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_timeRadioButton2ActionPerformed

    private void timeRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeRadioButton3ActionPerformed
        this.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
//        pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_timeRadioButton3ActionPerformed

    private void timeRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeRadioButton4ActionPerformed
        this.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
//        pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_timeRadioButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chunksLabel;
    private javax.swing.JLabel chunksValLabel;
    private javax.swing.JLabel filesIndexedLabel;
    private javax.swing.JLabel filesIndexedValue;
    private javax.swing.JLabel frequencyLabel;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JSeparator informationSeparator;
    private javax.swing.JLabel settingsLabel;
    private javax.swing.JSeparator settingsSeparator;
    private javax.swing.JCheckBox showSnippetsCB;
    private javax.swing.JCheckBox skipNSRLCheckBox;
    private javax.swing.ButtonGroup timeGroup;
    private javax.swing.JRadioButton timeRadioButton1;
    private javax.swing.JRadioButton timeRadioButton2;
    private javax.swing.JRadioButton timeRadioButton3;
    private javax.swing.JRadioButton timeRadioButton4;
    private javax.swing.JRadioButton timeRadioButton5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void store() {
        KeywordSearchSettings.setSkipKnown(skipNSRLCheckBox.isSelected());
        KeywordSearchSettings.setUpdateFrequency(getSelectedTimeValue());
        KeywordSearchSettings.setShowSnippets(showSnippetsCB.isSelected());
    }

    @Override
    public void load() {
        activateWidgets();
    }

    private void setTimeSettingEnabled(boolean enabled) {
        timeRadioButton1.setEnabled(enabled);
        timeRadioButton2.setEnabled(enabled);
        timeRadioButton3.setEnabled(enabled);
        timeRadioButton4.setEnabled(enabled);
        timeRadioButton5.setEnabled(enabled);
        frequencyLabel.setEnabled(enabled);
    }

    private UpdateFrequency getSelectedTimeValue() {
        if (timeRadioButton1.isSelected()) {
            return UpdateFrequency.FAST;
        } else if (timeRadioButton2.isSelected()) {
            return UpdateFrequency.AVG;
        } else if (timeRadioButton3.isSelected()) {
            return UpdateFrequency.SLOW;
        } else if (timeRadioButton4.isSelected()) {
            return UpdateFrequency.SLOWEST;
        } else if (timeRadioButton5.isSelected()) {
            return UpdateFrequency.NONE;
        }
        return UpdateFrequency.DEFAULT;
    }

    private void customizeComponents() {

        timeGroup.add(timeRadioButton1);
        timeGroup.add(timeRadioButton2);
        timeGroup.add(timeRadioButton3);
        timeGroup.add(timeRadioButton4);
        timeGroup.add(timeRadioButton5);

        this.skipNSRLCheckBox.setSelected(KeywordSearchSettings.getSkipKnown());

        try {
            filesIndexedValue.setText(Integer.toString(KeywordSearch.getServer().queryNumIndexedFiles()));
            chunksValLabel.setText(Integer.toString(KeywordSearch.getServer().queryNumIndexedChunks()));
        } catch (KeywordSearchModuleException | NoOpenCoreException ex) {
            logger.log(Level.WARNING, "Could not get number of indexed files/chunks"); //NON-NLS
        }

        KeywordSearch.addNumIndexedFilesChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String changed = evt.getPropertyName();
                Object newValue = evt.getNewValue();

                if (changed.equals(KeywordSearch.NUM_FILES_CHANGE_EVT)) {
                    int newFilesIndexed = ((Integer) newValue).intValue();
                    filesIndexedValue.setText(Integer.toString(newFilesIndexed));
                    try {
                        chunksValLabel.setText(Integer.toString(KeywordSearch.getServer().queryNumIndexedChunks()));
                    } catch (KeywordSearchModuleException | NoOpenCoreException ex) {
                        logger.log(Level.WARNING, "Could not get number of indexed chunks"); //NON-NLS

                    }
                }
            }
        });
    }
}
