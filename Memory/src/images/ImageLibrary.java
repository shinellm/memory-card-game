package images;
import java.util.ArrayList;
import java.net.URL;
import java.net.MalformedURLException;
public class ImageLibrary {
	public static URL getURL(int index, ArrayList<URL> arr){
		return arr.get(index);
	}
}
