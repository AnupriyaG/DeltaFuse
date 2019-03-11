package org.yash.deltafuse.dataingestion.model;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("MOBILE_DATA")
public class FileData {

	@PrimaryKey
	private UUID id;

	@Column("Mobile")
	private Map<String, String> mobile;

	public FileData(UUID id, Map<String, String> mobile) {
		super();
		this.id = id;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "FileData [id=" + id + ", mobile=" + mobile + "]";
	}

}
