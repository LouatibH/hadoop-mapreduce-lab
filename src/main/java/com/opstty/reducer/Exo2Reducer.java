package com.opstty.reducer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;

public class Exo2Reducer extends Reducer<Text, IntWritable, Text, IntWritable> {


    @Override
    public void reduce(final Text key, final Iterable<IntWritable> values,
                       final Context context) throws IOException, InterruptedException {


        context.write(key, null);
    }
}