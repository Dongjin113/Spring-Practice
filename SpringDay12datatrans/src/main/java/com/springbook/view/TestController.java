package com.springbook.view;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Controller
public class TestController {

	@RequestMapping("apiEvinsert.do")
	public  String   insert() throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=jrLHt4JyJ5Ekiiok06JukET40YfK9YrFUNt%2FwVvLdBIt7sZaGbyU%2F9rjGuk0WYaW%2FD5160RFRzdvD7JqpalbKg%3D%3D"); /*Service Key (일반인증키)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수 (최소 10, 최대 9999)*/
        urlBuilder.append("&" + URLEncoder.encode("searchDate","UTF-8") + "=" + URLEncoder.encode("2022-09-14", "UTF-8")); /*상태갱신 조회 범위(분) (기본값 5, 최소 1, 최대 10)*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*상태갱신 조회 범위(분) (기본값 5, 최소 1, 최대 10)*/
        urlBuilder.append("&" + URLEncoder.encode("InformCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*시도 코드 (행정구역코드 앞 2자리)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        //xml데이터 읽어오기
       // System.out.println(sb.toString());
        
        Node data1 = null;   
        Node data2 = null;   
        Node data3 = null;
        
        try {
        	DocumentBuilderFactory	dbFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
        	
        	FileOutputStream output = new FileOutputStream("./ApiExplorer");
        	output.write(sb.toString().getBytes("UTF-8"));  // 전체 데이터 읽어 오기 
        	output.close();
        	
        	Document doc = dBuilder.parse("./ApiExplorer");
        	doc.getDocumentElement().normalize();
        	
        	Element body =(Element) doc.getElementsByTagName("body").item(0);
        	Element items =(Element) body.getElementsByTagName("items").item(0);
        	
        	for(int i=0 ; i<10 ; i++ ) {
        	Element item =(Element) items.getElementsByTagName("item").item(i);
        	
        	//data1 = item.getElementsByTagName("imageUrl4").item(0);  // 필요한 데이터 값 추출하기 
        	data2 = item.getElementsByTagName("informCause").item(0);
        	data3 = item.getElementsByTagName("informData").item(0);
         	
        	//String strData1 = data1.getChildNodes().item(0).getNodeValue();
        	String strData2 = data2.getChildNodes().item(0).getNodeValue();
        	String strData3 = data3.getChildNodes().item(0).getNodeValue();
        	
        	System.out.println(strData2 + " " + strData3 + " " );

        	}        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "index.jsp";        
    }
	
	@RequestMapping("apiEvinsert2.do")
	public  String   insert2() throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/EvCharger/getChargerInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=9fUhHWkn8J23BGz8obUfEF6zSihn8D%2F0juIFYW5quBlH9Ln9LwBqnYYPTpgVjGFvuOxz1s5Yqpmj6YYxEzanQw%3D%3D"); /*Service Key (일반인증키)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수 (최소 10, 최대 9999)*/
        urlBuilder.append("&" + URLEncoder.encode("period","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8")); /*상태갱신 조회 범위(분) (기본값 5, 최소 1, 최대 10)*/
        urlBuilder.append("&" + URLEncoder.encode("zcode","UTF-8") + "=" + URLEncoder.encode("11", "UTF-8")); /*시도 코드 (행정구역코드 앞 2자리)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        Node data1 = null;   
        Node data2 = null;   
        Node data3 = null;
        Node data4 = null;
        Node data5 = null;
        
        try {
        	DocumentBuilderFactory	dbFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
        	
        	FileOutputStream output = new FileOutputStream("./ApiExplorer");
        	output.write(sb.toString().getBytes("UTF-8"));  // 전체 데이터 읽어 오기 
        	output.close();
        	
        	Document doc = dBuilder.parse("./ApiExplorer");
        	doc.getDocumentElement().normalize();
        	
        	Element body =(Element) doc.getElementsByTagName("body").item(0);
        	Element items =(Element) body.getElementsByTagName("items").item(0);
        	
        	for(int i=0 ; i<10 ; i++ ) {
        	Element item =(Element) items.getElementsByTagName("item").item(i);
        	
        	data1 = item.getElementsByTagName("statNm").item(0);  // 필요한 데이터 값 추출하기 
        	data2 = item.getElementsByTagName("addr").item(0);
        	data3 = item.getElementsByTagName("lat").item(0);
        	data4 = item.getElementsByTagName("lng").item(0);
        	data5 = item.getElementsByTagName("statUpdDt").item(0);
         	
        	String strData1 = data1.getChildNodes().item(0).getNodeValue();
        	String strData2 = data2.getChildNodes().item(0).getNodeValue();
        	String strData3 = data3.getChildNodes().item(0).getNodeValue();
        	String strData4 = data4.getChildNodes().item(0).getNodeValue();
        	String strData5 = data5.getChildNodes().item(0).getNodeValue();
        	
        	System.out.println(strData1 + " " + strData2 + " " + strData3 + " " + strData4 + " " + strData5 );

        	}        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "index.jsp";        
    }
	
	@RequestMapping("apiEvinsert14.do")
    String apiExplorer14() throws Exception {
	   
    StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
    urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=9fUhHWkn8J23BGz8obUfEF6zSihn8D%2F0juIFYW5quBlH9Ln9LwBqnYYPTpgVjGFvuOxz1s5Yqpmj6YYxEzanQw%3D%3D"); /*Service Key*/
    urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
    urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
    urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
    urlBuilder.append("&" + URLEncoder.encode("searchDate","UTF-8") + "=" + URLEncoder.encode("2022-09-14", "UTF-8")); /*통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)*/
    urlBuilder.append("&" + URLEncoder.encode("InformCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*통보코드검색(PM10, PM25, O3)*/
    URL url = new URL(urlBuilder.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Content-type", "application/json");
    
    System.out.println("Response code: " + conn.getResponseCode());
    
    BufferedReader rd;
    if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    } else {
        rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    }
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
        sb.append(line);
    }
    rd.close();
    conn.disconnect();
   
    System.out.println(sb);

     try {
    	 
        JSONParser jsonParser = new JSONParser();
         
        //  JSON 데이터 예제 
        // {"response":{"body":{"totalCount":20,"items":[{"imageUrl4":"https:a.png","informCode":"PM10",
        
        // JSON데이터를 넣어 JSON Object 로 만들어 준다.
        JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
        JSONObject response = (JSONObject) jsonObject.get("response"); 
        JSONObject body = (JSONObject) response.get("body");
        
        // items의 배열을 추출
        JSONArray InfoArray = (JSONArray) body.get("items");

        System.out.println("* items *");

        for(int i=0; i< InfoArray.size(); i++){

            System.out.println("=items_"+i+" ===========================================");
             
            //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
            JSONObject object = (JSONObject) InfoArray.get(i);
             
            //JSON name으로 추출
            System.out.println("Info: imageUrl4==>"+object.get("imageUrl4"));
            System.out.println("Info: informCode==>"+object.get("informCode"));
            System.out.println("Info: imageUrl5==>"+object.get("imageUrl5"));

        } 

    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	return "index.jsp";
    
}


	@RequestMapping("apiEvinsert44.do")
    String apiExplorer44() throws Exception {
	   
    StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
    urlBuilder.append("?" + URLEncoder.encode("mode","UTF-8") + "=json"); /*Service Key*/
    urlBuilder.append("&" + URLEncoder.encode("addr","UTF-8") + "=" + URLEncoder.encode("%EC%A4%91%EA%B5%AC", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
    URL url = new URL(urlBuilder.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Content-type", "application/json");
    
    System.out.println("Response code: " + conn.getResponseCode());
    
    BufferedReader rd;
    if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    } else {
        rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    }
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
        sb.append(line);
    }
    rd.close();
    conn.disconnect();
   
    System.out.println(sb);

     try {
    	 
        JSONParser jsonParser = new JSONParser();
         
        //  JSON 데이터 예제 
        // {"response":{"body":{"totalCount":20,"items":[{"imageUrl4":"https:a.png","informCode":"PM10",
        
        // JSON데이터를 넣어 JSON Object 로 만들어 준다.
        JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
        JSONObject status = (JSONObject) jsonObject.get("status"); 
        JSONObject total = (JSONObject) status.get("total");
        
        // items의 배열을 추출
        JSONArray InfoArray = (JSONArray) total.get("data");

        System.out.println("* data *");

        for(int i=0; i< InfoArray.size(); i++){

            System.out.println("=data_"+i+" ===========================================");
             
            //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
            JSONObject object = (JSONObject) InfoArray.get(i);
             
            //JSON name으로 추출
            System.out.println("주소==>"+object.get("GNG_CS"));
            System.out.println("분야==>"+object.get("FD_CS"));
            System.out.println("상표명==>"+object.get("BZ_NM"));
            System.out.println("전화번호==>"+object.get("TLNO"));
            System.out.println("영업시간==>"+object.get("MBZ_HR"));
            System.out.println("주차여부==>"+object.get("PKPL"));
            System.out.println("url주소==>"+object.get("HP"));
            System.out.println("메뉴==>"+object.get("MNU"));

        } 

    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	return "index.jsp";
    
}
	

}
	
	
		
		   
	
		 