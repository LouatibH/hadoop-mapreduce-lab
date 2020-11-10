package com.opstty.mapper;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class Exo2Mapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    //private final static IntWritable one = new IntWritable(1);
    private final static int species_col = 2;
    private Text species = new Text();

    @Override
    protected void map(LongWritable keyE, Text valE, Context context) throws IOException,InterruptedException
    {
        // Ignoring header
        if (keyE.get()!=0) {
            String line = valE.toString();
            // Split and get the type
            String[] splitted = line.split(";");
            String typeString = splitted[species_col];
            species.set(typeString);
            // Emit (type, 1)
            context.write(species,NullWritable.get());
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