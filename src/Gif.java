import javax.swing.ImageIcon;


public class Gif {
	
	String name;
	String url;
	ImageIcon gifImage;
	public Gif( String name, String url) {
		this.name = name;
		this.url = url;
		gifImage = new ImageIcon(this.url);		
	}
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ImageIcon getGifImage() {
		return gifImage;
	}
	public String toString()
	{
		return getName() + " " + getUrl();
	}
}