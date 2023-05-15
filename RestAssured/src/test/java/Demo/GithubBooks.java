package Demo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


	public class GithubBooks {
		public static String baseUrl="https://simple-books-api.glitch.me";
		public static String accessToken="a85973bd03d29339953bf9cbaabd6fc7140c1dfc5ec96d8b30e97101b0c9f356";
		public static String orderId;
		@Test(priority = 1)
		public void GetStatus() {
			RestAssured.baseURI=baseUrl;
		   Response  response= given()
		    .header("Content-Type","application/json")
			.when()
			.get("/status")
			
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
			.extract().response();
		   //for printing the complete response of the body
		   String jsonresponse=response.asString();
		    System.out.println(jsonresponse);
		    //for printing id
		  
		   }
		@Test(priority = 2)
		public void GetBooks() {
			RestAssured.baseURI=baseUrl;
		   Response  response= given()
		    .header("Content-Type","application/json")
			.when()
			.get("/books")
			
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
			.extract().response();
		   //for printing the complete response of the body
		   String jsonresponse=response.asString();
		    System.out.println(jsonresponse);
		    //for printing id
		  
		   }
		
		@Test(priority = 3)
		public void GetSingleBooks() {
			RestAssured.baseURI=baseUrl;
		   Response  response= given()
		    .header("Content-Type","application/json")
			.when()
			.get("/books/3")
			
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
			.extract().response();
		   //for printing the complete response of the body
		   String jsonresponse=response.asString();
		    System.out.println(jsonresponse);
		    //for printing id
		  
		   }
		@Test(priority = 4)
		public void submitOrder() {
			String data1="{\r\n"
					+ "  \"bookId\": 3,\r\n"
					+ "  \"customerName\": \"John\"\r\n"
					+ "}";
			
			RestAssured.baseURI=baseUrl;
		   Response  response= given()
		    .header("Content-Type","application/json")
		    .header("Authorization","Bearer "+accessToken)
		    .body(data1)
			.when()
			.post("/orders/")
			
			.then()
			.assertThat().statusCode(201).contentType(ContentType.JSON)
			.extract().response();
		   //for printing the complete response of the body
		   String jsonresponse=response.asString();
		    System.out.println(jsonresponse);
		    //for printing id
		    JsonPath js=new JsonPath(jsonresponse);
		    
             orderId=js.get("orderId");
             System.out.println(orderId);
		   }
		
		@Test(priority = 5)
		public void Get_an_Order() {
			RestAssured.baseURI=baseUrl;
		   Response  response= given()
		    .header("Content-Type","application/json")
		    .header("Authorization","Bearer "+accessToken)
			.when()
			.get("/orders/"+orderId)
			
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
			.extract().response();
		   //for printing the complete response of the body
		   String jsonresponse=response.asString();
		    System.out.println(jsonresponse);

		   }
		@Test(priority = 6)
		public void Update_an_Order() {
			RestAssured.baseURI=baseUrl;
			String data2="{\r\n"
					+ "  \"customerName\": \"Ajay\"\r\n"
					+ "}";
		   Response  response= given()
		    .header("Content-Type","application/json")
		    .header("Authorization","Bearer "+accessToken)
		    .body(data2)
			.when()
			.patch("/orders/"+orderId)
			
			.then()
			.assertThat().statusCode(204).contentType(ContentType.JSON)
			.extract().response();
		   //for printing the complete response of the body
		   String jsonresponse=response.asString();
		    System.out.println(jsonresponse);

		   }
		
		
		
//		@Test(priority = 0)
//		public void Authenticate() {
//			String data="{\r\n"
//					+ "   \"clientName\": \"Ajay Dhaakadd\",\r\n"
//					+ "   \"clientEmail\": \"Dhakaada2020@example.com\"\r\n"
//					+ "}";
//			RestAssured.baseURI=baseUrl;
//		   Response  response= given()
//			.header("Content-Type","application/json")
//			.body(data)
//			.when()
//			.post("/api-clients/")
//			
//			.then()
//			.assertThat().statusCode(201).contentType(ContentType.JSON)
//			.extract().response();
//		   //for printing the complete response of the body
//		    String jsonresponse=response.asString();
//		    System.out.println(jsonresponse);
//		    //for printing id
//		    JsonPath js=new JsonPath(jsonresponse);
//		       accessToken = js.get("accessToken");
//		       System.out.println(accessToken);
//		  
//		   }
}
