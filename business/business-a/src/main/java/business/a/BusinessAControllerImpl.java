package business.a;

import io.micronaut.http.annotation.Controller;
import microservice.a.example.api.DefaultApi;
import microservice.a.example.model.Hello;

@Controller
public class BusinessAControllerImpl implements DefaultApi {
    @Override
    public Hello hello() {
        return null;
    }
}
