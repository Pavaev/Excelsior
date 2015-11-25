package Repository;

import Entities.Product;
import Exceptions.ProductException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;


public class ProductRepository {

    private static final String MYURL = "http://localhost:3000/product";

    public static void addProduct(Product product) throws ProductException, IOException {

        try {
            validateProduct(product);


            URL obj = new URL(MYURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");

            String urlParameters = "name=" + product.getName() + "&price=" + product.getPrice() + "&category=" + product.getCategory() + "&weight=" + product.getWeight() + "&manufacturer=" + product.getManufacturer();

            con.setDoOutput(true);

            DataOutputStream dataOutputStream = new DataOutputStream(con.getOutputStream());
            dataOutputStream.writeBytes(urlParameters);
            dataOutputStream.flush();
            dataOutputStream.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + MYURL);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);
        } catch (ProductException e) {
            e.printStackTrace();
            throw e;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getAllProducts() {
        HttpURLConnection con;
        String string = null;
        StringBuffer json = new StringBuffer();
        try {
            con = (HttpURLConnection) ((new URL(MYURL).openConnection()));
            con.setRequestMethod("GET");
            con.setDoInput(true);


            BufferedReader input = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));


            while ((string = input.readLine()) != null) {
                json.append(string);
            }
            input.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    private static ArrayList getAllProductsList() {
        String string = getAllProducts();
        JSONParser parser = new JSONParser();
        ArrayList<Product> list = new ArrayList<>();
        try {
            Object obj = parser.parse(string);
            JSONArray jsonArr = (JSONArray) obj;
            for (int i = 0; i < jsonArr.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArr.get(i);
                String name = String.valueOf(jsonObject.get("name"));
                String price = String.valueOf(jsonObject.get("price"));
                String category = String.valueOf(jsonObject.get("category"));
                String weight = String.valueOf(jsonObject.get("weight"));
                String manufacturer = String.valueOf(jsonObject.get("manufacturer"));
                Product product = new Product(name, Integer.parseInt(price), category, Integer.parseInt(weight), manufacturer);
                list.add(product);

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String[][] makeTable() {
        ArrayList<Product> list = getAllProductsList();
        String[][] products = new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            products[i][0] = list.get(i).getName();
            products[i][1] = String.valueOf(list.get(i).getPrice());
            products[i][2] = list.get(i).getCategory();
            products[i][3] = String.valueOf(list.get(i).getWeight());
            products[i][4] = list.get(i).getManufacturer();

        }
        return products;
    }


    public static void validateProduct(Product product) throws ProductException {

        if (product.getName() == "" || product.getCategory() == "") {
            throw new ProductException("All fields must be filled");
        }
        if (product.getWeight() <= 0 || product.getPrice() < 0) {
            throw new ProductException("Price and weight can't be less than zero");
        }
    }
}