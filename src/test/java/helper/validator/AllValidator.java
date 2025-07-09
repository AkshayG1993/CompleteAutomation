package helper.validator;

import com.reqres.pojos.requestPojos.CreateUser;
import com.reqres.pojos.requestPojos.UpdateUser;
import com.reqres.pojos.responsePojos.*;

import static org.testng.Assert.*;

public class AllValidator {

    public static void validateGetAllUsersResponse(GetAllUsers getAllUsers) {
        // Assert the object is not null
        assertNotNull(getAllUsers, "GetAllUsers object should not be null");

        // Assert total users is greater than 0
        assertTrue(getAllUsers.getTotal() > 0, "Total users should be greater than 0");

        // Assert data list is not null and not empty
        assertNotNull(getAllUsers.getData(), "User data list should not be null");
        assertFalse(getAllUsers.getData().isEmpty(), "User data list should not be empty");

        // Assert each user has required fields
        getAllUsers.getData().forEach(user -> {
            assertNotNull(user.getId(), "User ID should not be null");
            assertNotNull(user.getEmail(), "User email should not be null");
            assertTrue(user.getEmail().contains("@"), "User email should contain '@'");
            assertNotNull(user.getFirstName(), "User first name should not be null");
            assertNotNull(user.getLastName(), "User last name should not be null");
            // Optionally check avatar
            assertNotNull(user.getAvatar(), "User avatar should not be null");
        });

    }

    public static void validateSingleUserResponse(GetSingleUser getSingleUser) {
        // Assert the object is not null
        assertNotNull(getSingleUser, "GetSingleUser object should not be null");

        // Assert the data object is not null
        assertNotNull(getSingleUser.getData(), "User data should not be null");

        // Assert user fields
        assertNotNull(getSingleUser.getData().getEmail(), "User email should not be null");
        assertTrue(getSingleUser.getData().getEmail().contains("@"), "User email should contain '@'");
        assertNotNull(getSingleUser.getData().getFirstName(), "User first name should not be null");
        assertNotNull(getSingleUser.getData().getLastName(), "User last name should not be null");
        assertNotNull(getSingleUser.getData().getAvatar(), "User avatar should not be null");

        // Optionally, assert support object if present
        if (getSingleUser.getSupport() != null) {
            assertNotNull(getSingleUser.getSupport().getUrl(), "Support URL should not be null");
            assertNotNull(getSingleUser.getSupport().getText(), "Support text should not be null");
        }
    }

    public static void validateCreateUserResponse(CreateUserResponse createUserResponse, CreateUser createUser) {

        // Assert the response object is not null
        assertNotNull(createUserResponse, "CreateUserResponse object should not be null");

        // Assert required fields are not null or empty
        assertNotNull(createUserResponse.getId(), "User ID should not be null");
        assertFalse(createUserResponse.getId().isEmpty(), "User ID should not be empty");

        assertNotNull(createUserResponse.getName(), "User name should not be null");
        assertFalse(createUserResponse.getName().isEmpty(), "User name should not be empty");

        assertNotNull(createUserResponse.getJob(), "User job should not be null");
        assertFalse(createUserResponse.getJob().isEmpty(), "User job should not be empty");

        assertNotNull(createUserResponse.getCreatedAt(), "CreatedAt should not be null");

        assertEquals(createUserResponse.getName(), createUser.getName(), "Name in response should match the request");
        assertEquals(createUserResponse.getJob(), createUser.getJob(), "Job in response should match the request");
    }

    public static void validateUpdateUserResponse(UpdateUserResponse updateUserResponse, UpdateUser updateUser) {
        // Assume updateUserResponse is the deserialized object

        assertNotNull(updateUserResponse, "UpdateUserResponse object should not be null");

        // Validate 'name'
        assertNotNull(updateUserResponse.getName(), "Name should not be null");
        assertFalse(updateUserResponse.getName().isEmpty(), "Name should not be empty");

        // Validate 'job'
        assertNotNull(updateUserResponse.getJob(), "Job should not be null");
        assertFalse(updateUserResponse.getJob().isEmpty(), "Job should not be empty");

        // Validate 'updatedAt'
        assertNotNull(updateUserResponse.getUpdatedAt(), "updatedAt should not be null");

        //validate that the response matches the request
        assertEquals(updateUserResponse.getName(), updateUser.getName(), "Name in response should match the request");
        assertEquals(updateUserResponse.getJob(), updateUser.getJob(), "Job in response should match the request");
    }

    public static void validatingRegisterUserResponse(RegisterUserResponse registerUserResponse) {
        // Assertions for RegisterUserResponse fields
        assertNotNull(registerUserResponse, "RegisterUserResponse should not be null");
        assertNotEquals(registerUserResponse.getId(),0, "User ID should not be 0");
        assertNotNull(registerUserResponse.getToken(), "Token should not be null");
        assertFalse(registerUserResponse.getToken().isEmpty(), "Token should not be empty");
    }
}
