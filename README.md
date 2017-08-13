

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

<i><strong>2. Information: </strong></i>

When the user requests information using the ”-i” option,
they may pass a 2nd parameter indicating the file or directory they wish
information on. This is handled in different ways, depending on whether
it is a file or directory.

<strong>If it is a file:</strong>

• Print the absolute path to the file

• Indicate whether the file can be executed

• Print out the file size in bytes

• Print out the last modified date of the file

<strong>if it is a directory:</strong>

• Print a heading indicating that you are printing size followed by
filename

• Give each file on which you are printing the size, followed by the
filename

• Sort the files by filesize (lowest to highest)

• See example output for details

If the 2nd parameter is not a regular file or directory, print the error message:
”Error: Invalid File”

<strong><i>3. View: </i></strong>
If the user requests to view a file, the 2nd parameter should be a
regular file. If the file is not found, print an appropriate error message.
You should then print the contents of the file, as text, to the screen.
Remember to handle all exceptions you encounter.

<strong><i>4. Copy:</i></strong> If the user requests to copy a file, the 2nd parameter should be
the name of a regular file (the source file) and the 3rd parameter should
be the name of the file to copy to (the destination file). If the destination
file already exists, print an appropriate error message. If the source file
is not valid, print an appropriate error message. Then you should copy
the information from the source file to the destination file, handling any
exceptions encountered appropriately. After this, print a message to the
user stating that the copy was successful. Please note that you should be
able to copy binary files with this method, not just text files.

