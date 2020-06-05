package typing_game1;

public class Beat {
	public int time;		//노트가 나오는 시간
	public String noteName;	//노트가 내려오는 칸 이름('S','D','F','J','K','L')
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public Beat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}
	
}
