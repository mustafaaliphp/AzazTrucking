
package com.azaztrucking.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "callerRequestId",
    "callerApplicationName",
    "callerId",
    "taskName",
    "encodedMessage",
    "additionalInfo"
})
public class Request {

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
    @JsonProperty("additionalInfo")
    private List<AdditionalInfo> additionalInfo = new ArrayList<AdditionalInfo>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("callerRequestId")
    public String getCallerRequestId() {
        return callerRequestId;
    }

    @JsonProperty("callerRequestId")
    public void setCallerRequestId(String callerRequestId) {
        this.callerRequestId = callerRequestId;
    }

    public Request withCallerRequestId(String callerRequestId) {
        this.callerRequestId = callerRequestId;
        return this;
    }

    @JsonProperty("callerApplicationName")
    public String getCallerApplicationName() {
        return callerApplicationName;
    }

    @JsonProperty("callerApplicationName")
    public void setCallerApplicationName(String callerApplicationName) {
        this.callerApplicationName = callerApplicationName;
    }

    public Request withCallerApplicationName(String callerApplicationName) {
        this.callerApplicationName = callerApplicationName;
        return this;
    }

    @JsonProperty("callerId")
    public String getCallerId() {
        return callerId;
    }

    @JsonProperty("callerId")
    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public Request withCallerId(String callerId) {
        this.callerId = callerId;
        return this;
    }

    @JsonProperty("taskName")
    public String getTaskName() {
        return taskName;
    }

    @JsonProperty("taskName")
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Request withTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    @JsonProperty("encodedMessage")
    public String getEncodedMessage() {
        return encodedMessage;
    }

    @JsonProperty("encodedMessage")
    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }

    public Request withEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
        return this;
    }

    @JsonProperty("additionalInfo")
    public List<AdditionalInfo> getAdditionalInfo() {
        return additionalInfo;
    }

    @JsonProperty("additionalInfo")
    public void setAdditionalInfo(List<AdditionalInfo> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Request withAdditionalInfo(List<AdditionalInfo> additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
