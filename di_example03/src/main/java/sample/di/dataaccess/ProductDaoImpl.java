package sample.di.dataaccess;

import sample.di.business.domain.Product;
import sample.di.business.service.ProductDao;

import java.util.HashMap;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    private Map<String, Product> storage = new HashMap<>();

    @Override
    public void addProduct(final Product product) {
        storage.put(product.getName(), product);
    }

    @Override
    public Product findByProductName(final String name) {
        return storage.get(name);
    }
}
