public class Product{

    private String name;
    private int quantity;
    private double value;

    public Product(String name,double value,int quantity){

        this.name=name;
        this.quantity=quantity;
        this.value=value;
    }


    public String getName(){
        return this.name;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getValue(){
        return this.value;
    }
    public double getTotalValue(){
        return value*quantity;
    }
    @Override
    public String toString(){
        return "Name: "+name+" Price: "+value+" Quantity: "+quantity+"Total Value: "+getTotalValue();
    }
}