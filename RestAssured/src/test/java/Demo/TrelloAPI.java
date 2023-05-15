package Demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TrelloAPI {
	public static String baseUrl="https://api.trello.com";
	public static String Key="dbc09d1498e40a5b79e4c5b757f26587";
	public static String Token="ATTAed9b5125075239814b2d20885d2f359a50c83d17c417c38b8cbc2b9a9130238e304E1790";
	public static String id;
	
	@Test(priority = 0)
	public void CreateBoard() {
		// Given : request- contains=> body,headers,Authorization,content,type,Querry parameters
		//When: resource(Endpoints)
		//Then: response(Assertions)
		
		
		RestAssured.baseURI=baseUrl;
	   Response  response= given().queryParam("name","MasaiBoard")
		.queryParam("key",Key)
		.queryParam("token",Token)
		.header("Content-Type","application/json")
		
		.when()
		.post("/1/boards")
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
	   //for printing the complete response of the body
	   String jsonresponse=response.asString();
	    System.out.println(jsonresponse);
	    //for printing id
	    JsonPath js=new JsonPath(jsonresponse);
	       id = js.get("id");
        System.out.println(id);
	   }
	
	@Test(priority = 1)
	public void getBoard() {
		RestAssured.baseURI=baseUrl;
	   Response  response= given()
		.queryParam("key",Key)
		.queryParam("token",Token)
		.header("Content-Type","application/json")
		
		.when()
		.get("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
	   //for printing the complete response of the body
	   String jsonresponse=response.asString();
	    System.out.println(jsonresponse);
	    //for printing id
        System.out.println(id);
	   }
	
	@Test(priority = 2)
	public void UpdateBoard() {
		RestAssured.baseURI=baseUrl;
		String data="{\"id\":\"644b51fb3e753679fdc880eb\",\"name\":\"Ajay's Board\",\"desc\":\"Todo Tasks\",\"descData\":null,\"closed\":false,\"idOrganization\":\"62e12642e047d95cb4d5a669\",\"idEnterprise\":null,\"pinned\":false,\"url\":\"https://trello.com/b/P8UghAzz/masaiboard\",\"shortUrl\":\"https://trello.com/b/P8UghAzz\",\"prefs\":{\"permissionLevel\":\"private\",\"hideVotes\":false,\"voting\":\"disabled\",\"comments\":\"members\",\"invitations\":\"members\",\"selfJoin\":true,\"cardCovers\":true,\"isTemplate\":false,\"cardAging\":\"regular\",\"calendarFeedEnabled\":false,\"hiddenPluginBoardButtons\":[],\"switcherViews\":[{\"viewType\":\"Board\",\"enabled\":true,\"_id\":\"644b51fb3e753679fdc880ec\"},{\"viewType\":\"Table\",\"enabled\":true,\"_id\":\"644b51fb3e753679fdc880ed\"},{\"viewType\":\"Calendar\",\"enabled\":false,\"_id\":\"644b51fb3e753679fdc880ee\"},{\"viewType\":\"Dashboard\",\"enabled\":false,\"_id\":\"644b51fb3e753679fdc880ef\"},{\"viewType\":\"Timeline\",\"enabled\":false,\"_id\":\"644b51fb3e753679fdc880f0\"},{\"viewType\":\"Map\",\"enabled\":false,\"_id\":\"644b51fb3e753679fdc880f1\"}],\"background\":\"blue\",\"backgroundColor\":\"#0079BF\",\"backgroundImage\":null,\"backgroundImageScaled\":null,\"backgroundTile\":false,\"backgroundBrightness\":\"dark\",\"backgroundBottomColor\":\"#0079BF\",\"backgroundTopColor\":\"#0079BF\",\"canBePublic\":true,\"canBeEnterprise\":true,\"canBeOrg\":true,\"canBePrivate\":true,\"canInvite\":true},\"labelNames\":{\"green\":\"\",\"yellow\":\"\",\"orange\":\"\",\"red\":\"\",\"purple\":\"\",\"blue\":\"\",\"sky\":\"\",\"lime\":\"\",\"pink\":\"\",\"black\":\"\",\"green_dark\":\"\",\"yellow_dark\":\"\",\"orange_dark\":\"\",\"red_dark\":\"\",\"purple_dark\":\"\",\"blue_dark\":\"\",\"sky_dark\":\"\",\"lime_dark\":\"\",\"pink_dark\":\"\",\"black_dark\":\"\",\"green_light\":\"\",\"yellow_light\":\"\",\"orange_light\":\"\",\"red_light\":\"\",\"purple_light\":\"\",\"blue_light\":\"\",\"sky_light\":\"\",\"lime_light\":\"\",\"pink_light\":\"\",\"black_light\":\"\"},\"limits\":{}}\r\n"
				+ "";
	   Response  response= given()
		 .body(data)
		.queryParam("key",Key)
		.queryParam("token",Token)
		.header("Content-Type","application/json")
		
		.when()
		.put("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
	   //for printing the complete response of the body
	   String jsonresponse=response.asString();
	    System.out.println(jsonresponse);
	    //for printing id
        System.out.println("Updated Board");
	   }
	@Test(priority = 3)
	public void DeleteBoard() {
		RestAssured.baseURI=baseUrl;
		   Response  response= given()
		
			.queryParam("key",Key)
			.queryParam("token",Token)
			.header("Content-Type","application/json")
			
			.when()
			.delete("/1/boards/"+id)
			
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
			.extract().response();
		   //for printing the complete response of the body
		   String jsonresponse=response.asString();
		    System.out.println(jsonresponse);
           System.out.println("Board Deleted");
		}




	
}
