package c322spring2024homework2.c322spring2024homework2.model;

public class Guitar {
    String serialNum;
    double price;
    Builder builder;
    String model;
    Type type;
    Wood backWood;
    Wood topWood;

    public Guitar(String serialNum, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.serialNum = serialNum;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }


    //gets serial num
    public String getSerialNumber(){
        return serialNum;
    }
    //gets price
    public double getPrice(){
        return price;
    }
    //sets the price
    public void setPrice(float p){
        price = p;

    }
    //gets the builder
    public Builder getBuilder(){
        return builder;
    }
    //gets the model
    public String getModel(){
        return model;
    }
    //gets the type
    public Type getType(){
        return type;
    }
    //gets backwood
    public Wood getBackWood(){
        return backWood;
    }
    //gets topwood
    public Wood getTopWood(){
        return topWood;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Guitar guitar = (Guitar) obj;
        return Double.compare(guitar.price, price) == 0 &&
                serialNum.equals(guitar.serialNum) &&
                builder == guitar.builder &&
                model.equals(guitar.model) &&
                type == guitar.type &&
                backWood == guitar.backWood &&
                topWood == guitar.topWood;
    }
}