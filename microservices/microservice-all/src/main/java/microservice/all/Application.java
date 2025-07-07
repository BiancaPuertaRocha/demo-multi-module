package microservice.all;

import business.a.BusinessAControllerImpl;
import business.b.BusinessBControllerImpl;
import io.micronaut.openapi.annotation.OpenAPIInclude;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.jar.JarFile;

@OpenAPIDefinition(
        info = @Info(
                title = "demo",
                version = "0.0"
        )
)
//@OpenAPIInclude(classes = {BusinessAControllerImpl.class, BusinessBControllerImpl.class})
public class Application {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources("");

        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            String protocol = url.getProtocol();

            if ("file".equals(protocol)) {
                File dir = new File(URLDecoder.decode(url.getPath(), "UTF-8"));
                listFiles(dir, dir.getAbsolutePath());
            }
        }

        Micronaut.run(Application.class, args);
    }


    private static void listFiles(File dir, String base) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                listFiles(file, base);
            } else {
                System.out.println("→ " + file.getAbsolutePath().substring(base.length() + 1));
            }
        }
    }
}