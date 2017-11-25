package sample.di.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.di.business.domain.Product;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public void addProduct(final Product product) {
        productDao.addProduct(product);
    }

    @Override
    public Product findByProductName(final String name) {
        return productDao.findByProductName(name);
    }
}
