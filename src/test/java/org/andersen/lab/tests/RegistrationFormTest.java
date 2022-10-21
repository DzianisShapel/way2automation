package org.andersen.lab.tests;

import org.andersen.lab.base.BaseTest;
import org.andersen.lab.objects.User;
import org.andersen.lab.pages.RegistrationForm;
import org.andersen.lab.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class RegistrationFormTest extends BaseTest {

    @Test
    public void SuccesfullRegistration () throws IOException {
        User user = JacksonUtils.deserializeJson("user.json", User.class);
        RegistrationForm registrationForm = new RegistrationForm(getDriver()).load();
        registrationForm.fillTheFormCorrectly(user).submitForm();

        Assert.assertEquals(registrationForm.getHeading(), "Registration");
    }

    @Test
    public void FailedRegistration() throws IOException {
        User user = JacksonUtils.deserializeJson("user.json", User.class);
        RegistrationForm registrationForm = new RegistrationForm(getDriver()).load();
        registrationForm.fillTheFormWithoutPasswordConfirmation(user).submitForm();
        Assert.assertEquals(registrationForm.getConfirmPasswordLabel(), "This field is required.");
    }
}
