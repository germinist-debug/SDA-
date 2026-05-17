/// Represents a product in the store with its attributes and methods
/// NOW implements the refactored ProductHandling interface

public class Product implements ProductHandling {

    protected String size, color, name;
    protected int quantity, price;
    
    public enum colors{ RED, BLUE, GREEN, YELLOW, BLACK, WHITE, ORANGE, PURPLE, PINK, BROWN, GREY, BEIGE, NAVY, OLIVE, MAROON, LIME, TEAL, INDIGO, VIOLET,
                        AQUA, TURQUOISE, SILVER, LAVENDER, TAN, KHAKI, PLUM, GOLD, MAGENTA, SALMON, CRIMSON, CORAL, BURGUNDY, MUSTARD }
    public enum sizes{ XS, S, M, L, XL, XXL }

    @Override
    public String getSize(){ 
        return size; 
    }
    
    @Override
    public String getName(){ 
        return name; 
    }

    public String getType(){
        if(this instanceof BottomWear) return "bottomWear";
        else return "topWear";
    }
    
    @Override
    public String getColor(){ 
        return color; 
    }
    
    @Override
    public int getQuantity(){ 
        return quantity; 
    }
    
    @Override
    public int getPrice(){ 
        return price; 
    }
    
    @Override
    public void setPrice(int price){ 
        this.price = price; 
    }
    
    @Override
    public void increaseQuantity(int quantity){ 
        this.quantity += quantity; 
    }
    
    @Override
    public void decreaseQuantity(int quantity){
        if(this.quantity - quantity < 0) this.quantity = 0;
        else this.quantity -= quantity;
    }

    @Override
    public int compareTo(ProductHandling o) {
        Product other = (Product) o;
        if(this.name.compareTo(other.name) != 0) return this.name.compareTo(other.name);
        if(this.size.compareTo(other.size) != 0) return this.size.compareTo(other.size);
        if(this.color.compareTo(other.color) != 0) return this.color.compareTo(other.color);
        if (this.quantity != other.quantity) return this.quantity - other.quantity;
        if (this.price != other.price) return this.price - other.price;
        return 0;
    }

    @Override
    public String toString(){
        return this.name + ":\n- size " + this.size + "\n- color " + this.color + "\n- quantity " + this.quantity + "\n" + "- price " + this.price + "\n";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Product product){
            return this.name.equals(product.name) && this.size.equals(product.size) && this.color.equals(product.color);
        }
        return false;
    }

    public static boolean checkSize(String size){
        for(sizes s : sizes.values()){
            if(s.toString().equals(size)) return true;
        }
        return false;
    }

    public static boolean checkColor(String color){
        for(colors c : colors.values()){
            if(c.toString().equals(color)) return true;
        }
        return false;
    }

    public static boolean checkPrice(int price){
        return price >= 0;
    }

    public static boolean checkQuantity(int quantity){
        return quantity >= 0;
    }
    
    @Override
    public void checkAttributes() throws InvalidProductAttribute{
        if(!checkSize(size)) throw new InvalidProductSize("Invalid size");
        if(!checkColor(color)) throw new InvalidProductColor("Invalid color");
        if(!checkPrice(price)) throw new InvalidProductPrice("Invalid price");
        if(!checkQuantity(quantity)) throw new InvalidProductQuantity("Invalid quantity");
    }

    public static String checkType(String name) throws InvalidProductTypeException{
            for(BottomWear.BottomWearType bottomWearType : BottomWear.BottomWearType.values()){
                if(bottomWearType.toString().equals(name)) return "bottomWear";
            }
            for(TopWear.TopWearType topWearType : TopWear.TopWearType.values()){
                if(topWearType.toString().equals(name)) return "topWear";
            }
        throw new InvalidProductTypeException("Invalid type");
    }
}