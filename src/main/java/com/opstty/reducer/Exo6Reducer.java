package com.opstty.reducer;
import com.opstty.compare.Exo6Pair;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class Exo6Reducer extends Reducer<NullWritable, Exo6Pair, NullWritable, Text> {


    private Text district = new Text();

    @Override
    public void reduce(final NullWritable key, final Iterable<Exo6Pair> values,
                       final Context context) throws IOException, InterruptedException {

        String oldest_district = "";
        int max_year = 2020;
        for(Exo6Pair value:values) {
            if (value.getYear().get() < max_year) {
                max_year = value.getYear().get();
                oldest_district = value.getDistrict().toString();
            }
        }
        
        district.set(oldest_district);    
        context.write(NullWritable.get(), district);
    }
}