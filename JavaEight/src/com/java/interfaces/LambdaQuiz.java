package com.java.interfaces;

import java.io.File;
import java.io.FileFilter;


/*
 
Which among the following can replace the anonymous FileFilter class?

Correct - File[] result = directoryPath.listFiles(filePathname-> filePathname.getName().endsWith(".java"));
File[] result = directoryPath.listFiles((String filePathname) -> filePathname.getName().endsWith(".java"));
Correct - File[] result = directoryPath.listFiles((File filePathname) -> filePathname.getName().endsWith(".java"));
Correct - File[] result = directoryPath.listFiles(filePathname-> { return filePathname.getName().endsWith(".java"); });
File[] result = directory.listFiles(pathname -> { pathname.getName().endsWith(".java"); });
File[] result = directory.listFiles(pathname -> return pathname.getName().endsWith(".java") );

 */
public class LambdaQuiz {
	
	public static void main(String[] args) {
        File directoryPath = new File("D:\\demo\\src");
 
        File[] result = directoryPath.listFiles(new FileFilter() {
            
            public boolean accept(File filePathname) {
               return filePathname.getName().endsWith(".java"); 
            }
        });
        
        for(File file: result ){
            System.out.println(file.getName());
        }
    }

}
