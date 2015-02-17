// Course      : CMP-129
// Title       : Carpet Cleaner , Example of Aggregation 
// Instructor  : JReynolds

public class CarpetCleaner {

    private String    customer_;
    private Rectangle room_;
    private FloorType floor_;
	
    
    public CarpetCleaner() {
    }

    public CarpetCleaner( String cust , Rectangle room , FloorType floor ) {
	customer_=cust;
	room_=room;
	floor_=floor;
    }

    public String toString() {
	return new String( "CarpetCleaner:customer=" + customer_ + ":room="+room_.getLen()+"x"+room_.getWidth()+":floor="+floor_);
    }
    
    public double getCostPerSqFt() {
	switch(floor_) {
	case Wood: return 1.10;
	case Concrete: return 0.75;
	case Industrial: return 1.75;
	case Carpet: return 0.95;
	case Tile: return 0.85;
	}
	return 1.75;
    }

    public double calculateCost() {
	return room_.area() * getCostPerSqFt();
    }

    public String getCustomer() {
	return customer_;
    }

    public Rectangle getRoom() {
	return room_;
    }

    public FloorType getFloor() {
	return floor_;
    }

    //---------------------------------------------------------
    // test 
    //---------------------------------------------------------
    public static void main( String []  args ) {
	CarpetCleaner c = new CarpetCleaner( "CCM", new Rectangle(10,10), FloorType.Tile );
	System.out.println( c + ":cost=" + c.calculateCost());
    }

}