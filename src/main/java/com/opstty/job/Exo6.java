package com.opstty.job;
import com.opstty.compare.Exo6Pair;
import com.opstty.mapper.Exo6Mapper;
import com.opstty.reducer.Exo6Reducer;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;


public class Exo6 extends Configured implements Tool {


    public int run(String[] args) throws Exception {

        if (args.length != 2) {
            System.out.println("Usage: [input] [output]");
            System.exit(-1);
        }


        // Job creation and description
        Job job = Job.getInstance(getConf());
        job.setJobName("Exo6");


        // Precise Driver, Mapper and Reducer
        job.setJarByClass(Exo6.class);
        job.setMapperClass(Exo6Mapper.class);
        job.setReducerClass(Exo6Reducer.class);


        // Types of key/values for the mapper and the reducer
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Exo6Pair.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(TextOutputFormat.class);

        // Input and output file path
        Path inputFilePath = new Path(args[0]);
        Path outputFilePath = new Path(args[1]);


        // If folder, go into all documents
        FileInputFormat.setInputDirRecursive(job, true);
        FileInputFormat.addInputPath(job, inputFilePath);
        FileOutputFormat.setOutputPath(job, outputFilePath);

        // If output already exists, delete it
        FileSystem fs = FileSystem.newInstance(getConf());
        if (fs.exists(outputFilePath)) {
            fs.delete(outputFilePath, true);
        }

        return job.waitForCompletion(true) ? 0: 1;
    }

    public static void main(String[] args) throws Exception {
        Exo6 exempleDriver = new Exo6();
        int res = ToolRunner.run(exempleDriver, args);
        System.exit(res);

    }
}