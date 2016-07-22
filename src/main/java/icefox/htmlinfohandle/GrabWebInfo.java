package icefox.htmlinfohandle;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;

import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class GrabWebInfo {
	public String webInfoHandle(String citi) {
		String text = "";
		try {
			Document doc = Jsoup.connect("http://lishi.tianqi.com/"+citi+"/index.html").get();
			Elements elements = doc.getElementsByClass("tqtongji1");
			elements = elements.get(0).getElementsByTag("a");

			for (Element element : elements) {
				String url = element.attr("href");
				// System.out.println(url);
				Document doc1 = Jsoup.connect(url).get();
				Elements elements1 = doc1.getElementsByClass("tqtongji2");
				elements1 = elements1.get(0).getElementsByTag("ul");
				String addtext = elements1.text().replaceAll("日期 最高气温 最低气温 天气 风向 风力 ", "").replaceAll("201", "\n201");

				text += addtext;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}

	public void toExcel() throws Exception {
		String path = "C:/Users/PF-083PK2/Documents/模型数据";
//		String name = "京津冀天气记录表";
//		String[] citiesName = { "北京", "天津", "石家庄", "唐山", "保定", "廊坊", "邢台", "张家口", "秦皇岛", "衡水", "邯郸", "承德", "沧州" };
//        String[] citi = {"beijing","tianjin","shijiazhuang","tangshan","baoding","langfang","xingtai","zhangjiakou","qinhuangdao","hengshui","handan","chengde","cangzhou"};
//        
//        String name = "长三角天气记录表";
//        String[] citiesName = {"上海","南京","杭州","苏州","无锡","常州","镇江","扬州","泰州","南通","湖州","宁波","台州","绍兴","嘉兴","舟山"};
//        String[] citi = {"shanghai","nanjing","hangzhou","suzhou","wuxi","changzhou","zhenjiang","yangzhou","taizhou2","nantong","huzhou","ningbo","taizhou","shaoxing","jiaxing","zhoushan"};
        
        String name = "珠三角天气记录表";
        String[] citiesName = {"广州","深圳","珠海","惠州","东莞","中山","佛山","江门","肇庆"};
        String[] citi = {"guangzhou","shenzhen","zhuhai","huizhou","dongguan","zhongshan","foshan","jiangmen","zhaoqing"};
        
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		WritableWorkbook book = Workbook.createWorkbook(new File(path + "/" + name + ".xls"));
		for (int i = 0; i < citi.length; i++) {
			System.out.println(citiesName[i]);
			WritableSheet sheet = book.createSheet(citiesName[i], i);
			String text = webInfoHandle(citi[i]);
			Label titleLabel = new Label(0, 0, "日期 最高气温 最低气温 天气 风向 风力");
			sheet.addCell(titleLabel);
			String[] texts = text.split("\n");
			for (int j = 0; j < texts.length; j++) {
				Label titleLabe2 = new Label(0, j+1, texts[j]);
				sheet.addCell(titleLabe2);
				
			}
			
		}
		book.write();
		book.close();
		
		System.out.println("ok");
		

	}
}
