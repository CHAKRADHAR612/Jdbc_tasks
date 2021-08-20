package com.sonata.jobtrack.main;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import com.sonata.jobtrack.dao.JobTracker;
import com.sonata.jobtrack.dao.impl.JobTrackerImpl;
import com.sonata.jobtrack.model.Task;
import com.sonata.jobtrack.model.User;

public class MyJobTracker {

	public static void main(String[] args) throws ParseException {
		JobTracker jt=new JobTrackerImpl();
		Task t=new Task();
//		System.out.println(jt.updateTaskStatus(1, "new"));
//		System.out.println(jt.updateTaskPriority(1, "Medium"));
//		String notes="Today we learnt about JDBC statements like Update,select,insert";
//		System.out.println(jt.updateTaskNotes(1, notes));
//		boolean isBookmarked=false;
//		System.out.println(jt.updateTaskBookmark(1, isBookmarked));
		int ownerId=5;
//		System.out.println(jt.assignTaskUser(3, ownerId));
		System.out.println(jt.assignTaskUser(4, 3));
		List<Task> tasks=jt.getAllTasks();
//		String status="In progress";
//		List<Task> tasks=jt.getAllTasksByStatus(status);
//		int ownerId=1;
//		List<Task> tasks=jt.getAllTasksByOwner(ownerId);
		System.out.println(tasks);
		t.setTaskId(4);
		t.setOwnerId(2);
		t.setCreatorId(1);
		t.setName("JDBC training");
		t.setDescription("JDBC connectivity");
		t.setStatus("In progress");
		t.setPriority("High");
		t.setNotes("JDBC drivers are automatically registered");
		t.setIsBookmarked(true);
		t.setCreatedOn(Date.valueOf("2021-08-20"));
		t.setStatusChangedOn(Date.valueOf("2021-08-20"));
//		System.out.println(jt.addTask(t));
		
		User user=new User();
		user.setUserId(1);
		user.setUserName("chakri");
		user.setEmail("chakri@xyz.com");
		user.setFirstName("chakradhar");
		user.setLastName("K");
		user.setContactNumber("9999999999");
		user.setRole("Developer");
		user.setIsActive(true);
		user.setDob(Date.valueOf("2000-12-06"));
		user.setCreatedOn(Date.valueOf("2021-08-19"));
//		System.out.println(jt.addUser(user));
		
		
	}

}
