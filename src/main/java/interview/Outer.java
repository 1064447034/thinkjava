package interview;

import com.alibaba.fastjson.JSON;

public class Outer {
	private String data;
	private Entry entry = new Entry();

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Outer(String data) {
		this.data = data;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public class Entry {
		public void print() {
			System.out.println(data);
		}
	}

	public static void main(String[] args) {
		Outer out = new Outer("aaa");
		out.getEntry().print();
	}
}
