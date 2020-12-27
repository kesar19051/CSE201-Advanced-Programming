import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Zotato zotato = new Zotato();
        Restaurant restaurant1 = new AuthenticRestaurant("Shah", 1);
        Restaurant restaurant2 = new Restaurant("Ravi's");
        Restaurant restaurant3 = new AuthenticRestaurant("The Chinese", 0);
        Restaurant restaurant4 = new FastFoodRestaurant("Wang's", 2);
        Restaurant restaurant5 = new Restaurant("Paradise");
        Customer customer1 = new EliteCustomer("Ram");
        Customer customer2 = new EliteCustomer("Sam");
        Customer customer3 = new SpecialCustomer("Tim");
        Customer customer4 = new Customer("Kim");
        Customer customer5 = new Customer("Jim");
        Zotato.addRestaurant(restaurant1);
        Zotato.addRestaurant(restaurant2);
        Zotato.addRestaurant(restaurant3);
        Zotato.addRestaurant(restaurant4);
        Zotato.addRestaurant(restaurant5);
        Zotato.addCustomer(customer1);
        Zotato.addCustomer(customer2);
        Zotato.addCustomer(customer3);
        Zotato.addCustomer(customer4);
        Zotato.addCustomer(customer5);

        while (true){
            System.out.println("Welcome to Zotato:");
            System.out.println("1) Enter as Restaurant owner");
            System.out.println("2) Enter as Customer");
            System.out.println("3) Check User Details");
            System.out.println("4) Company Account details");
            System.out.println("5) Exit");
            int input = in.nextInt();
            if(input==1){
                Zotato.showRestaurants(in);
            }
            else if(input==2){
                Zotato.showCustomers();
            }
            else if(input==3){
                System.out.println("Which user? Enter 1 for restaurant owner and 2 for customer");
                Zotato.checkUserDetails();
            }
            else if(input==4){
                System.out.println("Total Company Balance: "+Zotato.getWallet());
                System.out.println("Total Delivery Amount: "+Zotato.getDeliveryCharge());
            }
            else if (input==5){
                return;
            }
        }
    }
}

class Zotato{
    static private ArrayList<Restaurant> restaurants;
    static private ArrayList<Customer> customers;
    static private int wallet;
    static private int deliveryCharge;

