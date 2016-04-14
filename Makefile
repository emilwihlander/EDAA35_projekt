all: Algorithms.class 
Algorithms.class: src/Algorithms.java
	javac -d bin/ src/Algorithms.java
clean:
	rm -f *.class
