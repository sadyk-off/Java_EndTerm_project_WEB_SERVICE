package entities;

public class Parcel {
    private int id;
    private String from_address;
    private String to_address;
    private String type_delivery;
    private String weight;
    private double evaluate_cost;
    private String type_parcel;
    private String delivery_deadline;
    private String size;

    public Parcel() {

    }

    public Parcel(String from_address,String to_address,String type_delivery,String weight,double evaluate_cost,String type_parcel,String delivery_deadline,String size) {

    }

    public Parcel(int id,String from_address,String to_address,String type_delivery,String weight,double evaluate_cost,String type_parcel,String delivery_deadline,String size) {
        this(from_address,to_address,type_delivery,weight,evaluate_cost,type_parcel,delivery_deadline,size);
        setId(id);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom_address() {
        return from_address;
    }

    public void setFrom_address(String from_address) {
        this.from_address = from_address;
    }

    public String getTo_address() {
        return to_address;
    }

    public void setTo_address(String to_address) {
        this.to_address = to_address;
    }

    public String getType_delivery() {
        return type_delivery;
    }

    public void setType_delivery(String type_delivery) {
        this.type_delivery = type_delivery;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getEvaluate_cost() {
        return evaluate_cost;
    }

    public void setEvaluate_cost(double evaluate_cost) {
        this.evaluate_cost = evaluate_cost;
    }

    public String getType_parcel() {
        return type_parcel;
    }

    public void setType_parcel(String type_parcel) {
        this.type_parcel = type_parcel;
    }

    public String getDelivery_deadline() {
        return delivery_deadline;
    }

    public void setDelivery_deadline(String delivery_deadline) {
        this.delivery_deadline = delivery_deadline;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", from_address='" + from_address + '\'' +
                ", to_address='" + to_address + '\'' +
                ", type_delivery='" + type_delivery + '\'' +
                ", weight='" + weight + '\'' +
                ", evaluate_cost=" + evaluate_cost +
                ", type_parcel='" + type_parcel + '\'' +
                ", delivery_deadline='" + delivery_deadline + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}