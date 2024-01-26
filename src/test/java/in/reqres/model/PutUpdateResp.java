package in.reqres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PutUpdateResp {

    private String name;
    private String job;
    private String updatedAt;

}



