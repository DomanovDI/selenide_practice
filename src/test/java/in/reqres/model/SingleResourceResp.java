package in.reqres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class SingleResourceResp {

        @JsonProperty("data")
        private SingleResourceData data;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SingleResourceData {

            private Integer id;
            private String name;
            private Integer year;
            private String color;
            @JsonProperty("pantone_value")
            private String pantoneValue;
        }
    }


