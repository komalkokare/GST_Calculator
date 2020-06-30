class Commodity{

	private String name;
	private Type type;
	private int price;

	public Commodity(Type type,String name,int price){
		this.type = type;
		this.name = name;
		this.price = price;
	}
	public int get_price(){
		return price;
	}
	public Type get_type(){
		return type;
	}
	public String get_name(){
		return name;
	}
	public void set_price(int price) {
		this.price = price;
	}

	public void set_type(Type type) {
		this.type = type;
	}
	public void set_name(String name){
		this.name = name;
	}
}
