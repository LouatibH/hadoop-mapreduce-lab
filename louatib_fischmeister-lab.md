######## Hanaa LOUATIB - Anna FISCHMEISTER ##########

# MapReduceJava Lab

### • Send the Jar to the edge node
##### • Mac OS X

	"""scp /Users/annafischmeister/IdeaProjects/hadoop-examples-mapreduce/target/hadoop-examples-mapreduce-1.0-SNAPSHOT.jar afischmeister@hadoop-edge01.efrei.online:/home/afischmeister

_**output :**_ 
Welcome to EFREI Hadoop Cluster

Password: 
hadoop-examples-mapreduce-1.0-SNAPSHOT.jar    100%   27KB 968.5KB/s   00:00    

##### • Connection to the cluster

	ssh afischmeister@hadoop-edge01.efrei.online

_**output :**_ 
Welcome to EFREI Hadoop Cluster

Password: 
Last login: Tue Nov 10 09:52:22 2020 from static-176-175-75-231.ftth.abo.bbox.fr

	kinit afischmeister@EFREI.ONLINE

_**output :**_ 
Password for afischmeister@EFREI.ONLINE: 
[afischmeister@hadoop-edge01 ~]$ 

##### • Run the job 

	""" yarn jar /home/afischmeister/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar wordcount 
--> adding an input file and output file

_**output :**_ 
Usage: wordcount <in> [<in>...] <out>

################## • Lab work.  ##############################
We used the remarkable Paris trees dataset (CSV file)
Downloading the trees.csv file and putting it in hdfs 

	hdfs dfs -put trees.csv
	hdfs dfs -ls

_**output :**_ 
-rw-r--r--   3 afischmeister afischmeister      16680 2020-10-28 15:43 trees.csv

This command ca show you all our jobs with the description of each one

	yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar

An example program must be given as the first argument.
Valid program names are:
  exo1: A map/reduce program that gives districts containing trees in the input files.
  exo2: A map/reduce program that shows all existing species trees in the input files.
  exo3: A map/reduce program that gives the number of trees by species in the input files.
  exo4: A map/reduce program that gives the maximum height per specie of tree in the input files.
  exo5: A map/reduce program that sort the  height per specie of tree from smallest to in the input files.
  exo6: A map/reduce program that gives the district containing the oldest tree  in the input files.
  wordcount: A map/reduce program that counts the words in the input files.


################## • District containing trees -Exo1 OK

This exercice job return all the districts of Paris which contain trees
The mapper class maps all the district occurrence to a NullWritable.
The reducer class returns the district as output key and NullWritable as value contain null. 

	yarn jar /home/afischmeister/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar exo1 /user/afischmeister/trees.csv /user/afischmeister/exo1

_**output :**_ 
...
...
20/11/10 22:19:25 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 22:19:35 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 22:19:40 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 22:19:41 INFO mapreduce.Job: Job job_1603290159664_3660 completed successfully
20/11/10 22:19:41 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=477
		FILE: Number of bytes written=494933
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16781
		HDFS: Number of bytes written=44
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=21696
		Total time spent by all reduces in occupied slots (ms)=11728
		Total time spent by all map tasks (ms)=7232
		Total time spent by all reduce tasks (ms)=2932
		Total vcore-milliseconds taken by all map tasks=7232
		Total vcore-milliseconds taken by all reduce tasks=2932
		Total megabyte-milliseconds taken by all map tasks=11108352
		Total megabyte-milliseconds taken by all reduce tasks=6004736
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=277
		Map output materialized bytes=477
		Input split bytes=101
		Combine input records=0
		Combine output records=0
		Reduce input groups=17
		Reduce shuffle bytes=477
		Reduce input records=97
		Reduce output records=17
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=188
		CPU time spent (ms)=3260
		Physical memory (bytes) snapshot=1445412864
		Virtual memory (bytes) snapshot=7268962304
		Total committed heap usage (bytes)=1560281088
		Peak Map Physical memory (bytes)=1153769472
		Peak Map Virtual memory (bytes)=3393499136
		Peak Reduce Physical memory (bytes)=291643392
		Peak Reduce Virtual memory (bytes)=3875463168
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=44

	hdfs dfs -cat /user/afischmeister/exo1/part-r-00000

_**output:**_
11
12
13
14
15
16
17
18
19
20
3
4
5
6
7
8
9

################## • Show all existing species -Exo2 OK

