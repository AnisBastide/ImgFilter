package org.temoinjehova;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        String input="imgs";
        String output="output";

        //String intputDirArg="";
        String filterArg="";

        Options options= new Options();
        options.addOption("i","input-dir",true,"input directory");
        options.addOption("o","output-dir",true,"Output directory");
        options.addOption("h","help",false,"Display all arguments");

        CommandLineParser parser = new DefaultParser();
        try{
            CommandLine cmd = parser.parse(options,args);
            if(cmd.hasOption("i")){
                input=cmd.getOptionValue("i");
                System.out.println(input);
            }
            if(cmd.hasOption("o")){
                output = cmd.getOptionValue("o");
                System.out.println(output);
            }
        } catch (org.apache.commons.cli.ParseException e) {
            e.printStackTrace();
        }

//        BlurFilter blur = new BlurFilter();
//       blur.process(input,output);
     Dilate dilate=new Dilate();
      dilate.process(input,output);
 //       GreyScale grey=new GreyScale();
 //         grey.process(input,output);

    }
}