    Zotato(){
        restaurants = new ArrayList<>();
        customers = new ArrayList<>();
        wallet = 0;
        deliveryCharge = 0;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void showRestaurants(Scanner in){

        System.out.println("Choose Restaurant");
        for(int i = 0; i<Zotato.getRestaurants().size(); i++){
            Restaurant restaurant = Zotato.getRestaurants().get(i);
            int j = i+1;
            System.out.println(j+") "+restaurant.displayDetails());
        }
        int input1 = in.nextInt();
        Restaurant restaurant = Zotato.getRestaurants().get(input1-1);
        System.out.println("Welcome "+restaurant.getName());
        System.out.println("Which option?");
        FoodItem foodItem = new FoodItem("", 0, 0);

        while(true){
            restaurant.showMenuOptions();
            int whichMenu = in.nextInt();
                if(whichMenu==1){
                    System.out.println("Food Name: ");
                    String name = in.next();
                    System.out.println("Item price: ");
                    int price = in.nextInt();
            System.out.println("Item quantity: ");
            int quantity = in.nextInt();
            System.out.println("Item category:");
            String category = in.next();
            System.out.println("Discount: ");
            int discount = in.nextInt();
            foodItem.setName(name);
            foodItem.setPrice(price);
            foodItem.setQuantity(quantity);
            foodItem.setCategory(category);
            foodItem.setDiscount(discount);
            restaurant.addFoodItem(foodItem);
            System.out.println(foodItem.getID()+" "+name+" "+price+" "+quantity+" "+discount+"% off "+category);
        }
        else if(whichMenu==2){
            System.out.println("Enter the food number: ");

            for(int i = 0; i< restaurant.getFoodItems().size(); i++){
                int j = i+1;
                FoodItem foodItem1 = restaurant.getFoodItems().get(i);
                System.out.println(j+") "+ foodItem1.getName());
            }
                    int hello = in.nextInt();
            FoodItem foodItem1 = restaurant.getFoodItems().get(hello-1);
            System.out.println("Enter the attribute to edit: ");
            System.out.println("1) Name");
            System.out.println("2) Price");
            System.out.println("3) Quantity");
            System.out.println("4) Discount");
            System.out.println("5) Exit");
            int attribute = in.nextInt();
            if(attribute==1){
                System.out.println("Enter new name: ");
                String name = in.next();
                restaurant.editFoodName(foodItem1, name);
            }
            else if(attribute==2){
                System.out.println("Enter new price: ");
                int price = in.nextInt();
                restaurant.editFoodPrice(foodItem1, price);
            }
            else if(attribute==3){
                System.out.println("Enter new quantity: ");
                int quantity = in.nextInt();
                restaurant.editFoodQuantity(foodItem1, quantity);
            }
            else if(attribute==4){
                System.out.println("Enter new discount: ");
                int discount = in.nextInt();
                restaurant.editFoodDiscount(foodItem1, discount);
            }
        }
        else if(whichMenu==3){
            restaurant.getReward();
            }
        else if(whichMenu==4){
            System.out.println("Enter customer name: ");
            String name = in.next();
            for(int i = 0; i< customers.size(); i++){
                Customer customer = customers.get(i);
                if(customer.getName().equalsIgnoreCase(name)){
                    restaurant.discountBill(customer);
                }
                else
                    System.out.println("No such customer!");
            }

            }
        else if(whichMenu==5){
            break;
            }
        }

    }

    public static int getDeliveryCharge() {
        return deliveryCharge;
    }

    public static void setDeliveryCharge(int deliveryCharge) {
        Zotato.deliveryCharge = deliveryCharge;
    }

    public static int getWallet() {
        return wallet;
    }

    public static void setWallet(int wallet) {
        Zotato.wallet = wallet;
    }

    public static void checkUserDetails(){
        System.out.println("1) Customer List");
        System.out.println("2) Restaurant List");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if(input==1){
            for(int i = 0; i<customers.size(); i++){
                int j = i+1;
                Customer customer = customers.get(i);
                System.out.println(j+") "+customer.getName());
            }
            int input1 = in.nextInt();
            ParentMenu customer = customers.get(input1-1);
            System.out.println(customer.displayDetails());
        }
        else{
            for(int i = 0; i<restaurants.size(); i++){
                int j = i+1;
                Restaurant restaurant = restaurants.get(i);
                System.out.println(j+") "+restaurant.getName());
            }
            int input1 = in.nextInt();
            ParentMenu restaurant = restaurants.get(input1-1);
            System.out.println(restaurant.displayDetails());
        }
    }

    public static void addRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }

    public static void addCustomer(Customer customer){
        customers.add(customer);
    }

    public static void showCustomers() {
        Scanner in = new Scanner(System.in);
        System.out.println("Which customer?");
        for(int i = 0; i<customers.size(); i++){
            Customer customer = customers.get(i);
            int j = i+1;
            System.out.println(j+") "+customer.displayDetails());
        }
        int input1 = in.nextInt();
        Customer customer = customers.get(input1-1);
        System.out.println("Enter the query: ");
        System.out.println("1) Selecting");
        System.out.println("2) Checkout option");
        System.out.println("3) Print reward");
        System.out.println("4) List recent orders");
        System.out.println("5) Exit");
        int query = in.nextInt();
        if(query==1){
            customer.selecting();
        }
        else if(query==2){
            customer.checkout();
        }
        else if(query==3){
            customer.printReward();
        }
        else if(query==4){
            customer.listRecentOrders();
        }
        else{
            return;
        }
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}

interface ParentMenu{
    String displayDetails();
    void showMenuOptions();

}

class Restaurant implements ParentMenu{
    private String name;
    private int wallet;
    private int reward;
    private ArrayList<FoodItem> foodItems;
    private int deliveryChargeAccount = 0;

