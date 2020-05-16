package typing_game1;

public class Track {
	
	private String titleImage;	//노래 제목 이미지
	private String albumImage;		//노래 앨범 이미지
	private String gameImage;	//게임 실행 시 이미지
	private String highlightMusic;	//노래 선택창 노래
	private String gameMusic;		//게임 실행 시 노래
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getAlbumImage() {
		return albumImage;
	}
	public void setAlbumImage(String albumImage) {
		this.albumImage = albumImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getHighlightMusic() {
		return highlightMusic;
	}
	public void setHighlightMusic(String highlightMusic) {
		this.highlightMusic = highlightMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public Track(String titleImage, String albumImage, String gameImage, String highlightMusic, String gameMusic) {
		super();
		this.titleImage = titleImage;
		this.albumImage = albumImage;
		this.gameImage = gameImage;
		this.highlightMusic = highlightMusic;
		this.gameMusic = gameMusic;
	}
	

}
