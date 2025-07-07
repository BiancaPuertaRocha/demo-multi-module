package microservice.b;

import business.b.BusinessBControllerImpl;
import io.micronaut.openapi.annotation.OpenAPIInclude;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "demo",
                version = "0.0"
        )
)
//@OpenAPIInclude(classes = BusinessBControllerImpl.class)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}