    Restaurant(String name){
        this.name = name;
        this.wallet = 0;
        this.reward = 0;
        this.foodItems = new ArrayList<>();
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getWallet() {
        return wallet;
    }

    public void pay(Customer customer){
        int toPay = (int)((float)customer.getCost()*0.01);
        Zotato.setWallet(toPay+getWallet());
    }


    public int getDeliveryChargeAccount() {
        return deliveryChargeAccount;
    }

    public void setDeliveryChargeAccount(int deliveryChargeAccount) {
        this.deliveryChargeAccount = deliveryChargeAccount;
    }

    public void addFoodItem(FoodItem foodItem){
        foodItems.add(foodItem);
    }

    public void editFoodName(FoodItem foodItem, String name){
        foodItem.setName(name);
    }

    public void editFoodPrice(FoodItem foodItem, int price){
        foodItem.setPrice(price);
    }

    public void editFoodQuantity(FoodItem foodItem, int quantity){
        foodItem.setQuantity(quantity);
    }

    public void editFoodDiscount(FoodItem foodItem, int discount){
        foodItem.setDiscount(discount);
    }

    public int getReward() {
        System.out.println(reward);
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public void reward(Customer customer){
        int numOfTime = customer.getCost()/100;
        int reward = numOfTime*5;
        customer.setRewardAccount(customer.getRewardAccount()+reward);
        this.setReward(this.getReward()+reward);
    }

    public void discountBill(Customer customer){
        return;
    }
    public String getName() {
        return name;
    }

    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }


    @Override
    public String displayDetails() {
        return this.getName();
    }

    @Override
    public void showMenuOptions() {
        System.out.println("1) Add item");
        System.out.println("2) Edit item");
        System.out.println("3) Print rewards");
        System.out.println("4) Discount on bill value");
        System.out.println("5) Exit");
    }

}

class FastFoodRestaurant extends Restaurant{
    private int discount;
    FastFoodRestaurant(String name, int discount){
        super(name);
        this.discount = discount;
    }

    public void discountBill(Customer customer){
        float bill = (float)customer.getCost();
        float discount = ((float)this.discount/100)* customer.getCost();
        bill = bill-discount;
        customer.setCost((int) bill);
    }

    public void reward(Customer customer) {
        int numOfTime = customer.getCost()/150;
        int reward = numOfTime*10;
        customer.setRewardAccount(customer.getRewardAccount()+reward);
        this.setReward(this.getReward()+reward);
    }

    public String displayDetails() {
        return this.getName()+" (Fast Food)";
    }
}

class AuthenticRestaurant extends Restaurant{
    private int discount;

    AuthenticRestaurant(String name, int discount) {
        super(name);
        this.discount = discount;
    }

    public void discountBill(Customer customer){
        float bill = (float)customer.getCost();
        float discount = ((float)this.discount/100)* customer.getCost();
        bill = bill-discount;
        if(bill>100){
            bill-=50;
        }
        customer.setCost((int)bill);
    }

    public void reward(Customer customer) {
        int numOfTime = customer.getCost()/200;
        int reward = numOfTime*25;
        customer.setRewardAccount(customer.getRewardAccount()+reward);
        this.setReward(this.getReward()+reward);
    }

    public String displayDetails() {
        return this.getName()+" (Authentic)";
    }
}

class Customer implements ParentMenu{
    private String name;
    protected int deliveryCharge;
    private int rewardAccount;
    private int wallet;
    private ArrayList<FoodItem> cart;
    protected int cost;
    private int index;
    private ArrayList<ArrayList<FoodItem>> orders = new ArrayList<ArrayList<FoodItem>>(10);

    {
        for(int i = 0; i<10; i++){
            ArrayList<FoodItem> cart1 = new ArrayList<>();
            orders.add(cart1);
            index = 0;
        }
    }

    Customer(String name){
        this.name = name;
        this.rewardAccount = 0;
        this.cost = 40;
        this.wallet = 1000;
        this.cart = new ArrayList<>();
        this.deliveryCharge = 0;
    }

    protected int getDeliveryCharge() {
        return deliveryCharge;
    }

    public String getName() {
        return name;
    }

