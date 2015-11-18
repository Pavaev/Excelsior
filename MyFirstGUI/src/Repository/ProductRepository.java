package Repository;

import Entities.Product;
import Utilities.DBService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {

    public static void addProduct(Product product) {
    }

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> list = new ArrayList<>();
        Connection connection = DBService.connect();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT pname, price, weight, manufacturer FROM products");
            while (result.next()) {
                String name = result.getString(1);
                int price = result.getInt(2);
                int weight = result.getInt(3);
                String manufacturer = result.getString(4);


                list.add(new Product(name, price, weight, manufacturer));
            }


        } catch (SQLException e) {
            System.err.println("Проблемы с базой данных");
        }
        return list;
    }

    public static Product getProduct() {

        return null;
    }



        public static void moveProduct() {
    }
public static String[][] getAll(){
    ArrayList<Product> list = getAllProducts();
    String [][] products = new String[list.size()][4];
    for (int i = 0; i<list.size(); i++){
        products[i][0] = list.get(i).getName();
        products[i][1] = String.valueOf(list.get(i).getPrice());
        products[i][2] = String.valueOf(list.get(i).getWeight());
        products[i][3] = list.get(i).getManufacturer();

    }
    return products;
}
}
