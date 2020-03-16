package de.techem.wurst.contentservice;

import java.util.List;

public class Content {
	
	private  String id;
	private  List<String> tags;
	private  String data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	public Content(String id, List<String> tags, String data) {
		super();
		this.id = id;
		this.tags = tags;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", tags=" + tags + ", data=" + data + "]";
	}

	
}