    public int getRewardAccount() {
        return rewardAccount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setRewardAccount(int rewardAccount) {
        this.rewardAccount = rewardAccount;
    }

    @Override
    public String displayDetails() {
        return this.getName();
    }

    @Override
    public void showMenuOptions() {
        System.out.println("1) Select Restaurant");
        System.out.println("2) Checkout Cart");
        System.out.println("3) Reward won");
        System.out.println("4) Print recent orders");
        System.out.println("5) Exit");
    }

    public void selecting(){
        Scanner in = new Scanner(System.in);
        System.out.println("Choose by entering the serial number");
        ArrayList<Restaurant> list = Zotato.getRestaurants();
        for(int i = 0; i<list.size(); i++){
            int j = i+1;
            System.out.println(j+". "+list.get(i).getName());
        }
        int input = in.nextInt();
        Restaurant restaurant = list.get(input-1);
        ArrayList<FoodItem> foodItems = restaurant.getFoodItems();
        System.out.println("Choose by entering the serial number or enter 0 to exit");
        for(int i = 0; i<foodItems.size(); i++){
            int j = i+1;
            System.out.println(j+". "+foodItems.get(i).getID()+" "+foodItems.get(i).getQuantity());
        }
        int foodNum = in.nextInt();
        if(foodNum==0){
            System.out.println("No item selected!");
            return;
        }
        FoodItem food = foodItems.get(foodNum-1);
        food.applyDiscount();
        cost+=food.getPrice();
        food.setRestaurant(restaurant);
        restaurant.discountBill(this);
        cart.add(foodItems.get(foodNum-1));
        this.discount();
        restaurant.setWallet(restaurant.getWallet()+cost-this.getDeliveryCharge());
        restaurant.setDeliveryChargeAccount(restaurant.getDeliveryChargeAccount()+this.getDeliveryCharge());
        Zotato.setDeliveryCharge(Zotato.getDeliveryCharge()+this.deliveryCharge);
        System.out.println("Item added!");
        restaurant.reward(this);
        restaurant.pay(this);
    }

    public void checkout(){
        if(rewardAccount>=cost) {
            rewardAccount = rewardAccount - cost;
            cart.clear();
            System.out.println("Checked out!");
            orders.add(index%10, cart);
            index+=1;
        }
        else if(rewardAccount+wallet>=cost){
            int temp = cost - rewardAccount;
            rewardAccount = 0;
            wallet = wallet-temp;
            cart.clear();
            System.out.println("Checked out!");
            orders.add(index%10, cart);
            index+=1;
        }
        else if(wallet>=cost){
            wallet=wallet-cost;
            cart.clear();
            System.out.println("Checked out!");
            orders.add(index%10, cart);
            index+=1;
        }
        else{
            System.out.println("Insufficient balance!");
            System.out.println("If you want to delete any item enter 0");
            System.out.println("If you want to cancel the order enter 1");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            if(input==0){
                System.out.println("Enter the serial number of the item to delete.");
                for(int i = 0; i<cart.size(); i++){
                    int j = i+1;
                    System.out.println(j+". "+cart.get(i).getName());
                }
                int serialNum = in.nextInt();
                FoodItem foodItem = cart.get(serialNum-1);
                cart.remove(serialNum-1);
                cost-= foodItem.getPrice();
                System.out.println("The total cost is "+cost);
                System.out.println("Checked out!");
                orders.add(index%10, cart);
                index+=1;
                wallet=0;
                rewardAccount=0;
            }
            return;
        }
    }

    public void discount(){
        this.setCost(cost+40);
        this.setDeliveryCharge(40);
    }

    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public void printReward(){
        System.out.println("Reward won "+this.rewardAccount);
    }

    public void listRecentOrders(){
        for(int i = 0; i<10; i++){
            if(orders.get(i)!=null){
                ArrayList<FoodItem> cart = orders.get(i);
                if(!cart.isEmpty()){
                    for(int j = 0; j< cart.size(); j++){
                        FoodItem foodItem = cart.get(j);
                        System.out.println("Bought item: "+foodItem.getName());
                        System.out.println("Quantity: "+foodItem.getQuantity());
                        System.out.println("Item price: "+foodItem.getPrice());
                        System.out.println("Restaurant: "+foodItem.getRestaurant().getName());
                    }
                }
            }
        }
    }
}

class EliteCustomer extends Customer{

    EliteCustomer(String name){
        super(name);
    }

    public void discount(){
        if(cost>200){
            cost-=50;
            this.setCost(cost);
            this.setDeliveryCharge(0);
        }
    }

    @Override
    public String displayDetails() {
        return this.getName()+" (Elite)";
    }
}

class SpecialCustomer extends Customer{
    SpecialCustomer(String name){
        super(name);
    }

    public void discount() {
        if(cost>200){
            cost-=25;
        }
        this.setCost(cost+20);
        this.setDeliveryCharge(20);
    }
    @Override
    public String displayDetails() {
        return this.getName()+" (Special)";
    }
}

class FoodItem{
    private int ID;
    private String name;
    private int price;
    private int quantity;
    private String category;
    private int discount = 0;
    private Restaurant restaurant;

    private static int nextId = 0;

    static {
        nextId+=1;
    }

    public FoodItem(String name, int price, int quantity){
        this.ID = nextId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void applyDiscount() {
        if(this.discount!=0){
            price=price-(int)((((float)discount)/100)*price);
            this.setPrice(price);
        }
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}

