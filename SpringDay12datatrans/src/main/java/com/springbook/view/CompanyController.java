package com.springbook.view;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.springbook.biz.bigdata.BigdataVo;
import com.springbook.biz.company.CompanyService;
import com.springbook.biz.company.CompanyVo;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@RequestMapping("apiEvinsert3.do")
	public  String   insert3( CompanyVo vo) throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6480000/gyeongnamgoodemploycompany/gyeongnamgoodemploycompanylist"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=jrLHt4JyJ5Ekiiok06JukET40YfK9YrFUNt%2FwVvLdBIt7sZaGbyU%2F9rjGuk0WYaW%2FD5160RFRzdvD7JqpalbKg%3D%3D"); /*Service Key (일반인증키)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("25", "UTF-8")); /*한 페이지 결과 수 (최소 10, 최대 9999)*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*상태갱신 조회 범위(분) (기본값 5, 최소 1, 최대 10)*/
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
        //System.out.println(sb.toString());
        
        Node data1 = null;   
        Node data2 = null;   
        Node data3 = null;
        Node data4 = null;   
        Node data5 = null;   
        Node data6 = null;
        
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
        	int size = items.getElementsByTagName("item").getLength();
        
        
        	for(int i=0 ; i<size; i++ ) {
        	Element item =(Element) items.getElementsByTagName("item").item(i);
        	
        	data1 = item.getElementsByTagName("rdnmadr").item(0);  // 필요한 데이터 값 추출하기 
        	data2 = item.getElementsByTagName("logitude").item(0);
        	data3 = item.getElementsByTagName("entrprsNm").item(0);
        	data4 = item.getElementsByTagName("rprsntvNm").item(0);  // 필요한 데이터 값 추출하기 
        	data5 = item.getElementsByTagName("latitude").item(0);
        	data6 = item.getElementsByTagName("mainGoods").item(0);
         	
        	String strData1 = data1.getChildNodes().item(0).getNodeValue();
        	String strData2 = data2.getChildNodes().item(0).getNodeValue();
        	String strData3 = data3.getChildNodes().item(0).getNodeValue();
        	String strData4 = data4.getChildNodes().item(0).getNodeValue();
        	String strData5 = data5.getChildNodes().item(0).getNodeValue();
        	String strData6 = data6.getChildNodes().item(0).getNodeValue();
        	
        	//System.out.println(strData1 + " " + strData2 + " " + strData3 + " " + strData4 + " " + strData5 + " " + strData6 );
        	vo.setSEQ(i+1);
        	vo.setRdnmadr(strData1);
        	vo.setLogitude(strData2);
        	vo.setEntrprsNm(strData3);
        	vo.setRprsntvNm(strData4);
        	vo.setLatitude(strData5);
        	vo.setMainGoods(strData6);
        	
        	
        	service.companyInsert(vo);
        	}        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "index.jsp";        
    }

}
