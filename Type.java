 class Type{
	String type;
	float gstRate;

	public Type(String type, float rate){
		this.type = type;
		gstRate = rate;
	}

	public float get_gstRate(){
		return gstRate;
	}
	public String get_type(){
		return type;
	}

	public void set_gstRate(float rate) {
		gstRate = rate;
	}

	public void set_type(String type) {
		this.type = type;
	}
}
