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
			"http://mexico.phillipmartin.info/mexico_cactus.gif",
			"http://sr.photos3.fotosearch.com/bthumb/CSP/CSP690/k6903453.jpg",
			"http://qph.cr.quoracdn.com/main-qimg-2f9e12d78b8e59194f6d0ed02dc55242",
			"https://img.clipartfox.com/83abce63681690372fc4e9008b5ce5b0_chinese-dragon-free-clipart-clipart-chinese-dragon_425-275.jpeg",
			"https://s-media-cache-ak0.pinimg.com/564x/70/eb/2f/70eb2f2bf0f67747d5c0302a2c983dc2.jpg",
			"http://previews.123rf.com/images/rie0914/rie09141302/rie0914130200013/17889781-Mt-Fuji-in-Japan-Stock-Vector.jpg",
			"http://gallery.yopriceville.com/var/resizes/Free-Clipart-Pictures/Fast-Food-PNG-Clipart/Sushi_PNG_Clipart_Image.png?m=1434273435",
			"https://img.clipartfox.com/a9e18d93d2d9b70f719900d5d50efa6a_lantern-clipart-chinese-lantern-clip-art_1024-765.jpeg",
			"https://img.clipartfest.com/fe9987ac303780e1b3d4522cff24328d_free-clip-art-hand-fan-clipart_550-471.png",
			"https://img.clipartfox.com/0e7cf9e4ac7ade979a2e79fd1a28562c_ramen-noodle-ramen-noodles-clipart-free_216-160.jpeg",
			"http://img01.deviantart.net/4273/i/2014/280/d/e/cute_panda_drawing_by_arycarys-d81yy6k.png",
			"http://classroomclipart.com/images/gallery/Clipart/Asia/TN_woman-man-standing-in-front-Taj-Mahal-India-clipart.jpg",
			"https://img.clipartfox.com/8ce944e94c7bb3b7f3a9c676f2bcef6d_asian-american-clipart-1-asian-clip-art_722-364.gif",
			"http://europe.phillipmartin.info/croatia_woman_m.png",
			"http://classroomclipart.com/images/gallery/Clipart/Europe/french-man-with-bread-and-red-wine.jpg",
			"http://www.prawny.me.uk/image.php?mediaID=MjcwMWM3ZDM1ZGJiZWI=&type=sample&folderID=NDJjN2QzNWRiYmVi&seo=toddler-art-european-flag-kid-prawny-clip-art",
			"http://classroomclipart.com/images/gallery/Clipart/Europe/cartoon-bear-holding-flag-of-sweden.jpg",
			"http://3.bp.blogspot.com/_oNMyXKFEdO8/S0oXfHoyVVI/AAAAAAAAY20/lvTGEHtSK8c/s320/ARTeurope_004-776345.gif",
			"http://europe.phillipmartin.info/iceland_title.png",
			"https://s-media-cache-ak0.pinimg.com/736x/a4/58/45/a458459beee494c7d259f5b667c8eaf8.jpg",
			"http://1.bp.blogspot.com/_oNMyXKFEdO8/S0ocvFS8QKI/AAAAAAAAZbM/s5EXHE5mj1A/s320/ARTeurope_051-720697.gif",
			"http://4.bp.blogspot.com/_oNMyXKFEdO8/S0oXhs55njI/AAAAAAAAY30/5VP_AWvDxTE/s320/ARTeurope_012-786128.gif",
			"https://www.clipartsgram.com/image/300982047-stock-vector-eu-flag-text-name-country-vector-illustration-hand-made-249293509.jpg",
			"https://s-media-cache-ak0.pinimg.com/originals/23/ca/d8/23cad8109c67a8aeaba612b73a93153d.jpg",
			"http://2.bp.blogspot.com/_oNMyXKFEdO8/S0ocxZGYc3I/AAAAAAAAZcU/NRgRAaNtZI4/s320/ARTeurope_060-729493.gif"
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
