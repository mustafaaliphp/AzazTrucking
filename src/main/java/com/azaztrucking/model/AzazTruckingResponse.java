package com.az.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	"azId",
    "callerRequestId",
    "callerApplicationName",
    "callerId",
    "taskName",
    "encodedMessage",
    "errorMessage",
    "additionalInfo"
})
@Data
@ToString
public class AzResponse {

	@JsonProperty("azId")
	private String azId;
    @JsonProperty("callerRequestId")
    private String callerRequestId;
    @JsonProperty("callerApplicationName")
    private String callerApplicationName;
    @JsonProperty("callerId")
    private String callerId;
    @JsonProperty("taskName")
    private String taskName;
    @JsonProperty("encodedMessage")
    private String encodedMessage;
    @JsonProperty("errorMessage")
    private ErrorMessage errorMessage;
    @JsonProperty("additionalInfo")
    private List<AdditionalInfo> additionalInfo = new ArrayList<AdditionalInfo>();
}
