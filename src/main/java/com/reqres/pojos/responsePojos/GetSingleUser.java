package com.reqres.pojos.responsePojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSingleUser {
    public Data data;
    public Support support;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data{
        public int id;
        public String email;
        @JsonProperty("first_name")
        public String firstName;
        @JsonProperty("last_name")
        public String lastName;
        public String avatar;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Support{
        public String url;
        public String text;
    }
}
