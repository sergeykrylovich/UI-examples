package ui.annotations;

import org.junit.jupiter.api.extension.ExtendWith;
import ui.utils.SetupChromeDriver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ExtendWith(SetupChromeDriver.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ChromeSetUp {
}
