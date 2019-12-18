package org.temoinjehova;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;

public class BlurFilter extends FilterMat{
    public BlurFilter() {

    }
    public void process() {
        File f = new File("imgs/");

        File[] list= f.listFiles();
        for(File file:list) {
            Mat image = opencv_imgcodecs.imread(file.getAbsolutePath());
            try {
                image = filterBlur(image);
                File outputDir = new File("output");
                File outputFile = new File(outputDir, file.getName());
                opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
            } catch (Exception e) {
                new FilterException("Filter Blur Cannot be applied", e);
            }
        }
    }




    private Mat filterBlur(Mat image) {
        int size = 25;
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }

}

