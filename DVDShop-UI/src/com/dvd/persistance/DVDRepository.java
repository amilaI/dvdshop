/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.persistance;

import com.dvd.domain.Dvd;
import com.dvd.domain.DvdCopy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DVDRepository {
    
    public List<Dvd> getDVDList() throws JSONException, IOException{
    
     String result = "";
                String url1 = "http://localhost:8080/getDVDList";
                
                   //  String q = URLEncoder.encode(original, "UTF-8");
			URL url = new URL(url1);
			
			URL obj = url;
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
			// optional default is GET
			con.setRequestMethod("GET");
 
			//add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
 
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
 
			//print result
			result = response.toString();
			// Parse to get translated text

			JSONObject jsonObject = new JSONObject(result);
			JSONArray dvdList = jsonObject.getJSONArray("body");
                        List<Dvd> list = null;
                        
                        if(dvdList != null){
                                 list = new ArrayList<>();
                                 for(int i = 0; i < dvdList.length(); i++){
                                    JSONObject c = dvdList.getJSONObject(i);
                                    Dvd d = new Dvd(c.getInt("code"), c.getString("title"), c.getString("actors"), c.getInt("rating"), c.getString("definiiton"), c.getString("year"));
                                    list.add(d);
                             }

                        }
                        
                        
                        
                return list;
                      
    
    
    
    
    }
    
    
    
       public List<DvdCopy> getCopyDVDList(int id) throws JSONException, IOException{
    
     String result = "";
                String url1 = "http://localhost:8080/getCopyDVDList?dvdcode=" + id;
                
                   //  String q = URLEncoder.encode(original, "UTF-8");
			URL url = new URL(url1);
			
			URL obj = url;
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
			// optional default is GET
			con.setRequestMethod("GET");
 
			//add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
 
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
 
			//print result
			result = response.toString();
			// Parse to get translated text

			JSONObject jsonObject = new JSONObject(result);
			JSONArray dvdList = jsonObject.getJSONArray("body");
                        List<DvdCopy> list = null;
                        
                        if(dvdList != null){
                                 list = new ArrayList<>();
                                 for(int i = 0; i < dvdList.length(); i++){
                                    JSONObject c = dvdList.getJSONObject(i);
                                    DvdCopy d = new DvdCopy(c.getString("isleNumber"), String.valueOf(c.getInt("copyNumber")), c.getString("shelfNumber"),new Dvd(), c.getString("isAvailable"));
                                    list.add(d);
                             }

                        }
                        
                        
                        
                return list;
                      
    
    
    
    
    }
}
