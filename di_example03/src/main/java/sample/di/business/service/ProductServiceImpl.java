package sample.di.business.service;

import sample.di.business.domain.Product;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(final Product product) {
        productDao.addProduct(product);
    }

    @Override
    public Product findByProductName(final String name) {
        return productDao.findByProductName(name);
    }
}