This exercice job return the different tree species.
The mapper class maps all the species occurrence to a NullWritable.
The reducer class returns the species as output key and NullWritable as value contain null.

	yarn jar /home/afischmeister/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar exo2 /user/afischmeister/trees.csv /user/afischmeister/exo2

_**output:**_
...
...
20/11/10 22:24:54 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 22:25:04 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 22:25:15 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 22:25:15 INFO mapreduce.Job: Job job_1603290159664_3662 completed successfully
20/11/10 22:25:15 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=1035
		FILE: Number of bytes written=496049
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16781
		HDFS: Number of bytes written=317
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=20940
		Total time spent by all reduces in occupied slots (ms)=28820
		Total time spent by all map tasks (ms)=6980
		Total time spent by all reduce tasks (ms)=7205
		Total vcore-milliseconds taken by all map tasks=6980
		Total vcore-milliseconds taken by all reduce tasks=7205
		Total megabyte-milliseconds taken by all map tasks=10721280
		Total megabyte-milliseconds taken by all reduce tasks=14755840
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=835
		Map output materialized bytes=1035
		Input split bytes=101
		Combine input records=0
		Combine output records=0
		Reduce input groups=36
		Reduce shuffle bytes=1035
		Reduce input records=97
		Reduce output records=36
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=193
		CPU time spent (ms)=3350
		Physical memory (bytes) snapshot=1455128576
		Virtual memory (bytes) snapshot=7273246720
		Total committed heap usage (bytes)=1555562496
		Peak Map Physical memory (bytes)=1156268032
		Peak Map Virtual memory (bytes)=3396128768
		Peak Reduce Physical memory (bytes)=298860544
		Peak Reduce Virtual memory (bytes)=3877117952
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=317

	hdfs dfs -cat /user/afischmeister/exo2/part-r-00000

_**output:**_
Acer
Aesculus
Ailanthus
Alnus
Araucaria
Broussonetia
Calocedrus
Catalpa
Cedrus
Celtis
Corylus
Davidia
Diospyros
Eucommia
Fagus
Fraxinus
Ginkgo
Gymnocladus
Juglans
Liriodendron
Maclura
Magnolia
Paulownia
Pinus
Platanus
Pterocarya
Quercus
Robinia
Sequoia
Sequoiadendron
Styphnolobium
Taxodium
Taxus
Tilia
Ulmus
Zelkova

################## • Number of trees by species -Exo3 OK

This exercice job return the number of trees in each species.
The mapper class maps all the species to an IntWritable that have the value one.
The reducer class returns the species as output key and the number of trees of each species as value.

	yarn jar /home/afischmeister/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar exo3 /user/afischmeister/trees.csv /user/afischmeister/exo3

_**output:**_ 
...
...
20/11/10 22:28:13 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 22:28:22 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 22:28:32 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 22:28:33 INFO mapreduce.Job: Job job_1603290159664_3663 completed successfully
20/11/10 22:28:33 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=1423
		FILE: Number of bytes written=496823
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16781
		HDFS: Number of bytes written=390
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=20814
		Total time spent by all reduces in occupied slots (ms)=28680
		Total time spent by all map tasks (ms)=6938
		Total time spent by all reduce tasks (ms)=7170
		Total vcore-milliseconds taken by all map tasks=6938
		Total vcore-milliseconds taken by all reduce tasks=7170
		Total megabyte-milliseconds taken by all map tasks=10656768
		Total megabyte-milliseconds taken by all reduce tasks=14684160
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=1223
		Map output materialized bytes=1423
		Input split bytes=101
		Combine input records=0
		Combine output records=0
		Reduce input groups=36
		Reduce shuffle bytes=1423
		Reduce input records=97
		Reduce output records=36
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=208
		CPU time spent (ms)=3380
		Physical memory (bytes) snapshot=1460211712
		Virtual memory (bytes) snapshot=7274295296
		Total committed heap usage (bytes)=1538785280
		Peak Map Physical memory (bytes)=1161015296
		Peak Map Virtual memory (bytes)=3396845568
		Peak Reduce Physical memory (bytes)=299196416
		Peak Reduce Virtual memory (bytes)=3877449728
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=390

	hdfs dfs -cat /user/afischmeister/exo3/part-r-00000

_**output:**_
Acer	3
Aesculus	3
Ailanthus	1
Alnus	1
Araucaria	1
Broussonetia	1
Calocedrus	1
Catalpa	1
Cedrus	4
Celtis	1
Corylus	3
Davidia	1
Diospyros	4
Eucommia	1
Fagus	8
Fraxinus	1
Ginkgo	5
Gymnocladus	1
Juglans	1
Liriodendron	2
Maclura	1
Magnolia	1
Paulownia	1
Pinus	5
Platanus	19
Pterocarya	3
Quercus	4
Robinia	1
Sequoia	1
Sequoiadendron	5
Styphnolobium	1
Taxodium	3
Taxus	2
Tilia	1
Ulmus	1
Zelkova	4
################## • Maximum height per specie of tree -Exo4 OK

