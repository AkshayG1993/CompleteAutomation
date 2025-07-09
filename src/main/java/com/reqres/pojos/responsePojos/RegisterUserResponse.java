package com.reqres.pojos.responsePojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUserResponse {
    public int id;
    public String token;
    public String error;
}
