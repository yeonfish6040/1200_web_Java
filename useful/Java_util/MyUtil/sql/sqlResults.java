package MyUtil.sql;

public class sqlResults {
	protected String[][] data;
	sqlResults(String[][] data) {
		this.data = data;
	}
	
	public String[][] get() {
		return data;
	}
	
	public int getCount() {
		return data.length;
	}
	
	public String[] split(String spChar) {
		String[] result = new String[data.length];
		int i = 0;
		for(String[] e:data) {
			String str = "";
			for(String e2:e) {
				if (str == "") str += e2;
				else str += spChar+e2;
			}
			result[i] = str;
			i++;
		}
		return result;
	}
}