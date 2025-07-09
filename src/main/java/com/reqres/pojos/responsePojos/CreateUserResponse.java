package com.reqres.pojos.responsePojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponse {
    public String name;
    public String job;
    public String id;
    public Date createdAt;
}
