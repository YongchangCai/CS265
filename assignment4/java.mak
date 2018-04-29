
####  Java  ########
# If, e.g., you have 2 files:
#   a4.java - contains the driver (the main method)
#   account.java - another class
# 
# NOTE:  You'll need a Bash script called accounts, to invoke the JVM, on
#        your entry class

.PHONY : build view clean

build :
	chmod +x accounts
	javac a4.java account.java

view :
	-@\less a4.java account.java

clean :
	@\rm *.class

