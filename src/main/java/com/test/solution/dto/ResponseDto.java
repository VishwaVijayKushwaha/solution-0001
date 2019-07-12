package com.test.solution.dto;

import java.util.List;

public class ResponseDto {
	private String range;
	private String majorDimension;
	private List<List<String>> values;
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getMajorDimension() {
		return majorDimension;
	}
	public void setMajorDimension(String majorDimension) {
		this.majorDimension = majorDimension;
	}
	public List<List<String>> getValues() {
		return values;
	}
	public void setValues(List<List<String>> values) {
		this.values = values;
	}
	
	
	@Override
	public String toString() {
		return "ResponseDto [range=" + range + ", majorDimension=" + majorDimension + ", values=" + values + "]";
	}
	
	
	public ResponseDto() {
		super();
	}
	public ResponseDto(String range, String majorDimension, List<List<String>> values) {
		super();
		this.range = range;
		this.majorDimension = majorDimension;
		this.values = values;
	}
	
	
}
