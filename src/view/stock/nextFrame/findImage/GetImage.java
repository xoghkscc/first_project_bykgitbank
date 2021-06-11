package view.stock.nextFrame.findImage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GetImage extends JButton {

	private String fileWay;
	
	private ImageIcon iic;
	
	
	public GetImage(String fileWay,int x, int y, int width, int height) {//, int x, int y, int width, int height
		// TODO Auto-generated constructor stub
		
//		setBounds(x,y,width,height);
		
		File fi = new File(fileWay);
		try {
			BufferedImage buffi = ImageIO.read(fi);
			
			iic = new ImageIcon(buffi.getSubimage(67, 26, 194, 190).getScaledInstance(width, height, Image.SCALE_DEFAULT));
			
			setIcon(new ImageIcon(buffi.getSubimage(67, 26, 194, 190).getScaledInstance(width, height, Image.SCALE_DEFAULT)));
//			setIcon(new ImageIcon(ImageIO.read(fi)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ImageIcon getIic() {
		return iic;
	}

	
//	public static void main(String[] args) {
//		new GetImage()
//	}
}