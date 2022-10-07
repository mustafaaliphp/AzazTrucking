package com.az.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ErrorMessage {
  private int statusCode;
  private Date timestamp;
  private String message;
  private String description;
  private List<ErrorDetail> errorDetail = new ArrayList<ErrorDetail>();

}
