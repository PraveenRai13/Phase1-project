package Mypackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import
java.util.LinkedList;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Lockme {
	static final String errorMessage = "Some error occured please contact admin: admin@LockedMe.Com";
			static final String projectFilesPath ="C:/Users/Praveen/Desktop/Java Course simplilearn";
			public static void main(String[]args) throws IOException
			{
			Scanner obj = new Scanner(System.in);
			int ch;
			do
			{
			displayMenu();
			System.out.println("Enter your choice");
			ch=Integer.parseInt(obj.nextLine());
			switch(ch)
			{
			case 1:
			getAllFiles();
			break;
			case 2:createFiles();
			break;
			case 3: deleteAllFiles();
			break;
			case 4: searchFiles();
			break;
			case 5: System.exit(0);
			break;
			default:System.out.println("Invalid option");
			}
			}
			while(ch>0);
			obj.close();
			}
			public static void displayMenu()
			{
			System.out.println("\t=================================");
			System.out.println("\tWelcome to LockedMe.com");
			System.out.println("\t=================================");
			System.out.println("\tDesigned by Praveen Rai");
			System.out.println("\t1. Display all the files");
			System.out.println("\t2. Add a new file");
			System.out.println("\t3. Delete a file");
			System.out.println("\t4. Search a file");
			System.out.println("\t5. Exit");

			}
			/*This method will return all the files from the directory*/
			public static void getAllFiles()
			{
			try {
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			if(listOfFiles.length==0)
			{
			System.out.println("No Files exist");
			}
			else
			{
			for(var l:listOfFiles)
			{
			System.out.println(l.getName());
			}
			}
			}
			catch(Exception Ex)
			{
			System.out.println(errorMessage);
			}
			}
			public static void createFiles() throws IOException
			{
			try
			{
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the filename: ");
			fileName = obj.nextLine();
			int linesCount;
			System.out.println("Enter how many lines in the file");
			linesCount = Integer.parseInt(obj.nextLine());
			FileWriter myWriter = new
			FileWriter(projectFilesPath+"\\"+fileName);
			for(int i=1;i<=linesCount;i++)
			{

			System.out.println("Enter the file line : ");

			myWriter.write(obj.nextLine()+"\n");
			}
			System.out.println("File has been created successfully.");
			myWriter.close();   obj.close();
			}
			catch(Exception ex)
			{
			System.out.println("Some error has occcured");
			}
			}
			/*This method will delete the file based on the user input if it exists*/
			public static void deleteAllFiles()
			{
			Scanner obj = new Scanner(System.in);
			try
			{
			String fileName;
			System.out.println("Enter the file name to be deleted");
			fileName = obj.nextLine();
			File file = new File(projectFilesPath+"\\"+fileName);
			if(file.exists())
			{
			file.delete();
			System.out.println("File deleted SuccessFully : "+fileName);
			}
			else
			System.out.println("File do not exists");
			}
			catch(Exception ex)
			{
			System.out.println(errorMessage);
			}
			finally
			{
			obj.close();
			}
			}
			/*This method will search the files from the directory*/
			public static void searchFiles()
			{
			Scanner obj = new Scanner(System.in);
			try
			{
			String fileName;

			System.out.println("Enter the file name to be Searched");
			fileName = obj.nextLine();
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			LinkedList<String> filenames = new LinkedList<String>();
			for(var l:listOfFiles)
			filenames.add(l.getName());
			if(filenames.contains(fileName))
			System.out.println("File is available");
			else
			System.out.println("File is not available");
			}
			catch(Exception ex)
			{
			System.out.println(errorMessage);
			} finally
			{
			obj.close();
			}
			}
}
