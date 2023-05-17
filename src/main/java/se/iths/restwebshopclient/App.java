package se.iths.restwebshopclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class App implements CommandLineRunner {

    @Autowired
    WebShopClient client;
    Product product;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            menu();
        }

    }

    private void menu() {
        System.out.println("""
                1. Lägg till produkt
                2. Uppdatera produkt
                3. Ta bort produkt
                4. Visa alla produkter 
                0. Avsluta
                """);

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> updateProduct();
            case 3 -> deleteProduct();
            case 4 -> allProducts();
            case 0 -> System.exit(0);
        }
    }

    private void allProducts() {
        System.out.println(client.showProducts());
        System.out.println();
    }

    private void addProduct() {
        Category category = null;
        System.out.println("Produkt namn: ");
        String name = scanner.nextLine();
        System.out.println("Kategori: (Frukt,Mejeri,Bröd,Dryck,Annat)");
        category = Category.valueOf(scanner.nextLine());
        System.out.println("Pris: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Product product = client.addProduct(new Product(name, category, price));
        System.out.println(product.getName() + " tillagd\n");
    }

    private void updateProduct() {
        Category category = null;
        System.out.println("Produkt id: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Produkt namn: ");
        String name = scanner.nextLine();
        System.out.println("Kategori: (Frukt,Mejeri,Bröd,Dryck,Annat)");
        category = Category.valueOf(scanner.nextLine());
        System.out.println("Pris: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        client.updateProduct(id, new Product(name, category, price));
        System.out.println("Produkt uppdaterad.\n");
    }

    private void deleteProduct() {
        System.out.println("Produkt id: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        client.deleteProduct(id);
        System.out.println("Produkt bortagen.\n");
    }

}
