package parse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

import models.Data;

public class ParseUrl implements ParseObject{
	private String path;
	
	public ParseUrl() {
		this("https://tiki.vn/api/v2/products?limit=50&include=advertisement&aggregations=1&category=2549&page=200");
	}
	
	public ParseUrl(String path) {
		this.path = path;
	}
	
	public Data getData() throws IOException {
		URL url = new URL(path);
		InputStreamReader input = new InputStreamReader(url.openStream());
		
		Data data = new Gson().fromJson(input, Data.class);
		
		return data;
	}
	
//	public static void main(String[] args) throws IOException {
//		URL oracle = new URL("https://tiki.vn/api/v2/products?limit=50&include=advertisement&aggregations=1&category=2549&page=200");
//        BufferedReader in = new BufferedReader(
//        new InputStreamReader(oracle.openStream()));
//
//        String input = "";
//        String inputLine;
//        while ((inputLine = in.readLine()) != null)
//            input += inputLine;
//        
//        System.out.println(input);
//        in.close();
//	}
}
