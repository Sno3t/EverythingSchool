import java.util.ArrayList;

public class Container {
    private int id;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Container() {
    }

    public void add(Product product) {
        products.add(product);
    }

    public void addAll(ArrayList<Product> products) {
        this.products.addAll(products);
    }

    public ArrayList<Product> getItemList() {
        return products;
    }

    public void removeProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdentifier().equals(id)) {
                products.remove(i);
            }
        }
    }

    public void printProductList() {
        for (Product product : products) {
//            System.out.println("ID: " + product.getIdentifier() + "Name" + product.getName());
            System.out.println(product.toString());
        }
    }
}
