package org.yash.deltafuse.dataingestion.model;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("MOBILE_DATA")
public class FileData {

	public FileData() {
		super();
	}
	
	public FileData(UUID id, Map<String, String> mobile) {
		super();
		this.id = id;
		this.mobile = mobile;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Map<String, String> getMobile() {
		return mobile;
	}

	public void setMobile(Map<String, String> mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "FileData [id=" + id + ", mobile=" + mobile + "]";
	}

	@PrimaryKey
	private UUID id;

	@Column("Mobile")
	private Map<String, String> mobile ;

	

}
