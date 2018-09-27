package org.nico.ourbatis.xml;

import java.util.List;
import java.util.Map;

public class Document {

	private String name;
	
	private DocumentType type;
	
	private Map<String, String> parameters;
	
	private String content;
	
	private String beforeContent = "";
	
	private String afterContent = "";
	
	private Document pre;
	
	private Document next;
	
	private Document parent;
	
	private List<Document> childs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParameter(String key) {
		if(this.parameters == null) {
			return null;
		}
		return this.parameters.get(key);
	}
	
	public String setParameter(String key, String value) {
		if(this.parameters == null) {
			return null;
		}
		return this.parameters.put(key, value);
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public DocumentType getType() {
		return type;
	}

	public void setType(DocumentType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBeforeContent() {
		return beforeContent;
	}

	public void setBeforeContent(String beforeContent) {
		this.beforeContent = beforeContent;
	}

	public String getAfterContent() {
		return afterContent;
	}

	public void setAfterContent(String afterContent) {
		this.afterContent = afterContent;
	}

	public Document getPre() {
		return pre;
	}

	public void setPre(Document pre) {
		this.pre = pre;
	}

	public Document getNext() {
		return next;
	}

	public void setNext(Document next) {
		this.next = next;
	}

	public Document getParent() {
		return parent;
	}

	public void setParent(Document parent) {
		this.parent = parent;
	}

	public List<Document> getChilds() {
		return childs;
	}

	public void setChilds(List<Document> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return "XMLDocument [name=" + name + ", type=" + type + ", parameters=" + parameters + "]";
	}
	
}
