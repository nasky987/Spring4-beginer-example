package sample.di.business.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.AppConfig;
import sample.di.business.domain.Product;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Test
    public void testFindProduct() {
        final Product addProduct = new Product("공책", 100);
        productService.addProduct(addProduct);

        final Product findProduct = productService.findByProductName("공책");

        assertThat(findProduct, equalTo(addProduct));
    }
}
