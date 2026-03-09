/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.CardLayout;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Nandika
 */
public class ProductRegistration extends javax.swing.JPanel {

    Main m;
    RepairRequest rr;
    StockUpdate su;
    CardLayout cl;

    /**
     * Creates new form ProductRegistration
     */
    public ProductRegistration(Main m) {
        initComponents();
        loadProducts();
        loadCategories();
        loadBrands();
        loadSeries();
        loadModels();
        loadUnits();
        this.m = m;
        cl = (CardLayout) m.jPanel4.getLayout();
    }

    public ProductRegistration(Main m, StockUpdate su) {
        initComponents();
        loadProducts();
        loadCategories();
        loadBrands();
        loadSeries();
        loadModels();
        loadUnits();
        this.m = m;
        this.su = su;
        cl = (CardLayout) m.jPanel4.getLayout();
    }

    public ProductRegistration(Main m, RepairRequest rr) {
        initComponents();
        loadProducts();
        loadCategories();
        loadBrands();
        loadSeries();
        loadModels();
        loadUnits();
        this.m = m;
        this.rr = rr;
        cl = (CardLayout) m.jPanel4.getLayout();
    }

    private void loadProducts() {
        try {
            ResultSet rs = MySQL.search("SELECT `product`.`id`, `category`.`name` AS 'category', `brand`.`name` AS 'brand', `series`.`name` AS 'series', `brand_has_series`.`modelno` AS 'model', `product`.`name`, `unit`.`name` AS 'unit' FROM `product` INNER JOIN `brand_has_series` ON `product`.`brand_has_series_id` = `brand_has_series`.`id` INNER JOIN `category` ON `product`.`category_id` = `category`.`id` INNER JOIN `brand` ON `brand_has_series`.`brand_id` = `brand`.`id` INNER JOIN `series` ON `brand_has_series`.`series_id` = `series`.`id` INNER JOIN `unit` ON `product`.`unit_id` = `unit`.`id` ORDER BY `id` ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("category"));
                v.add(rs.getString("brand"));
                v.add(rs.getString("series"));
                v.add(rs.getString("model"));
                v.add(rs.getString("name"));
                v.add(rs.getString("unit"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
        }
    }

    private void loadProducts(String text) {
        try {
            ResultSet rs = MySQL.search("SELECT `product`.`id`, `category`.`name` AS 'category', `brand`.`name` AS 'brand', `model`.`name` AS 'model', `product`.`name`, `unit`.`name` AS 'unit' FROM `product` INNER JOIN `model_has_brand` ON `product`.`model_has_brand_id` = `model_has_brand`.`id` INNER JOIN `category` ON `model_has_brand`.`category_id` = `category`.`id` INNER JOIN `model` ON `model_has_brand`.`model_id` = `model`.`id` INNER JOIN `brand` ON `model_has_brand`.`brand_id` = `brand`.`id` INNER JOIN `unit` ON `product`.`unit_id` = `unit`.`id` WHERE `product`.`name` LIKE '%" + text + "%' `name` ORDER BY `id` ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("category"));
                v.add(rs.getString("brand"));
                v.add(rs.getString("model"));
                v.add(rs.getString("unit"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
        }
    }

    public final void loadCategories() {
        try {
            ResultSet rs = MySQL.search("SELECT `name` FROM `category`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            jComboBox1.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
        }
    }

    public final void loadBrands() {
        try {
            ResultSet rs = MySQL.search("SELECT `name` FROM `brand`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            jComboBox2.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
        }
    }

    public final void loadSeries() {
        try {
            ResultSet rs = MySQL.search("SELECT `name` FROM `series`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            jComboBox3.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
        }
    }

    public final void loadModels() {
        try {
            ResultSet rs = MySQL.search("SELECT `modelno` FROM `brand_has_series`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("modelno"));
            }

            jComboBox4.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
        }
    }

    private void loadUnits() {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `unit`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            jComboBox5.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Product Name");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Category");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Brand");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Series");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton7.setText("Add Product");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Model");

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel22.setText("Quantity Unit");

        jComboBox5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jButton4))
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jButton5))
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jButton6))
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Brand", "Series", "Model", "Name", "Quantity Unit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(32);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Search Product:");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Hint: If product name is left empty, the system will generate the name according to the data provided.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CategoryRegistration cr = new CategoryRegistration(m, this);

        m.jPanel4.add(cr);
        cl.next(m.jPanel4);
        m.jPanel4.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        BrandRegistration br = new BrandRegistration(m, this);

        m.jPanel4.add(br);
        cl.next(m.jPanel4);
        m.jPanel4.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SeriesRegistration sr = new SeriesRegistration(m, this);

        m.jPanel4.add(sr);
        cl.next(m.jPanel4);
        m.jPanel4.revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ModelRegistration mr = new ModelRegistration(m, this);

        m.jPanel4.add(mr);
        cl.next(m.jPanel4);
        m.jPanel4.revalidate();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String name;
        if (jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(m, "Please select category", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jComboBox2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(m, "Please select brand", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jComboBox3.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(m, "Please select series", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jComboBox4.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(m, "Please select model", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jComboBox5.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(m, "Please select quantity unit", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (jTextField1.getText().isBlank()) {
                name = jComboBox2.getSelectedItem().toString() + " " + jComboBox3.getSelectedItem().toString() + " " + jComboBox4.getSelectedItem().toString();
            } else {
                name = jTextField1.getText();
            }
            String category = jComboBox1.getSelectedItem().toString();
            String brand = jComboBox2.getSelectedItem().toString();
            String series = jComboBox3.getSelectedItem().toString();
            String model = jComboBox4.getSelectedItem().toString();
            String unit = jComboBox5.getSelectedItem().toString();

            try {
                ResultSet rs = MySQL.search("SELECT * FROM `product` INNER JOIN `brand_has_series` ON `product`.`brand_has_series_id` = `brand_has_series`.`id` INNER JOIN `category` ON `product`.`category_id` = `category`.`id` INNER JOIN `brand` ON `brand_has_series`.`brand_id` = `brand`.`id` INNER JOIN `series` ON `brand_has_series`.`series_id` = `series`.`id` WHERE `product`.`name` = '" + name + "' AND `brand`.`name` = '" + brand + "' AND `category`.`name` = '" + category + "' AND `series`.`name` = '" + series + "' AND `brand_has_series`.`modelno` = '" + model + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(m, "Product already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    ResultSet rs1 = MySQL.search("SELECT `id` FROM `brand` WHERE `name` = '" + brand + "'");
                    rs1.next();
                    String brand_id = rs1.getString("id");

                    ResultSet rs2 = MySQL.search("SELECT `id` FROM `series` WHERE `name` = '" + series + "'");
                    rs2.next();
                    String series_id = rs2.getString("id");

                    ResultSet rs3 = MySQL.search("SELECT `id` FROM `brand_has_series` WHERE `brand_id` = '" + brand_id + "' AND `series_id` = '" + series_id + "' AND `modelno` = '" + model + "'");
                    if (!rs3.next()) {
                        JOptionPane.showMessageDialog(m, "Product brand, series and model number combination does not exist", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    String brand_has_series_id = rs3.getString("id");

                    ResultSet rs4 = MySQL.search("SELECT `id` FROM `category` WHERE `name` = '" + category + "'");
                    rs4.next();
                    String category_id = rs4.getString("id");

                    ResultSet rs5 = MySQL.search("SELECT `id` FROM `unit` WHERE `name` = '" + unit + "'");
                    rs5.next();
                    String unit_id = rs4.getString("id");

                    MySQL.iud("INSERT INTO `product` (`category_id`, `brand_has_series_id`, `name`, unit_id) VALUES ('" + category_id + "', '" + brand_has_series_id + "', '" + name + "', '" + unit_id + "')");

                    jTextField1.setText("");
                    jComboBox1.setSelectedIndex(0);
                    jComboBox2.setSelectedIndex(0);
                    jComboBox3.setSelectedIndex(0);
                    jComboBox4.setSelectedIndex(0);
                    jComboBox5.setSelectedIndex(0);

                    loadProducts();
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int r = jTable1.getSelectedRow();

        if (r == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (evt.getClickCount() == 2) {
                if (this.rr != null) {
                    String pid = jTable1.getValueAt(r, 0).toString();
                    String pname = jTable1.getValueAt(r, 5).toString();
                    String category = jTable1.getValueAt(r, 1).toString();
                    String brand = jTable1.getValueAt(r, 2).toString();
                    String series = jTable1.getValueAt(r, 3).toString();

                    rr.jLabel17.setText(pid);
                    rr.jLabel19.setText(pname);
                    rr.jLabel23.setText(category);
                    rr.jLabel21.setText(brand);
                    rr.jLabel25.setText(series);

                    m.backButton(this);
                } else if (this.su != null) {
                    String pid = jTable1.getValueAt(r, 0).toString();
                    String pname = jTable1.getValueAt(r, 5).toString();
                    String category = jTable1.getValueAt(r, 1).toString();
                    String brand = jTable1.getValueAt(r, 2).toString();
                    String series = jTable1.getValueAt(r, 3).toString();
                    String model = jTable1.getValueAt(r, 4).toString();
                    String unit = jTable1.getValueAt(r, 6).toString();

                    su.jLabel10.setText(pid);
                    su.jLabel12.setText(pname);
                    su.jLabel14.setText(category);
                    su.jLabel16.setText(brand);
                    su.jLabel18.setText(series);
                    su.jLabel20.setText(model);
                    su.jLabel23.setText(unit);
                    m.backButton(this);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String text = jTextField2.getText();
        loadProducts(text);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        m.backButton(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        m.homeButton();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
