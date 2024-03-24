
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static voir main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }

    public class HelloController{
        @GetMapping
        public String sayHello(){
            return "Hello";
        }
    }
}
