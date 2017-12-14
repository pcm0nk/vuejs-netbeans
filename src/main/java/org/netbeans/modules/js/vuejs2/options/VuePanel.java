package org.netbeans.modules.js.vuejs2.options;

import java.io.File;
import java.util.List;
import org.netbeans.modules.js.vuejs2.wizard.VueConfigurationVisualPanel;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.util.NbBundle;
import org.openide.util.NbPreferences;

final class VuePanel extends javax.swing.JPanel {
    private final VueOptionsPanelController controller;

    public static final String EXECUTABLE_NAME = "vue.cmd"; // NOI18N
    public static final String EXECUTABLE_LONG_NAME = EXECUTABLE_NAME + FileUtils.getScriptExtension(true, false);

    VuePanel(VueOptionsPanelController controller) {
        this.controller = controller;

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        vueFolderBrowseButton = new javax.swing.JButton();
        vuePathTextField = new javax.swing.JTextField();
        vuePathBrowseButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(VuePanel.class, "VuePanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(vueFolderBrowseButton, org.openide.util.NbBundle.getMessage(VuePanel.class, "VuePanel.vueFolderBrowseButton.text")); // NOI18N
        vueFolderBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vueFolderBrowseButtonActionPerformed(evt);
            }
        });

        vuePathTextField.setText(org.openide.util.NbBundle.getMessage(VuePanel.class, "VuePanel.vuePathTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(vuePathBrowseButton, org.openide.util.NbBundle.getMessage(VuePanel.class, "VuePanel.vuePathBrowseButton.text")); // NOI18N
        vuePathBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vuePathBrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vuePathTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vueFolderBrowseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vuePathBrowseButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(vuePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(vueFolderBrowseButton)
                .addComponent(vuePathBrowseButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    @NbBundle.Messages("VueOptionsPanel.browse.title=Select Vue")
    private void vueFolderBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vueFolderBrowseButtonActionPerformed
        File file = new FileChooserBuilder(VuePanel.class)
                .setFilesOnly(true)
                .setTitle(Bundle.VueOptionsPanel_browse_title())
                .showOpenDialog();
        if (file != null) {
            vuePathTextField.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_vueFolderBrowseButtonActionPerformed

    @NbBundle.Messages("VueOptionsPanel.executable.notFound=No Vue executable found.")
    private void vuePathBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vuePathBrowseButtonActionPerformed
        List<String> vuePaths = FileUtils.findFileOnUsersPath(EXECUTABLE_LONG_NAME, EXECUTABLE_NAME);
        if (vuePaths.isEmpty()) {
            StatusDisplayer.getDefault().setStatusText(Bundle.VueOptionsPanel_executable_notFound());
        } else {
            vuePathTextField.setText(vuePaths.get(0));
        }
    }//GEN-LAST:event_vuePathBrowseButtonActionPerformed

    void load() {
        String vue = NbPreferences.forModule(VueConfigurationVisualPanel.class).get("vueExecutableLocation", "");
        vuePathTextField.setText(vue);
    }

    void store() {
        NbPreferences.forModule(VueConfigurationVisualPanel.class).put("vueExecutableLocation", vuePathTextField.getText());
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton vuePathBrowseButton;
    private javax.swing.JTextField vuePathTextField;
    private javax.swing.JButton vueFolderBrowseButton;
    // End of variables declaration//GEN-END:variables
}