package helpers;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Screenshot {
    WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void doScreenshot(WebDriver driver,String screenName) throws IOException {
        this.driver = driver;

        ru.yandex.qatools.ashot.Screenshot screen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

        ImageIO.write(screen.getImage(), "jpg", new File(new File("screenshots/" + screenName + ".jpg").getAbsolutePath()));

    }


}
