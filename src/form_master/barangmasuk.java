package form_master;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import koneksi.Koneksi_Apotek;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author User
 */
public class barangmasuk extends javax.swing.JFrame {
private Connection conn = new Koneksi_Apotek () .connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form barangmasuk
     */
    public barangmasuk() {
        initComponents();
        kosong();
        aktif();
        datatable();
        }
    protected void aktif(){
        kdo.requestFocus();
    }
    
    protected void kosong(){
        try {
            kdo.removeAllItems();
            String sql = "SELECT nm_obat FROM obat";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                String namaObat = rs.getString("nm_obat");
                DefaultComboBoxModel model = (DefaultComboBoxModel)kdo.getModel();
                if(model.getIndexOf(namaObat) == -1) {
                    kdo.addItem(namaObat);
                }
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }   
        
        try {
            supp.removeAllItems();
            String sql = "SELECT npt FROM supplier";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                String supplier = rs.getString("npt");
                DefaultComboBoxModel model = (DefaultComboBoxModel)supp.getModel();
                if(model.getIndexOf(supplier) == -1) {
                    supp.addItem(supplier);
                }
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }   
        txtstok.setText("");
        tglm.setDate(null);
    }
   
protected void datatable(){
            Object[] Baris ={"Kode Obat", "Supplier", "Tanggal Masuk", "Stok"};
                tabmode= new DefaultTableModel(null, Baris);
                String cariitem=txtcari.getText();
                
                try {
                     String sql = "SELECT o.nm_obat, b.kdo, s.npt, b.tgl, b.stok FROM barangmasuk b INNER JOIN supplier s ON b.supp = s.kpt INNER JOIN obat o ON o.kd_obat = b.kdo where b.kdo like '%"+cariitem+"%' " + "or b.supp like'%"+cariitem+"%' order by b.kdo asc"; Statement stat = conn.createStatement();
                    ResultSet hasil = stat.executeQuery(sql);
                    while (hasil.next()){
                        tabmode.addRow(new Object[]{
                            hasil.getString("kdo"),
                            hasil.getString("npt"),
                            hasil.getString("tgl"),
                            hasil.getString("stok")
                        });
                    }
                    tblbrgm.setModel (tabmode);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
                }
}

private java.util.Date getDate(String date){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(barangmasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

private String getDateString(){
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        return dcn.format(tglm.getDate());
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bubah = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbrgm = new javax.swing.JTable();
        tglm = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtstok = new javax.swing.JTextField();
        supp = new javax.swing.JComboBox<>();
        kdo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("BARANG MASUK");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Kode Obat");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("supplier");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Tgl Masuk");

        bubah.setText("Ubah");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        jButton6.setText("Cari");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tblbrgm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblbrgm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbrgmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbrgm);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Stok");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(bsimpan))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(bubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(bkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(92, 92, 92)
                                .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tglm, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(supp, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kdo, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bhapus, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bsimpan)
                    .addComponent(kdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bubah)
                    .addComponent(supp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bhapus)
                    .addComponent(tglm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bbatal))
                .addGap(18, 18, 18)
                .addComponent(bkeluar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        try{
            String sqlSearchIdObat = "SELECT kd_obat FROM obat where nm_obat like '%"+kdo.getSelectedItem()+"%'";
            Statement statIdObat = conn.createStatement();
            ResultSet rsObat = statIdObat.executeQuery(sqlSearchIdObat);
            String kodeObat = "";
            if(rsObat.next()) {
               kodeObat = rsObat.getString(1);
            }
            
            String sqlSearchObat = "SELECT COUNT(kdo) FROM barangmasuk where kdo like '%"+kodeObat+"%'";
            Statement statObat = conn.createStatement();
            ResultSet rsAdaObat = statObat.executeQuery(sqlSearchObat);
            int adaObat = 0;
            if(rsAdaObat.next()) {
               adaObat = rsAdaObat.getInt(1);
            }
            
            if(adaObat == 1) {
                String sql ="UPDATE barangmasuk set tgl=?,stok=stok+? where kdo='"+kodeObat+"'";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, getDateString());
                stat.setString(2, txtstok.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "stok berhasil ditambahkan");
            } else {
                String sql ="insert into barangmasuk values (NULL,?,?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, kodeObat);

                String sqlSearchIdSupplier = "SELECT kpt FROM supplier where npt like '%"+supp.getSelectedItem()+"%'";
                Statement statIdSupplier = conn.createStatement();
                ResultSet rsSupplier = statIdSupplier.executeQuery(sqlSearchIdSupplier);
                String supplierCode = "";
                if(rsSupplier.next()) {
                   supplierCode = rsSupplier.getString(1);
                }
                stat.setString(2, supplierCode);
                stat.setString(3, getDateString());
                stat.setString(4, txtstok.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            }
            kosong();
            kdo.requestFocus();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        datatable();        // TODO add your handling code here:
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        try{
            String sqlSearchIdObat = "SELECT kd_obat FROM obat where nm_obat like '%"+kdo.getSelectedItem()+"%'";
            Statement statIdObat = conn.createStatement();
            ResultSet rsObat = statIdObat.executeQuery(sqlSearchIdObat);
            String kodeObat = "";
            if(rsObat.next()) {
               kodeObat = rsObat.getString(1);
            }
            
            String sql ="UPDATE barangmasuk set tgl=?,stok=? where kdo='"+kodeObat+"'";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, getDateString());
            stat.setString(2, txtstok.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            kdo.requestFocus();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        datatable();        // TODO add your handling code here:
    }//GEN-LAST:event_bubahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasi dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            try {
                String sqlSearchIdObat = "SELECT kd_obat FROM obat where nm_obat like '%"+kdo.getSelectedItem()+"%'";
                Statement statIdObat = conn.createStatement();
                ResultSet rsObat = statIdObat.executeQuery(sqlSearchIdObat);
                String kodeObat = "";
                if(rsObat.next()) {
                   kodeObat = rsObat.getString(1);
                }
                String sql = "Delete from barangmasuk where kdo ='"+kodeObat+"'";
                try{
                    PreparedStatement stat = conn.prepareStatement(sql); 
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                    kosong ();
                    kdo.requestFocus();
                    }
                catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "data gagal dihapus "+e); 
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
            }
        
