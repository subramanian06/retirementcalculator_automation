package nz.co.westpac.datacomponents;

import java.io.FileReader;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;
/**
 * Read and store values from the .yaml data file
 * @author Subramanian_K
 *
 */
public class RetirementCalcData {
	/**
	 * fetch the values from the .yaml data file
	 * @param key
	 * @return Map
	 */
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
