package task06.task06;

public enum AvailabilityStatus {
    AVAILABLE("Available"),
    LOW_STOCK("Low Stock"),
    OUT_OF_STOCK("Out of Stock"),
    DISCONTINUED("Discontinued");
    private final String description;
    AvailabilityStatus(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
    public AvailabilityStatus determineStatus(int quantity){
        if(quantity==0){
            return OUT_OF_STOCK;
        }
        else if(quantity <=5){
            return LOW_STOCK;
        }
        else{
            return AVAILABLE;
        }
    }
}
