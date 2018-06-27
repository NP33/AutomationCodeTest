package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadData {

    public ReadData() {
        readProperties();
    }


    String url;
    String browser;
    String zipCode;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * read properties of a test data file
     **/
    private void readProperties() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/test/resources/testdata.properties");
            prop.load(input);
            setUrl(prop.getProperty("url"));
            setBrowser(prop.getProperty("browser"));
            setZipCode(prop.getProperty("zipcode"));

        } catch (Exception e) {
            throw new RuntimeException("Failed due to exception: " + e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException("Failed due to IOException: " + e);
                }
            }

        }
    }

}
