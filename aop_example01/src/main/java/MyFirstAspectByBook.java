import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import sample.aop.business.domain.Product;

@Aspect
@Component
public class MyFirstAspectByBook {
    @Before("execution(* findProduct(String))")
    public void before() {
        System.out.println("[Before] Hello Aop! 메서드 호출전 수행");
    }

    @After("execution(* findProduct(String))")
    public void after() {
        System.out.println("[After] Hello Aop! 메서드 호출 후 수행");
    }

    @AfterReturning(value = "execution(* findProduct(String))", returning = "product")
    public void afterReturning(Product product) {
        System.out.println("[AfterReturning] Hello Aop! 예외 없이 종료했을 때 수행");
    }

    @Around("execution(* findProduct(String))")
    public Product around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("[Around] Hello Aop! 메서드 호출 전 수행");

        Product product = (Product) proceedingJoinPoint.proceed();

        System.out.println("[Around] Hello Aop! 메서드 호출 후 수행");

        return product;
    }

    @AfterThrowing(value = "execution(* findProduct(String))", throwing = "throwable")
    public void afterThrowing(Throwable throwable) {
        System.out.println("[AfterThrowing] Hello Aop! 예외 발생시 수행");
    }
}
