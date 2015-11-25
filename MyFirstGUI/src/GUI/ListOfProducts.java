package GUI;

import Repository.ProductRepository;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Daniel Shchepetov on 25.11.2015.
 */
public class ListOfProducts {
    public static JPanel getProductPanel() {
        final JPanel listOfProducts = new JPanel();
        listOfProducts.setLayout(new BorderLayout());

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
