package GUI;

import Entities.Product;
import Repository.ProductRepository;
import Utilities.GUIService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel Shchepetov on 25.11.2015.
 */
public class ProductAdd {


    public static JPanel getPanel() {


        final Font font = new Font("Verdana", Font.PLAIN, 16);
        final JPanel productContent = new JPanel();
        productContent.setLayout(new GridBagLayout());


        JLabel topLabel = new JLabel("Add a new product: ");
        topLabel.setFont(font);
        productContent.add(topLabel, GUIService.setTopLabelConstraints());

        JLabel nameLabel = new JLabel("Name: ");
        productContent.add(nameLabel, GUIService.setLabelConstraints());
        final JTextField nameF = new JTextField(20);
        productContent.add(nameF, GUIService.setTextFieldConstraints());

        JLabel priceLabel = new JLabel("Price: ");
        productContent.add(priceLabel, GUIService.setLabelConstraints());
        final JTextField priceF = new JTextField(10);
        productContent.add(priceF, GUIService.setTextFieldConstraints());

        JLabel categoryLabel = new JLabel("Category: ");
        productContent.add(categoryLabel, GUIService.setLabelConstraints());
        String[] items = {
                "White goods",
                "Computers",
                "Mobile telephones"
        };
        final JComboBox categoryF = new JComboBox(items);
        productContent.add(categoryF, GUIService.setTextFieldConstraints());

        JLabel manufacturerLabel = new JLabel("Manufacturer: ");
        productContent.add(manufacturerLabel, GUIService.setLabelConstraints());
        final JTextField manufacturerF = new JTextField(20);
        productContent.add(manufacturerF, GUIService.setTextFieldConstraints());

        JLabel weightLabel = new JLabel("Weight: ");
        productContent.add(weightLabel, GUIService.setLabelConstraints());
        final JTextField weightF = new JTextField(10);
        productContent.add(weightF, GUIService.setTextFieldConstraints());

        JButton addProductButton = new JButton("Add");
        ActionListener addListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameF.getText();
                String price = priceF.getText();
                String category = (String) categoryF.getSelectedItem();
                String weight = weightF.getText();
                String manufacturer = manufacturerF.getText();
                String message;
                try {
                    Product product = new Product(name, Integer.parseInt(price), category, Integer.parseInt(weight), manufacturer);
                    ProductRepository.addProduct(product);
                    message = "Product has been added";
                } catch (Exception ex) {
                    message = "Something is bad: " + ex.getMessage();
                    ex.printStackTrace();


                }
                JOptionPane.showMessageDialog(productContent, message);
                nameF.setText(null);
                priceF.setText(null);
                weightF.setText(null);
                manufacturerF.setText(null);


            }
        };
        addProductButton.addActionListener(addListener);
        productContent.add(addProductButton);

        final JButton listButton = new JButton("List of Products");
        ActionListener listListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame listOfProducts = new JFrame();
                listOfProducts = ListOfProducts.getProductPanel();
                listOfProducts.setVisible(true);


            }
        };

        listButton.addActionListener(listListener);
        productContent.add(listButton);


        return productContent;
    }


}
