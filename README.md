

<strong>Java File Viewer </strong>

Program to access file system using Java's File class and use of input/output streams. 

Program accepts the following command line options: 

• ”-i” (for (i)nformation) with an optional file or directory as a 2nd
parameter. If no 2nd parameter is passed, default to the current
directory ”.”

• ”-v” (for (v)iew) with a file to view as the 2nd parameter

• ”-c” (for (c)opy) with a sourcefile as the 2nd parameter and a destination
file as the 3rd parameter

• If no parameters are passed, then the program should default to
displaying information on the current directory (as if the user had
passed ”-i .”)


If the command is invalid usage (illegal options), print a usage message,
as below, then exit the program:
Usage : java -jar hw4.jar

[-i [<file>|<directory>]|-v <file>|-c <sourceFile> <destFile>]

