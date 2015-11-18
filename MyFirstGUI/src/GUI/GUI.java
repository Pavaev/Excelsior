package GUI;

import Entities.Product;
import Repository.ProductRepository;
import Utilities.DBService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GUI extends JFrame {
    public GUI() {
        super("GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.GRAY);

        Font font = new Font("Verdana", Font.PLAIN, 16);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);


        JPanel productContent = new JPanel();
        productContent.setLayout(new GridBagLayout());

        JPanel categoryContent = new JPanel();
        categoryContent.setLayout(new GridBagLayout());

        JPanel listOfProducts = new JPanel();
        listOfProducts.setLayout(new BorderLayout());

        tabbedPane.addTab("Products", productContent);
        tabbedPane.addTab("Categories", categoryContent);
        tabbedPane.addTab("List Of Products", listOfProducts);

        JLabel topLabel = new JLabel("Add a new product: ");
        topLabel.setFont(font);
        productContent.add(topLabel, this.setTopLabelConstraints());

        JLabel nameLabel = new JLabel("Name: ");
        productContent.add(nameLabel, this.setLabelConstraints());
        JTextField nameF = new JTextField(20);
        productContent.add(nameF, this.setTextFieldConstraints());

        JLabel priceLabel = new JLabel("Price: ");
        productContent.add(priceLabel, this.setLabelConstraints());
        JTextField priceF = new JTextField(10);
        productContent.add(priceF, this.setTextFieldConstraints());

        JLabel categoryLabel = new JLabel("Category: ");
        productContent.add(categoryLabel, this.setLabelConstraints());
        JTextField categoryF = new JTextField(20);
        productContent.add(categoryF, this.setTextFieldConstraints());

        JLabel manufacturerLabel = new JLabel("Manufacturer: ");
        productContent.add(manufacturerLabel, this.setLabelConstraints());
        JTextField manufacturerF = new JTextField(20);
        productContent.add(manufacturerF, this.setTextFieldConstraints());

        JLabel weightLabel = new JLabel("Weight: ");
        productContent.add(weightLabel, this.setLabelConstraints());
        JTextField weightF = new JTextField(10);
        productContent.add(weightF, this.setTextFieldConstraints());


        JButton addProductButton = new JButton("Add");
        ActionListener addListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        addProductButton.addActionListener(addListener);
        productContent.add(addProductButton);


        JLabel categoryNameLabel = new JLabel("Name: ");
        categoryContent.add(categoryNameLabel, this.setLabelConstraints());
        JTextField categoryNameF = new JTextField(20);
        categoryContent.add(categoryNameF, this.setTextFieldConstraints());

        JButton addCategoryButton = new JButton("Add");
        ActionListener addCategoryListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        addCategoryButton.addActionListener(addCategoryListener);
        categoryContent.add(addCategoryButton);

        String[][] rows = ProductRepository.getAll();
        String[] columnNames = {"Name", "Price", "Weight", "Manufacturer"};

        JTable table = new JTable(rows, columnNames);
        table.setEnabled(false);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        listOfProducts.add(scrollPane);

        this.add(tabbedPane);
        this.setBounds(150, 150, 500, 300);


    }

    private GridBagConstraints setLabelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.anchor = GridBagConstraints.BASELINE_LEADING;
        c.weightx = 0.0;


        return c;
    }

    private GridBagConstraints setTextFieldConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.anchor = GridBagConstraints.BASELINE;
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;
        return c;
    }

    private GridBagConstraints setTopLabelConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.BASELINE_LEADING;
        c.weightx = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        return c;
    }


}
