package sample.di.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sample.di.business.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    @Qualifier("productDao")
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
