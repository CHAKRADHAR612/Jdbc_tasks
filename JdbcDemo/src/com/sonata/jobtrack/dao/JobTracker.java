package com.sonata.jobtrack.dao;

import java.util.List;

import com.sonata.jobtrack.model.Task;
import com.sonata.jobtrack.model.User;

public interface JobTracker {
	public boolean addTask(Task task);
	public boolean addUser(User user);
	public List<Task> getAllTasks();
	public List<Task> getAllTasksByStatus(String status);
	public List<Task> getAllTasksByOwner(int ownerId);
	public int updateTaskStatus(int taskId,String status);
	public int updateTaskPriority(int taskId,String priority);
	public int updateTaskNotes(int taskId,String notes);
	public int updateTaskBookmark(int taskId,boolean isBookmarked);
	public int assignTaskUser(int taskId,int ownerId);
}
