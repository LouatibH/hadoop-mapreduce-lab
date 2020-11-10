package com.opstty.compare;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class Exo6Pair implements Writable {
    private IntWritable year;
    private Text district;

    public Exo6Pair() {
        year = new IntWritable(0);
        district = new Text("");

    }

    public Exo6Pair(IntWritable year, Text district) {
        this.year = year;
        this.district = district;
    }

    public IntWritable getYear() {
        return year;
    }

    public void setYear(IntWritable year) {
        this.year = year;
    }

    public Text getDistrict() {
        return district;
    }

    public void setDistrict(Text district) {
        this.district = district;
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        year.readFields(dataInput);
        district.readFields(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        year.write(dataOutput);
        district.write(dataOutput);
    }

    @Override
    public String toString() {
        return year.toString() + "\t" + district.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exo6Pair exo6Pair = (Exo6Pair) o;
        return year.equals(exo6Pair.year) &&
                district.equals(exo6Pair.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, district);
    }
}
