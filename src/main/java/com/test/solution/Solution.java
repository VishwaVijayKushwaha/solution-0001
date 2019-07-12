package com.test.solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.test.solution.dto.Fruit;
import com.test.solution.dto.ResponseDto;

public class Solution {
	
	private static final String API_URL = "https://sheets.googleapis.com/v4/spreadsheets/"
			+ "1lpiyYeEEv91_pphMkmgO48gkTix2a4NcSQ2kzzVR7w8/values/test!A1:D23?key=AIzaSy"
			+ "C_DzMrJ8GhRamRnuBjAGpakryrw_HoOdw";
	
	public static void main(String[] args) {
		System.out.println("Hello.....");
		
		System.out.print("Fetching data from google api.");
		ResponseDto responseDto = getFruitDataFromGoogleApi();
		System.out.println(".... done");
		
		if(responseDto==null || responseDto.getValues()==null || responseDto.getValues().isEmpty()) {
			System.out.println("Got invalid data from google api.");
			System.exit(0);
		}
		
		System.out.println("Processing data....");
		List<Fruit> fruits = responseDto.getValues().stream().skip(1).map(Fruit::of).collect(Collectors.toList());
		
		System.out.println("\nTotal number of fruits : "+fruits.size());
		System.out.println("\nTypes of fruit : "+fruits.stream().map(Fruit::getName).distinct().count());
		
		System.out.println("\nThe number of each type of fruit in descending order");
		fruits.stream().map(Fruit::getName).collect(Collectors.groupingBy(name->name)).entrySet().stream()
		.collect(Collectors.toList()).stream().sorted((e1, e2)->e2.getValue().size()-e1.getValue().size())
		.map(entry->String.format("%-20s", entry.getKey())+" : "+entry.getValue().size()).forEach(System.out::println);
		
		System.out.println("\nThe characteristics (size, color, shape, etc.) of each fruit by type");
		fruits.stream().map(f-> f.getName()+": "+ Arrays.stream(new String[] {f.getTast(), f.getColor()}).sorted().collect(Collectors.joining(",")))
		.collect(Collectors.groupingBy(name->name)).entrySet().forEach(entry->{
			System.out.println(entry.getValue().size()+":"+entry.getKey());
		});
		
		//.collect(Collectors.groupingBy(name->name)).entrySet().stream()
		//.map(entry->entry.getKey()+"\t: "+entry.getValue().size()).forEach(System.out::println);
		System.out.println("\nHave any fruit been in the basket for over 3 days");
		String message =fruits.stream().filter(f->f.getAge()>3).map(Fruit::getName)
				.collect(Collectors.groupingBy(n->n, Collectors.collectingAndThen(Collectors.toList(),  r->r.size())  )).entrySet()
				.stream().map(entry->entry.getValue()+" "+entry.getKey()).collect(Collectors.joining(", "))
				+"  are over 3 days old";
		System.out.println(new StringBuilder(new StringBuilder().append(message).reverse().toString().replaceFirst(",", "dna ")).reverse().toString());
	}
	
	private static ResponseDto getFruitDataFromGoogleApi() {
		try {
			String json = Unirest.get(API_URL).asString().getBody();
			return new Gson().fromJson(json, ResponseDto.class);
		} catch (Exception e) {
			System.out.println("Error while fetching data from google api. Error : " + e.getMessage());
			throw new RuntimeException("Error while fetching data from google api.", e);
		}
	}
}
