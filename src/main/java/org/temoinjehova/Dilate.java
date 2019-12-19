package org.temoinjehova;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileWriter;

import static org.bytedeco.opencv.global.opencv_imgproc.dilate;
import static org.bytedeco.opencv.global.opencv_imgproc.getStructuringElement;

public class Dilate extends FilterMat{
    public void process(String input, String output) {
        File f = new File(input);

        File[] list= f.listFiles();
        for(File file:list) {
            Mat image = opencv_imgcodecs.imread(file.getAbsolutePath());
            try {
                image = filterDilate(image);
                File outputDir = new File(output);
                File outputFile = new File(outputDir, file.getName());
                opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
                FileWriter fw = new FileWriter("imageFilter.log", true);
                fw.write("image=" + file.getName() + " filter applied=dilate"+ "\n");
                fw.close();
            } catch (Exception e) {
                new FilterException("Filter Dilate Cannot be applied", e);
            }
        }
    }
    private Mat filterDilate(Mat image) {
        int size = 8;
        Mat result = image.clone();
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(image, result, element);
        return result;
    }
}