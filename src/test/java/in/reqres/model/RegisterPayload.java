package in.reqres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterPayload {

    private String email;
    private String password;

    @Data
    public static class RegisterResponse {

        private String id;
        private String token;
        private String error;

    }

}



