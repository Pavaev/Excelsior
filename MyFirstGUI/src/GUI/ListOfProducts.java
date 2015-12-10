package GUI;

import Repository.ProductRepository;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Daniel Shchepetov on 25.11.2015.
 */
public class ListOfProducts {
    public static JFrame getProductPanel() {
        final JFrame listOfProducts = new JFrame();
        listOfProducts.setLayout(new BorderLayout());

       
        listOfProducts.setBackground(Color.GRAY);
        listOfProducts.setBounds(150, 150, 500, 300);


        String[] columnNames = {"Name", "Price", "Category", "Weight", "Manufacturer"};
        String[][] rows = ProductRepository.makeTable();

        final JTable table = new JTable(rows, columnNames);
        table.setEnabled(false);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        listOfProducts.add(scrollPane);

        return listOfProducts;

    }
}
