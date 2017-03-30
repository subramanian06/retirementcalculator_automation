package nz.co.westpac.datacomponents;

import java.io.FileReader;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;

public class RetirementCalcData {
	
public static Map fetch(String key){
		
		Object object = null;
		YamlReader reader;
		try {
			reader = new YamlReader(new FileReader("data-pool/Data.yaml"));
			object = reader.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map map = (Map)object;
		return map;
	}
}
