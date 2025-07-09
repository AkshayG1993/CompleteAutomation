package com.reqres.automation;

import com.reqres.pojos.requestPojos.CreateUser;
import com.reqres.pojos.requestPojos.RegisterUser;
import com.reqres.pojos.requestPojos.UpdateUser;
import com.reqres.pojos.responsePojos.*;
import helper.DataProviderClass;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static helper.builder.BackendBuilderClass.*;
import static helper.validator.AllValidator.*;
import static org.apache.http.HttpStatus.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BackEndAutomation extends BaseTest {

    @Test(description = "Test get All User api")
    public void testGetAllUsers() {
        Response response = apiHelper.getAllUsers();
        assertEquals(response.getStatusCode(), SC_OK, "Status code should be 200");
        GetAllUsers getAllUsers = response.as(GetAllUsers.class);
        userIds.addAll(getAllUsers.getData().stream()
                .map(GetAllUsers.Data::getId)
                .toList());
        validateGetAllUsersResponse(getAllUsers);
    }

    @Test(description = "Test get Single User api")
    public void testGetSingleUsers() {
        Response response = apiHelper.getUserById(userIds.get(0));
        assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        GetSingleUser getSingleUser = response.as(GetSingleUser.class);
        validateSingleUserResponse(getSingleUser);
    }

    @Test(description = "Test create user api")
    public void testCreateUser() {
        CreateUser createUser = getFreshCreateUser();
        CreateUserResponse createUserResponse = getFreshUser(createUser);
        validateCreateUserResponse(createUserResponse, createUser);
    }

    @Test(description = "Test fresh user been visible on all user list")
    public void testFreshUserBeenVisibleOnAllUserList() {
        CreateUser createUser = getFreshCreateUser();
        CreateUserResponse createUserResponse = getFreshUser(createUser);
        int id = Integer.parseInt(createUserResponse.getId());
        Response response = apiHelper.getAllUsers();
        GetAllUsers getAllUsers = response.as(GetAllUsers.class);
        String errorMsg = String.format("Fresh user (id: %d, name: %s, job: %s) should be visible in all users list", id, createUser.getName(), createUser.getJob());
        assertTrue(getAllUsers.getData().stream().anyMatch(e -> e.getId() == id), errorMsg);
    }

    @Test(description = "Test create user api")
    public void testUpdateUser() {
        CreateUser createUser = getFreshCreateUser();
        CreateUserResponse createUserResponse = getFreshUser(createUser);
        int id = Integer.parseInt(createUserResponse.getId());
        UpdateUser updateUser = getFreshUpdateUser();
        Response response = apiHelper.updateUser(id, updateUser);
        UpdateUserResponse updateUserResponse = response.as(UpdateUserResponse.class);
        validateUpdateUserResponse(updateUserResponse, updateUser);
    }

    CreateUser deleteUser = getFreshCreateUser();
    int deleteUserId;

    @Test(description = "Test delete user api")
    public void testDeleteUser() {
        CreateUserResponse createUserResponse = getFreshUser(deleteUser);
        deleteUserId = Integer.parseInt(createUserResponse.getId());
        Response response = apiHelper.deleteUser(deleteUserId);
        assertEquals(response.getStatusCode(), SC_NO_CONTENT, "Status code should be 204");
    }

    @Test(description = "Test delete user api and verify user is deleted", dependsOnMethods = "testDeleteUser")
    public void testDeleteUserAndVerify() {
        Response getResponse = apiHelper.getUserById(deleteUserId);
        getResponse.print();
        assertEquals(getResponse.getStatusCode(), SC_NOT_FOUND, "Status code should be 404 for deleted user");
    }

    @Test(description = "Test register api")
    public void testRegisterApi() {
        RegisterUser registerUser = getFreshUserForRegister();
        Response response = apiHelper.registerUser(registerUser);
        assertEquals(response.getStatusCode(), SC_OK, "Status code should be 200");
        RegisterUserResponse registerUserResponse = response.as(RegisterUserResponse.class);
        validatingRegisterUserResponse(registerUserResponse);
    }

    @Test(description = "Test register api negative flows", dataProviderClass = DataProviderClass.class, dataProvider = "registerUserNegativeDataProvider")
    public void testRegisterApiNegativeFlows(RegisterUser registerUser, String errorMessage) {
        Response response = apiHelper.registerUser(registerUser);
        assertEquals(response.getStatusCode(), SC_BAD_REQUEST, "Status code should be 400");
        RegisterUserResponse registerUserResponse = response.as(RegisterUserResponse.class);
        assertEquals(registerUserResponse.getError(), errorMessage, "Error message should match expected");
    }
}
