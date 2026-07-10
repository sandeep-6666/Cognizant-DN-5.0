class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }
}

public class dsaex2 {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(104, "Headphones", "Electronics"),
            new Product(105, "Watch", "Fashion")
        };

        int targetId = 104;
        Product[] sorted = sortedProducts(products);

        int linearIndex = linearSearch(products, targetId);
        int binaryIndex = binarySearch(sorted, targetId);

        System.out.println("Linear Search:");
        if (linearIndex != -1) {
            System.out.println("Found product: " + products[linearIndex].getProductName());
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\nBinary Search:");
        if (binaryIndex != -1) {
            System.out.println("Found product: " + sorted[binaryIndex].getProductName());
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\nAnalysis:");
        System.out.println("Big O notation describes how algorithm time grows with input size.");
        System.out.println("Linear search: best O(1), average O(n), worst O(n).");
        System.out.println("Binary search: best O(1), average O(log n), worst O(log n).");
        System.out.println("Binary search is more suitable for a large e-commerce platform because it is faster on sorted data.");
    }

    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i;
            }
        }
        return -1;
    }

    public static Product[] sortedProducts(Product[] products) {
        Product[] sorted = products.clone();
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - i - 1; j++) {
                if (sorted[j].getProductId() > sorted[j + 1].getProductId()) {
                    Product temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    public static int binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == targetId) {
                return mid;
            }
            if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
