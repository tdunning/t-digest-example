# Example t-digest program

This is a simple project that puts some data in a t-digest and computes some 
simple values from the data.

The point is not so much to show how to use the t-digest, but rather to test 
that the t-digest artifacts have been loaded correctly to maven central and 
can be used by an independent project.

To compile and package the example:
```bash
mvn package
```
To run the example program:
```bash
mvn -q exec:java -Dexec.mainClass=com.tdunning.Example
```
The output should look like this:
```
type,x,tdigest,empirical,relative_error
cdf,0.0000100,0.0000090,0.0000090,0.0000000
cdf,0.9999900,0.9999860,0.9999860,0.0000000
cdf,0.0001000,0.0000962,0.0000950,0.0123375
cdf,0.9999000,0.9998946,0.9998950,0.0038542
cdf,0.0010000,0.0009799,0.0009820,0.0021319
cdf,0.9990000,0.9990318,0.9990260,0.0058071
cdf,0.0100000,0.0100475,0.0100470,0.0000467
cdf,0.9900000,0.9901782,0.9901380,0.0040238
cdf,0.1000000,0.0997367,0.0997640,0.0002726
cdf,0.9000000,0.9000532,0.8998780,0.0017521
```