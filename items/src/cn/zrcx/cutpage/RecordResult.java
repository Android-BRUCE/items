package cn.zrcx.cutpage;

import java.util.List;

public class RecordResult<T> {

	private List<T> records;
	private long totalRecord;
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	
}
