package org.temoinjehova;

import org.apache.commons.cli.*;

import java.util.Arrays;

/**
 * Main class (launched when you launch the code)
 */
public class Main {
    /**
     * main method (launched when you launched the code)
     * @param args arguments that are given when you launch the code
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        String input="imgs";
        String output="output";

        Options options= new Options();
        options.addOption("i","input-dir",true,"input directory");
        options.addOption("o","output-dir",true,"Output directory");
        options.addOption("h","help",false,"Display all arguments");
        options.addOption("f","filter",true,"Choose filter");


        CommandLineParser parser = new DefaultParser();
        try{
            CommandLine cmd = parser.parse(options,args);
            if (cmd.hasOption("h")){
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "ant", options );
            }
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
        try{
            CommandLine cmd = parser.parse(options,args);
            if(cmd.hasOption("f")){
               String filter=cmd.getOptionValue("f");
                switch(filter){
                    case "blur":BlurFilter blur = new BlurFilter();
                    blur.process(input,output);
                    break;
                    case "dilate":Dilate dilate=new Dilate();
                        dilate.process(input,output);
                        break;
                    case "greyscale": GreyScale grey=new GreyScale();
                              grey.process(input,output);
                              break;
                    default:
                        System.out.println("You need to give a filter");
                    break;
                }

            }
            if(cmd.hasOption("o")){
                output = cmd.getOptionValue("o");
                System.out.println(output);
            }
        } catch (org.apache.commons.cli.ParseException e) {
            e.printStackTrace();
        }
    }
}
