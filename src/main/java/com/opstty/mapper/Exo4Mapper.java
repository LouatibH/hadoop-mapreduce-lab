package com.opstty.mapper;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class Exo4Mapper extends Mapper<LongWritable, Text, Text, FloatWritable> {

    private FloatWritable height = new FloatWritable();
    private final static int species_col = 2;
    private final static int height_col = 6;
    private Text species = new Text();

    @Override
    protected void map(LongWritable keyE, Text valE, Context context) throws IOException,InterruptedException
    {
        // Ignoring header
        if (keyE.get()!=0) {
            String line = valE.toString();
            String[] splitted = line.split(";");

            try {
                // Get type and height
                float height_float = Float.parseFloat(splitted[height_col]);
                height.set(height_float);
                String type_string = splitted[species_col];
                species.set(type_string);

                //Emit (type, height)
                context.write(species, height);
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
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