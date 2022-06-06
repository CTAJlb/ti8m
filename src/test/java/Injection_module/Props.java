package Injection_module;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@ToString
public class Props {

    public String baseUrl;
    public String browser;



    public Props(){
        getProperties();
    }

    public void getProperties() {
        Properties prop = new Properties();
        InputStream input;
        try {
            input = Files.newInputStream(Paths.get("src/test/resources/config.properties"));
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.baseUrl = prop.getProperty("baseUrl");
        this.browser = prop.getProperty("browser");

    }

}
