package lib;

import java.io.File;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class HandlingDesktopWindows {
	AutoItX x = null;

	public HandlingDesktopWindows() {
		File file = new File(System.getProperty("user.dir") + "\\externalLibreries\\jacob-1.18-M2-x64.dll"); 
		System.out.println(file.getAbsolutePath());
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		x = new AutoItX();

	}

	public void setUploadFile() {
		x.send("C:\\Images\\newLogo.jpg");
		x.send("{ENTER}!n", false );
	}

	public void sleep(int i) {
		x.sleep(i);

	}
}