This exercice job return the tallest tree in each species.
The mapper class maps all the species to their heights
The reducer class have the species and all his heights as output key and return the Max value of the heights as value.

	yarn jar /home/afischmeister/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar exo4 /user/afischmeister/trees.csv /user/afischmeister/exo4

_**output:**_ 

...
...
20/11/10 22:12:44 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 22:12:53 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 22:13:03 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 22:13:03 INFO mapreduce.Job: Job job_1603290159664_3655 completed successfully
20/11/10 22:13:03 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=1402
		FILE: Number of bytes written=496785
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16781
		HDFS: Number of bytes written=496
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=20856
		Total time spent by all reduces in occupied slots (ms)=28116
		Total time spent by all map tasks (ms)=6952
		Total time spent by all reduce tasks (ms)=7029
		Total vcore-milliseconds taken by all map tasks=6952
		Total vcore-milliseconds taken by all reduce tasks=7029
		Total megabyte-milliseconds taken by all map tasks=10678272
		Total megabyte-milliseconds taken by all reduce tasks=14395392
	Map-Reduce Framework
		Map input records=98
		Map output records=96
		Map output bytes=1204
		Map output materialized bytes=1402
		Input split bytes=101
		Combine input records=0
		Combine output records=0
		Reduce input groups=36
		Reduce shuffle bytes=1402
		Reduce input records=96
		Reduce output records=36
		Spilled Records=192
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=215
		CPU time spent (ms)=3200
		Physical memory (bytes) snapshot=1456898048
		Virtual memory (bytes) snapshot=7275130880
		Total committed heap usage (bytes)=1568669696
		Peak Map Physical memory (bytes)=1160617984
		Peak Map Virtual memory (bytes)=3396407296
		Peak Reduce Physical memory (bytes)=296280064
		Peak Reduce Virtual memory (bytes)=3878723584
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=496


	hdfs dfs -cat /user/afischmeister/exo4/part-r-00000

_**output:**_
Acer	16.0
Aesculus	30.0
Ailanthus	35.0
Alnus	16.0
Araucaria	9.0
Broussonetia	12.0
Calocedrus	20.0
Catalpa	15.0
Cedrus	30.0
Celtis	16.0
Corylus	20.0
Davidia	12.0
Diospyros	14.0
Eucommia	12.0
Fagus	30.0
Fraxinus	30.0
Ginkgo	33.0
Gymnocladus	10.0
Juglans	28.0
Liriodendron	35.0
Maclura	13.0
Magnolia	12.0
Paulownia	20.0
Pinus	30.0
Platanus	45.0
Pterocarya	30.0
Quercus	31.0
Robinia	11.0
Sequoia	30.0
Sequoiadendron	35.0
Styphnolobium	10.0
Taxodium	35.0
Taxus	13.0
Tilia	20.0
Ulmus	15.0
Zelkova	30.0

################## • Sort the trees height from smallest to largest -Exo5 OK

This exercice job return and sort the trees from smallest to largest.
The mapper class maps all the heights to their species
The reducer class have the heights already sort and we have to return the heights as output key and list of the trees that having this height as value.

	yarn jar /home/afischmeister/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar exo5 /user/afischmeister/trees.csv /user/afischmeister/exo5

_**output:**_ 
...
...
20/11/10 22:05:47 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 22:05:59 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 22:06:09 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 22:06:09 INFO mapreduce.Job: Job job_1603290159664_3651 completed successfully
20/11/10 22:06:09 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=1423
		FILE: Number of bytes written=496823
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16781
		HDFS: Number of bytes written=894
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=22896
		Total time spent by all reduces in occupied slots (ms)=31068
		Total time spent by all map tasks (ms)=7632
		Total time spent by all reduce tasks (ms)=7767
		Total vcore-milliseconds taken by all map tasks=7632
		Total vcore-milliseconds taken by all reduce tasks=7767
		Total megabyte-milliseconds taken by all map tasks=11722752
		Total megabyte-milliseconds taken by all reduce tasks=15906816
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=1223
		Map output materialized bytes=1423
		Input split bytes=101
		Combine input records=0
		Combine output records=0
		Reduce input groups=28
		Reduce shuffle bytes=1423
		Reduce input records=97
		Reduce output records=28
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=179
		CPU time spent (ms)=3520
		Physical memory (bytes) snapshot=1460695040
		Virtual memory (bytes) snapshot=7277633536
		Total committed heap usage (bytes)=1560281088
		Peak Map Physical memory (bytes)=1165213696
		Peak Map Virtual memory (bytes)=3399843840
		Peak Reduce Physical memory (bytes)=295481344
		Peak Reduce Virtual memory (bytes)=3877789696
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=894

	hdfs dfs -cat /user/afischmeister/exo5/part-r-00000

