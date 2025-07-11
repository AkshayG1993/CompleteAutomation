package com.reqres.automation;

import com.reqres.pojos.requestPojos.CreateUser;
import com.reqres.pojos.responsePojos.CreateUserResponse;
import com.reqres.pojos.responsePojos.GetAllUsers;
import helper.ApiHelper;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    public List<Integer> userIds = new ArrayList<>();
    public ApiHelper apiHelper = new ApiHelper();

    @BeforeMethod
    public void beforeMethod() {
        updateUserIds();
    }

    /**
     * This method is used to update the userIds list with all user ids from the API.
     * It checks if the list is empty before making the API call to avoid unnecessary calls.
     */
    public void updateUserIds() {
        if (userIds.isEmpty()) {
            userIds.addAll(apiHelper.getAllUsers().as(GetAllUsers.class).getData().stream()
                    .map(GetAllUsers.Data::getId)
                    .toList());
        }
    }

    public CreateUserResponse getFreshUser(CreateUser createUser) {
        Response response = apiHelper.createUser(createUser);
        return response.as(CreateUserResponse.class);
    }

}
