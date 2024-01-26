package in.reqres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class PostCreatedResp {

        private String name;
        private String job;
        private String id;
        private String createdAt;

    }



