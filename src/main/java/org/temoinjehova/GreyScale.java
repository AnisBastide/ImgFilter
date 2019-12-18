package org.temoinjehova;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class GreyScale extends FilterMat{
    public void process() {
        File f = new File("imgs/test.jpg");
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        image = filterGrayscale(image);

        File outputDir = new File("output");
        File outputFile = new File(outputDir, "result.jpg");
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }
    private Mat filterGrayscale(Mat image) {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
        return result;
    }
}
