package org.javacream.util.stream;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class EventMessage implements Serializable{
	public EventMessage(long id, String description, String action, String... endpoints) {
		super();
		this.id = id;
		this.description = description;
		this.action = action;
		this.endpoints = Arrays.asList(endpoints);
		
	}
	@Override
	public String toString() {
		return "EventMessage [id=" + id + ", description=" + description + ", action=" + action + ", endpoints="
				+ endpoints + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endpoints == null) ? 0 : endpoints.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventMessage other = (EventMessage) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endpoints == null) {
			if (other.endpoints != null)
				return false;
		} else if (!endpoints.equals(other.endpoints))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getAction() {
		return action;
	}
	public List<String> getEndpoints() {
		return endpoints;
	}
	private static final long serialVersionUID = 1L;
	private long id;
	private String description;
	private String action;
	private List<String> endpoints;

}
