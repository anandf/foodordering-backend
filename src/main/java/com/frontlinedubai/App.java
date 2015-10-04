
import com.frontlinedubai.config.WebConfig;
import com.frontlinedubai.service.impl.FoodOrderingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan({ "com.frontlinedubai" })
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        new WebConfig(ctx.getBean(FoodOrderingService.class));
        ctx.registerShutdownHook();
    }


}