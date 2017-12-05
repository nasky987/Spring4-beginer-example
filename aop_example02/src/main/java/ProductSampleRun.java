import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.aop.business.domain.Product;
import sample.aop.business.service.ProductService;

public class ProductSampleRun {
    public static void main(String[] args) {
        final ProductSampleRun productSampleRun = new ProductSampleRun();

        productSampleRun.execute();
    }

    public void execute() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final ProductService productService = applicationContext.getBean(ProductService.class);

        productService.addProduct(new Product("공책", 100));

        final Product product = productService.findByProductName("공책");

        System.out.println(product);
    }
}
