package com.azaztrucking.model;

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
    "status",
    "code",
    "encodedMessage",
    "errorMessage",
    "additionalInfo"
})
@Data
@ToString
public class AzazTruckingResponse {

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
    @JsonProperty("status")
    private String status;
    @JsonProperty("code")
    private String code;
    @JsonProperty("encodedMessage")
    private String encodedMessage;
    @JsonProperty("errorMessage")
    private ErrorMessage errorMessage;
    @JsonProperty("additionalInfo")
    private List<AdditionalInfo> additionalInfo = new ArrayList<AdditionalInfo>();
}
