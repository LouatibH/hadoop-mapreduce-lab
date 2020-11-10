package com.opstty;

import com.opstty.job.WordCount;
import com.opstty.job.Exo1;
import com.opstty.job.Exo2;
import com.opstty.job.Exo3;
import com.opstty.job.Exo4;
import com.opstty.job.Exo5;
import com.opstty.job.Exo6;

import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");

            programDriver.addClass("exo1", Exo1.class,
                    "A map/reduce program that gives districts containing trees in the input files.");

            programDriver.addClass("exo2", Exo2.class,
                    "A map/reduce program that shows all existing species trees in the input files.");

            programDriver.addClass("exo3", Exo3.class,
                    "A map/reduce program that gives the number of trees by species in the input files.");

            programDriver.addClass("exo4", Exo4.class,
                    "A map/reduce program that gives the maximum height per specie of tree in the input files.");

            programDriver.addClass("exo5", Exo5.class,
                    "A map/reduce program that sort the  height per specie of tree from smallest to in the input files.");

            programDriver.addClass("exo6", Exo6.class,
                    "A map/reduce program that gives the district containing the oldest tree  in the input files.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
