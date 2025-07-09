package com.reqres.pojos.responsePojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserResponse {
    public String name;
    public String job;
    public Date updatedAt;
}
