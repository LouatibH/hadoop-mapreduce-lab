package com.opstty.mapper;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

// To complete according to your problem
public class Exo1Mapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    private Text district = new Text();
    private final static int district_col = 1;


    @Override
    protected void map(LongWritable keyE, Text valE, Context context) throws IOException, InterruptedException {
        // Ignoring header
        if (keyE.get() != 0) {
            String line = valE.toString();
            String[] splitted = line.split(";");

            try {
                // Get district
                String district_string = splitted[district_col];
                district.set(district_string);

                context.write(district, NullWritable.get());
            } catch (Exception e) {
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
