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
        File f = new File("imgs/test.jpg");
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterBlur(image);

        File outputDir = new File("output");
        File outputFile = new File(outputDir, "result.jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }
    private Mat filterBlur(Mat image) {
        int size = 25;
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }
}
