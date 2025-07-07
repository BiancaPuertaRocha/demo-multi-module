package business.b;

import io.micronaut.http.annotation.Controller;
import microservice.b.example.api.DefaultApi;
import microservice.b.example.model.Hello;

@Controller
public class BusinessBControllerImpl implements DefaultApi {
    @Override
    public Hello hello() {
        return null;
    }
}
