/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.AdminRole.AdministerUserAccountsWorkResp;

import Business.Business;
import Business.Person.Person;
import Business.Profiles.Profile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import UserInterface.WorkAreas.AdminRole.AdminRoleWorkAreaJPanel;
import javax.swing.JOptionPane;


import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kal bugrara
 */
public class ManageUserAccountsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageSuppliersJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    UserAccount selecteduseraccount;


    public ManageUserAccountsJPanel(Business bz, JPanel jp) {
        CardSequencePanel = jp;
        this.business = bz;
        initComponents();
        refreshTable();

    }

    public void refreshTable() {

//clear supplier table
        int rc = UserAccountTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) UserAccountTable.getModel()).removeRow(i);
        }



        UserAccountDirectory uad = business.getUserAccountDirectory();

       

        for (UserAccount ua : uad.getUserAccountList()) {

            Profile profile = ua.getAssociatedPersonProfile();
            Person person = profile.getPerson();
            Object[] row = new Object[6];
            row[0] = ua;
            row[1] = ua.isIsEnabled();
            row[2] = ua.getRole();
            row[3] = person.getFirstName();
            row[4] = person.getLastName();
            row[5] = person.getEmailID();
            
            System.out.println(person.getFirstName());
 //           row[1] = ua.getStatus(); //complete this..
 //           row[2] = ua.getLastUpdated()
 //           row[3] = 

          ((DefaultTableModel) UserAccountTable.getModel()).addRow(row);
        }

    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserAccountTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back);
        Back.setBounds(30, 300, 74, 22);

        Next.setText("Next >>");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        add(Next);
        Next.setBounds(500, 300, 80, 22);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("User Accounts");
        add(jLabel1);
        jLabel1.setBounds(30, 90, 190, 19);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Manage User Accounts");
        add(jLabel2);
        jLabel2.setBounds(21, 20, 550, 28);

        UserAccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "User Name", "isEnabled", "Role", "First Name", "Last Name", "Email"
            }
        ));
        UserAccountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UserAccountTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(UserAccountTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 550, 130);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        
//        AdminRoleWorkAreaJPanel adminWorkArea = new AdminRoleWorkAreaJPanel(business, CardSequencePanel);
//        CardSequencePanel.remove(this);
//        CardSequencePanel.add(adminWorkArea);
//        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
          
          CardSequencePanel.remove(this);
          ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
 //       ((java.awt.CardLayout)CardSequencePanel.getLayout()).show(CardSequencePanel, "IdentifyEventTypes");

    }//GEN-LAST:event_BackActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        if(selecteduseraccount==null){
            JOptionPane.showMessageDialog(this, "Please select any user");
        }
        else{
            AdminUserAccount mppd = new AdminUserAccount(selecteduseraccount, CardSequencePanel, business);
            CardSequencePanel.add(mppd);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        }
        

    }//GEN-LAST:event_NextActionPerformed

    private void UserAccountTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserAccountTableMousePressed
        // Extracts the row (uaser account) in the table that is selected by the user
        int size = UserAccountTable.getRowCount();
        int selectedrow = UserAccountTable.getSelectionModel().getLeadSelectionIndex();

        if (selectedrow < 0 || selectedrow > size - 1) {
            return;
        }
        selecteduseraccount = (UserAccount) UserAccountTable.getValueAt(selectedrow, 0);
        if (selecteduseraccount == null) {
            return;
        
        
            
    }//GEN-LAST:event_UserAccountTableMousePressed
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Next;
    private javax.swing.JTable UserAccountTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
