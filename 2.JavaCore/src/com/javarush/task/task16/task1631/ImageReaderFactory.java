package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;


public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageTypes)  {
        ImageReader obj = null;
        try {
            if (imageTypes.equals(ImageTypes.BMP)) obj = new BmpReader();
            if (imageTypes.equals(ImageTypes.JPG)) obj = new JpgReader();
            if (imageTypes.equals(ImageTypes.PNG)) obj = new PngReader();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        return obj;
    }
}
