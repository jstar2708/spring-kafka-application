package com.jaideep.kafkacommon.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Customer {
	private int id;
	private String name;
	private String email;
	private String contactNo;
}
