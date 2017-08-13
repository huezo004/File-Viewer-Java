//Denyse Huezo dah12
//Implements EC (-d ) option
import java.io.*;
import java.util.*;
import java.lang.*; 

public class FileViewer {
    public static void main(String[] args) throws Exception{

     String usage="Usage: java -jar hw4.jar [-i[<file>]|<directory>]|-v <file>|-c <sourceFile> <destFile>]";
	
	if(args.length == 0){ // default with no parameters	    
	    File f1 = new File(".");  // create File object 
	    File [] fileArray= f1.listFiles();  //returns list of files under directory 
	    System.out.println("Size    Filename");
	    Arrays.sort(fileArray, new Asort()); // overriten sort function 
	    for(File f: fileArray){   // for loop to print size and name of files/directories under directory 
		System.out.print(f.length());
		System.out.print("          ");
		System.out.println(f.getName());
	    }
	}//end lenght==0
	
	//** -i option 
	if(args.length==1){
	    if(!args[0].equals("-i")){		
		System.out.println(usage);
		System.exit(0); 
	    }
	    if(args[0].equals("-i")){	     
	      File f1 = new File(".");
	      File [] fileArray= f1.listFiles();
	      System.out.println("Size    Filename");
	      Arrays.sort(fileArray, new Asort());		   
	           for(File f: fileArray){
		     System.out.print(f.length());
		     System.out.print("          "); 
		     System.out.println(f.getName()); 
		   }	      
	    }// end if .equals(-i) 
	}//end if(length==1)

	 //** 3 Arguments**//
	//*check for valid command*
	
       if(args.length==3){	   
	   if(!args[0].equals("-c") && !args[0].equals("-d")){    
	       System.out.println(usage);
	       System.exit(0); 
	   }// end of command validation

	   /* if(!args[0].equals("-d")){
	       System.out.println(usage);
	       System.exit(0); 
	       }*/
 	  //Files to be tested first if they exist
 	   File sourceFile= new File(args[1]);	   
	   File targetFile= new File(args[2]);
	   
	   // ** -d option EC** 
	   if(args[0].equals("-d")){	     
	      if(!sourceFile.exists()){
		  System.out.println("First file does not exist"); 
	          System.exit(0);
	      }
	      if(!targetFile.exists()){
		  System.out.println("Second file does not exist"); 
	         System.exit(0);
	      }

	      boolean flag=true;

	      if(sourceFile.length()!= targetFile.length()){
		  flag=false; 
	      }

	      /*InputStream input= new BufferedInputStream(new FileInputStream(sourceFile));
	      InputStream output= new BufferedInputStream(new FileInputStream(targetFile));

	      int v1;
	      int v2;

	      do{
		  
		  v1= input.read();
		  v2= output.read();
		  if(v1!= v2){
		    flag= false;     
		  }
	      }while(v1>=0);
	      */ 
	      if(flag= false){
		System.out.println("The files are different");
		System.exit(0); 
	      }

	      if(flag==true){
		  System.out.println("The files are the same");
		  System.exit(0); 		  
	      }
		  	      
	   }//**end -d
	   //** -c option (copy sourceFile to destinationFile)  
	   if(args[0].equals("-c")){	       
	       if(!sourceFile.exists()){// check source file exists 
	       System.out.println("Source file does not exist"); 
	       System.exit(0); 
	       }
	       if(targetFile.exists()){ //check destination file exists 
	       System.out.println("Target file already exists"); 
	       System.exit(0); 
	       }
	   //create input stream 
	   BufferedInputStream input=new BufferedInputStream(new FileInputStream(sourceFile));
	   //create output stream
	   BufferedOutputStream output= new BufferedOutputStream(new FileOutputStream(targetFile));
	   int rd;
	   
	   while((rd= input.read())!= -1){  // while there is still binary/text keep writing to source file 
	       output.write((byte)rd);      	       
	   }	   	 	   
	   input.close(); // close inout file type BufferedInputStream
	   output.close();// close output file  type BufferedOutPutStream	   
 System.out.println("File " + sourceFile.getName() + " was copied to file " + targetFile.getName()+ " succesfully");	   
	   }//**end -c **
      }//end if(lenght==3)

       //** 2 Arguments
       //**Check valid command**
      if(args.length == 2){ 	 
	  if(!args[0].equals("-v") && !args[0].equals("-i")){   
		  System.out.println(usage);
		  System.exit(0);
	  }
	  /*if(!args[0].equals("-i")){
	        System.out.println(usage);
	        System.exit(0);
		}*/
	    File f1 = new File(args[1]);    //**File obj. to be tested in -v and -i
	    
	    //** -v  option (Just view File) 
	    if(args[0].equals("-v")){		
		if(!f1.exists()){  //check if file exists 
		    System.out.println("File to view does not exist");
		    System.exit(0); 
		}
		if(f1.isDirectory()){  //check its not a directory 
		    System.out.println("Input is a directory not a file");
		    System.exit(0); 
		}
		//** if file is valid create Scanner to read file 
	        Scanner rd= new Scanner(f1);
		while(rd.hasNext()){                   // while there is still text 
		    System.out.println(rd.nextLine()); //print text to console 
		}
	    }//**end of -v
	    
	    //** -i option (File or directory)
	    //** -i File 
 	    if(args[0].equals("-i")){  
		if(f1.isFile()){ //** if file: print information requested on file** 
		    Date date = new Date(f1.lastModified()); //Date object to display last modified date 
		    System.out.println("File Path: "  + f1.getAbsolutePath()); //Functions from File class  	    
	           System.out.println("Is executable? " + f1.canExecute());	   
	           System.out.println("Size: " + f1.length() + " Bytes"); 	  
	           System.out.print("Last Modiefied Date: ");
		   System.out.printf("%tB %<te %<tY", date); //format to print date 
		   System.out.println(); 
	        }
		//** -i Directory 
	        if(f1.isDirectory()){ // if command is Directory		    
	           System.out.println("Size    Filename");
	           File [] fileArray= f1.listFiles();
		   Arrays.sort(fileArray, new Asort());
		   
	           for(File f: fileArray){
		     System.out.print(f.length());
		     System.out.print("          "); 
		     System.out.println(f.getName()); 
		   }
		}// end -i Directory 
	    }//end args[0].equals(-i)
      }// end  args.length ==2 
    }//end main()


//File reader 
// overriten comparator function from Arrays class to compare the sizes of Files 
    private static class Asort implements Comparator<File> {
    public int compare(File a, File b){
        Long an= new  Long(a.length()); //convert primitive long to Long obj.
	Long bn= new  Long(b.length());
	int aan= an.intValue();// Long obj gets converted to int in order to make precise subtraction 
	int bbn= bn.intValue(); 
	return aan-bbn; // subtract original primitive long(now int) 
    }          
    }//end  Asort class
}//end FileViewer class 