_**output:**_
2	[Fagus]
5	[Taxus]
6	[Cedrus]
9	[Araucaria]
10	[Fagus, Quercus, Styphnolobium, Pinus, Gymnocladus]
11	[Robinia]
12	[Acer, Davidia, Broussonetia, Diospyros, Magnolia, Eucommia, Zelkova]
13	[Taxus, Maclura]
14	[Diospyros, Pinus]
15	[Acer, Fagus, Ulmus, Quercus, Catalpa]
16	[Acer, Celtis, Alnus, Zelkova]
18	[Aesculus, Fagus, Ginkgo, Zelkova]
20	[Fagus, Sequoiadendron, Calocedrus, Paulownia, Corylus, Tilia, Taxodium, Platanus]
22	[Aesculus, Pterocarya, Ginkgo, Liriodendron, Platanus]
23	[Fagus]
25	[Ginkgo, Pinus, Cedrus, Platanus]
26	[Platanus]
27	[Sequoiadendron, Pterocarya, Platanus]
28	[Juglans]
30	[Aesculus, Fagus, Sequoiadendron, Pterocarya, Quercus, Pinus, Sequoia, Cedrus, Fraxinus, Zelkova, Taxodium, Platanus]
31	[Quercus, Platanus]
32	[Platanus]
33	[Ginkgo]
34	[Platanus]
35	[Sequoiadendron, Ailanthus, Liriodendron, Taxodium, Platanus]
40	[Platanus]
42	[Platanus]
45	[Platanus]

##### • District containing the oldest tree -Exo6 OK

This exercice job return the district where the oldest tree is.

We have to aggregate the districts and years in composed key. So we create Exo6Pair class that combine the both and enable to compare this object.

The mapper class combine the district and year and sent them as value, and NullWritable as key.
The reducer class return NullWritable as output key and the district having old tree as value.


	yarn jar /home/afischmeister/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar exo6 /user/afischmeister/trees.csv /user/afischmeister/exo6

_**output:**_
...
...
20/11/10 22:37:14 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 22:37:23 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 22:37:33 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 22:37:33 INFO mapreduce.Job: Job job_1603290159664_3670 completed successfully
20/11/10 22:37:34 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=687
		FILE: Number of bytes written=495317
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16781
		HDFS: Number of bytes written=2
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=20607
		Total time spent by all reduces in occupied slots (ms)=28360
		Total time spent by all map tasks (ms)=6869
		Total time spent by all reduce tasks (ms)=7090
		Total vcore-milliseconds taken by all map tasks=6869
		Total vcore-milliseconds taken by all reduce tasks=7090
		Total megabyte-milliseconds taken by all map tasks=10550784
		Total megabyte-milliseconds taken by all reduce tasks=14520320
	Map-Reduce Framework
		Map input records=98
		Map output records=77
		Map output bytes=527
		Map output materialized bytes=687
		Input split bytes=101
		Combine input records=0
		Combine output records=0
		Reduce input groups=1
		Reduce shuffle bytes=687
		Reduce input records=77
		Reduce output records=1
		Spilled Records=154
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=188
		CPU time spent (ms)=3120
		Physical memory (bytes) snapshot=1449250816
		Virtual memory (bytes) snapshot=7268179968
		Total committed heap usage (bytes)=1546649600
		Peak Map Physical memory (bytes)=1153339392
		Peak Map Virtual memory (bytes)=3394854912
		Peak Reduce Physical memory (bytes)=295911424
		Peak Reduce Virtual memory (bytes)=3873325056
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=2

	hdfs dfs -cat /user/afischmeister/exo6/part-r-00000

_**output:**_
5


##### • District containing the most trees

	yarn jar /home/afischmeister/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar exo7 /user/afischmeister/trees.csv /user/afischmeister/exo7

_**output:**_

	hdfs dfs -cat /user/afischmeister/exo7/part-r-00000

_**output:**_

