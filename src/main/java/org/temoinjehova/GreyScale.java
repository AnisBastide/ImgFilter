package org.temoinjehova;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileWriter;

import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class GreyScale extends FilterMat{
    public void process(String input, String output) {
        File f = new File(input);

        File[] list= f.listFiles();
        for(File file:list) {
            Mat image = opencv_imgcodecs.imread(file.getAbsolutePath());
            try {
                image = filterGrayscale(image);
                File outputDir = new File(output);
                File outputFile = new File(outputDir, file.getName());
                opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
                FileWriter fw = new FileWriter("imageFilter.log", true);
                fw.write("image=" + file.getName() + " filter applied=greyscale"+ "\n");
                fw.close();
            } catch (Exception e) {
                new FilterException("Filter Greyscale Cannot be applied", e);
            }
        }
    }



    private Mat filterGrayscale(Mat image) {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
        return result;
    }
}
