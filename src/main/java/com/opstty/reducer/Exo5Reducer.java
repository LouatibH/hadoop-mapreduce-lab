package com.opstty.reducer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Exo5Reducer extends Reducer<IntWritable, Text, IntWritable, Text> {


    private Text result = new Text();


    public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        Set<String> species = new HashSet<>();

        for(Text value : values) {
            species.add(value.toString());
        }

        result.set(species.toString());
        context.write(key, result);
    }
}