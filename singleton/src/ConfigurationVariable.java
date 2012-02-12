import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 設定ファイルを読み込み、グローバルにアクセス可能な変数に格納。
 * @author shintaro
 *
 */
final class ConfigurationVariable {
  private static final ConfigurationVariable instance = new ConfigurationVariable();
  
  private ConfigurationVariable(){
	  try {
		InputStream fis = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis);
		hostname = properties.getProperty("hostname");
		port = Integer.parseInt(properties.getProperty("port"));
		interval = Long.decode(properties.getProperty("interval"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  };
  
  public static ConfigurationVariable getInstance(){
    return ConfigurationVariable.instance;
  }
  
  public String hostname;
  
  public int port;
  
  public long interval;
  
  
}