package org.temoinjehova;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import java.io.File;
import java.io.FileWriter;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;

/**
 * apply a blur on an image
 * child of class FilterMat
 */
public class BlurFilter extends FilterMat{
    public BlurFilter() {

    }
    /**
     * Launch the filter process and manage the input and output file
     * @param input name of the input file
     * @param output name of the output file
     */
    public void process(String input, String output) {
        File f = new File(input);

        File[] list= f.listFiles();
        for(File file:list) {
            Mat image = opencv_imgcodecs.imread(file.getAbsolutePath());
            try {
                image = filterBlur(image);
                File outputDir = new File(output);
                File outputFile = new File(outputDir, file.getName());
                opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
                FileWriter fw = new FileWriter("imageFilter.log", true);
                fw.write("image=" + file.getName() + " filter applied=Blur"+ "\n");
                fw.close();
            } catch (Exception e) {
                new FilterException("Filter Blur Cannot be applied", e);
            }
        }
    }

    /**
     * Apply the blur filter on the image
     * @param image image on which the filter is applied
     * @return the image with the filter
     */
    private Mat filterBlur(Mat image) {
        int size = 25;
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }

}

