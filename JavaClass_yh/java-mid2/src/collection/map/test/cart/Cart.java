package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartMap = new HashMap<>();

    public void add(Product product, int count){
        cartMap.put(product, cartMap.getOrDefault(product, 0) + count);
    }
    public void minus(Product product, int count){
        int update = cartMap.getOrDefault(product, 0) - count;
        if(update <= 0){
            cartMap.remove(product);
            return;
        }
        cartMap.put(product, update);
    }
    public void printAll() {
        System.out.println("== 모든 상품 출력 ==");
//        for (Product product : cartMap.keySet()) {
//            System.out.println("상품: " + product + " 수량: " + cartMap.get(product));
//        }
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            System.out.println("상품: " + entry.getKey() + " 수량: " + entry.getValue());
        }
    }
}
