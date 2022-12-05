JAVA = java
CC = $(JAVA)c
OPT =
VERSION = --release 11

FLAGS =
WARNINGS =
REMOVE_WARN =
HEADERS =
LIBS = -classpath ./lib/jspec.jar:./test

INPUT = test/**/*.java test/TestRunner.java
OUTPUT = test/**/*.class test/*.class

all:
	$(CC) $(LIBS) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(INPUT)
	$(JAVA) $(LIBS) TestRunner

clean:
	$(RM) -r $(OUTPUT)
