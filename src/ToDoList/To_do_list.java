package ToDoList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class To_do_list {

	static ArrayList<Task> al= new ArrayList();
    
	public static void To_Do_List () throws IOException
	{
		loadDataFromFileToArrayList();
		
		Scanner scanner=new Scanner(System.in);
		
		boolean canIKeepRunningTheProgram=true;
		
		while(canIKeepRunningTheProgram==true)
		{
			System.out.println("**** Welcome to To Do List Management ****");
			System.out.println("\n");
			System.out.println("1.Add Task");
			System.out.println("2.Search Task");
			System.out.println("3.Delete Task");
			System.out.println("4.Edit Task");
			System.out.println("5.Exit");
			
			int optionSelectedByUser=scanner.nextInt();
			
			if(optionSelectedByUser==TaskOptions.EXIT)
			{
				File file=new File("C:\\Users\\HP\\eclipse-workspace\\ToDoList\\src\\ToDoList\\List.csv");
				FileWriter fileWriter=new FileWriter(file,false);
				BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
				
				for(Task task:al)
				{
					bufferedWriter.write(task.Taskname+" , "+task.TaskID+" , "+task.TaskCategory+","+task.TaskMark+","+"\n");
					
				}
				bufferedWriter.close();
				fileWriter.close();
				file=null;
				
				System.out.println("Program is closed..");
				canIKeepRunningTheProgram=false;
			}
			else if(optionSelectedByUser==TaskOptions.ADD_TASK)
			{
				addTask();
				System.out.println("\n");
			}
			else if(optionSelectedByUser==TaskOptions.DELETE_TASK)
			{
				System.out.println("Enter The Task name to delete:");
			    scanner.nextLine();
			    String sn=scanner.nextLine();
			    deleteTask(sn);
			    System.out.println("\n");
			 }
			else if(optionSelectedByUser==TaskOptions.SEARCH_TASK)
			{
				System.out.println("Enter the Task Name to search:");
				scanner.nextLine();
				String sn=scanner.nextLine();
				searchTask(sn);
			}
			else if(optionSelectedByUser==TaskOptions.EDIT_TASK)
			{
				System.out.println("Enter the Task Name to edit:");
				scanner.nextLine();
				String sn=scanner.nextLine();
				editTask(sn);
		    }
			
		}
		System.out.println("\n");
		System.out.println("After While Loop");
		
		for(Task task:al)
		{
			System.out.println(task.Taskname);
			System.out.println(task.TaskID);
			System.out.println(task.TaskCategory);
			System.out.println(task.TaskMark);
		}
	}
	
	public static void addTask()
	{
		Scanner scanner=new Scanner(System.in);
		Task taskObject=new Task();
		
		System.out.println("Task Name:");
		taskObject.Taskname=scanner.nextLine();
		
		System.out.println("Task Category :");
		taskObject.TaskCategory=scanner.nextLine();
		
		System.out.println("Task Id:");
		taskObject.TaskID=scanner.nextLine();
		
		System.out.println("TaskMark:");
		taskObject.TaskMark=scanner.nextLine();
		
		
		System.out.println("Task Name:"+taskObject.Taskname);
		System.out.println("Task Id:"+taskObject.TaskID);
		System.out.println("Task Category:"+taskObject.TaskCategory);
		System.out.println("Task Mark :"+taskObject.TaskMark);
		
		al.add(taskObject);
		
	}
	public static void searchTask(String BookName)
	{
		for(Task t : al)
		 {
			if(t.Taskname.equalsIgnoreCase(BookName))
			{
				System.out.println("Book Name:"+t.Taskname);
				System.out.println("Book Id:"+t.TaskID);
				System.out.println("Category :"+t.TaskCategory);
				System.out.println("TaskMark :"+t.TaskMark);

				
				return;
			}
		}
		
		System.out.println("Task Not Found");
	}
	public static void editTask(String TaskName)
	{
		for( Task t : al)
		{
			if(t.Taskname.equalsIgnoreCase(TaskName))
			{
		        Scanner scanner=new Scanner(System.in);
				System.out.println("Editing Task :"+t.Taskname);

				System.out.println("New Task Name:");
				t.Taskname=scanner.nextLine();
				
				System.out.println("New TaskId:");
				t.TaskID=scanner.nextLine();
				
				System.out.println("New  Task Category");
				t.TaskCategory=scanner.nextLine();
				
				System.out.println("New Task Mark:");
				t.TaskMark=scanner.nextLine();
				
			
				
				
				System.out.println("Task Information Updated");
				
				return;

			}
		}
		
		System.out.println("Task not found");
	}
	public static void deleteTask(String TaskName)
	{
         Iterator<Task>Iterator=al.iterator();
		
		while(Iterator.hasNext())
		{
			Task task=Iterator.next();
			if(task.Taskname.equalsIgnoreCase(TaskName))
			{
				Iterator.remove();
				System.out.println("Task" + task.Taskname+" has been deleted!");
				break;
			}
		}
		
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file=new File("C:\\Users\\HP\\eclipse-workspace\\ToDoList\\src\\ToDoList\\List.csv");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String Line="";
		while((Line= br.readLine())!=null)
		{
			Task task=new Task();
			String[] taskDataArray=Line.split(",");
			
			if(taskDataArray.length>2)
			{
				task.Taskname=taskDataArray[0];
				task.TaskID=taskDataArray[1];
				task.TaskMark=taskDataArray[2];
				task.TaskCategory=taskDataArray[3];
				
                al.add(task);
             }
		}
		 br.close();
		 fr.close();
		 file=null;

		}
}