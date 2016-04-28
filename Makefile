all: Algorithms.class almostNotSortedIndata.class almostSortedIndata.class
Algorithms.class: src/Algorithms.java 
	javac -d bin/ src/Algorithms.java
almostNotSortedIndata.class: src/makeIndata/almostNotSortedIndata.java
	javac -d bin/ src/makeIndata/almostNotSortedIndata.java
almostSortedIndata.class: src/makeIndata/almostSortedIndata.java
	javac -d bin/ src/makeIndata/almostSortedIndata.java
clean:
	rm -f *.class
