/* 
 * Copyright (c) 2010-2012 Thiago T. Sá
 * 
 * This file is part of CloudReports.
 *
 * CloudReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * CloudReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * For more information about your rights as a user of CloudReports,
 * refer to the LICENSE file or see <http://www.gnu.org/licenses/>.
 */

package cloudreports.gui.datacenters;

import cloudreports.dao.CustomerRegistryDAO;
import cloudreports.dao.DatacenterRegistryDAO;
import cloudreports.gui.CloudTree;
import cloudreports.gui.Dialog;
import cloudreports.gui.MainView;
import cloudreports.models.DatacenterRegistry;
import java.awt.event.KeyEvent;

/**
 * The NewDatacenter form. Most of its code is generated automatically by the
 * NetBeans IDE.
 * 
 * @author Thiago T. Sá
 * @since 1.0
 */
public class NewDatacenter extends javax.swing.JDialog {

	/** The instance of the main form's CloudTree. */
	private CloudTree tree;

	/** Creates a new NewDatacenter form. */
	public NewDatacenter(CloudTree tree) {
		this.tree = tree;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		textField = new javax.swing.JTextField();
		cancelButton = new javax.swing.JButton();
		okButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("New Datacenter");
		setModal(true);
		setResizable(false);

		jLabel1.setText("New datacenter's name:");

		textField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				textFieldKeyPressed(evt);
			}
		});

		cancelButton
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cloudreports/gui/resources/cancel.png"))); // NOI18N
		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cloudreports/gui/resources/ok.png"))); // NOI18N
		okButton.setText("OK");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(textField, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(okButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(cancelButton)))
				.addContainerGap()));

		layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { cancelButton, okButton });

		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cancelButton).addComponent(okButton))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Creates the new datacenter when the OK button is clicked. The name of the
	 * datacenter must be unique.
	 *
	 * @param evt an action event.
	 * @since 1.0
	 */
	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_okButtonActionPerformed
		String name = textField.getText().replaceAll(" ", "");
		DatacenterRegistryDAO drDAO = new DatacenterRegistryDAO();
		CustomerRegistryDAO crDAO = new CustomerRegistryDAO();
		if ((!name.isEmpty()) && (crDAO.getCustomerRegistry(name) == null)
				&& drDAO.insertNewDatacenterRegistry(new DatacenterRegistry(name))) {
			MainView.setDatacenterModified(true);
			tree.insertNode(name, 0);
			dispose();
		} else {
			Dialog.showWarning(this, "Error creating new datacenter.\nPlease try another name.");
		}
	}// GEN-LAST:event_okButtonActionPerformed

	/**
	 * Closes the form when the Cancel button is clicked.
	 *
	 * @param evt an action event.
	 * @since 1.0
	 */
	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
		dispose();
	}// GEN-LAST:event_cancelButtonActionPerformed

	/**
	 * Triggers a click on the OK button when the ENTER key is pressed.
	 *
	 * @param evt an action event.
	 * @since 1.0
	 */
	private void textFieldKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_textFieldKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER)
			okButtonActionPerformed(null);
	}// GEN-LAST:event_textFieldKeyPressed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JButton okButton;
	private javax.swing.JTextField textField;
	// End of variables declaration//GEN-END:variables

}
