package com.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class PetStorepage {
	
	public static String randomID = "";
	
	/**
	 * Method to get Petdetails from Petstore API
	 * @param randomID
	 * @return
	 */
	public String getAPIResponse(String randomID) {
		String apiResponse = "";
		apiResponse = RestAssured.given().log().all().contentType("application/json").when()
				.get("https://petstore.swagger.io/v2/pet/" + randomID).asPrettyString();
		//then().assertThat().log().all().statusCode(200).extract()
		JsonPath js = new JsonPath(apiResponse);
		String responseMessage = js.getString("id");
		Assert.assertTrue(responseMessage.equals(randomID));
		return apiResponse;
	}
	
	/**
	 * 
	 * @param randomID
	 * @return
	 */
	public String deleteAPIResponse(String randomID) {
		String apiResponse = "";
		apiResponse = RestAssured.given().log().all().contentType("application/json").when()
				.delete("https://petstore.swagger.io/v2/pet/" + randomID).asPrettyString();
		//then().assertThat().log().all().statusCode(200).extract()
		JsonPath js = new JsonPath(apiResponse);
		String responseMessage = js.getString("message");
		Assert.assertTrue(responseMessage.equals(randomID));
		return apiResponse;
	}
	
	
	public String postAPIResponse(String category, String firstName, String secondName) {
		String apiResponse = "";

		randomID = RandomStringUtils.randomNumeric(19);
		String name = RandomStringUtils.randomAlphabetic(5);
		apiResponse = RestAssured.given().log().all().contentType("application/json")
				.baseUri("https://petstore.swagger.io/v2/pet").when()
				.body("{\r\n" + "    \"id\": " + randomID + ",\r\n" + "    \"category\": {\r\n" + "      \"id\": 0,\r\n"
						+ "      \"name\": \"" + category + "\"\r\n" + "    },\r\n" + "    \"name\": \"" + firstName
						+ "\",\r\n" + "    \"photoUrls\": [\r\n" + "      \"string\"\r\n" + "    ],\r\n"
						+ "    \"tags\": [\r\n" + "      {\r\n" + "        \"id\": 0,\r\n" + "        \"name\": \""
						+ secondName + "\"\r\n" + "      }\r\n" + "    ],\r\n" + "    \"status\": \"available\"\r\n"
						+ "  }")
				.post().asPrettyString();
		//then().assertThat().log().all().statusCode(200).extract()
		return apiResponse;
	}
	
}
