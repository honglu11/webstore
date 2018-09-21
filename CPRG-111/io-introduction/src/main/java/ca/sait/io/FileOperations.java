package ca.sait.io;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileOperations {
    
    public static void main(String [] args) {
        final FileOperations fileOperations = new FileOperations();
        
//        fileOperations.FileSystem();
//        fileOperations.Paths();
        fileOperations.Files();
    }

    private void FileSystem() {
    	// factory pattern, know the window or ... system
        final FileSystem fs = FileSystems.getDefault();
        
        System.out.println("File Stores:");
        fs.getFileStores().forEach(System.out::println);
        
        System.out.println("\nRoot Directories:");
        fs.getRootDirectories().forEach(System.out::println);
        
    }

    private void Paths() {
        //final Path p1 = Paths.get("C:\\Users\\honglu\\opt\\CPRG-111");
        
        //final Path p1 = Paths.get(".", "./person.ser"); can build the path
        
        final Path p1 = Paths.get("./person.ser");
        
        System.out.format("getFileName: %s%n", p1.getFileName());
        System.out.format("getParent: %s%n", p1.getParent());
        System.out.format("getNameCount: %d%n", p1.getNameCount());
        System.out.format("getRoot: %s%n", p1.getRoot());
        System.out.format("isAbsolute: %b%n", p1.isAbsolute());
        System.out.format("toAbsolutePath: %s%n", p1.toAbsolutePath());
        System.out.format("toURI: %s%n", p1.toUri());
    }
    
    private void Files() {
    	// start from current folder and move back one when meet ..
        final Path p1 = Paths.get("..");
        
        // Files.exists(p1) may read simbolic link
        // no simbolic link
        boolean exists = Files.exists(p1, LinkOption.NOFOLLOW_LINKS);
        System.out.println(p1.toString() + ": " + exists);
        
        try {
            Files.walkFileTree(p1, new PrintTree());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public class PrintTree implements FileVisitor<Path> {
    	
    	private int counter = 0;
        
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        	//System.out.println(dir);
        	final String name = dir.getFileName().toString();
        	if (name.equals(".metadata"))
        		return FileVisitResult.SKIP_SUBTREE;
        	
        	for (int i = 0; i < counter; i++) {
        		System.out.print(" ");
        	}
        	System.out.println(name);
        	counter++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        	counter--;
            return FileVisitResult.CONTINUE;
        }
        
    }
}