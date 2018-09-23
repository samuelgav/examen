package pe.com.examen.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	private static final String ABS_PATH="D:/EclipseProjects/examen/src/main/webapp/assets/images/";
	private static String REAL_PATH=null;
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code){
		
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		
		if(!new File(REAL_PATH).exists()){
			new File(REAL_PATH).mkdirs();
		}
		
		if(!new File(ABS_PATH).exists()){
			new File(ABS_PATH).mkdirs();
		}
		
		try {
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			file.transferTo(new File(ABS_PATH+code+".jpg"));
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static void uploadNoImage(HttpServletRequest request,String code){
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
		String imageURL = "http://placehold.it/640X480?text=No Image";
		String destinationServerFile=REAL_PATH + code+ ".jpg";
		String destinationProjectFile=REAL_PATH + code+".jpg";
		
		try {
			URL url=new URL(imageURL);
			try(InputStream is=url.openStream();
				OutputStream osREAL_PATH=new FileOutputStream(destinationServerFile);
				OutputStream osABS_PATH=new FileOutputStream(destinationProjectFile);
				){
				byte[] b=new byte[2048];
				int length;
				while((length=is.read(b))!=-1){
					osREAL_PATH.write(b, 0, length);
					osABS_PATH.write(b, 0, length);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

