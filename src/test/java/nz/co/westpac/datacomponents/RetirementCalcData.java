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
@SuppressWarnings("unchecked")
public static Map<String,String> fetch(){
		YamlReader reader;
		Map<String, String> map = null;
		try {
			reader = new YamlReader(new FileReader("data-pool/Data.yaml"));
			map = (Map<String, String>) reader.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
    
		return map;
	}
}
