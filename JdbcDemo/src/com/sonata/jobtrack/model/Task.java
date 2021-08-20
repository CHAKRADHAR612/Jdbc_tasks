package com.sonata.jobtrack.model;

import java.sql.Date;

public class Task {
	private int taskId;
	private int ownerId;
	private int creatorId;
	private String name;
	private String description;
	private String status;
	private String priority;
	private String notes;
	private Boolean isBookmarked;
	private Date createdOn;
	private Date statusChangedOn;
	public Task(){}
	public Task(int taskId, int ownerId, int creatorId, String name, String description, String status, String priority,
			String notes, Boolean isBookmarked, Date createdOn, Date statusChangedOn) {
		super();
		this.taskId = taskId;
		this.ownerId = ownerId;
		this.creatorId = creatorId;
		this.name = name;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.notes = notes;
		this.isBookmarked = isBookmarked;
		this.createdOn = createdOn;
		this.statusChangedOn = statusChangedOn;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Boolean getIsBookmarked() {
		return isBookmarked;
	}
	public void setIsBookmarked(Boolean isBookmarked) {
		this.isBookmarked = isBookmarked;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getStatusChangedOn() {
		return statusChangedOn;
	}
	public void setStatusChangedOn(Date statusChangedOn) {
		this.statusChangedOn = statusChangedOn;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", ownerId=" + ownerId + ", creatorId=" + creatorId + ", name=" + name
				+ ", description=" + description + ", status=" + status + ", priority=" + priority + ", notes=" + notes
				+ ", isBookmarked=" + isBookmarked + ", createdOn=" + createdOn + ", statusChangedOn=" + statusChangedOn
				+ "]\n";
	}
}

