package helper.builder;

import com.reqres.pojos.requestPojos.CreateUser;
import com.reqres.pojos.requestPojos.RegisterUser;
import com.reqres.pojos.requestPojos.UpdateUser;

import static com.reqres.utils.Utility.*;
import static com.reqres.utils.Utility.getRandomPassword;

public class BackendBuilderClass {

    public static CreateUser getFreshCreateUser() {
        return CreateUser.builder().job(getRandomJob()).name(getRandomName()).build();
    }

    public static UpdateUser getFreshUpdateUser() {
        return UpdateUser.builder().name(getRandomName()).job(getRandomJob()).build();
    }

    public static RegisterUser getFreshUserForRegister() {
        return RegisterUser.builder().email(getConstantEmail()).password(getRandomPassword()).build();
    }

}
