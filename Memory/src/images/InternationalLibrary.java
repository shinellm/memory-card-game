package images;
import java.util.ArrayList;
import java.net.URL;
import java.net.MalformedURLException;
public class InternationalLibrary extends ImageLibrary{
	public static final int TOTAL_IMAGES = 36;
	private final String [] urls = {"https://www.clipartsgram.com/image/1539733666-san-francisco-trolley-stock-art-illustration-m6wz2v-clipart.jpg", 
			"https://img.clipartfest.com/29285f1e9574761ab6960ca7a7dcf468_free-mexico-clip-art-by-mexico-clipart_648-623.gif", 
			"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJtVpQZ91lvqbk_5MImyY27r3K12rtiIeZTQyzyhMlgzY1jlkroQ",
			"https://openclipart.org/download/248560/Deer4.svg",
			"http://www.gifs-animados.es/clip-art/geografia/peru/gifs-animados-peru-3053119.jpg",
			"http://www.ftijournal.com/uploads/images/resized/uploads/images/guide-to-brazil-header-930x470.png",
			"http://www.leerichardson.ca/wp-content/uploads/2014/08/canada_mapleleaf.gif",
			"https://s-media-cache-ak0.pinimg.com/736x/3a/b7/90/3ab79092dcffa4775d899ae99696c362.jpg",
			"http://images.clipartpanda.com/maine-clipart-maine_pine_cone.gif",
			"http://www.clipartkid.com/images/50/back-gallery-for-fall-harvest-pictures-clip-art-04w8Ue-clipart.gif",
			"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQP6NkRRmI-VYFCG4baixH7R0m6EcggW-vQYKp51O4F5lzDmhEYDw",
			"http://mexico.phillipmartin.info/mexico_cactus.gif"};
	private ArrayList<URL> holders = new ArrayList<URL>();
	private static InternationalLibrary uniqueInstance;
	private InternationalLibrary() {
		for (int i = 0; i < 12; i++) {
			  try {
					URL url = new URL(urls[i]);
					holders.add(i, url);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public ArrayList<URL> getURLs() {
		return holders;
	}
	
	public static InternationalLibrary getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new InternationalLibrary();
		}
		return uniqueInstance;
	}
}
