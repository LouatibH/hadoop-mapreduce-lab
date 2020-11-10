package com.opstty.mapper;
import com.opstty.compare.Exo6Pair;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

// To complete according to your problem
public class Exo6Mapper extends Mapper<LongWritable, Text, NullWritable, Exo6Pair> {
    private Exo6Pair result = new Exo6Pair();
    //private Text district = new Text();
    private IntWritable year = new IntWritable();
    private final static int district_col = 1;
    private final static int year_col = 5;

    @Override
    protected void map(LongWritable keyE, Text valE, Context context) throws IOException,InterruptedException
    {
        // Ignoring header
        if (keyE.get()!=0) {
            String line = valE.toString();
            String[] splitted = line.split(";");

            String year_string = splitted[year_col];

            if (!year_string.equals("")) {
                try {

                    IntWritable year_int = new IntWritable(Integer.parseInt(year_string));
                    result.setYear(year_int);

                }
                catch(Exception e) {
                    System.out.println(e.toString());
                }

                String district_string = splitted[district_col];
                Text district = new Text(district_string);
                result.setDistrict(district);
                context.write(NullWritable.get(), result);
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