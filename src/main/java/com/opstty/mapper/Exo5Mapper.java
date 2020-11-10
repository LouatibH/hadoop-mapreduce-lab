package com.opstty.mapper;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class Exo5Mapper extends Mapper<LongWritable, Text, IntWritable, Text> {

    private IntWritable height = new IntWritable();
    private final static int species_col = 2;
    private final static int height_col = 6;
    private Text species = new Text();

    @Override
    public void map(LongWritable keyE, Text valE, Context context) throws IOException, InterruptedException {
        // Ignoring header
        if (keyE.get()!=0) {
            String line = valE.toString();
            String[] splitted = line.split(";");

            try {
                String height_s = splitted[height_col];
                int height_f = Double.valueOf(height_s).intValue();
                height.set(height_f);
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }

            String species_s = splitted[species_col];
            species.set(species_s);
            context.write(height, species);
        }

    }

    public void run(Context context) throws IOException, InterruptedException {
        setup(context);
        while (context.nextKeyValue()) {
            map(context.getCurrentKey(), context.getCurrentValue(), context);
        }
        cleanup(context);
    }

}