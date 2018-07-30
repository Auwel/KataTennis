package kata.tennis.points;

public enum DeucePoint {

	QUARANTE("40"),
	ADV("ADV"),
	DEUCE("DEUCE"),
	WIN("WIN");
	private String point;
	
	 DeucePoint(String point) {
		this.point=point;
	}
	
	 public String getEnumPoint() {
		 return this.point;
	 }

}
