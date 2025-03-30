package utils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLProc {
    public static List<String> xmlParse(String fileName) {
        List<String> dependencies = new ArrayList<>();

        try {
            // DocumentBuilderFactory 인스턴스 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // XML 파일 읽기
            Document document = builder.parse(new File(fileName));
            document.getDocumentElement().normalize();

            // <dependency> 태그 목록 가져오기
            NodeList nodeList = document.getElementsByTagName("dependency");

            // 각 <dependency> 태그의 내용을 리스트에 추가
            for (int i = 0; i < nodeList.getLength(); i++) {
                String dependency = nodeList.item(i).getTextContent();
                dependencies.add(dependency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dependencies;
    }
}
