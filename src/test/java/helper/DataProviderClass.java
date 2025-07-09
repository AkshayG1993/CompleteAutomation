package helper;

import com.reqres.pojos.requestPojos.RegisterUser;
import org.testng.annotations.DataProvider;

import static helper.builder.BackendBuilderClass.getFreshUserForRegister;

public class DataProviderClass {

    @DataProvider(parallel = true)
    public Object[][] registerUserNegativeDataProvider() {
        RegisterUser registerUser = getFreshUserForRegister();
        return new Object[][]{
                {registerUser.toBuilder().email(null).build(), "Missing email or username"},
                {registerUser.toBuilder().password(null).build(), "Missing password"},
                {registerUser.toBuilder().email(null).password(null).build(), "Missing email or username"}
        };
    }
}
