package images;
import java.util.ArrayList;
import java.net.URL;
import java.net.MalformedURLException;
public class InternationalLibrary extends ImageLibrary{
	public static final int TOTAL_IMAGES = 36;
	private final String [] urls = {"https://www.clipartsgram.com/image/1539733666-san-francisco-trolley-stock-art-illustration-m6wz2v-clipart.jpg",
			"https://image.shutterstock.com/z/stock-vector-warriors-of-south-america-mayan-aztec-or-inca-vector-illustration-174255932.jpg",
			"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJtVpQZ91lvqbk_5MImyY27r3K12rtiIeZTQyzyhMlgzY1jlkroQ",
			"http://fscomps.fotosearch.com/compc/ECC/ECC115/01020331.jpg",
			"http://www.gifs-animados.es/clip-art/geografia/peru/gifs-animados-peru-3053119.jpg",
			"http://www.ftijournal.com/uploads/images/resized/uploads/images/guide-to-brazil-header-930x470.png",
			"http://st2.depositphotos.com/1770943/9066/v/950/depositphotos_90667762-stock-illustration-traditional-costumes-icon-argentina-and.jpg",
			"https://s-media-cache-ak0.pinimg.com/736x/3a/b7/90/3ab79092dcffa4775d899ae99696c362.jpg",
			"http://traveltoblank.com/wp-content/uploads/2016/02/ECUADORFLAG.png",
			"http://images.clipartpanda.com/south-clipart-image_exp_earth066.jpg",
			"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQP6NkRRmI-VYFCG4baixH7R0m6EcggW-vQYKp51O4F5lzDmhEYDw",
			"https://image.shutterstock.com/z/stock-vector-cartoon-map-of-south-america-371521006.jpg",
			"http://sr.photos3.fotosearch.com/bthumb/CSP/CSP690/k6903453.jpg",
			"http://qph.cr.quoracdn.com/main-qimg-2f9e12d78b8e59194f6d0ed02dc55242",
			"http://www.georgemaps.com/wp-content/uploads/2016/06/treasure-adventure-jungle-map-stock-vector-image-cartoon-hunt-clipart-asia.jpg",
			"https://s-media-cache-ak0.pinimg.com/564x/70/eb/2f/70eb2f2bf0f67747d5c0302a2c983dc2.jpg",
			"http://2.bp.blogspot.com/_oNMyXKFEdO8/S0kXQLTewcI/AAAAAAAAUyc/ZOKb8-nZ8F8/s320/ARTasia00006-780203.gif",
			"https://s-media-cache-ak0.pinimg.com/736x/49/e9/7b/49e97b8bc08b48f18485ea5711003a45.jpg",
			"http://classroomclipart.com/images/gallery/Clipart/Asia/TN_mongol-empire-genghis-khan-clipart-125.jpg",
			"https://img.clipartfest.com/fe9987ac303780e1b3d4522cff24328d_free-clip-art-hand-fan-clipart_550-471.png",
			"http://classroomclipart.com/images/gallery/Clipart/Asia/TN_Thai-Buddhist-Monk-Thailand-Asia-Clipart.jpg",
			"http://img01.deviantart.net/4273/i/2014/280/d/e/cute_panda_drawing_by_arycarys-d81yy6k.png",
			"http://classroomclipart.com/images/gallery/Clipart/Asia/TN_woman-man-standing-in-front-Taj-Mahal-India-clipart.jpg",
			"http://classroomclipart.com/images/gallery/Clipart/Asia/Sushi-Traditional-Japanese-Food-Japan-Asia-Clipart.jpg",
			"http://europe.phillipmartin.info/croatia_woman_m.png",
			"http://classroomclipart.com/images/gallery/Clipart/Europe/french-man-with-bread-and-red-wine.jpg",
			"http://www.prawny.me.uk/image.php?mediaID=MjcwMWM3ZDM1ZGJiZWI=&type=sample&folderID=NDJjN2QzNWRiYmVi&seo=toddler-art-european-flag-kid-prawny-clip-art",
			"https://img.clipartfest.com/4558d233b56a28dcfd0cb61ad20954ed_european-history-wars-of-european-history-clipart_360-648.gif",
			"http://www.clipartkid.com/images/15/europe-london-england-big-ben-classroom-clipart-2V65Gh-clipart.jpg",
			"http://europe.phillipmartin.info/iceland_title.png",
			"https://s-media-cache-ak0.pinimg.com/736x/a4/58/45/a458459beee494c7d259f5b667c8eaf8.jpg",
			"https://conceptdraw.com/a2278c3/p2/preview/640/pict--flag-of-benelux-european-country-flags---vector-stencils-library.png--diagram-flowchart-example.png",
			"http://fscomps.fotosearch.com/compc/CSP/CSP953/k9530383.jpg",
			"https://www.clipartsgram.com/image/300982047-stock-vector-eu-flag-text-name-country-vector-illustration-hand-made-249293509.jpg",
			"https://s-media-cache-ak0.pinimg.com/originals/23/ca/d8/23cad8109c67a8aeaba612b73a93153d.jpg",
			"http://classroomclipart.com/images/gallery/Clipart/Europe/TN_leaning-tower-of-pisa--bell-tower-clipart-7116.jpg"
	};
	private ArrayList<URL> holders = new ArrayList<URL>();
	private static InternationalLibrary uniqueInstance;
	private InternationalLibrary() {
		for (int i = 0; i < 36; i++) {
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