            datatable ();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bhapusActionPerformed

    private void tblbrgmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbrgmMouseClicked
        try {
            int bar = tblbrgm.getSelectedRow();
            String a = tabmode.getValueAt(bar,0).toString();
            String b = tabmode.getValueAt(bar,1).toString();
            String c = tabmode.getValueAt(bar,2).toString();
            String d = tabmode.getValueAt(bar,3).toString();
            
            String sqlSearchNmObat = "SELECT nm_obat FROM obat where kd_obat like '%"+a+"%'";
            Statement statNmObat = conn.createStatement();
            ResultSet rsObat = statNmObat.executeQuery(sqlSearchNmObat);
            String nmObat = "";
            if(rsObat.next()) {
                nmObat = rsObat.getString(1);
            }
            
            String sqlSearchNmSupplier = "SELECT npt FROM supplier where kpt like '%"+b+"%'";
            Statement statNmSupplier = conn.createStatement();
            ResultSet rsSupplier = statNmSupplier.executeQuery(sqlSearchNmSupplier);
            String nmSupplier = "";
            if(rsSupplier.next()) {
                nmSupplier = rsObat.getString(1);
            }

                kdo.setSelectedItem(nmObat);
                supp.setSelectedItem(b);
                tglm.setDate(getDate(c));
                txtstok.setText(d);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal dibaca"+e);
        }
    }//GEN-LAST:event_tblbrgmMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
datatable();          // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
if(evt.getKeyCode()== KeyEvent.VK_ENTER){
    datatable();}         // TODO add your handling code here:
    }//GEN-LAST:event_txtcariKeyPressed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
kosong();
datatable();         // TODO add your handling code here:
    }//GEN-LAST:event_bbatalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_bkeluarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barangmasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kdo;
    private javax.swing.JComboBox<String> supp;
    private javax.swing.JTable tblbrgm;
    private com.toedter.calendar.JDateChooser tglm;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}