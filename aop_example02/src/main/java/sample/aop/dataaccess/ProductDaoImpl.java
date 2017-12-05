package sample.aop.dataaccess;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import sample.aop.business.domain.Product;
import sample.aop.business.service.ProductDao;

import java.util.HashMap;
import java.util.Map;

//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Primary
@Repository("productDao")
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
